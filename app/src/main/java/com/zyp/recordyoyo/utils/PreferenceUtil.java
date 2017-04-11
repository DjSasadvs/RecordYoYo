package com.zyp.recordyoyo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/**
 * Created by zyp on 2016/12/8.
 */

public class PreferenceUtil {

    private static final long ONE_DAY_INTERVAL = 24 * 60 * 60 * 1000L;

    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        return getPreferences(context).getBoolean(key, defaultValue);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static int getInt(Context context, String key, int defaultValue) {
        return getPreferences(context).getInt(key, defaultValue);
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static long getLong(Context context, String key, long defaultValue) {
        return getPreferences(context).getLong(key, defaultValue);
    }

    public static void putLong(Context context, String key, long value) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static String getString(Context context, String key, String defaultValue) {
        return getPreferences(context).getString(key, defaultValue);
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    @SuppressLint("InlinedApi")
    public static SharedPreferences getPreferences(Context context) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                return context.getSharedPreferences(Constants.CONFIG_FILE_NAME, Context.MODE_MULTI_PROCESS);
            } else {
                return context.getSharedPreferences(Constants.CONFIG_FILE_NAME, Context.MODE_PRIVATE);
            }
        } else
            return null;
    }

    public static SharedPreferences getDialogPreferences(Context context) {
        return context.getSharedPreferences(Constants.DIALOG_FILE_NAME, Context.MODE_PRIVATE);
    }
}
