package com.example.assignmenttops.viewpager_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityViewPagerHostBinding;

public class ViewPagerHostActivity extends AppCompatActivity {
    private ActivityViewPagerHostBinding binding;
    private MyPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityViewPagerHostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter=new MyPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new ChatFragment(),"Chat");
        adapter.addFragment(new CameraFragment(),"Camera");
        adapter.addFragment(new StatusFragment(),"Status");

        binding.viewPagerHost.setAdapter(adapter);

        binding.tabLayout.setupWithViewPager(binding.viewPagerHost);




    }

}