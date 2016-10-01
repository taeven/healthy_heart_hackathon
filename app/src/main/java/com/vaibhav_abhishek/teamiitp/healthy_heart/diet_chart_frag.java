package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class diet_chart_frag extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_diet_chart_frag, container, false);
        WebView wv=(WebView)view.findViewById(R.id.web_diet);
        wv.loadUrl("file:///android_asset/diet.html");
        wv.getSettings().setBuiltInZoomControls(true);


        return  view;
    }

}
