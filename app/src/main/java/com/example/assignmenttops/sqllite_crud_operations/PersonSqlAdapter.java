package com.example.assignmenttops.sqllite_crud_operations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttops.databinding.PerosnSqlRowItemBinding;
import com.example.assignmenttops.sqllite_crud_operations.database.PersonDataSql;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PersonSqlAdapter extends RecyclerView.Adapter<PersonSqlAdapter.PersonSqlViewHolder> {

    List<PersonDataSql> list;

    public PersonSqlAdapter(List<PersonDataSql> list) {
        this.list = list;
    }

    @NotNull
    @Override
    public PersonSqlViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PerosnSqlRowItemBinding binding = PerosnSqlRowItemBinding.inflate(inflater, parent, false);
        PersonSqlViewHolder viewHolder = new PersonSqlViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PersonSqlAdapter.PersonSqlViewHolder holder, int position) {
        PersonDataSql personDataSql =list.get(position);
        holder.binding.setPersonsql(personDataSql);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PersonSqlViewHolder extends RecyclerView.ViewHolder {

        private PerosnSqlRowItemBinding binding;

        public PersonSqlViewHolder(@NonNull PerosnSqlRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
