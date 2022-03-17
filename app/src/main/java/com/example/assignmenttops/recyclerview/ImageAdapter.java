package com.example.assignmenttops.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ImageRowItemBinding;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {


    public interface onImageClickListener{
        public void onImageClick(int position);
    }
//    public interface onRatingClick{
//        void onRatingClick(int position);
//    }
    private ArrayList<Image>images;
    private onImageClickListener listener;

    //private onRatingClick ratingClick;

    public ImageAdapter(ArrayList<Image>images,onImageClickListener listener){
    this.images=images;
    this.listener=listener;
    //this.ratingClick=ratingClick;
    }

    @NotNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ImageRowItemBinding binding=ImageRowItemBinding.inflate(inflater,parent,false);
        ImageViewHolder viewHolder=new ImageViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ImageAdapter.ImageViewHolder holder, int position) {
        Image image=images.get(position);
        holder.binding.setImage(image);

        holder.itemView.setOnClickListener(v -> {
            listener.onImageClick(position);

            //ratingClick.onRatingClick(position);

        });



    }
    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageRowItemBinding binding;
        public ImageViewHolder(@NonNull ImageRowItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
