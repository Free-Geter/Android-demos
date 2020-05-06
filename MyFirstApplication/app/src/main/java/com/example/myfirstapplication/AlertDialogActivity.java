package com.example.myfirstapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapplication.Util.ToastUtil;

import java.util.zip.Inflater;

public class AlertDialogActivity extends AppCompatActivity {

    private Button mDialog1,mDialog2,mDialog3,mDialog4,mDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        mDialog1 = findViewById(R.id.dialog1);
        mDialog2 = findViewById(R.id.dialog2);
        mDialog3 = findViewById(R.id.dialog3);
        mDialog4 = findViewById(R.id.dialog4);
        mDialog5 = findViewById(R.id.dialog5);

        OnClick onClick = new OnClick();

        mDialog1.setOnClickListener(onClick);
        mDialog2.setOnClickListener(onClick);
        mDialog3.setOnClickListener(onClick);
        mDialog4.setOnClickListener(onClick);
        mDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder.setTitle("Please answer").setMessage("how are you?").setIcon(R.drawable.ic_launcher_foreground)
                            .setPositiveButton("I'm fine!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"thank you, and you?");
                        }
                    }).setNeutralButton("not too bad.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"tomorrow will be better!");
                        }
                    }).setNegativeButton("not very well.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"hope you have a nice day");
                        }
                    }).show();
                    break;
                case R.id.dialog2:
                    final String[] gender = new String[]{"male","female"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder2.setTitle("select your gender: ").setItems(gender, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,gender[which]);
                            dialog.dismiss();                                                      //点击以后关闭dialog
                        }
                    }).setCancelable(false).show();                                               //点击空白处不可关闭dialog
                    break;
                case R.id.dialog3:
                    final String[] nation = new String[]{"Han","minority"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder3.setTitle("choose your nation: ").setSingleChoiceItems(nation, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,nation[which]);
                            dialog.dismiss();                                                      //点击以后关闭dialog
                        }
                    }).setCancelable(false).show();                                                 //点击空白处不可关闭dialog
                    break;
                case R.id.dialog4:
                    final String[] action = new String[]{"sing","dance","rap"};
                    boolean[] seclected = new boolean[]{false,false,false};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder4.setMultiChoiceItems(action, seclected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(AlertDialogActivity.this,action[which] + ":" + isChecked);
                        }
                    }).setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                    break;
                case R.id.dialog5:
                    final AlertDialog.Builder builder5 =  new AlertDialog.Builder(AlertDialogActivity.this);
                    View view = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.layout_dialog,null);
                    Button button = view.findViewById(R.id.btn_login);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    builder5.setTitle("Please login first.").setView(view).show();
                    break;
            }
        }
    }
}
