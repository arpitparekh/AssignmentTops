package com.example.assignmenttops.dialog_assignment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttops.databinding.GmailRecyclerBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GmailAdapter extends RecyclerView.Adapter<GmailAdapter.GmailViewHolder>{
    private ArrayList<GmailData> gmailDataArrayList;
    private GmailAdapter adapter;
    private onGmailClickListener listener;
    private GmailData addData;


    public interface onGmailClickListener{
        void onGmailClick(int position);
        void onGmailLongClick(int position);
//        void removeItem(int position);
    }

    public GmailAdapter(ArrayList<GmailData>gmailDataArrayList,onGmailClickListener listener){
        this.gmailDataArrayList=gmailDataArrayList;
        this.listener=listener;
    }
    @NotNull
    @Override
    public GmailViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        GmailRecyclerBinding binding=GmailRecyclerBinding.inflate(inflater,parent,false);
        GmailViewHolder viewHolder=new GmailViewHolder(binding);
        
        return viewHolder;
    }




    @Override
    public void onBindViewHolder(@NonNull GmailAdapter.GmailViewHolder holder, int position) {

        GmailData gmailData=gmailDataArrayList.get(position);
        holder.binding.setGmail(gmailData);
//
        holder.itemView.setOnClickListener(v -> {
            listener.onGmailClick(position);
        });
        holder.itemView.setOnLongClickListener(v -> {
            listener.onGmailLongClick(position);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return gmailDataArrayList.size();
    }



    public class GmailViewHolder extends RecyclerView.ViewHolder {
        private GmailRecyclerBinding binding;
        public GmailViewHolder(@NonNull GmailRecyclerBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }
//    public void removeItem(int position){
//        gmailDataArrayList.remove(position);
//        notifyDataSetChanged();
//    }
//    public void addItem(String str, int position){
//        gmailDataArrayList.set(position,addData);
//        notifyDataSetChanged();
//    }

}
