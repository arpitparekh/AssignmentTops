package com.example.assignmenttops.other_stuff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.assignmenttops.R;

public class OtherStuffMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_stuff_main);
        setTitle("Assignment and Practice");

        Fragment fragement=new ListOfbuttonsFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.otherstufflinear,fragement)
                .commit();
    }
}