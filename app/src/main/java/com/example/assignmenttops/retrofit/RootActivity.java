package com.example.assignmenttops.retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Delete;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityRootBinding;
import com.example.assignmenttops.recyclerview.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RootActivity extends AppCompatActivity {
    private ActivityRootBinding binding;
    private ArrayAdapter<UserData>adapter;
    private List<UserData>userDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRootBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        fetchUserList();

        binding.listViewRetrofit.setOnItemClickListener((parent, view, position, id) -> {
            UserData userData=userDataList.get(position);
            new AlertDialog.Builder(this)
                    .setTitle("Choose one")
                    .setPositiveButton("Delete",(dialog,which)->{

                        ProjectService service=ProjectRetrofitClient.getService();
                        Call<String> call=service.deleteUser(userData.id);

                        call.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                String msg=response.body();
                                Toast.makeText(RootActivity.this,msg,Toast.LENGTH_SHORT).show();
                                fetchUserList();
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(RootActivity.this,t.toString(),Toast.LENGTH_SHORT).show();
                            }
                        });

                    })
                    .setNegativeButton("Update",(Dialog,which)->{
                        Intent intent=new Intent(this,AddUserActivity.class);
                        intent.putExtra("update",userData);
                        startActivity(intent);


                    })
                    .create().show();
        });
    }
    private void fetchUserList() {
        ProjectService service=ProjectRetrofitClient.getService();
        Call<List<UserData>>call=service.getUserData();
        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                userDataList=response.body();
                Toast.makeText(RootActivity.this,userDataList.toString(),Toast.LENGTH_SHORT).show();
                setMyAdapter(userDataList);
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {

                Toast.makeText(RootActivity.this,t.toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchUserList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_add){
            Intent intent=new Intent(this,AddUserActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }



    private void setMyAdapter(List<UserData>userDataList) {
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,userDataList);
        binding.listViewRetrofit.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}