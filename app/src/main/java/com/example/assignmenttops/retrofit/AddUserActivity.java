package com.example.assignmenttops.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityAddUserBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserActivity extends AppCompatActivity {
    private ActivityAddUserBinding binding;
    private UserData userData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();
        if(intent!=null){
            userData=intent.getParcelableExtra("update");
        }
        if(userData!=null){
            binding.firstNameRetrofit.setText(userData.firstName);
            binding.lastNameRetrofit.setText(userData.lastName);
            binding.emailNameRetrofit.setText(userData.email);
        }

        binding.btnSubmitRetroFit.setOnClickListener(v -> {

            ProjectService service=ProjectRetrofitClient.getService();


        if(userData==null){

            String firstName=binding.firstNameRetrofit.getText().toString();
            String lastName=binding.lastNameRetrofit.getText().toString();
            String email=binding.emailNameRetrofit.getText().toString();

            Call<String> call=service.insertUser(firstName,lastName,email);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    String msg=response.body();
                    Toast.makeText(AddUserActivity.this,msg,Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(AddUserActivity.this,t.toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }if(userData!=null){

                String firstName=binding.firstNameRetrofit.getText().toString();
                String lastName=binding.lastNameRetrofit.getText().toString();
                String email=binding.emailNameRetrofit.getText().toString();

                Call<String> call=service.updateUser(firstName,lastName,email,userData.id);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String msg=response.body();
                        Toast.makeText(AddUserActivity.this,msg,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(AddUserActivity.this,t.toString(),Toast.LENGTH_SHORT).show();

                    }
                });
            }

        Intent intent1=new Intent(this,RootActivity.class);
        startActivity(intent1);

        });

    }
}