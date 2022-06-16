package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;

public class BookingActivity extends AppCompatActivity implements View.OnClickListener{
   private Button bookrooms ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bookrooms = findViewById(R.id.bookrooms);
        bookrooms.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}