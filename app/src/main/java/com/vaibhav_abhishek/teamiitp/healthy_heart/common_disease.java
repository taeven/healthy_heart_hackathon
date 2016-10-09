package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;


public class common_disease extends Fragment {

    public common_disease() {
        // Required empty public constructor
        url="http://www.cdc.gov/diseasesconditions/";
    }

    private String url;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_common_disease, container, false);


        ProgressBar progressBar=(ProgressBar)view.findViewById(R.id.common_prog);
        progressBar.setVisibility(View.VISIBLE);

        WebView wv = (WebView) view.findViewById(R.id.common_disease_web);
//        ProgressDialog pd=new ProgressDialog(getActivity());
//        pd.setTitle("loading...");
//        pd.show();

        wv.setWebViewClient(new mybrowser(progressBar));
        wv.getSettings().setLoadsImagesAutomatically(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv.loadUrl(url);

        return  view;
    }


}
