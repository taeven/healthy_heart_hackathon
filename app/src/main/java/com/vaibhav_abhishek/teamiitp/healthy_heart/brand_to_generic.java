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


public class brand_to_generic extends Fragment {
  WebView wv;
    private String url;

    public brand_to_generic() {
        // Required empty public constructor
        url="http://www.emedexpert.com/lists/brand-generic.shtml";
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_brand_to_generic, container, false);
        wv=(WebView)view.findViewById(R.id.brand_to_generic);

        ProgressBar progressBar=(ProgressBar)view.findViewById(R.id.brand_prog);
        progressBar.setVisibility(View.VISIBLE);
//
//        ProgressDialog pd=new ProgressDialog(getActivity());
//        pd.setTitle("loading...");
//        pd.setMessage("please waitwhile page loads");
//        pd.show();
        wv.setWebViewClient(new mybrowser(progressBar));
        wv.getSettings().setLoadsImagesAutomatically(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.loadUrl(url);


        return view;
    }

}
