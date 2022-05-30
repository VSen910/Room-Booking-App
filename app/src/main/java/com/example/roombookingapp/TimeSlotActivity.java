package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TimeSlotActivity extends AppCompatActivity implements View.OnClickListener {
    TextView roomNumText;

    CardView nineTen;
    CardView tenEleven;
    CardView elevenTwelve;
    CardView twelveOne;
    CardView oneTwo;
    CardView twoThree;
    CardView threeFour;
    CardView fourFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);

        roomNumText = findViewById(R.id.roomnumber);
        String room = getIntent().getStringExtra("ROOM_NUMBER");
        roomNumText.setText(room);

        nineTen = findViewById(R.id.zero_zero);
        tenEleven = findViewById(R.id.zero_one);
        elevenTwelve = findViewById(R.id.one_zero);
        twelveOne = findViewById(R.id.one_one);
        oneTwo = findViewById(R.id.two_zero);
        twoThree = findViewById(R.id.two_one);
        threeFour = findViewById(R.id.three_zero);
        fourFive = findViewById(R.id.three_one);

        nineTen.setOnClickListener(this);
        tenEleven.setOnClickListener(this);
        elevenTwelve.setOnClickListener(this);
        twelveOne.setOnClickListener(this);
        oneTwo.setOnClickListener(this);
        twoThree.setOnClickListener(this);
        threeFour.setOnClickListener(this);
        fourFive.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent1 = new Intent(this, DetailsActivity.class);
        switch (view.getId()){
            case R.id.zero_zero:
            case R.id.zero_one:
            case R.id.one_zero:
            case R.id.one_one:
            case R.id.two_zero:
            case R.id.two_one:
            case R.id.three_zero:
            case R.id.three_one:
                startActivity(intent1);
                break;
        }
    }
}