package com.example.assignmenttops.file_storage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityReadWriteMessageBinding;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadWriteMessageActivity extends AppCompatActivity {
    private ActivityReadWriteMessageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityReadWriteMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnWriteMessage.setOnClickListener(v -> {

            String str=binding.edtFileReadWrite.getText().toString();
            try {
                FileOutputStream fileOutputStream = openFileOutput("Test", MODE_PRIVATE);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                Toast.makeText(this, "File Write SuccessFully", Toast.LENGTH_SHORT).show();
            }catch(Exception e){
                e.printStackTrace();
            }

        });
        binding.btnReadMessage.setOnClickListener(v -> {
            try {
                FileInputStream fileInputStream = openFileInput("Test");
                byte b[] = new byte[fileInputStream.available()];
                fileInputStream.read(b);
                fileInputStream.close();
                String str = new String(b);
                binding.tvReadWrite.setText(str);
            }catch(Exception e){
                e.printStackTrace();
            }
        });
        binding.btnWritePreference.setOnClickListener(v -> {
            SharedPreferences preferences=getSharedPreferences("TestPreference",MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            String message=binding.edtFileReadWrite.getText().toString();
            editor.putString("message",message);
            editor.putInt("score",700);
            editor.commit();
            Toast.makeText(this,"Shared Preference Written",Toast.LENGTH_SHORT).show();

        });
        binding.btnReadPreference.setOnClickListener(v -> {
            SharedPreferences preferences=getSharedPreferences("TestPreference",MODE_PRIVATE);
            //SharedPreferences.Editor editor=preferences.edit();
            String message=preferences.getString("message",null);
            int score=preferences.getInt("score",0); //show it in logi
            binding.tvReadWrite.setText(message);

        });
        binding.btnLogout.setOnClickListener(v -> {
            SharedPreferences sharedPreferences=getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.commit();

            Intent intent=new Intent(this,OneTimeLoginActivity.class);
            startActivity(intent);
            finish();

        });
    }
}