package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    Button submitBtn;
    Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        submitBtn = findViewById(R.id.sbmtbutton);
        cancelBtn = findViewById(R.id.cnclbutton);
        submitBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sbmtbutton:
                Toast.makeText(getApplicationContext(), "Submitted the request successfully", Toast.LENGTH_LONG).show();
                break;
            case R.id.cnclbutton:
                finish();
                break;
        }
    }
}