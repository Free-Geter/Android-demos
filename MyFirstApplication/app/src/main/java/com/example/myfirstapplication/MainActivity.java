package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapplication.Fragment.ContainerActivity;

public class MainActivity extends AppCompatActivity {

    private Button mUI,mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUI = findViewById(R.id.btn_UI);
        mFragment = findViewById(R.id.btn_Fragment);

        OnClick onClick = new OnClick();

        mUI.setOnClickListener(onClick);
        mFragment.setOnClickListener(onClick);
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
            }
            startActivity(intent);
        }
    }
}
