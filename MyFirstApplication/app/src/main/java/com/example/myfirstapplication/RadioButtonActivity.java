package com.example.myfirstapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    private RadioGroup mRg1;
    private RadioGroup mRg2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        mRg1 = (RadioGroup) findViewById(R.id.rg_1);
        mRg2 = findViewById(R.id.rg_2);
        mRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton =(RadioButton) group.findViewById(checkedId);
//                if(group.getId()==R.id.rg_1 & checkedId == R.id.rb_1) {
//                    RadioButton rb = findViewById(R.id.rb_3);
//                    rb.setChecked(radioButton.isChecked());
//                }else if(group.getId()==R.id.rg_1 & checkedId == R.id.rb_2){
//                   RadioButton rb = findViewById(R.id.rb_4);
//                   rb.setChecked(radioButton.isChecked());
//                }
//  联动选择
                Toast.makeText(RadioButtonActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
