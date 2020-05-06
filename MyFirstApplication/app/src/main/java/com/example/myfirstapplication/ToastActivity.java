package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapplication.Util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button mBtn1,mBtn2,mBtn3,mBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mBtn1 = findViewById(R.id.btn_1);
        mBtn2 = findViewById(R.id.btn_2);
        mBtn3 = findViewById(R.id.btn_3);
        mBtn4 = findViewById(R.id.btn_4);

        OnClick onClick = new OnClick();
        mBtn1.setOnClickListener(onClick);
        mBtn2.setOnClickListener(onClick);
        mBtn3.setOnClickListener(onClick);
        mBtn4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btn_1:
                    Toast.makeText(getApplicationContext(), "default toast", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_2:
                    Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
                    toast.setText("hello");
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    break;
                case R.id.btn_3:
                    Toast customToast = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view = inflater.inflate(R.layout.layout_toast, null);
                    TextView textView = view.findViewById(R.id.tv);
                    ImageView imageView = view.findViewById(R.id.iv);
                    textView.setText("test");
                    imageView.setImageResource(R.drawable.ic_launcher_foreground);
                    customToast.setView(view);
                    customToast.setDuration(Toast.LENGTH_LONG);
                    customToast.show();
                    break;
                case R.id.btn_4:
                    ToastUtil.showMsg(getApplicationContext(),"封装的Toast");
                    break;
            }
        }
    }
}
