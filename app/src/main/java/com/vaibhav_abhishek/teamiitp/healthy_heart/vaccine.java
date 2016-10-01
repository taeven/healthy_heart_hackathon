package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;


public class vaccine extends Fragment {


    private WebView wv;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_vaccine, container, false);

        wv=(WebView)v.findViewById(R.id.web_vaccine);
        wv.loadUrl("file:///android_asset/vaccine.html");
        wv.getSettings().setBuiltInZoomControls(true);


        return v;
    }





}
