package com.example.assignmenttops.WebViewAssignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityNewWebViewBinding;

public class NewWebViewActivity extends AppCompatActivity {
    private ActivityNewWebViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnWenView.setOnClickListener(v -> {
            String str= binding.edtUrl.getText().toString();
            binding.NewWebView.loadUrl("https://www.google.com/search?q="+str+"&sxsrf=ALeKk01uaRdyePUx5nb8pm03mxOYriWPkA%3A1620961328212&source=hp&ei=MOidYMmwCpHfz7sP2-WDqA0&iflsig=AINFCbYAAAAAYJ32QHYvd1Sub5SjBilt4WYkBnV2XTOY&oq=text&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyBAgjECcyBAgjECcyBQgAEJECMgUIABCRAjIICAAQsQMQgwEyCAgAELEDEIMBMgIILjIFCAAQsQMyAggAOgcIIxDqAhAnULkRWNITYPAXaAFwAHgAgAGdAYgB1ASSAQMwLjSYAQCgAQGqAQdnd3Mtd2l6sAEK&sclient=gws-wiz&ved=0ahUKEwjJiKTBl8jwAhWR73MBHdvyANUQ4dUDCAc&uact=5");

        });
        binding.NewWebView.setWebViewClient(new WebClass());
    }

    private class WebClass extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}