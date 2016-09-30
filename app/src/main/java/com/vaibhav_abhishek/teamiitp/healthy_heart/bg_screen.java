package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class bg_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bg_screen);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i= new Intent("com.vaibhav_abhishek.teamiitp.healthy_heart.MainActivity");
                startActivity(i);
            }
        }, 1500);

    }



}

