package com.example.myfirstapplication.Room_Library;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.SQLite.DeleteFragment;
import com.example.myfirstapplication.SQLite.UpdateFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button BtnAdd,BtnView,BtnDelete,BtnUpdate;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        BtnAdd = view.findViewById(R.id.btn_add_user);
        BtnDelete = view.findViewById(R.id.btn_delete_user);
        BtnUpdate = view.findViewById(R.id.btn_update_user);
        BtnView = view.findViewById(R.id.btn_view_user);

        OnClick onClick = new OnClick();

        BtnView.setOnClickListener(onClick);
        BtnUpdate.setOnClickListener(onClick);
        BtnDelete.setOnClickListener(onClick);
        BtnAdd.setOnClickListener(onClick);

        return view;
    }

    public class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_add_user:
                    getFragmentManager().beginTransaction().replace(R.id.Container4Room,new AddUserFragment()).addToBackStack(null).commit();
                    break;
                case R.id.btn_view_user:
                    getFragmentManager().beginTransaction().replace(R.id.Container4Room,new ReadUserFragment()).addToBackStack(null).commit();
                    break;
                case R.id.btn_delete_user:
                    getFragmentManager().beginTransaction().replace(R.id.Container4Room,new DeleteFragment()).addToBackStack(null).commit();
                    break;
                case R.id.btn_update_user:
                    getFragmentManager().beginTransaction().replace(R.id.Container4Room,new UpdateFragment()).addToBackStack(null).commit();
            }
        }
    }

}
