package com.example.assignmenttops.online_Json;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.ArrayAdapter;

import com.example.assignmenttops.databinding.ActivityOnlineBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class OnlineActivity extends AppCompatActivity implements MyAsyncTask.onResponseListener {
    private ActivityOnlineBinding binding;
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOnlineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pd=ProgressDialog.show(this,"Wait","Fetching Date");

        MyAsyncTask myAsyncTask=new MyAsyncTask();
        myAsyncTask.setRequestUrl("https://jsonplaceholder.typicode.com/posts/");
        myAsyncTask.setListener(this);
        myAsyncTask.execute();


    }

    @Override
    public void onResponse(String response) {
        pd.dismiss();
        ArrayList<JsonData>arrayList=new ArrayList<>();
        try {

            JSONArray jsonArray=new JSONArray(response);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject object=jsonArray.getJSONObject(i);
                int userId=object.getInt("userId");
                int id=object.getInt("id");
                String title=object.getString("title");
                String body=object.getString("body");
                JsonData jsonData=new JsonData(userId,id,title,body);
                arrayList.add(jsonData);

            }
            ArrayAdapter<JsonData> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
            binding.listViewOnline.setAdapter(adapter);

//            JSONObject object=new JSONObject(response);
//            String title= object.getString("title");
//            String body=object.getString("body");
//
//            binding.tvOnline.setText(title+"\n\n\n"+body);



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}