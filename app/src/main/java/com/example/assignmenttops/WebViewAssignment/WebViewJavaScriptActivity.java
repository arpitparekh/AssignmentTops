package com.example.assignmenttops.WebViewAssignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityWebViewJavaScriptBinding;

public class WebViewJavaScriptActivity extends AppCompatActivity {
    private ActivityWebViewJavaScriptBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWebViewJavaScriptBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webViewJavaScript.loadUrl("file:///android_asset/demo.html");

        binding.webViewJavaScript.getSettings().setJavaScriptEnabled(true); // important

        binding.webViewJavaScript.addJavascriptInterface(new WebAppInterface(this),"Android");

    }

    private static class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

    }
}