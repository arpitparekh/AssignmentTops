package com.example.assignmenttops.prepopulateRoom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityMyDbBinding;

import java.util.ArrayList;
import java.util.List;

public class MyDbActivity extends AppCompatActivity {
    private ActivityMyDbBinding binding;
    private   List<datatable> dbDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyDbBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DbDatabase db=DbDatabase.getInstance(this);
        DbDao dbDao=db.dbDao();

        dbDataList=dbDao.getAllDbData();

        ArrayAdapter<datatable>adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dbDataList);

        binding.listViewDb.setAdapter(adapter);



        Toast.makeText(this,dbDataList.toString(),Toast.LENGTH_SHORT).show();


    }
}