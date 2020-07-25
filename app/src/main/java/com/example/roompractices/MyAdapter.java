package com.example.roompractices;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roompractices.entity.User;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private List<User> users;
    public MyAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        User current = users.get(position);
        holder.username.setText("Username: " + current.username);
        holder.age.setText("Age: " + current.age);
        holder.gender.setText("Gender: " + current.gender);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
