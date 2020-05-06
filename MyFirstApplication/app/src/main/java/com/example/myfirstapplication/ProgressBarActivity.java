package com.example.myfirstapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myfirstapplication.Util.ToastUtil;

public class ProgressBarActivity extends AppCompatActivity {

    private ProgressBar mProgressBar2;
    private Button mbtnStart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        mProgressBar2 = findViewById(R.id.pb_2);
        mbtnStart = findViewById(R.id.btn_start);

        mbtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
                Toast.makeText(ProgressBarActivity.this,"click",Toast.LENGTH_SHORT).show();
            }
        });
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(mProgressBar2.getProgress() < 100){
                mProgressBar2.postDelayed(runnable,500);
            }else{
                ToastUtil.showMsg(ProgressBarActivity.this,"progress complete");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mProgressBar2.setProgress(mProgressBar2.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}
