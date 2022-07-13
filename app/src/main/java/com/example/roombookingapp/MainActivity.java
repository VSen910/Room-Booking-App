package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView c101;
    CardView c102;
    CardView c103;
    CardView c104;
    CardView c105;

    CardView c201;
    CardView c202;
    CardView c203;
    CardView c204;
    CardView c205;

    CardView c301;
    CardView c302;
    CardView c303;
    CardView c304;
    CardView c305;

    CardView c401;
    CardView c402;
    CardView c403;
    CardView c404;
    CardView c405;

    public void onBackClick(){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c101 = findViewById(R.id.C101);
        c102 = findViewById(R.id.C102);
        c103 = findViewById(R.id.C103);
        c104 = findViewById(R.id.C104);
        c105 = findViewById(R.id.C105);

        c201 = findViewById(R.id.C201);
        c202 = findViewById(R.id.C202);
        c203 = findViewById(R.id.C203);
        c204 = findViewById(R.id.C204);
        c205 = findViewById(R.id.C205);

        c301 = findViewById(R.id.C301);
        c302 = findViewById(R.id.C302);
        c303 = findViewById(R.id.C303);
        c304 = findViewById(R.id.C304);
        c305 = findViewById(R.id.C305);

        c401 = findViewById(R.id.C401);
        c402 = findViewById(R.id.C402);
        c403 = findViewById(R.id.C403);
        c404 = findViewById(R.id.C404);
        c405 = findViewById(R.id.C405);

        c101.setOnClickListener(this);
        c102.setOnClickListener(this);
        c103.setOnClickListener(this);
        c104.setOnClickListener(this);
        c105.setOnClickListener(this);

        c201.setOnClickListener(this);
        c202.setOnClickListener(this);
        c203.setOnClickListener(this);
        c204.setOnClickListener(this);
        c205.setOnClickListener(this);

        c301.setOnClickListener(this);
        c302.setOnClickListener(this);
        c303.setOnClickListener(this);
        c304.setOnClickListener(this);
        c305.setOnClickListener(this);

        c401.setOnClickListener(this);
        c402.setOnClickListener(this);
        c403.setOnClickListener(this);
        c404.setOnClickListener(this);
        c405.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, TimeSlotActivity.class);
        switch (view.getId()){
            case R.id.C101:
            case R.id.C102:
            case R.id.C103:
            case R.id.C104:
            case R.id.C105:
            case R.id.C201:
            case R.id.C202:
            case R.id.C203:
            case R.id.C204:
            case R.id.C205:
            case R.id.C301:
            case R.id.C302:
            case R.id.C303:
            case R.id.C304:
            case R.id.C305:
            case R.id.C401:
            case R.id.C402:
            case R.id.C403:
            case R.id.C404:
            case R.id.C405:
                String room = getResources().getResourceEntryName(view.getId());
                intent.putExtra("ROOM_NUMBER", room);
                startActivity(intent);
                break;
        }
    }
}