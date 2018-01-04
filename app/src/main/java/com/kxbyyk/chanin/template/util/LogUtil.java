package com.kxbyyk.chanin.template.util;


import android.annotation.SuppressLint;
import android.util.Log;

import com.google.gson.Gson;
import com.kxbyyk.chanin.template.BuildConfig;

/**
 * Created by codeest on 2016/8/3.
 */
public class LogUtil {

    public static boolean isDebug = BuildConfig.DEBUG;
    private static final String TAG = BuildConfig.APPLICATION_ID;
    private static Gson gson = new Gson();

    public static void e(String tag,Object o) {
        if(isDebug) {
            Log.e(tag, gson.toJson(o));
        }
    }

    public static void e(Object o) {
        LogUtil.e(TAG,o);
    }

    public static void w(String tag,Object o) {
        if(isDebug) {
            Log.w(tag, gson.toJson(o));
        }
    }

    public static void w(Object o) {
        LogUtil.w(TAG,o);
    }

    @SuppressLint("LongLogTag")
    public static void d(String msg) {
        if(isDebug) {
            Log.d(TAG,msg);
        }
    }

    @SuppressLint("LongLogTag")
    public static void i(String msg) {
        if(isDebug) {
            Log.i(TAG,msg);
        }
    }
}
