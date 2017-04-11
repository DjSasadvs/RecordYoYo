package com.zyp.recordyoyo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zyp.recordyoyo.R;
import com.zyp.recordyoyo.utils.Constants;

/**
 * the gesture way need are supposed to consider
 * whether effect the user experience
 * fling by accident will destroy the information done
 * ways: change the fling data or cancel this gesture way
 * think in user perspective and compare with we chat
 * remark on 2016/1/14
 */
public class AddThingActivity extends AppCompatActivity {

    private TextView mTxtCancel;
    private TextView mTxtConfirm;
    private EditText mEditTxtTittle;
    private EditText mEditTxtContent;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_thing);
        init();
        setListener();
    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_add_activity);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        mTxtCancel = (TextView) findViewById(R.id.text_cancel_action);
    }

    private void setListener() {
        mTxtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
