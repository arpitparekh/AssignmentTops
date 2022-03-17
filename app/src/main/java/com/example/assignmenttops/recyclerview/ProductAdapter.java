package com.example.assignmenttops.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttops.databinding.ProductRowItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    ArrayList<Product> productArrayList;
    onProductClickListener listener;

    public interface onProductClickListener {
        void onProductClick(int position);


    }

    public ProductAdapter(ArrayList<Product> productArrayList, onProductClickListener listener) {
        this.productArrayList = productArrayList;
        this.listener = listener;
    }

    @NotNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProductRowItemBinding binding = ProductRowItemBinding.inflate(inflater, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductAdapter.ProductViewHolder holder, int position) {
        Product product = productArrayList.get(position);
        holder.binding.setProduct(product);
        holder.itemView.setOnClickListener(v -> {
            listener.onProductClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ProductRowItemBinding binding;

        public ProductViewHolder(@NonNull ProductRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
