package com.example.assignmenttops.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttops.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private ArrayList<User> userList;

    public void setUser(ArrayList<User> userList ){
        this.userList=userList;
    }



    @NotNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.user_row_item,parent,false);
        UserViewHolder userViewHolder=new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserAdapter.UserViewHolder holder, int position) {
        User user=userList.get(position);
        holder.tvname.setText("Name is : "+user.getName());
        holder.tvphone.setText("Name is : "+user.getPhone());
        holder.tvemail.setText("Name is : "+user.getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvname,tvphone,tvemail;
        public UserViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.tvname);
            tvphone=itemView.findViewById(R.id.tvphone);
            tvemail=itemView.findViewById(R.id.tvemail);
        }
    }
}
