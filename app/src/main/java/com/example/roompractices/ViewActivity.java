package com.example.roompractices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.roompractices.dao.UserDao;
import com.example.roompractices.entity.User;

import java.util.List;

public class ViewActivity extends AppCompatActivity {
    UserDao userDao;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        userDao = MyApplication.getUserDao();
        List<User> users = userDao.getAllUsers();
        Log.d("Users:", "Size:"+users.size());

        recyclerView = findViewById(R.id.user_recycler);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(users);
        recyclerView.setAdapter(myAdapter);
    }
}