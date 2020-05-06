package com.example.myfirstapplication.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfirstapplication.R;

public class Fragment_1 extends Fragment {

    private EditText mEtMessage;
    private Button mBtnSend;

    public interface onMessageReader {
        public void onMessageReade(String message);
    }

    onMessageReader onMessageReader;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1,container,false);
        mBtnSend = view.findViewById(R.id.btn_send);
        mEtMessage = view.findViewById(R.id.et_message);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mEtMessage.getText().toString();
                onMessageReader.onMessageReade(message);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;


        try {  //check实现接口是是否override了Read方法
            onMessageReader = (Fragment_1.onMessageReader) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must override onMessageReader...");
        }
    }
}
