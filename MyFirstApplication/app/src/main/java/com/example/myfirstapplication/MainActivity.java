package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapplication.Fragment.ContainerActivity;
import com.example.myfirstapplication.Room_Library.Container4RoomActivity;
import com.example.myfirstapplication.SQLite.Container4SQLiteActivity;

public class MainActivity extends AppCompatActivity {

    private Button mUI,mFragment,mSharedPreference,mBtnSQLite,mBtnRoomLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUI = findViewById(R.id.btn_UI);
        mFragment = findViewById(R.id.btn_Fragment);
        mSharedPreference = findViewById(R.id.btn_SharedPreference);
        mBtnSQLite = findViewById(R.id.btn_SQLite);
        mBtnRoomLibrary = findViewById(R.id.btn_Room_Library);

        OnClick onClick = new OnClick();

        mUI.setOnClickListener(onClick);
        mFragment.setOnClickListener(onClick);
        mSharedPreference.setOnClickListener(onClick);
        mBtnSQLite.setOnClickListener(onClick);
        mBtnRoomLibrary.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()){
                case R.id.btn_UI:
                    intent.setClass(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_Fragment:
                    intent.setClass(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_SharedPreference:
                    intent.setClass(MainActivity.this,SharedPreferenceActivity.class);
                    break;
                case R.id.btn_SQLite:
                    //intent.setClass(MainActivity.this, Container4SQLiteActivity.class);
                    break;
                case R.id.btn_Room_Library:
                    intent.setClass(MainActivity.this, Container4RoomActivity.class);
            }
            startActivity(intent);
        }
    }
}
