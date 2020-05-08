package com.example.myfirstapplication.SQLite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.myfirstapplication.R;

public class Container4SQLiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container4_s_q_lite);

        if(findViewById(R.id.container4SQLite) != null){
            if(savedInstanceState != null){
                return;
            }
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container4SQLite,homeFragment).commit();
        }
    }
}
