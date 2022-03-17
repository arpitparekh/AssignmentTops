package com.example.assignmenttops.dialog_assignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityDialogBinding;
import com.example.assignmenttops.databinding.DisplayDataBinding;

public class DialogActivity extends AppCompatActivity {
    private ActivityDialogBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btndialogBox.setOnClickListener(v -> {
            DisplayDataBinding binding=DisplayDataBinding.inflate(getLayoutInflater());
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("This is demo DialogBox");
            builder.setView(binding.getRoot());

            builder.setIcon(R.drawable.ic_icon);

            builder.setMessage("This is Description");

            builder.setPositiveButton("Yes",((dialog, which) -> {
                Toast.makeText(this,"Yes is Clicked",Toast.LENGTH_SHORT).show();
            }));
            builder.setNegativeButton("No",((dialog, which) -> {
                Toast.makeText(this,"No is Clicked",Toast.LENGTH_SHORT).show();
            }));
            builder.setNeutralButton("Cancel",((dialog, which) -> {
                Toast.makeText(this,"Cancel is Clicked",Toast.LENGTH_SHORT).show();
            }));
            AlertDialog dialog=builder.create();
            dialog.show();
        });
    }
}