package com.zyp.recordyoyo.recordYoYo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.zyp.recordyoyo.models.User;

/**
 * use IoDH to design Singleton
 * Created by YipengZhang on 2015/12/23.
 */
public class RecordYoYo extends Application {

    public static final int DRAW_HOME_DISCOVER = 0;
    public static final int DRAW_MESSAGE = 1;
    public static final int DRAW_CONTACT = 2;
    public static final int DRAW_PERSONALITY = 3;
    public static final int DRAW_BOOKMARK = 4;
    public static final int DRAW_BACKUP = 5;
    public static final int DRAW_SETTINGS = 6;
    //public static final int DRAW_REFLECTION = 5;

    public final User userSession = new User();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public RecordYoYo() {

    }

    private static class HolderClass {
        private final static RecordYoYo instance = new RecordYoYo();
    }

    public static RecordYoYo getInstance() {
        return HolderClass.instance;
    }

    //judge if there exits a history-user
    public void getUser() {
        SharedPreferences mUserSharedPre = getSharedPreferences("UserSession", Context.MODE_PRIVATE);
        userSession.setUserName(mUserSharedPre.getString("userName", "请登录"));
        userSession.setUserId(mUserSharedPre.getString("userId", ""));
    }
}
