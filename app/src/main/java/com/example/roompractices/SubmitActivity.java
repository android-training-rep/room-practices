package com.example.roompractices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.NumberKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        genderView.setKeyListener(new NumberKeyListener() {
            @NonNull
            @Override
            protected char[] getAcceptedChars() {
                char numberChars[] = {'0', '1'};
                return numberChars;
            }

            @Override
            public int getInputType() {
                return 0;
            }
        });
    }

    private void submitUser() {
        String username = usernameView.getText().toString();
        int age = Integer.parseInt(ageView.getText().toString());
        int gender = Integer.parseInt(genderView.getText().toString());
        boolean usernameRight = username.length() <= 8;
        boolean genderRight = gender == 0 || gender == 1;
        boolean ageRight = age > 0 && age < 200;
        String toastText = "Add User Failure, Please check input!";
        if(usernameRight && genderRight && ageRight) {
            User user = new User(username,age,gender);
            userDao.insertUser(user);
            toastText = "Add User Success";
            Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
            finish();
        }
        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
    }
}