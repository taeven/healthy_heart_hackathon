package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class home extends Fragment {

    public home() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        WebView wv=(WebView) view.findViewById(R.id.webView_for_home);
        wv.loadUrl("file:///android_asset/home.html");

        return view;
    }

}
