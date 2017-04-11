package com.zyp.recordyoyo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;

import com.zyp.recordyoyo.R;
import com.zyp.recordyoyo.utils.Constants;

public class PersonalInfoActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private Toolbar mToolbar;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        init();
    }

    private void init() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_personal_info_activity);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        if (mGestureDetector == null)
            mGestureDetector = new GestureDetector(this.getApplicationContext(), this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e2.getX() - e1.getX() > Constants.FLING_MIN_DISTANCE && Math.abs(velocityX) > Constants.FLING_MIN_VELOCITY) {
            Log.i("MyGesture", "Fling left");
            finish();
            return true;
        }
        return false;
    }
}
