package com.zuicool.screenviewlibrary.screen.util;

import android.util.Log;

/**
 * Created by jk on 2018/11/1.
 * Log工具类
 */

public class LogUtil {
    private static final String TAG = "ScreenView";

    public static void log(String log) {
        Log.e(TAG, log);
    }
}
