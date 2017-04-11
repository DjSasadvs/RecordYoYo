package com.zyp.recordyoyo.utils;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.zyp.recordyoyo.recordYoYo.RecordYoYo;

/**
 * Created by zyp on 2016/12/8.
 */
public class ViewUtil {

    public static final float SCREEN_DENSITY;

    public static final int PORTRAIT_SCREEN_WIDTH;

    public static final int PORTRAIT_SCREEN_HEIGHT;

    static {
        Resources res = RecordYoYo.getContext().getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        SCREEN_DENSITY = dm.density;

        if (res.getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            PORTRAIT_SCREEN_WIDTH = dm.widthPixels;
            PORTRAIT_SCREEN_HEIGHT = dm.heightPixels;
        } else {
            PORTRAIT_SCREEN_WIDTH = dm.heightPixels;
            PORTRAIT_SCREEN_HEIGHT = dm.widthPixels;
        }
    }

    public static int px2dip(float pxValue) {
        return (int) (pxValue / SCREEN_DENSITY + 0.5f);
    }

    public static int dip2px(float dp) {
        return (int) (SCREEN_DENSITY * dp + 0.5f);
    }
}
