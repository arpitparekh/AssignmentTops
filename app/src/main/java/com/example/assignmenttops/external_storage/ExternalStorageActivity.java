package com.example.assignmenttops.external_storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;

import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityExternalStorageBinding;


import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static android.os.Build.VERSION.SDK_INT;

public class ExternalStorageActivity extends AppCompatActivity {
    private static final int REQ_WRITE_EXTERNAL = 100;
    private static final String TAG = "External";
    private ActivityExternalStorageBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExternalStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnWriteExternal.setOnClickListener(v -> {
            String message = binding.edtExternalStorage.getText().toString();

            File file = Environment.getExternalStorageDirectory();
            file = new File(file, getString(R.string.app_name));
            if (!file.exists()) {
                if (file.mkdirs()) {
                    Toast.makeText(getApplicationContext(), "Dir Created", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Dir not Created", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            file = new File(file, "test.txt");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(message.getBytes());
                fos.close();
                Toast.makeText(this, "File Written Success!!!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }


        });
        binding.btnReadExternal.setOnClickListener(v -> {

            File file = Environment.getExternalStorageDirectory();
            file = new File(file, getString(R.string.app_name));
            if (!file.exists()) {
                if (file.mkdir()) {
                    Toast.makeText(getApplicationContext(), "Dir Created", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Dir not Created", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            file = new File(file, "test.txt");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte b[] = new byte[fileInputStream.available()];
                fileInputStream.read(b);
                fileInputStream.close();
                String msg = new String(b);
                binding.tvExternal.setText(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        // CHECK PERMISSION HERE IMPORTANT
        checkPermissionAllowDenied();


    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkPermissionAllowDenied() {


        if (SDK_INT >= Build.VERSION_CODES.R) {
            if(!Environment.isExternalStorageManager()) {
                try {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(String.format("package:%s", getApplicationContext().getPackageName())));
                    startActivityForResult(intent, 2296);
                } catch (Exception e) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                    startActivityForResult(intent, 2296);
                }
            }
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQ_WRITE_EXTERNAL);
            }
        }


        
//            if(shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
//                //show dialog explain reason for permission
//                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQ_WRITE_EXTERNAL);
//
//            }else{
//                //Ask for Permission First Time Application Started
//                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQ_WRITE_EXTERNAL);
//            }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_WRITE_EXTERNAL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                binding.btnWriteExternal.setVisibility(View.GONE);
                binding.btnReadExternal.setVisibility(View.GONE);
            }
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2296) {
            if (SDK_INT >= Build.VERSION_CODES.R) {
                if (Environment.isExternalStorageManager()) {
                    Toast.makeText(this, "Allowed permission", Toast.LENGTH_SHORT).show();
                    // perform action when allow permission success
                } else {
                    binding.btnWriteExternal.setVisibility(View.GONE);
                    binding.btnReadExternal.setVisibility(View.GONE);
                }
            }
        }
    }
}