package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView mIv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        mIv4 = findViewById(R.id.iv_4);
        Glide.with(this).load("data:image/jpeg;base64,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").into(mIv4);
    }
}
