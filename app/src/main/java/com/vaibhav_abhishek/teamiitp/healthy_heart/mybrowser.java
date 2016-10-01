package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by vaibhav on 1/10/16.
 */
public class mybrowser extends WebViewClient {


    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

}
