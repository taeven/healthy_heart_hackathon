package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class web_for_articles extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_web_for_articles, container, false);
        String url=getArguments().getString("url");
        WebView wv=(WebView)view.findViewById(R.id.web_articles);
        wv.loadUrl(url);
        return view;
    }


}
