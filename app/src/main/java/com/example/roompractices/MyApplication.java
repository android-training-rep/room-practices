package com.example.roompractices;

import android.app.Application;
import android.content.Context;

import com.example.roompractices.dao.UserDao;
import com.example.roompractices.database.UserDatabase;

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static UserDao getUserDao() {
        return UserDatabase.getInstance(mContext).userDao();
    }
}
