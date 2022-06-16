package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.EmojiCompatConfigurationView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        cancel = findViewById(R.id.cancel_2);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, LoginRegisterActivity.class);
        startActivity(intent);
    }
}