package com.example.assignmenttops.WebViewAssignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityLoadHtmlWebViewBinding;

public class LoadHtmlWebViewActivity extends AppCompatActivity {
    private ActivityLoadHtmlWebViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoadHtmlWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loadHtml.setOnClickListener(v -> {
            binding.WebViewLoadHtml.loadUrl("file:///android_asset/text.html");
        });
        binding.WebViewLoadHtml.setWebViewClient(new Webclass());
    }
    private class Webclass extends WebViewClient {
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