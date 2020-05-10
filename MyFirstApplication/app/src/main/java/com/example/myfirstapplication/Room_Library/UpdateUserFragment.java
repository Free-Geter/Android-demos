package com.example.myfirstapplication.Room_Library;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myfirstapplication.R;

import java.net.Inet4Address;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends Fragment {

    private EditText myUserID,myUserName,myUserEmail;
    private Button myBtnUpdate;

    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);

        myUserID = view.findViewById(R.id.et_UserID);
        myUserName = view.findViewById(R.id.et_UserName);
        myUserEmail = view.findViewById(R.id.et_UserEmail);

        myBtnUpdate = view.findViewById(R.id.btn_to_update);

        myBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(myUserID.getText().toString());
                String name = myUserName.getText().toString();
                String email = myUserEmail.getText().toString();

                User u = new User();
                u.setId(id);
                u.setName(name);
                u.setEmail(email);

                Container4RoomActivity.myAppDatabase.myDao().updateUser(u);
                Log.d("Room operation", "onClick: Updating ---------------------");
            }
        });

        return view;
    }
}
