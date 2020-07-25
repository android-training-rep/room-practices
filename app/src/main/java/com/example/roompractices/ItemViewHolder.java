package com.example.roompractices;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class ItemViewHolder extends RecyclerView.ViewHolder {
    public View itemView;
    public TextView username, age, gender;
    public ItemViewHolder(View v) {
        super(v);
        itemView = v;
        username = itemView.findViewById(R.id.username);
        age = itemView.findViewById(R.id.age);
        gender = itemView.findViewById(R.id.gender);
    }
}
