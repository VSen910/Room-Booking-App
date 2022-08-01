package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReasonActivity extends AppCompatActivity implements View.OnClickListener {

    private Button cancelbtn;
    private Button submitbtn;

    private LoginResult loginParams;
    private String roomNumber;
    private String date;
    private String timeSlot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);

        cancelbtn = findViewById(R.id.cancel_3);
        cancelbtn.setOnClickListener(this);

        submitbtn = findViewById(R.id.sbmtbutton);
        submitbtn.setOnClickListener(this);

        loginParams = (LoginResult) getIntent().getSerializableExtra("loginParams");
        roomNumber = getIntent().getStringExtra("ROOM_NUMBER");
        date = getIntent().getStringExtra("date");
        timeSlot = getIntent().getStringExtra("timeSlot");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cancel_3:
                finish();
                break;
            case R.id.sbmtbutton:
                break;
        }
    }
}