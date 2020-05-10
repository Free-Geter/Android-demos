package com.example.myfirstapplication.Room_Library;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText mEtUserid,mEtUsername,mEtUseremail;
    private Button mBtnAdd;
    private int id;
    private String name,email;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        mBtnAdd = view.findViewById(R.id.btn_to_add);
        mEtUseremail = view.findViewById(R.id.et_UserEmail);
        mEtUserid = view.findViewById(R.id.et_UserID);
        mEtUsername = view.findViewById(R.id.et_UserName);

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = Integer.parseInt(mEtUserid.getText().toString());
                name = mEtUsername.getText().toString();
                email = mEtUseremail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setEmail(email);
                user.setName(name);

                Container4RoomActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getContext(),"User Add successfully...",Toast.LENGTH_SHORT).show();

                mEtUsername.setText("");
                mEtUserid.setText("");
                mEtUseremail.setText("");
            }
        });

        return view;
    }
}
