package com.example.roombookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class LoginAdminActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton backbtn;
    private Button loginbtn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        backbtn = findViewById(R.id.back_login);
        backbtn.setOnClickListener(this);

        loginbtn = findViewById(R.id.admin_log_btn);
        loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_login:
                finish();
                break;
            case R.id.admin_log_btn:
                Intent intent = new Intent(LoginAdminActivity.this, PendingRequestActivity.class);
                startActivity(intent);
                break;
        }
    }
}
