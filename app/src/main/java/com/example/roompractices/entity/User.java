package com.example.roompractices.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    public String username;
    public int age;
    public int gender;

    public User(String username, int age, int gender) {
        this.username = username;
        this.age = age;
        this.gender = gender;
    }
}
