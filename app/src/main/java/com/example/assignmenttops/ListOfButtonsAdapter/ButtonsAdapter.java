package com.example.assignmenttops.ListOfButtonsAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ButtonsAdapter extends RecyclerView.Adapter<ButtonsAdapter.ButtonsViewHolder> {
    private ArrayList<Buttons> buttons;

    public interface ButtonsClickListener{
        void onButtonsClick(Buttons button);
    }
    public void setItem(ArrayList<Buttons>buttons){
        this.buttons=buttons;
    }
    private ButtonsClickListener listener;

    public ButtonsAdapter(ButtonsClickListener listener){
        this.listener=listener;
    }


    @NotNull
    @Override
    public ButtonsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        ButtonsViewHolder viewHolder = new ButtonsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ButtonsAdapter.ButtonsViewHolder holder, int position) {
        Buttons button=buttons.get(position);
        holder.tvtitle.setText(button.getTitle());

        holder.itemView.setOnClickListener(v -> {
            listener.onButtonsClick(button);
        });

    }

    @Override
    public int getItemCount() {
        return buttons.size();
    }

    public class ButtonsViewHolder extends RecyclerView.ViewHolder {
        private TextView tvtitle;

        public ButtonsViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvtitle = itemView.findViewById(android.R.id.text1);
        }
    }
}
