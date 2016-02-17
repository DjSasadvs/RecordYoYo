package com.zyp.recordyoyo.utils;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * use this, need a context here to finish the activity, just exit function
 * however consider the efficiency and optimization between inner class
 * anonymous inner class and outer class, decided to use the inner class first
 * remark on 2016/1/14
 * <p/>
 * Created by YipengZhang on 2016/1/12.
 */
public class GestureDetectorUtil extends GestureDetector.SimpleOnGestureListener {

    final int FLING_MIN_DISTANCE = 100, FLING_MIN_VELOCITY = 150;
    // 触发条件 ：
    // X轴的坐标位移大于FLING_MIN_DISTANCE，且移动速度大于FLING_MIN_VELOCITY个像素/秒

    // 参数解释：
    // e1：第1个ACTION_DOWN MotionEvent
    // e2：最后一个ACTION_MOVE MotionEvent
    // velocityX：X轴上的移动速度，像素/秒
    // velocityY：Y轴上的移动速度，像素/秒
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //FLING_LEFT
        if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            Log.i("MyGesture", "Fling left");
            //this.getClass().finish();
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}

