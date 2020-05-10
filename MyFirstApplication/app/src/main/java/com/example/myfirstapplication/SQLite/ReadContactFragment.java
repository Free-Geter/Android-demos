package com.example.myfirstapplication.SQLite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myfirstapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactFragment extends Fragment {

    private TextView mTv_show_info;

    public ReadContactFragment() {
        // Required empty public constructor
    }


    public void Readinfo(){
        ContactDatabaseHelper contactDatabaseHelper = new ContactDatabaseHelper(getActivity());
        SQLiteDatabase database =  contactDatabaseHelper.getReadableDatabase();
        Cursor cursor = contactDatabaseHelper.readContact(database);
        String info = "";
        while (cursor.moveToNext()){
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            info = info +"\n\n ID : " + id + "\n NAME : " + name + "\n EMAIL : " + email;
        }
        mTv_show_info.setText(info);
        cursor.close();
        contactDatabaseHelper.close();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_contact, container, false);

        mTv_show_info = view.findViewById(R.id.tv_platform);
        Readinfo();
        return view;
    }
}
