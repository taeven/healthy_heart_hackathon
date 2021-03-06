package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {



    private static final long DRAWER_CLOSE_DELAY_MS = 350;
    private static final String NAV_ITEM_ID = "navItemId";
    private final articles artcls=new articles();
    private final brand_to_generic bg=new brand_to_generic();
    private final bmi_calculator bmi_cal = new bmi_calculator();
    private webview web_rt;
    private EditText hrs;
    private  String type="animal";
    private final common_disease cd=new common_disease();
    private final vaccine vc=new vaccine();
    private final diet_chart_frag dc=new diet_chart_frag();
    private final symptom_checker sc=new symptom_checker();
    private medicine_price mp=new medicine_price();
    private about abt=new about();
    private final first_aid FA=new first_aid();
    private final home hm=new home();
    private final schedule sch=new schedule();
    private final Handler mDrawerActionHandler = new Handler();
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mNavItemId;
    private Bundle bundle;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.trple_dot,menu);

        return true;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Healthy Heart");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // load saved navigation state if present
        if (null == savedInstanceState) {
            mNavItemId = R.id.home_icon;
        } else {
            mNavItemId = savedInstanceState.getInt(NAV_ITEM_ID);
        }

        hrs=(EditText)findViewById(R.id.hours_of_reppeated);

        // listen for navigation events
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        // select the correct nav menu item
        navigationView.getMenu().findItem(mNavItemId).setChecked(true);

        // set up the hamburger icon to open and close the drawer
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open,
                R.string.close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        navigate(mNavItemId);
    }

    /**
     * Performs the actual navigation logic, updating the main content fragment.
     */
    private void navigate(final int itemId) {
        switch (itemId) {
            case R.id.bmi:
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack("bmi")
                        .replace(R.id.content,bmi_cal)
                        .commit();
                break;
            case R.id.first_aid:
                getFragmentManager()
                        .beginTransaction().addToBackStack("first_aid")
                        .replace(R.id.content, FA)
                        .commit();
                break;
            case R.id.diet_chart:

                getFragmentManager()
                        .beginTransaction().addToBackStack("diet")
                        .replace(R.id.content, dc)
                        .commit();

//                notify_me();
                break;

            case R.id.home_icon:
                getFragmentManager()
                        .beginTransaction().addToBackStack("home")
                        .replace(R.id.content,hm)
                        .commit();
                break;
            case R.id.schedule:
                getFragmentManager()
                        .beginTransaction().addToBackStack("schedule")
                        .replace(R.id.content,sch)
                        .commit();
                break;
            case R.id.article:
                getFragmentManager()
                        .beginTransaction().addToBackStack("vaccine")
                        .replace(R.id.content,artcls)
                        .commit();
                break;

            case R.id.medicine_price:
                getFragmentManager()
                        .beginTransaction().addToBackStack("med_price")
                        .replace(R.id.content,mp)
                        .commit();
                break;

            case R.id.brand_generic:
                getFragmentManager()
                        .beginTransaction().addToBackStack("brand")
                        .replace(R.id.content,bg)
                        .commit();
                break;

            case R.id.symptom_checker:
                getFragmentManager()
                        .beginTransaction().addToBackStack("symptom")
                        .replace(R.id.content,sc)
                        .commit();
                break;
            case R.id.common_disease:
                getFragmentManager()
                        .beginTransaction().addToBackStack("symptom")
                        .replace(R.id.content,cd)
                        .commit();
                break;

            case R.id.vaccine:
                getFragmentManager()
                        .beginTransaction().addToBackStack("vaccine")
                        .replace(R.id.content,vc)
                        .commit();
                break;

    //            default:
    //                // ignore
//                break;
        }
    }

    public void animal(View v)
    {
        bundle=new Bundle();
        bundle.putString("type","animal");
        web_rt=new webview();
        web_rt.setArguments(bundle);

        getFragmentManager()
                .beginTransaction().addToBackStack("animal")
                .replace(R.id.content,web_rt)
                .commit();
    }

    public void burn(View v)
    {
        bundle=new Bundle();
        bundle.putString("type","thermal");
        web_rt=new webview();
        web_rt.setArguments(bundle);

        getFragmentManager()
                .beginTransaction().addToBackStack("burn")
                .replace(R.id.content,web_rt)
                .commit();
    }

    public void fever(View v)
    {
        bundle=new Bundle();
        bundle.putString("type","fever");
        web_rt=new webview();
        web_rt.setArguments(bundle);

        getFragmentManager()
                .beginTransaction().addToBackStack("fever")
                .replace(R.id.content,web_rt)
                .commit();
    }

    public void diarrea(View v)
    {
        bundle=new Bundle();
        bundle.putString("type","diarrea");
        web_rt=new webview();
        web_rt.setArguments(bundle);

        getFragmentManager()
                .beginTransaction().addToBackStack("diarrea")
                .replace(R.id.content,web_rt)
                .commit();
    }

    public void insect(View v)
    {
        bundle=new Bundle();
        bundle.putString("type","insect");
        web_rt=new webview();
        web_rt.setArguments(bundle);

        getFragmentManager()
                .beginTransaction().addToBackStack("insect")
                .replace(R.id.content,web_rt)
                .commit();
    }

    public void notify_me()
    {
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.bmi)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(3, mBuilder.build());


        
        Intent notificationIntent=new Intent(this,MainActivity.class);
        PendingIntent intent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        mBuilder.setContentIntent(intent);
    }

    public void cuts(View v)
    {
        bundle=new Bundle();
        bundle.putString("type","cuts");
        web_rt=new webview();
        web_rt.setArguments(bundle);

        getFragmentManager()
                .beginTransaction().addToBackStack("this")
                .replace(R.id.content,web_rt)
                .commit();
    }
    /**
     * Handles clicks on the navigation menu.
     */
    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {
        // update highlighted item in the navigation menu
        menuItem.setChecked(true);
        mNavItemId = menuItem.getItemId();

        // allow some time after closing the drawer before performing real navigation
        // so the user can see what is happening
        mDrawerLayout.closeDrawer(GravityCompat.START);
        mDrawerActionHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigate(menuItem.getItemId());
            }
        }, DRAWER_CLOSE_DELAY_MS);
        return true;
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.support.v7.appcompat.R.id.home) {
            return mDrawerToggle.onOptionsItemSelected(item);
        }
        if(item.getItemId()==R.id.action_settings)
        {
            getFragmentManager().beginTransaction().replace(R.id.content,abt).commit();
//            Toast.makeText(this,"selected",Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NAV_ITEM_ID, mNavItemId);
    }

    public void fab_listner(View view)
    {
//        hourly_certain hc=new hourly_certain();
//        AlertDialog ad=hc.onCreateDialog();
//        ad.show();

        final String choices[]={"Daily","For next X days"};




        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);


        ab.setTitle("Select A Reminder Type ");

        ab.setItems(choices, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                String selectedText = Arrays.asList(choices).get(which);
               dialog_hourly_certain(which);
               //to do with strings


            }
        });

        AlertDialog dialog = ab.create();

        dialog.show();

    }

    public void dialog_hourly_certain(final int position)
    {

        final String choices[]={"On hourly basis","For a certain time"};




        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);


        ab.setTitle("Day time setup");

        ab.setItems(choices, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                String selectedText = Arrays.asList(choices).get(which);

                if(which==0) {
                    dialog_hourly(position);
                }
                else
                    if(which==1)
                    {
                        dialog_certain(position);
                    }
                //to do with strings


            }
        });

        AlertDialog dialog = ab.create();

        dialog.show();


    }

    public void dialog_hourly(final int position)
    {
        DialogFragment dh=new hourly();
//        getFragmentManager().beginTransaction().replace(R.id.content,dh).commit();
        dh.show(getFragmentManager(),"dialog");
    }

    public void dialog_certain(int position)
    {
        DialogFragment dh=new certain();
        dh.show(getFragmentManager(),"dialog");


    }

    private web_for_articles wa;

    public void zika(View view)
    {

        String url;
        Bundle bundle=new Bundle();
        bundle.putString("url","file:///android_asset/Zika.html");
        wa=new web_for_articles();
        wa.setArguments(bundle);

        getFragmentManager()
                .beginTransaction().addToBackStack("zika")
                .replace(R.id.content,wa)
                .commit();
    }

    public void swineflu(View view)
    {

        String url;
        Bundle bundle=new Bundle();
        bundle.putString("url","file:///android_asset/swineflu.html");
        wa=new web_for_articles();
        wa.setArguments(bundle);

        getFragmentManager()
                .beginTransaction().addToBackStack("swine")
                .replace(R.id.content,wa)
                .commit();
    }

    public void medicine_and_math(View view)
    {

        String url;
        Bundle bundle=new Bundle();
        bundle.putString("url","file:///android_asset/mathanddoctor.html");
        wa=new web_for_articles();
        wa.setArguments(bundle);

        getFragmentManager()
                .beginTransaction().addToBackStack("maht")
                .replace(R.id.content,wa)
                .commit();
    }

    public void cough(View view)
    {

        String url;
        Bundle bundle=new Bundle();
        bundle.putString("url","file:///android_asset/cough.html");
        wa=new web_for_articles();
        wa.setArguments(bundle);

        getFragmentManager()
                .beginTransaction().addToBackStack("cough")
                .replace(R.id.content,wa)
                .commit();
    }





}
