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
public class DeleteFragment extends Fragment {
    private Button mBtn_delete;
    private EditText mEt_id_to_delete;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        mBtn_delete = view.findViewById(R.id.btn_confirm_to_delete);
        mEt_id_to_delete = view.findViewById(R.id.et_id_to_delete);

        mBtn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });

        return view;
    }

    public void deleteContact(){
        ContactDatabaseHelper contactDatabaseHelper = new ContactDatabaseHelper(getActivity());
        SQLiteDatabase database = contactDatabaseHelper.getWritableDatabase();

        int id = Integer.parseInt(mEt_id_to_delete.getText().toString());
        contactDatabaseHelper.deleteContact(id,database);

        contactDatabaseHelper.close();

        Toast.makeText(getActivity(),"Delete successfully",Toast.LENGTH_SHORT).show();

        mEt_id_to_delete.setText("");
    }
}
