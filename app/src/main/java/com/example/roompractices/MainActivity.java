package com.example.roompractices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_USER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewBtn = findViewById(R.id.btn_view);
        Button addBtn = findViewById(R.id.btn_add);

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toViewPage();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAddPage();
            }
        });
    }

    private void toAddPage() {
        Intent intent = new Intent(this, SubmitActivity.class);
        startActivity(intent);
    }
    private void toViewPage() {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }
}