package com.example.assignmenttops.broadcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.example.assignmenttops.databinding.ActivityBroadcastBinding;

public class BroadcastActivity extends AppCompatActivity {
    private ActivityBroadcastBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityBroadcastBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BroadcastReceiver receiver=new MyReceiver(binding.edtOtp);
        IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(receiver,filter);
    }
}