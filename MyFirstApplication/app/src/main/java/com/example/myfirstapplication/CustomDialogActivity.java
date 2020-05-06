package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapplication.Util.ToastUtil;
import com.example.myfirstapplication.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnCustomDialog = findViewById(R.id.btn_CustomDialog);
        mBtnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMessage("确认删除此项？").setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void OnCancel(Dialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this,"cancel...");
                    }
                }).setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void OnConfirm(Dialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this,"confirm...");
                    }
                }).show();
            }
        });
    }
}
