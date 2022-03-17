package com.example.assignmenttops.recyclerview;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttops.databinding.EmployeeRowItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    public interface onEmployeeClickListner {
        void onEmployeeClick(int position);
    }

    ArrayList<Employee> employeeArrayList;
    private onEmployeeClickListner listner;

    public EmployeeAdapter(ArrayList<Employee> employeeArrayList, onEmployeeClickListner listner) {
        this.employeeArrayList = employeeArrayList;
        this.listner = listner;
    }

    @NotNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        EmployeeRowItemBinding binding = EmployeeRowItemBinding.inflate(inflater, parent, false);

        EmployeeViewHolder viewHolder = new EmployeeViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EmployeeAdapter.EmployeeViewHolder holder, int position) {
        Employee employee = employeeArrayList.get(position);
        holder.binding.setEmployee(employee);
        holder.itemView.setOnClickListener(v -> {
            listner.onEmployeeClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return employeeArrayList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        EmployeeRowItemBinding binding;

        public EmployeeViewHolder(@NonNull EmployeeRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

