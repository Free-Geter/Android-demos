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
public class UpdateFragment extends Fragment {

    private EditText mEt_update_id,mEt_update_name,mEt_update_email;
    private Button mBtnUpdate;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_update, container, false);

        mBtnUpdate = view.findViewById(R.id.btn_confirm_to_update);
        mEt_update_email = view.findViewById(R.id.et_email);
        mEt_update_id = view.findViewById(R.id.et_contact_id);
        mEt_update_name = view.findViewById(R.id.et_name);

        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactDatabaseHelper contactDatabaseHelper = new ContactDatabaseHelper(getActivity());
                SQLiteDatabase database = contactDatabaseHelper.getWritableDatabase();
                int id = Integer.parseInt(mEt_update_id.getText().toString());
                String name = mEt_update_name.getText().toString();
                String email = mEt_update_email.getText().toString();
                contactDatabaseHelper.updateContact(id,name,email,database);
                contactDatabaseHelper.close();

                Toast.makeText(getActivity(),"update successfully...",Toast.LENGTH_SHORT).show();

                mEt_update_email.setText("");
                mEt_update_id.setText("");
                mEt_update_name.setText("");
            }
        });

        return view;
    }


}
