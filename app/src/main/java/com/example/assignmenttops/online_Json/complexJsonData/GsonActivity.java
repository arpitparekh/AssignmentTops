package com.example.assignmenttops.online_Json.complexJsonData;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityGsonBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GsonActivity extends AppCompatActivity {
    private ActivityGsonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGsonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String data=readFileFromAssets();

        if(data!=null){
            ArrayList<FoodItem>items=new ArrayList<>();
            Gson gson=new Gson();
            Type type=new TypeToken<ArrayList<FoodItem>>() {}.getType();
            items=gson.fromJson(data,type);
            binding.tvGson.setText(items.toString());
        }

    }

    private String readFileFromAssets() {
        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new InputStreamReader(getAssets().open("data.json")));
            String mLine,data="";
            while((mLine=reader.readLine())!=null){
                data+=mLine;
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}