package com.example.assignmenttops.data_binding;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.assignmenttops.R;

public class Detail {
    private String name, email;
    private int age;
    private boolean isOnline;

    private String imageUrl;

    private static final String TAG = "Detail";

    public Detail() {

    }

    public Detail(String name, String email, int age, boolean isOnline, String imageUrl) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isOnline = isOnline;
        this.imageUrl = imageUrl;

    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public void handleClick(){
        Log.i(TAG, "handleClick: ");
    }

    @BindingAdapter("android:imageUrl")

    public static void loadImage(ImageView imageView,String imageUrl){
        Glide.with(imageView)
                .load(imageUrl)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(imageView);
    }


}
