package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class After_bg_show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_bg_show);
//        ViewPager viewPager=(ViewPager)findViewById(R.id.viewPager);
//        viewPager.setAdapter(new Pager_adapter(getSupportFragmentManager()));
        Intent i=new Intent("com.incals.vaibhav.babaplant.login_page");
        startActivity(i);
    }
}
