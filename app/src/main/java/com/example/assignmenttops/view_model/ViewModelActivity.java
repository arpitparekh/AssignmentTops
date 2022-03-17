package com.example.assignmenttops.view_model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.assignmenttops.databinding.ActivityViewModelBinding;

public class ViewModelActivity extends AppCompatActivity {
    private ActivityViewModelBinding binding;
    //private int count=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityViewModelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CounterViewModel viewModel=new ViewModelProvider(this).get(CounterViewModel.class);
        viewModel.getCounter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer count) {
                binding.tvViewModel.setText("Count is :"+count);
            }
        });



        binding.btnViewModel.setOnClickListener(v -> {
           viewModel.setCounter();
        });
    }

}