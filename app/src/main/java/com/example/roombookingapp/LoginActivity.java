package com.example.roombookingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    private ImageButton backBtn;
    private ImageButton showPassword;
    private Button login;
    private TextView forgotPass;
    private TextView signupTxt;
    private EditText emailEdit;
    private EditText passwordEdit;

    private boolean isVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        backBtn = findViewById(R.id.back_login);
        showPassword = findViewById(R.id.showPass_login);
        login  = findViewById(R.id.login_2);
        forgotPass = findViewById(R.id.forgotPasswordTxt);
        signupTxt = findViewById(R.id.signup_text);
        emailEdit = findViewById(R.id.emailbox_register);
        passwordEdit = findViewById(R.id.passwordbox_register);

        backBtn.setOnClickListener(this);
        showPassword.setOnClickListener(this);
        login.setOnClickListener(this);
        forgotPass.setOnClickListener(this);
        signupTxt.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_2:
                HashMap<String, String> map = new HashMap<>();

                map.put("email", emailEdit.getText().toString());
                map.put("password", passwordEdit.getText().toString());

                Call<LoginResult> call = retrofitInterface.executeLogin(map);

                call.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        if(response.code() == 200){
                            LoginResult result = response.body();

                            Toast.makeText(getApplicationContext(), "Signed in successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), BookingActivity.class);
                            intent.putExtra("loginParams", result);
                            startActivity(intent);

                            emailEdit.setText("");
                            passwordEdit.setText("");
                        }else if(response.code() == 400){
                            passwordEdit.setText("");
                            Toast.makeText(getApplicationContext(), "Wrong credentials", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

                break;
            case R.id.back_login:
                finish();
                break;
            case R.id.showPass_login:
                if(!isVisible){
                    passwordEdit.setTransformationMethod(null);
                }else{
                    passwordEdit.setTransformationMethod(new PasswordTransformationMethod());
                }
                isVisible = !isVisible;
                break;
            case R.id.forgotPasswordTxt:
                startActivity(new Intent(getApplicationContext(), ForgotPasswordEmail.class));
                break;
            case R.id.signup_text:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
        }

    }
}