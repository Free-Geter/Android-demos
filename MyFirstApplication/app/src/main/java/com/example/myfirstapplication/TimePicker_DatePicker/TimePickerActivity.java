package com.example.myfirstapplication.TimePicker_DatePicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myfirstapplication.R;

public class TimePickerActivity extends Activity {

    private TimePicker mtp1;
    private DatePicker mdp1;
    private Button mbtnDatePicker;
    private SeekBar msb1;
    private RatingBar mRb1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);


        mtp1 = findViewById(R.id.tp_1);
        mdp1 = findViewById(R.id.dp_1);
        mbtnDatePicker = findViewById(R.id.btn_dp);
        msb1 = findViewById(R.id.sb_1);
        mRb1 = findViewById(R.id.Rb_1);
        mRb1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(fromUser){
                    Toast.makeText(TimePickerActivity.this, rating  + "评价", Toast.LENGTH_SHORT).show();
                }
            }
        });

        msb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mdp1.updateDate(2020,04,29);


        mtp1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(TimePickerActivity.this,"hour" + hourOfDay + ",minute" + minute,Toast.LENGTH_LONG).show();
            }
        });

        mbtnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TimePickerActivity.this,""+mdp1.getYear()+mdp1.getMonth()+mdp1.getDayOfMonth(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
