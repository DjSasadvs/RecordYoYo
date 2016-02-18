package com.zyp.recordyoyo.recordYoYo;

/**
 * Created by Administrator on 2015/12/23.
 */
public class RecordYoYo {
    public static final int DRAW_HOME_DISCOVER = 0;
    public static final int DRAW_MESSAGE = 1;
    public static final int DRAW_CONTACT = 2;
    public static final int DRAW_PERSONALITY = 3;
    public static final int DRAW_BOOKMARK = 4;
    public static final int DRAW_BACKUP = 5;
    public static final int DRAW_SETTINGS = 6;
    //public static final int DRAW_REFLECTION = 5;

    private RecordYoYo() {
    }

    private static class HolderClass {
        private final static RecordYoYo instance = new RecordYoYo();
    }

    public static RecordYoYo getInstance() {
        return HolderClass.instance;
    }
}
