package com.example.assignmenttops.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ProjectService {

    @GET("hello.php?flag=SELECT")
    Call<List<UserData>> getUserData();

    @FormUrlEncoded
    @POST("hello.php?flag=INSERT")
    Call<String> insertUser(@Field("first_name") String firstName,
                            @Field("last_name") String lastName,
                            @Field("email") String email);
    @FormUrlEncoded
    @POST("hello.php?flag=UPDATE")
    Call<String> updateUser(@Field("first_name") String firstName,
                            @Field("last_name") String lastName,
                            @Field("email") String email,
                            @Field("id") String id);
    @FormUrlEncoded
    @POST("hello.php?flag=DELETE")
    Call<String> deleteUser(@Field("id") String id);
}
