package com.example.roomtest;

import android.text.TextUtils;
import android.util.Log;

/**
 * Copyright 2021 想發財娛樂
 * <p>
 * Date 2021 - 02 - 06
 * Author : 紅色維尼
 * Descriptor :
 * Fix Item : roomtest
 **/

public class LogUtil {

    private static final String TAG = "LogUtil";
    private static boolean isShowDebug = true;
    private static boolean isShowError = true;
    private static boolean isShowWarn = true;
    private static boolean isShowInfo= true;
    private static boolean isShowVerbose = true;

    private static String generateTagMessage() {
        // 取得 StackTraceElement
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String callerClazzName = stackTraceElement.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);

        // 定義顯示格式
        String tagFormat = "%s.%s(L:%d)";
        // Class, Method Name, Code Line Number
        tagFormat = String.format(tagFormat, new Object[]{callerClazzName,
                stackTraceElement.getMethodName(),
                Integer.valueOf(stackTraceElement.getLineNumber())});

        tagFormat = TextUtils.isEmpty(TAG) ? tagFormat : TAG + ":" + tagFormat;
        return tagFormat;
    }

    public static void v(String msg) {
        if (isShowVerbose) {
            String tag = generateTagMessage();
            Log.v(tag, msg);
        }
    }

    public static void d(String msg) {
        if (isShowDebug) {
            String tag = generateTagMessage();
            Log.d(tag, msg);
        }
    }

    public static void i(String msg) {
        if (isShowInfo) {
            String tag = generateTagMessage();
            Log.i(tag, msg);
        }
    }

    public static void w(String msg) {
        if (isShowWarn) {
            String tag = generateTagMessage();
            Log.w(tag, msg);
        }
    }

    public static void e(String msg) {
        if (isShowError) {
            String tag = generateTagMessage();
            Log.e(tag, msg);
        }
    }
}
