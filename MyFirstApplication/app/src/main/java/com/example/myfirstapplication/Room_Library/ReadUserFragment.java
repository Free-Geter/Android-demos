package com.example.myfirstapplication.Room_Library;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myfirstapplication.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView mTvShowUser;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);

        mTvShowUser = view.findViewById(R.id.tv_show_info);

        String info = "";

        List<User> userList = Container4RoomActivity.myAppDatabase.myDao().viewUser();

        for(User u : userList){
            int id = u.getId();
            String name = u.getName();
            String email = u.getEmail();
            info = info + "\n\n ID: " + id + "\n Name: " + name + "\n Email: " + email;

        }

        Log.d("Room operation", "onCreateView: Reading=----------------------");

        mTvShowUser.setText(info);

        return view;
    }
}
