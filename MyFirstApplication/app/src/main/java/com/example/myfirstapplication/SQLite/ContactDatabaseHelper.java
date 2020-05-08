package com.example.myfirstapplication.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ContactDatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Contact_db";

    public static final String CREATE_TABLE = "create table " + ContactContract.ContactEntry.TABLE_NAME + "("
            + ContactContract.ContactEntry.CONTACT_ID + " number," + ContactContract.ContactEntry.NAME + " text,"
            + ContactContract.ContactEntry.EMAIL + " text)";

    public static final String DROP_TABLE = "drop table if exists " + ContactContract.ContactEntry.TABLE_NAME;

    //SQLiteOpenHelper的子类必须有此构造函数
    public ContactDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        //此构造函数中必须调用父类的构造函数
        super(context, name, factory, version);
        Log.d("Database operations","Database created...");
    }

    public ContactDatabaseHelper(Context context){
        this(context,DATABASE_NAME);  //此构造函数调用下面一个构造函数，形成迭代调用
    }

    public ContactDatabaseHelper(Context context,String name){
        this(context,name,VERSION);
    }


    public ContactDatabaseHelper(Context context, String name, int version){
        this(context,name,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database operations","Table created...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addContact(int id,String name,String email,SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.CONTACT_ID,id);
        contentValues.put(ContactContract.ContactEntry.NAME,name);
        contentValues.put(ContactContract.ContactEntry.EMAIL,email);
        database.insert(ContactContract.ContactEntry.TABLE_NAME,null,contentValues);
        Log.d("Database operations","One raw inserted...");
    }
}
