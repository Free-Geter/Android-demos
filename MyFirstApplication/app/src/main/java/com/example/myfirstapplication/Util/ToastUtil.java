package com.example.myfirstapplication.Util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Toast mToast;
    public static void showMsg(Context context , String Msg){
        if(mToast == null){
            mToast = Toast.makeText(context,Msg,Toast.LENGTH_LONG);
        }else{
            mToast.setText(Msg);
        }
        mToast.show();
    }
}
