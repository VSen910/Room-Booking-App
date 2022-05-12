package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TimeSlotActivity extends AppCompatActivity {
    TextView roomNumText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);

        roomNumText = findViewById(R.id.roomnumber);
        String room = getIntent().getStringExtra("ROOM_NUMBER");
        roomNumText.setText(room);
    }
}