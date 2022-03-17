package com.example.assignmenttops.data_binding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {
    private ActivityDataBindingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        binding.setMessage("This is DataBindingActivity");

        Detail detail=new Detail("Arpit",
                "arpitparekh9@gmail",
                23,
                true,
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png");
        binding.setDetail(detail);
    }
}