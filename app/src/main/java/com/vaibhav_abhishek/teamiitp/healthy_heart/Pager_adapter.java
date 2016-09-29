package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ImageView;

/**
 * Created by vaibhav on 28/8/16.
 */
public class Pager_adapter extends FragmentPagerAdapter {
    public ImageView imageView;
    public Pager_adapter(FragmentManager fm , ImageView img) {
        super(fm);
        imageView=img;


    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public int getItemPosition(Object object) {
       int pos=super.getItemPosition(object);

        return pos;

    }



    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
            {

                return new Case1();

            }
            case 1:
            {

                return new case2();
            }

        }
        return null;
    }
}
