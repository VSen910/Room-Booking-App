package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.zip.Inflater;

public class BookingActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    private Button bookrooms;
    private Button bookings;
    private LoginResult loginParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        bookrooms = findViewById(R.id.bookrooms);
        bookrooms.setOnClickListener(this);

        bookings = findViewById(R.id.bookings_bookingActivity);
        bookings.setOnClickListener(this);

        loginParams = (LoginResult) getIntent().getSerializableExtra("loginParams");
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(this, "Work in progress", Toast.LENGTH_SHORT).show();
        return true;
    }

    public void showPopup(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu);
        popupMenu.show();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bookrooms:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("loginParams", loginParams);
                startActivity(intent);
                break;
            case R.id.bookings_bookingActivity:
                Intent intent1 = new Intent(this, UserBookingsActivity.class);
                intent1.putExtra("loginParams", loginParams);
                startActivity(intent1);
                break;
        }
    }
}