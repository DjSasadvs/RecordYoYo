package com.zyp.recordyoyo.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;

import com.zyp.recordyoyo.broadcast.NotifyServiceReceiver;
import com.zyp.recordyoyo.recordYoYo.RecordYoYo;
import com.zyp.recordyoyo.utils.Constants;
import com.zyp.recordyoyo.utils.PreferenceUtil;
import com.zyp.recordyoyo.utils.Utility;

/**
 * Created by zyp on 2016/12/8.
 */
public class RecordYoYoCoreService extends Service {

    public final static String KEY_START_COMMAND = "key_start_command";
    public final static int VALUE_NOTIFY_RECOMMEND = 0x0001;
    public final static int NOTIFY_RECOMMEND_REQUEST_CODE = 101;
    private static final int TIME_RECOMMEND_INTERVAL = 3 * 3600 * 1000;
    private static final int TIME_RECOMMEND_FIRST_INTERVAL = 1 * 3600 * 1000;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        Log.i("RecordYoYoCoreService ", "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("RecordYoYoCoreService ", "onStartCommand()");
        if (intent != null) {
            int value = intent.getIntExtra(KEY_START_COMMAND, 0);
            switch (value) {
                case 1:
                    Utility.showRecommendNotification();
                    initNotifyScheduleAlarm(System.currentTimeMillis());
                    break;
                default:
                    break;
            }
        }
//super.onStartCommand(intent, flags, startId)
        return START_NOT_STICKY;
    }

    private void init() {
        initNotifyScheduleAlarm(0);
    }

    public void initNotifyScheduleAlarm(long wakeUp) {
        long lastTime = PreferenceUtil.getLong(RecordYoYo.getContext(), Constants.NOTIFICATION_RECOMMEND_TIME, 0);
        long alarmTime = wakeUp == 0 ? System.currentTimeMillis() : wakeUp + TIME_RECOMMEND_INTERVAL;
//        if (lastTime != 0 && System.currentTimeMillis() < lastTime)
//            return;
        Intent intent = new Intent();
        intent.setClass(this, RecordYoYoCoreService.class);
        intent.putExtra(KEY_START_COMMAND, VALUE_NOTIFY_RECOMMEND);
        PendingIntent pendIntent = PendingIntent.getService(this, NOTIFY_RECOMMEND_REQUEST_CODE, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        PreferenceUtil.putLong(RecordYoYo.getContext(), Constants.NOTIFICATION_RECOMMEND_TIME, alarmTime);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime, pendIntent);
    }


}
