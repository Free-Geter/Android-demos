package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferenceActivity extends AppCompatActivity {

    private EditText mEt_username,mEt_password;
    private SharedPreferencesConfig sharedPreferencesConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        mEt_password = findViewById(R.id.et_password);
        mEt_username = findViewById(R.id.et_username);
        sharedPreferencesConfig = new SharedPreferencesConfig(getApplicationContext());//使用本Activity构造SharedPreference

        if(sharedPreferencesConfig.readLoginStatus()){
            startActivity(new Intent(this,SuccessActivity.class));
            finish();
        }
    }

    public void btn_login(View view) {
        if(mEt_username.getText().toString().equals(getResources().getString(R.string.user_name)) &&
        mEt_password.getText().toString().equals(getResources().getString(R.string.user_passwored))){
            sharedPreferencesConfig.writeLoginStatus(true);
            startActivity(new Intent(this,SuccessActivity.class));
            finish();
        }else{
            Toast.makeText(this,"Login failed, try again...",Toast.LENGTH_SHORT).show();
        }
    }
}
