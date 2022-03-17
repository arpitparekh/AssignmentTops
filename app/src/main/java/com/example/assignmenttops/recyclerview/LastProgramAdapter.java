package com.example.assignmenttops.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttops.databinding.LastProgramRowItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LastProgramAdapter extends RecyclerView.Adapter<LastProgramAdapter.LastProgramViewHolder> {



    public interface onDataClickListener{
        void onDataClick(int position);
        void onDataLongClick(int position);
    }

    private ArrayList<LastProgramData>lastProgramDataArrayList;
    private onDataClickListener listener;

    public LastProgramAdapter(ArrayList<LastProgramData>lastProgramDataArrayList,onDataClickListener listener){
        this.lastProgramDataArrayList=lastProgramDataArrayList;
        this.listener=listener;
    }
    @NotNull
    @Override
    public LastProgramViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        LastProgramRowItemBinding binding=LastProgramRowItemBinding.inflate(inflater,parent,false);
        LastProgramViewHolder viewHolder=new LastProgramViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LastProgramAdapter.LastProgramViewHolder holder, int position) {
        LastProgramData lastProgramData=lastProgramDataArrayList.get(position);
        holder.binding.setLastprogramdata(lastProgramData);

        holder.itemView.setOnClickListener(v -> {
            listener.onDataClick(position);
        });
        holder.itemView.setOnLongClickListener(v -> {
            listener.onDataLongClick(position);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return lastProgramDataArrayList.size();
    }

    public class LastProgramViewHolder extends RecyclerView.ViewHolder {
        LastProgramRowItemBinding binding;
        public LastProgramViewHolder(@NonNull LastProgramRowItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
