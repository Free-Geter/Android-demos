package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox mCb1,mCb2,mCb3,mCb4,mCb5,mCb6,mCbAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        mCb1 = findViewById(R.id.cb_1);
        mCb2 = findViewById(R.id.cb_2);
        mCb3 = findViewById(R.id.cb_3);
        mCb4 = findViewById(R.id.cb_4);
        mCb5 = findViewById(R.id.cb_5);
        mCb6 = findViewById(R.id.cb_6);
        mCbAll = findViewById(R.id.cb_all);

//        mCb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//            }
//        });
         mCb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 Toast.makeText(CheckBoxActivity.this,isChecked?"checked":"dischecked",Toast.LENGTH_SHORT).show();
             }
         });

         mCb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 Toast.makeText(CheckBoxActivity.this,isChecked?"choosed":"dischoosed",Toast.LENGTH_SHORT).show();
             }
         });

         mCbAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 mCb1.setChecked(isChecked);
                 mCb2.setChecked(isChecked);
                 mCb3.setChecked(isChecked);
                 mCb4.setChecked(isChecked);
             }
         });
    }
}
