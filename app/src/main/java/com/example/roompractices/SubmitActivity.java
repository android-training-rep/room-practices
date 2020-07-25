package com.example.roompractices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roompractices.dao.UserDao;
import com.example.roompractices.entity.User;

public class SubmitActivity extends AppCompatActivity {
    UserDao userDao;
    EditText usernameView, ageView, genderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        usernameView = findViewById(R.id.username);
        ageView = findViewById(R.id.age);
        genderView = findViewById(R.id.gender);

        userDao = MyApplication.getUserDao();

        Button submitBtn = findViewById(R.id.btn_submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitUser();
            }
        });
    }

    private void submitUser() {

        String username = usernameView.getText().toString();
        int age = Integer.parseInt(ageView.getText().toString());
        int gender = Integer.parseInt(genderView.getText().toString());

        //todo 校验
        User user = new User(username,age,gender);
        userDao.insertUser(user);
        //todo toast
    }
}