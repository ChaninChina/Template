package com.kxbyyk.chanin.template.component;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.widget.Toast;


import com.kxbyyk.chanin.template.R;
import com.kxbyyk.chanin.template.util.Constants;
import com.kxbyyk.chanin.template.util.ToastUtil;

import java.io.File;

/**
 * Created by codeest on 16/10/10.
 */

public class UpdateService extends Service {
    private BroadcastReceiver receiver;

    public static final String APK_DOWNLOAD_URL = "APK_DOWNLOAD_URL";
    public static final String APK_FILE_NAME= "APK_FILE_NAME";
    public static final String APK_DOWNLOAD_PATH=Environment.DIRECTORY_DOWNLOADS;
    private String path;
    private DownloadManager dm;
    private long downloadId;
    private String fileName;


    public static void startUpdateService(Context context,String fileName,String path){
        Intent intent = new Intent(context,UpdateService.class);
        intent.putExtra(APK_DOWNLOAD_URL,path);
        intent.putExtra(APK_FILE_NAME,fileName);
        context.startService(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        path = intent.getStringExtra(APK_DOWNLOAD_URL);
        fileName = intent.getStringExtra(APK_FILE_NAME);

        File file = new File(Environment.getExternalStoragePublicDirectory(APK_DOWNLOAD_PATH), fileName);
        if(file.exists()){
            installAPK(file);
            stopSelf();
        }else {
            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    checkStatus();
                }
            };
            registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
            startDownload();
        }
        return Service.START_STICKY;
    }

    private void onComplete() {
        unregisterReceiver(receiver);
        stopSelf();
    }

    private void startDownload() {
        dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(
                Uri.parse(path));
        request.setAllowedOverRoaming(false);
        request.setTitle(getString(R.string.app_name));
        request.setDescription("新版本下载中");
        request.setMimeType("application/vnd.android.package-archive");
        request.setDestinationInExternalPublicDir(APK_DOWNLOAD_PATH, fileName);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        downloadId = dm.enqueue(request);
        ToastUtil.shortShow("后台下载中，请稍候...");
    }


    //检查下载状态
    private void checkStatus() {
        DownloadManager.Query query = new DownloadManager.Query();
        //通过下载的id查找
        query.setFilterById(downloadId);
        Cursor c = dm.query(query);
        if (c.moveToFirst()) {
            int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
            switch (status) {
                //下载暂停
                case DownloadManager.STATUS_PAUSED:
                    break;
                //下载延迟
                case DownloadManager.STATUS_PENDING:
                    break;
                //正在下载
                case DownloadManager.STATUS_RUNNING:
                    break;
                //下载完成
                case DownloadManager.STATUS_SUCCESSFUL:
                    //下载完成安装APK
                    installAPK();
                    onComplete();
                    break;
                //下载失败
                case DownloadManager.STATUS_FAILED:
                   // ToastUtil.shortShow();
                    Toast.makeText(this, R.string.error_download_apk, Toast.LENGTH_SHORT).show();
                    onComplete();
                    break;
            }
        }
    }

    //下载到本地后执行安装
    private void installAPK() {
        //获取下载文件的Uri
        Uri downloadFileUri = dm.getUriForDownloadedFile(downloadId);
        if (downloadFileUri != null) {
            Intent intent= new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(downloadFileUri, "application/vnd.android.package-archive");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           startActivity(intent);
        }
    }

    private void installAPK(File file) {
        startActivity(getInstallAppIntent(file, Constants.AUTHORITIES));
    }

    /**
     * 获取安装App(支持7.0)的意图
     *
     * @param file      文件
     * @param authority 7.0及以上安装需要传入清单文件中的{@code <provider>}的authorities属性
     *                  <br>参看https://developer.android.com/reference/android/support/v4/content/FileProvider.html
     * @return intent
     */
    public  Intent getInstallAppIntent(final File file, final String authority) {
        if (file == null) return null;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data;
        String type = "application/vnd.android.package-archive";
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            data = Uri.fromFile(file);
        } else {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            data = FileProvider.getUriForFile(this, authority, file);
        }
        intent.setDataAndType(data, type);
        return intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
}
