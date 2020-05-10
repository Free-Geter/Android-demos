package com.example.myfirstapplication.Room_Library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

import com.example.myfirstapplication.R;

public class Container4RoomActivity extends AppCompatActivity {

    public  static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container4_room);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"UserDatabase").allowMainThreadQueries().build();

        if(findViewById(R.id.Container4Room) != null){
            if(savedInstanceState != null){
                return;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.Container4Room,new HomeFragment()).commit();
        }
    }
}
