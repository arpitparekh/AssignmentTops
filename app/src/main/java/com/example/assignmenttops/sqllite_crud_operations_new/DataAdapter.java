package com.example.assignmenttops.sqllite_crud_operations_new;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttops.databinding.DataRowItemBinding;
import com.example.assignmenttops.sqllite_crud_operations_new.database_sqllite.Data;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    List<Data>dataList;
    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    @NotNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        DataRowItemBinding binding=DataRowItemBinding.inflate(inflater,parent,false);
        DataViewHolder viewHolder=new DataViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DataAdapter.DataViewHolder holder, int position) {

        Data theData=dataList.get(position);
        holder.binding.setData(theData);


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        private DataRowItemBinding binding;
        public DataViewHolder(@NonNull DataRowItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
