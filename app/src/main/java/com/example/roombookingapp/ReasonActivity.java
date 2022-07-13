package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReasonActivity extends AppCompatActivity implements View.OnClickListener {

    private Button cancelbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);

        cancelbtn = findViewById(R.id.cancel_3);
        cancelbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cancel_3:
                finish();
                break;
        }
    }
}