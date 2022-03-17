package com.example.assignmenttops.recyclerview_crud_operation;

import android.graphics.Color;
import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttops.databinding.CountryRowItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> implements Filterable {


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String text = constraint.toString();

                if (text.equals("")) {
                    countryArrayList = originalList;         //display original data
                } else {
                    countryArrayList = new ArrayList<>();    //filtered data
                    for (Country country : originalList) {
                        if(country.getName().toLowerCase().contains(text.toLowerCase()))
                        {
                            countryArrayList.add(country);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = countryArrayList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                countryArrayList = (ArrayList<Country>) results.values;
                listener.updateList(countryArrayList);
                notifyDataSetChanged();
            }
        };
    }

    public interface onCountryClickListener {
        void onCountryClick(int position);
        void onCountryLongClick(int position);
        void updateList(ArrayList<Country> list);
    }



    private ArrayList<Country> countryArrayList, originalList;
    private onCountryClickListener listener;


    public CountryAdapter(ArrayList<Country> countryArrayList, onCountryClickListener listener) {
        this.countryArrayList = countryArrayList;
        this.originalList = countryArrayList;  //assign userList to originalList
        this.listener = listener;

    }

    @NotNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CountryRowItemBinding binding = CountryRowItemBinding.inflate(inflater, parent, false);

        CountryViewHolder viewHolder = new CountryViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CountryAdapter.CountryViewHolder holder, int position) {

        Country country = countryArrayList.get(position);
        holder.binding.setCountry(country);

        // change color based on Selection
        if (country.isSelected()) {
            holder.itemView.setBackgroundColor(Color.GREEN);
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
        //clickEvent
        holder.itemView.setOnClickListener(v -> {
            listener.onCountryClick(position);
        });
        holder.itemView.setOnLongClickListener(v -> {
            listener.onCountryLongClick(position);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return countryArrayList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        private CountryRowItemBinding binding;
        public CountryViewHolder(@NonNull CountryRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
