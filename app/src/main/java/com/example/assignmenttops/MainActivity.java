package com.example.assignmenttops;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.assignmenttops.LoginForgetNewUser.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment=new LoginFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainlinear,fragment)
                .commit();

    }
}