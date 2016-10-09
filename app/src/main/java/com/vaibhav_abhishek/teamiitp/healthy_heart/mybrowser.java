package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by vaibhav on 1/10/16.
 */
public class mybrowser extends WebViewClient {

    ProgressBar pb;
    public mybrowser(ProgressBar pd) {
      this.pb=pd;
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {


        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {


        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        pb.setVisibility(View.GONE);

    }
}
