package com.zyp.recordyoyo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.Log;
import android.widget.Toast;

/**
 * Created by admin on 2017/3/14.
 */
public class NetBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "net change", Toast.LENGTH_LONG).show();
        Log.i("netreceiver","change");
    }
}
