package com.shahin.ai;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView w;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        w = new WebView(this);
        WebSettings s = w.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        w.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView v, WebResourceRequest r, WebResourceError e) {
                if (r.isForMainFrame()) {
                    v.loadUrl("file:///android_asset/index.html");
                }
            }
        });
        w.loadUrl("http://127.0.0.1:8765");
        setContentView(w);
    }

    @Override
    public void onBackPressed() {
        if (w.canGoBack()) {
            w.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
