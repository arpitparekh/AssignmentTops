package com.example.assignmenttops.viewpager_assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ChatRowItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    ArrayList<ChatData>chatDataArrayList;
    public ChatAdapter(ArrayList<ChatData>chatDataArrayList){
        this.chatDataArrayList=chatDataArrayList;

    }
    @NotNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ChatRowItemBinding binding=ChatRowItemBinding.inflate(inflater,parent,false);
        ChatViewHolder viewHolder=new ChatViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ChatAdapter.ChatViewHolder holder, int position) {
        ChatData chatData=chatDataArrayList.get(position);
        holder.binding.setChatdata(chatData);
    }

    @Override
    public int getItemCount() {
        return chatDataArrayList.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        private ChatRowItemBinding binding;
        public ChatViewHolder(@NonNull ChatRowItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
