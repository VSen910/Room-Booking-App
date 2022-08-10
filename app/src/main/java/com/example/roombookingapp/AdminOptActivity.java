package com.example.roombookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminOptActivity extends AppCompatActivity implements View.OnClickListener{
    private Button reqBox;
    private Button historyBox;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_opt);

        reqBox = findViewById(R.id.requestbox1);
        historyBox = findViewById(R.id.historybox1);
        reqBox.setOnClickListener(this);
        historyBox.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.requestbox1:
                Intent intent = new Intent(AdminOptActivity.this, PendingRequestActivity.class);
                startActivity(intent);
                break;
            case R.id.historybox1:
                Intent intent2 = new Intent(AdminOptActivity.this, HistoryActivity.class);
                startActivity(intent2);
                break;

        }
    }
}