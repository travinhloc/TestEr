package com.lt.test.utils;

import android.util.Log;

import com.lt.test.BuildConfig;

public class LogUtil {

    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG && msg != null) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (BuildConfig.DEBUG && msg != null) {
            Log.i(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (BuildConfig.DEBUG && msg != null) {
            Log.e(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (BuildConfig.DEBUG && msg != null) {
            Log.w(tag, msg);
        }
    }

    public static void e(String msg) {
        e(BuildConfig.APPLICATION_ID + ": Error ", msg);
    }

    public static void d(String msg) {
        d(BuildConfig.APPLICATION_ID + ": Debug ", msg);
    }


}
