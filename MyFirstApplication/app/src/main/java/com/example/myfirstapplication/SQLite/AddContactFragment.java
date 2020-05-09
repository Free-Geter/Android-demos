package com.example.myfirstapplication.SQLite;

import android.database.sqlite.SQLiteDatabase;
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
public class AddContactFragment extends Fragment {

    private EditText mEtID,mEtName,mEtEmail;
    private Button mBtnConfirm;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_contact, container, false);
        mEtEmail = view.findViewById(R.id.et_email);
        mEtID = view.findViewById(R.id.et_contact_id);
        mEtName = view.findViewById(R.id.et_name);
        mBtnConfirm = view.findViewById(R.id.btn_confirm_to_add);

        mBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = mEtID.getText().toString();
                String name = mEtName.getText().toString();
                String email = mEtEmail.getText().toString();

                ContactDatabaseHelper contactDatabaseHelper = new ContactDatabaseHelper(getActivity());
                SQLiteDatabase database = contactDatabaseHelper.getWritableDatabase();
                contactDatabaseHelper.addContact(Integer.parseInt(id),name,email,database);
                database.close();
                mEtEmail.setText("");
                mEtID.setText("");
                mEtName.setText("");
                Toast.makeText(getActivity(),"Add Information successfully...",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
