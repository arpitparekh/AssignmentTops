package com.example.assignmenttops;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.assignmenttops.databinding.ActivityViewBindingBinding;

public class ViewBindingActivity extends AppCompatActivity {
    private ActivityViewBindingBinding binding;
    private static final String TAG="message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("hi");

        binding= ActivityViewBindingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnbinding.setOnClickListener(v -> {

            String message=binding.edtbinding.getText().toString();
            Log.i(TAG,message);
        });
    }
}