package com.example.roompractices.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roompractices.dao.UserDao;
import com.example.roompractices.entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static UserDatabase instance;

    public static UserDatabase getInstance(Context context){
        if (instance == null){
            synchronized (UserDatabase.class){
                if (instance == null){
                    instance = create(context);
                }
            }
        }
        return instance;
    }

    private static UserDatabase create(Context context) {
        return Room.databaseBuilder( context,UserDatabase.class,"users-db").allowMainThreadQueries().build();
    }
}
