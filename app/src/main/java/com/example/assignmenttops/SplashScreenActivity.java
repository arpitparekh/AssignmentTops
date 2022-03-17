package com.example.assignmenttops;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // this is for full screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //for no title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash_screen);

        //A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue
        Handler handler =new Handler();
        handler.postDelayed(this,4000);
    }

    @Override
    public void run() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}