package com.example.assignmenttops.rapid_api;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.assignmenttops.databinding.ActivityJobSearchBinding;
import com.example.assignmenttops.online_Json.JsonData;
import com.example.assignmenttops.online_Json.MyAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class JobSearch extends AppCompatActivity implements MyNewAsyncTask.onResponseListener {

//    https://job-search4.p.rapidapi.com/indeed/search?query=Software%20Engineer&page=2
//    "https://job-search4.p.rapidapi.com/simplyhired/search?query=Software%20Engineer&page=1"


//    https://rapidapi.com/lattice-data-lattice-data-default/api/job-search4/  from this website
    private ActivityJobSearchBinding binding;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityJobSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.btnSearch.setOnClickListener(v -> {
            String search=binding.edtJobSearch.getText().toString();
            String Url="https://job-search4.p.rapidapi.com/simplyhired/search?query="+search+"&page=1";

            pd=ProgressDialog.show(this,"Wait","Fetching Date");

            MyNewAsyncTask myAsyncTask=new MyNewAsyncTask();
            myAsyncTask.setRequestUrl(Url);
            myAsyncTask.setListener(this);
            myAsyncTask.execute();
        });


    }

    @Override
    public void onResponse(String response) {
        pd.dismiss();
        if(response.equals("")){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();

        }else {
            ArrayList<JobData> arrayList=new ArrayList<>();
            try {
                JSONObject masterObject =new JSONObject(response);
                JSONArray jsonArray=masterObject.getJSONArray("jobs");
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject object=jsonArray.getJSONObject(i);


                    String title=object.getString("title");
                    String companyName=object.getString("company_name");
                    String description=object.getString("description");
                    String state=object.getString("state");
                    String city=object.getString("city");


                    JobData jsonData=new JobData(title,companyName,description,state,city);
                    arrayList.add(jsonData);

                }
                ArrayAdapter<JobData> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
                binding.listViewJobSearch.setAdapter(adapter);

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
}