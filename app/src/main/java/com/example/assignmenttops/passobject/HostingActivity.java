package com.example.assignmenttops.passobject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityHostingBinding;

public class HostingActivity extends AppCompatActivity {
    private ActivityHostingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHostingBinding.inflate(getLayoutInflater());


        Fragment fragment=new PehlaFragment();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.frameHost,fragment);
        transaction.commit();

        setContentView(binding.getRoot());
    }

}