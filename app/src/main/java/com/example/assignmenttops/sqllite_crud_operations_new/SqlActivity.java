package com.example.assignmenttops.sqllite_crud_operations_new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivitySqlBinding;

public class SqlActivity extends AppCompatActivity {
    private ActivitySqlBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySqlBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}