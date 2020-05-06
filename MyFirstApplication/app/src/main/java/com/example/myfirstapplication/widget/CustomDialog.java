package com.example.myfirstapplication.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.Util.ToastUtil;

public class CustomDialog extends Dialog implements View.OnClickListener{

    private TextView mTvTitle,mTvMessage;
    private Button mBtnConfirm,mBtnCancel;

    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;

    private String Title,Message,Cancel,Confirm;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public CustomDialog setTitle(String title) {
        Title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        Message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener listener) {
        Cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmListener listener) {
        Confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        //获取当前屏幕宽度
        WindowManager manager = getWindow().getWindowManager();
        Display display = manager.getDefaultDisplay();
        WindowManager.LayoutParams params = getWindow().getAttributes();

        //设置宽度为屏幕宽度的80%
        Point size = new Point();
        display.getSize(size);
        params.width = (int)(size.x * 0.8);
        getWindow().setAttributes(params);

        mTvMessage = findViewById(R.id.tv_message);
        mTvTitle = findViewById(R.id.tv_title);
        mBtnCancel = findViewById(R.id.btn_cancel);
        mBtnConfirm = findViewById(R.id.btn_confirm);

        if(!TextUtils.isEmpty(Title)){
            mTvTitle.setText(Title);
        }
        if(!TextUtils.isEmpty(Message)){
            mTvMessage.setText(Message);
        }
        if(!TextUtils.isEmpty(Cancel)){
            mBtnCancel.setText(Cancel);
        }
        if(!TextUtils.isEmpty(Confirm)){
            mBtnConfirm.setText(Confirm);
        }
        mBtnCancel.setOnClickListener(this);
        mBtnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancel:
                if(cancelListener != null){
                    cancelListener.OnCancel(this);
                    dismiss();
                }
                break;
            case R.id.btn_confirm:
                if(confirmListener != null){
                    confirmListener.OnConfirm(this);
                    dismiss();
                }
                break;
        }
    }

    public  interface IOnCancelListener{
        void OnCancel(Dialog dialog);
    }
    public interface IOnConfirmListener{
        void OnConfirm(Dialog dialog);
    }
}
