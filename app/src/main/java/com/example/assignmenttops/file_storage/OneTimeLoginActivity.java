package com.example.assignmenttops.file_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityOneTimeLoginBinding;

public class OneTimeLoginActivity extends AppCompatActivity {
    private ActivityOneTimeLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOneTimeLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkUserLogin();

        binding.btnLoginFirstTime.setOnClickListener(v -> {
            String userName = binding.edtUserNameFirstTime.getText().toString();
            String password = binding.edtPasswordFirstTime.getText().toString();

            if (userName.equals("admin") && password.equals("123456")) {
                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userName", userName);
                editor.putBoolean("isLogin", true);
                editor.commit();
                Intent intent = new Intent(this, ReadWriteMessageActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }

    private void checkUserLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        boolean isLogin = sharedPreferences.getBoolean("isLogin", false);
        if (isLogin) {
            Intent intent = new Intent(this, ReadWriteMessageActivity.class);
            startActivity(intent);
            finish();
        }
    }
}