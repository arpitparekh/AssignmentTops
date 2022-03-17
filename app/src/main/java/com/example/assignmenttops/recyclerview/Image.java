package com.example.assignmenttops.recyclerview;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.assignmenttops.R;

public class  Image {

    private String imageUrl;

    public Image(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @BindingAdapter("android:imageUrl")
    public static void loadImage(ImageView imageView, int imageUrl) {
        Glide.with(imageView)
                .load(imageUrl)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(imageView);
    }


}
