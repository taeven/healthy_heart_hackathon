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


public class medicine_price extends Fragment {


    public medicine_price() {
        // Required empty public constructor
        url="http://dawa.in/pages/all/medinfo.jsf";
    }

    private String url;

    private WebView wv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_medicine_price, container, false);

        ProgressBar pb= (ProgressBar)view.findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);
//        ProgressDialog pd=new ProgressDialog(getActivity());
        wv=(WebView)view.findViewById(R.id.medicine_price);
//        pd.setTitle("loading...");
//        pd.show();
        wv.setWebViewClient(new mybrowser(pb));

        wv.getSettings().setLoadsImagesAutomatically(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        wv.loadUrl(url);



        return view;
    }


}
