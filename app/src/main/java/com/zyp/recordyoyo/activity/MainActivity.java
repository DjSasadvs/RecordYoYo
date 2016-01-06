package com.zyp.recordyoyo.activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.zyp.recordyoyo.R;
import com.zyp.recordyoyo.fragment.HomeContent;
import com.zyp.recordyoyo.recordYoYo.RecordYoYo;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeContent.OnFragmentInteractionListener {

    //Fragment
    public static FragmentManager mContentFragmentManager;
    public static FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSelectItem(RecordYoYo.DRAW_HOME_CONTENT);
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addFloatingActionButton();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void addFloatingActionButton() {
        int floatingActionButtonSize = getResources().getDimensionPixelSize(R.dimen.fab);
        int floatingActionMargin = getResources().getDimensionPixelSize(R.dimen.fab_margin);
        int floatingActionButtonChildSize = getResources().getDimensionPixelSize(R.dimen.fab_child);
        int floatingActionButtonChildMargin = getResources().getDimensionPixelSize(R.dimen.fab_child_margin);
        int actionMenuRadius = getResources().getDimensionPixelSize(R.dimen.action_menu_radius);

        FloatingActionButton.LayoutParams startParams = new FloatingActionButton.LayoutParams(
                floatingActionButtonSize, floatingActionButtonSize);
        FrameLayout.LayoutParams childParams = new FrameLayout.LayoutParams(
                floatingActionButtonChildSize, floatingActionButtonChildSize);
        FrameLayout.LayoutParams childContentParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);

        startParams.setMargins(floatingActionMargin, floatingActionMargin, floatingActionMargin, floatingActionMargin);
        childContentParams.setMargins(floatingActionButtonChildMargin, floatingActionButtonChildMargin,
                floatingActionButtonChildMargin, floatingActionButtonChildMargin);

        final ImageView fabIconContent = new ImageView(this);
        fabIconContent.setImageResource(R.mipmap.ic_fab_star);
        final FloatingActionButton rightLowerButton = new FloatingActionButton.Builder(this)
                .setContentView(fabIconContent)
                .setBackgroundDrawable(R.drawable.fab_background)
                .setLayoutParams(startParams)
                .build();

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);
        rLSubBuilder.setLayoutParams(childParams);
        //rLSubBuilder.setLayoutParams(childContentParams);
        ImageView rlIcon1 = new ImageView(this);
        ImageView rlIcon2 = new ImageView(this);
        ImageView rlIcon3 = new ImageView(this);
        //ImageView rlIcon4 = new ImageView(this);

        rlIcon1.setImageResource(R.mipmap.ic_place_black_24dp);
        rlIcon2.setImageResource(R.mipmap.ic_add_black_48dp);
        rlIcon3.setImageResource(R.mipmap.ic_border_color_black_48dp);
        //rlIcon4.setImageResource(R.mipmap.ic_place_black_24dp);

        SubActionButton rLSub1 = rLSubBuilder.setContentView(rlIcon1, childContentParams).build();
        SubActionButton rLSub2 = rLSubBuilder.setContentView(rlIcon2, childContentParams).build();
        SubActionButton rLSub3 = rLSubBuilder.setContentView(rlIcon3, childContentParams).build();

        // Set 3 default SubActionButtons
        final FloatingActionMenu rightLowerMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(rLSub1, rLSub1.getLayoutParams().width, rLSub1.getLayoutParams().height)
                .addSubActionView(rLSub2, rLSub2.getLayoutParams().width, rLSub2.getLayoutParams().height)
                .addSubActionView(rLSub3, rLSub3.getLayoutParams().width, rLSub3.getLayoutParams().height)
                        //        .addSubActionView(rLSubBuilder.setContentView(rlIcon4).build())
                .setRadius(actionMenuRadius)
                .setStartAngle(240)
                .setEndAngle(180)
                .attachTo(rightLowerButton)
                .build();

        // Listen menu open and close events to animate the button content view
        rightLowerMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees clockwise
                fabIconContent.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconContent, pvhR);
                animation.start();
            }

            @Override
            public void onMenuClosed(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees counter-clockwise
                fabIconContent.setRotation(45);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconContent, pvhR);
                animation.start();
            }
        });

        rLSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, R.string.add_toast, Snackbar.LENGTH_LONG)
                        .setAction(R.string.add_toast_action, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent mIntent = new Intent();
                                mIntent.setClass(MainActivity.this, AddThingActivity.class);
                                startActivity(mIntent);
                            }
                        });
                setSnackbarColor(snackbar, Color.parseColor("#FFA726"), Color.parseColor("#F57C00"));
                snackbar.show();
                rightLowerMenu.close(true);
            }
        });
    }

    public static void setSnackbarColor(Snackbar snackbar, int textColor, int buttonColor) {
        View view = snackbar.getView();
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(textColor);
        ((Button) view.findViewById(R.id.snackbar_action)).setTextColor(buttonColor);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void setSelectItem(int position) {
        mContentFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mContentFragmentManager.beginTransaction();
        Fragment mContentFragment = null;
        switch (position) {
            case RecordYoYo.DRAW_HOME_CONTENT:
                mContentFragment = HomeContent.newInstance("MainActivity", "Home Content");
                Log.e("MainActivity.this", "HomeContent");
                //mContentFragment = new Fragment.HomeContent();
                break;
            default:
                break;
        }
        if (mContentFragment != null) {
            mFragmentTransaction.replace(R.id.content_frame, mContentFragment, "fragment here");
            mFragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            setSelectItem(RecordYoYo.DRAW_HOME_CONTENT);
            // Handle the camera action
        } else if (id == R.id.nav_personality) {
            setSelectItem(RecordYoYo.DRAW_PERSONALITY);
        } else if (id == R.id.nav_slideshow) {
            setSelectItem(RecordYoYo.DRAW_SLIDE_SHOW);
        } else if (id == R.id.nav_manage) {
            setSelectItem(RecordYoYo.DRAW_SLIDE_SHOW);
        } else if (id == R.id.nav_setting) {
            setSelectItem(RecordYoYo.DRAW_SETTINGS);
        } else if (id == R.id.nav_reflect) {
            setSelectItem(RecordYoYo.DRAW_REFLECTION);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
