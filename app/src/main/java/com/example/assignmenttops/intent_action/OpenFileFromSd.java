package com.example.assignmenttops.intent_action;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.OpenableColumns;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityOpenFileFromSdBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class OpenFileFromSd extends AppCompatActivity {
    private ActivityOpenFileFromSdBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOpenFileFromSdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityResultLauncher<String> mContent = registerForActivityResult(
                new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        if (result != null) {
                            String newFilePath = copyFileToInternal(result);
                            if (newFilePath != null) {
                                binding.tvFilePath.setText(newFilePath);
                                Bitmap bitmap = BitmapFactory.decodeFile(newFilePath);
                                binding.imageViewOpenFile.setImageBitmap(bitmap);
//
                            }
                        }
                    }
                }
        );

        binding.btnOpenFile.setOnClickListener(v -> {
//            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//            intent.addCategory(Intent.CATEGORY_OPENABLE);
//            intent.setType("image/*");
//            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            startActivityForResult(intent, 101);
            mContent.launch("image/*");
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == 101) {
//            if (data != null && data.getData() != null) {
//                //API 30
//                String newFilePath = copyFileToInternal(data.getData());
//                if(newFilePath!=null){
//                    binding.tvFilePath.setText(newFilePath);
//                    Bitmap bitmap= BitmapFactory.decodeFile(newFilePath);
//                    binding.imageViewOpenFile.setImageBitmap(bitmap);
//
//                }
//            }
//        }
//    }

    private String copyFileToInternal(Uri fileUri) {

        //query
        Cursor cursor = getContentResolver().query(fileUri, new String[]{OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE}
                , null, null, null);
        cursor.moveToFirst();

        String displayName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
        long size = cursor.getLong(cursor.getColumnIndex(OpenableColumns.SIZE));
        binding.tvOpenFile.setText("name is :" + displayName + " and size is :" + size);
        File file = new File(getFilesDir() + "/" + displayName);
        try {
            FileOutputStream os = new FileOutputStream(file);
            InputStream is = getContentResolver().openInputStream(fileUri);

            byte buffers[] = new byte[1024];
            int read;
            while ((read = is.read(buffers)) != -1) {
                os.write(buffers, 0, read);

            }
            is.close();
            os.close();
            return file.getPath();


        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }
}