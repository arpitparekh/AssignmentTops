package com.example.assignmenttops.ActivitySwitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.assignmenttops.R;

public class Activity1 extends AppCompatActivity {
    private EditText edt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        edt1=findViewById(R.id.edt1);

    }
    public void press(View view){
        String message=edt1.getText().toString();



        Intent intent=new Intent(this,Activity2.class);
        intent.putExtra("message", message);
        startActivity(intent);

        
        



}

}