package com.example.myfirstapplication.SQLite;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myfirstapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button mBtnAdd,mBtnUpdate,mBtnDelete,mBtnRead;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_contact:
                onDbOpListener.operation(1);
                break;
            case R.id.btn_view_contact:
                onDbOpListener.operation(2);
                break;
            case R.id.btn_update_contact:
                onDbOpListener.operation(3);
                break;
            case R.id.btn_delete_contact:
                onDbOpListener.operation(4);
                break;
        }
    }

    interface OnDbOpListener {
        public void operation(int method);
    }

    OnDbOpListener onDbOpListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mBtnAdd = view.findViewById(R.id.btn_add_contact);
        mBtnDelete = view.findViewById(R.id.btn_delete_contact);
        mBtnRead = view.findViewById(R.id.btn_view_contact);
        mBtnUpdate = view.findViewById(R.id.btn_update_contact);

        mBtnAdd.setOnClickListener(this);
        mBtnRead.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try{
            onDbOpListener = (OnDbOpListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must override interface method...");
        }
    }
}
