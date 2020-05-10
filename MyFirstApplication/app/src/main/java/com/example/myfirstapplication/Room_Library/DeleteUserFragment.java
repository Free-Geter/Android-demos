package com.example.myfirstapplication.Room_Library;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
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
public class DeleteUserFragment extends Fragment {

    private EditText EtId;
    private Button BtnDelete;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        EtId = view.findViewById(R.id.ET_Delete_by_id);
        BtnDelete = view.findViewById(R.id.btn_delete);

        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(EtId.getText().toString());
                User u = new User();
                u.setId(id);
                Container4RoomActivity.myAppDatabase.myDao().deleteUser(u);

                EtId.setText("");
                Toast.makeText(getActivity(),"Moved successfully...",Toast.LENGTH_SHORT).show();

                Log.d("Room operation", "onClick: Deleting--------------");
            }
        });
        return view;
    }
}
