package com.example.myfirstapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesConfig {

    private SharedPreferences sharedPreferences;
    private Context context;

    SharedPreferencesConfig (Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_status),Context.MODE_PRIVATE);
    }

    public void writeLoginStatus (boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status),status).commit();    //注意要commit后修改才会生效
    }

    public boolean readLoginStatus (){
        boolean status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status),false);
        return status;
    }
}
