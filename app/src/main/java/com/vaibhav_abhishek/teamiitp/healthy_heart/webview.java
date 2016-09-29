package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class webview extends Fragment {


    WebView web;

    String type;

    public webview() {

        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        type=getArguments().getString("type");
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_webview, container, false);

        web=(WebView) v.findViewById(R.id.browser);


        if(type.equals("animal"))
            web.loadUrl("file:///android_asset/AnimalBitesTreatment.html");

        else if(type.equals("cuts"))
            web.loadUrl("file:///android_asset/cuts.html");

        else if(type.equals("diarrea"))
            web.loadUrl("file:///android_asset/diarrea.html");

        else if(type.equals("fever"))
            web.loadUrl("file:///android_asset/fevr.html");

        else if(type.equals("insect"))
            web.loadUrl("file:///android_asset/insect.html");

        else if(type.equals("thermal"))
            web.loadUrl("file:///android_asset/thermal.html");



        return v;

    }

}
