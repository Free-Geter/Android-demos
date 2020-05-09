package com.example.myfirstapplication.SQLite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.myfirstapplication.R;

public class Container4SQLiteActivity extends AppCompatActivity implements HomeFragment.OnDbOpListener {

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

    @Override
    public void operation(int method) {
        switch (method){
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.container4SQLite,new AddContactFragment()).addToBackStack(null).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.container4SQLite,new ReadContactFragment()).addToBackStack(null).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.container4SQLite,new UpdateFragment()).addToBackStack(null).commit();
                break;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.container4SQLite,new DeleteFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
