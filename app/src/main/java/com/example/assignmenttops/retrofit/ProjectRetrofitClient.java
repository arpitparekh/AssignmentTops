package com.example.assignmenttops.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ProjectRetrofitClient {

    public static ProjectService service;

    public static ProjectService getService(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        if(service==null){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("http://192.168.0.7/practice/")
                    .addConverterFactory(ScalarsConverterFactory.create()) //important
                    .addConverterFactory(GsonConverterFactory.create(gson))

                    .build();
            service =retrofit.create(ProjectService.class);
        }
        return service;
    }

}
