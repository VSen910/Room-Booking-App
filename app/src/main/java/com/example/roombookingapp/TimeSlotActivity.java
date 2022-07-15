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
    private  Button ts2;
    private  Button ts3;
    private  Button ts4;
    private  Button ts5;
    private  Button ts6;
    private  Button ts7;
    private  Button ts8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);

        roomnum = findViewById(R.id.roomnumber);
        roomnum.setText(getIntent().getStringExtra("ROOM_NUMBER"));

        ts1 = findViewById(R.id.ninetenTS);
        ts1.setOnClickListener(this);

        ts2 = findViewById(R.id.tenelevenTS);
        ts2.setOnClickListener(this);

        ts3 = findViewById(R.id.eleventwelveTS);
        ts3.setOnClickListener(this);

        ts4 = findViewById(R.id.twelveoneTS);
        ts4.setOnClickListener(this);

        ts5 = findViewById(R.id.onetwoTS);
        ts5.setOnClickListener(this);

        ts6 = findViewById(R.id.twothreeTS);
        ts6.setOnClickListener(this);

        ts7 = findViewById(R.id.threefourTS);
        ts7.setOnClickListener(this);

        ts8 = findViewById(R.id.fourfiveTS);
        ts8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), ReasonActivity.class);
        switch (view.getId()){
            case R.id.ninetenTS:
                startActivity(intent);
                break;
            case R.id.tenelevenTS:
                startActivity(intent);
                break;

            case R.id.eleventwelveTS:
                startActivity(intent);
                break;
            case R.id.twelveoneTS:
                startActivity(intent);
                break;
            case R.id.onetwoTS:
                startActivity(intent);
                break;
            case R.id.twothreeTS:
                startActivity(intent);
                break;
            case R.id.threefourTS:
                startActivity(intent);
                break;
            case R.id.fourfiveTS:
                startActivity(intent);
                break;


        }
    }
}