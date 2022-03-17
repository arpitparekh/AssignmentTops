package com.example.assignmenttops.ActivitySwitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.assignmenttops.R;

public class Activity2 extends AppCompatActivity {
    private TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_2);

        Intent intent=getIntent();

        String message=intent.getStringExtra("message");

        tv2=findViewById(R.id.tv2);
        tv2.setText(message);

    }
}