package com.example.myfirstapplication.Room_Library;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")        //默认使用类名定义表格名，修改tableName属性以修改
public class User {

    @PrimaryKey                       //必须定义一个列为PrimaryKey
    private int id;

    @ColumnInfo(name = "user_name")  //默认使用变量名作为列名，修改name属性以修改
    private String name;

    @ColumnInfo(name = "user_email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
