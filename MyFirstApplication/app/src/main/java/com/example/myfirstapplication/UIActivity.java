package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.myfirstapplication.TimePicker_DatePicker.TimePickerActivity;
import com.example.myfirstapplication.gridview.GridViewActivity;
import com.example.myfirstapplication.listview.ListViewActivity;
import com.example.myfirstapplication.recyclerview.RecyclerViewActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecyclerView;
    private Button mBtnTimePicker;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mAlertDialog;
    private Button mProgressBar;
    private Button mCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
//        mBtnTextView = (Button) findViewById(R.id.btn_textview);
//        mBtnTextView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//             //跳转到TextView演示界面
//                Intent intent = new Intent(MainActivity.this,TextViewActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        mBtnButton = findViewById(R.id.btn_button);
//        mBtnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //跳转到Button演示界面
//                Intent intent = new Intent(MainActivity.this,ButtonActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        mBtnEditText = findViewById(R.id.btn_edittext);
//        mBtnEditText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //跳转到EditText演示界面
//                Intent intent = new Intent(MainActivity.this,EditTextActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        mBtnRadioButton = findViewById(R.id.btn_radiobutton);
//        mBtnRadioButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //跳转到RadioButton演示界面
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this,RadioButtonActivity.class);
//                startActivity(intent);
//            }
//        });
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById(R.id.btn_edittext);
        mBtnRadioButton = findViewById(R.id.btn_radiobutton);
        mBtnCheckBox = findViewById(R.id.btn_checkbox);
        mBtnImageView = findViewById(R.id.btn_imageview);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mBtnRecyclerView = findViewById(R.id.btn_recyclerview);
        mBtnTimePicker = findViewById(R.id.btn_timepicker);
        mBtnWebView = findViewById(R.id.btn_webview);
        mBtnToast = findViewById(R.id.btn_toast);
        mAlertDialog = findViewById(R.id.btn_alertdialog);
        mProgressBar = findViewById(R.id.btn_progressbar);
        mCustomDialog = findViewById(R.id.btn_custondialog);
        setListeners();
    }
    private void setListeners(){
        OnClick onClick = new OnClick();
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnTextView.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnTimePicker.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mAlertDialog.setOnClickListener(onClick);
        mProgressBar.setOnClickListener(onClick);
        mCustomDialog.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_textview:
                    //转到TextView
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    //转到Button
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    //转到EditText
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    //转到RadioButton
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    //转到CheckBox
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    //转到ImageView
                    intent = new Intent(UIActivity.this,ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    //转到ListView
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    //转到GridView
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    //转到LinearView
                    intent = new Intent (UIActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_timepicker:
                    //转到TimePicker
                    intent = new Intent(UIActivity.this, TimePickerActivity.class);
                    break;
                case R.id.btn_webview:
                    //转到WebView
                    intent = new Intent(UIActivity.this,WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    //转到Toast
                    intent = new Intent(UIActivity.this,ToastActivity.class);
                    break;
                case R.id.btn_alertdialog:
                    //转到AlertDialog
                    intent = new Intent(UIActivity.this,AlertDialogActivity.class);
                    break;
                case R.id.btn_progressbar:
                    //
                    intent = new Intent(UIActivity.this, ProgressBarActivity.class);
                    break;
                case R.id.btn_custondialog:
                    //
                    intent = new Intent(UIActivity.this,CustomDialogActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
