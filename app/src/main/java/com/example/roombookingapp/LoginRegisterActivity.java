package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginbtn;
    private Button registerbtn;
    private TextView adminbtn;
    private TextView clickhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        loginbtn = findViewById(R.id.login_1);
        registerbtn = findViewById(R.id.register_1);
        clickhere = findViewById(R.id.clickhere);


        loginbtn.setOnClickListener(this);
        registerbtn.setOnClickListener(this);
        clickhere.setOnClickListener(this);


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

            case R.id.clickhere:
                Intent intent2 = new Intent(getApplicationContext(), LoginAdminActivity.class);
                startActivity(intent2);
                break;
        }
    }
}