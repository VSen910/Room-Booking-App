package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TimeSlotActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView roomnum;
    private Button ts1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);

        roomnum = findViewById(R.id.roomnumber);
        roomnum.setText(getIntent().getStringExtra("ROOM_NUMBER"));

        ts1 = findViewById(R.id.ninetenTS);
        ts1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), ReasonActivity.class);
        switch (view.getId()){
            case R.id.ninetenTS:
                startActivity(intent);
                break;
        }
    }
}