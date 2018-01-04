package com.kxbyyk.chanin.template.component;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;


import com.kxbyyk.chanin.template.app.App;
import com.kxbyyk.chanin.template.util.Constants;
import com.kxbyyk.chanin.template.util.LogUtil;
import com.kxbyyk.chanin.template.util.SystemUtil;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class InitializeService extends IntentService {
    private static final String ACTION_INIT = "initApplication";

    public InitializeService() {
        super("InitializeService");
    }



    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            if(ACTION_INIT.equals(intent.getAction())){
                initApplication();
            }
        }
    }

    private void initApplication() {
        //初始化日志


        //初始化错误收集
//        CrashHandler.init(new CrashHandler(getApplicationContext()));
        initBugly();

        //初始化内存泄漏检测
        LeakCanary.install(App.getInstance());




    }

    private void initBugly() {
        Context context = getApplicationContext();
        String packageName = context.getPackageName();
        String processName = SystemUtil.getProcessName(android.os.Process.myPid());
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        CrashReport.initCrashReport(context, Constants.BUGLY_ID, LogUtil.isDebug, strategy);
    }


    public static void start(Context context){
        Intent intent = new Intent(context,InitializeService.class);
        intent.setAction(ACTION_INIT);
        context.startService(intent);
    }

}
