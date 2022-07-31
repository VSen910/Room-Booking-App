package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginbtn;
    private Button registerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        loginbtn = findViewById(R.id.login_1);
        registerbtn = findViewById(R.id.register_1);
        loginbtn.setOnClickListener(this);
        registerbtn.setOnClickListener(this);

//        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
//        String isRememberTrue = sharedPreferences.getString("remember", "false");
//        if(isRememberTrue.equals("true")){
//
//        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_1:
                Intent intent = new Intent(LoginRegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case  R.id.register_1:
                Intent intent1 = new Intent(LoginRegisterActivity.this, RegisterActivity.class);
                startActivity(intent1);
                break;

        }
    }
}