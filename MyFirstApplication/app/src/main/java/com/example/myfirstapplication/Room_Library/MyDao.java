package com.example.myfirstapplication.Room_Library;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

    @Query("select * from Users")
    public List<User> viewUser();

    @Delete
    public void deleteUser(User user);

    @Update
    public void updateUser(User user);
}
