package com.zyp.recordyoyo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.zyp.recordyoyo.R;
import com.zyp.recordyoyo.utils.Constants;

public class DetailsActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    public static final String TOOLBAR_TITLE = "toolbar_title";
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        //set the tittle of the CollapsingToolbarLayout
        Intent intent = getIntent();
        String toolbarTitle = "";
        if (intent != null)
            toolbarTitle = intent.getStringExtra(TOOLBAR_TITLE);
        if (toolbarTitle == null || toolbarTitle.equals(""))
            collapsingToolbar.setTitle("Steven.Tomas");
        else
            collapsingToolbar.setTitle(toolbarTitle);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "是否要收藏这边文章", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        if (mGestureDetector == null)
            mGestureDetector = new GestureDetector(this.getApplicationContext(), this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.mGestureDetector.onTouchEvent(event);
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
            Log.i("MyGesture", "Loading previous one");
            finish();
            return true;
        } else if (e1.getX() - e2.getX() > Constants.FLING_MIN_DISTANCE && Math.abs(velocityX) > Constants.FLING_MIN_VELOCITY) {
            Log.i("MyGesture", "Loading next one");
            finish();
            return true;
        }
        return false;
    }
}
