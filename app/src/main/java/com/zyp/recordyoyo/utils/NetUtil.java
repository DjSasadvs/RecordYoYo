package com.zyp.recordyoyo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by admin on 2017/3/14.
 */
public class NetUtil {

    private static final int NETWORK_NONE = -1;
    private static final int NETWORK_MOBILE = 0;
    private static final int NETWORK_WIFI = 1;

    public static synchronized int getNetWrokState(Context context) {
        // 得到连接管理器对象
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return NETWORK_NONE;
        } else if (!activeNetworkInfo.isConnected()) {
            return NETWORK_NONE;
        } else if ((activeNetworkInfo.getType() == (ConnectivityManager.TYPE_WIFI))) {
            return NETWORK_WIFI;
        } else if ((activeNetworkInfo.getType() == (ConnectivityManager.TYPE_MOBILE))) {
            return NETWORK_MOBILE;
        }
        return NETWORK_NONE;
    }

}