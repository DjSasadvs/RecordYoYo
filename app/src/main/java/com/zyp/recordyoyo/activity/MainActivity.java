package com.zyp.recordyoyo.activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.zyp.recordyoyo.R;
import com.zyp.recordyoyo.fragment.HomeContent;
import com.zyp.recordyoyo.recordYoYo.RecordYoYo;
import com.zyp.recordyoyo.services.RecordYoYoCoreService;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeContent.OnFragmentInteractionListener {

    //Fragment
    public static FragmentManager mContentFragmentManager;
    public static FragmentTransaction mFragmentTransaction;
    private HomeContent mHomeContentFragment;
    private LinearLayout mLinearLayoutNavHeader;
    private DrawerLayout drawer;

    private FloatingActionButton.LayoutParams startParams;
    private FrameLayout.LayoutParams childParams;
    private FrameLayout.LayoutParams childContentParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListener();
        setSelectItem(RecordYoYo.DRAW_HOME_DISCOVER);
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addFloatingActionButton();

        if (drawer == null)
            drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mLinearLayoutNavHeader = (LinearLayout) findViewById(R.id.nav_header_main);
        startService(new Intent(this, RecordYoYoCoreService.class));
    }

    private void setListener() {
        mLinearLayoutNavHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                mIntent.setClass(MainActivity.this, PersonalInfoActivity.class);
                startActivity(mIntent);
            }
        });
    }

    public void addFloatingActionButton() {
        int floatingActionButtonSize = getResources().getDimensionPixelSize(R.dimen.fab);
        int floatingActionMargin = getResources().getDimensionPixelSize(R.dimen.fab_margin);
        int floatingActionButtonChildSize = getResources().getDimensionPixelSize(R.dimen.fab_child);
        int floatingActionButtonChildMargin = getResources().getDimensionPixelSize(R.dimen.fab_child_margin);
        int actionMenuRadius = getResources().getDimensionPixelSize(R.dimen.action_menu_radius);

        startParams = new FloatingActionButton.LayoutParams(
                floatingActionButtonSize, floatingActionButtonSize);
        childParams = new FrameLayout.LayoutParams(
                floatingActionButtonChildSize, floatingActionButtonChildSize);
        childContentParams = new FrameLayout.LayoutParams(
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
        //ImageView rlIcon1 = new ImageView(this);
        ImageView rlIcon2 = new ImageView(this);
        ImageView rlIcon3 = new ImageView(this);
        //ImageView rlIcon4 = new ImageView(this);

        //rlIcon1.setImageResource(R.mipmap.ic_photo_camera_black_36dp);
        rlIcon2.setImageResource(R.mipmap.ic_add_black_36dp);
        rlIcon3.setImageResource(R.mipmap.ic_border_color_black_36dp);
        //rlIcon4.setImageResource(R.mipmap.ic_place_black_24dp);

        //SubActionButton rLSub1 = rLSubBuilder.setContentView(rlIcon1, childContentParams).build();
        SubActionButton rLSub2 = rLSubBuilder.setContentView(rlIcon2, childContentParams).build();
        SubActionButton rLSub3 = rLSubBuilder.setContentView(rlIcon3, childContentParams).build();

        // Set 3 default SubActionButtons
        final FloatingActionMenu rightLowerMenu = new FloatingActionMenu.Builder(this)
                //.addSubActionView(rLSub1, rLSub1.getLayoutParams().width, rLSub1.getLayoutParams().height)
                .addSubActionView(rLSub2, rLSub2.getLayoutParams().width, rLSub2.getLayoutParams().height)
                .addSubActionView(rLSub3, rLSub3.getLayoutParams().width, rLSub3.getLayoutParams().height)
                //.addSubActionView(rLSubBuilder.setContentView(rlIcon4).build())
                .setRadius(actionMenuRadius)
                .setStartAngle(225)
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
                setSnackBarColor(snackbar, Color.parseColor("#FFA726"), Color.parseColor("#F57C00"));
                snackbar.show();
                rightLowerMenu.close(true);
            }
        });

        rLSub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, R.string.edit_toast, Snackbar.LENGTH_LONG)
                        .setAction(R.string.add_toast_action, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v, Environment.getExternalStorageDirectory().toString(), Snackbar.LENGTH_LONG).show();
                            }
                        });
                setSnackBarColor(snackbar, Color.parseColor("#FFFFFF"), Color.parseColor("#FFFF00"));
                snackbar.show();
                rightLowerMenu.close(true);
            }
        });
    }

    public static void setSnackBarColor(Snackbar snackbar, int textColor, int buttonColor) {
        View view = snackbar.getView();
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(textColor);
        ((Button) view.findViewById(R.id.snackbar_action)).setTextColor(buttonColor);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this, "notYet", Toast.LENGTH_LONG).show();
        //Snackbar.make(uri, "notYet", Snackbar.LENGTH_LONG);
    }

    private void setSelectItem(int position) {
        mContentFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mContentFragmentManager.beginTransaction();
        Intent mIntent = new Intent();
        switch (position) {
            case RecordYoYo.DRAW_HOME_DISCOVER:
                if (mHomeContentFragment == null)
                    mHomeContentFragment = HomeContent.newInstance("MainActivity", "Home Content");
                Log.i("MainActivity.this", "HomeContent");
                //mContentFragment = new Fragment.HomeContent();
                break;
            case RecordYoYo.DRAW_SETTINGS:
                mIntent.setClass(MainActivity.this, SettingActivity.class);
                startActivity(mIntent);
                break;
            case RecordYoYo.DRAW_BACKUP:
                mIntent.setClass(MainActivity.this, BackUpActivity.class);
                startActivity(mIntent);
                break;
            case RecordYoYo.DRAW_BOOKMARK:
                mIntent.setClass(MainActivity.this, DetailsActivity.class);
                startActivity(mIntent);
                break;
            default:
                break;
        }
        if (mHomeContentFragment != null) {
            mFragmentTransaction.replace(R.id.content_frame, mHomeContentFragment, "fragment here");
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
        //noinspection SimplifiableIfStatement
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_discover) {
            setSelectItem(RecordYoYo.DRAW_HOME_DISCOVER);
            // Handle the camera action
        } else if (id == R.id.nav_personality) {
            setSelectItem(RecordYoYo.DRAW_PERSONALITY);
        } else if (id == R.id.nav_message) {
            setSelectItem(RecordYoYo.DRAW_MESSAGE);
        } else if (id == R.id.nav_contact) {
            setSelectItem(RecordYoYo.DRAW_CONTACT);
        } else if (id == R.id.nav_setting) {
            setSelectItem(RecordYoYo.DRAW_SETTINGS);
        } else if (id == R.id.nav_bookmark) {
            setSelectItem(RecordYoYo.DRAW_BOOKMARK);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
