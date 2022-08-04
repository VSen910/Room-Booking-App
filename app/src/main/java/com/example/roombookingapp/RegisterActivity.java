package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    private ImageButton backBtn;
    private ImageButton showPassword;
    private Button registerbtn;
    private TextView loginTxt;
    private EditText nameEdit;
    private EditText emailEdit;
    private EditText phoneEdit;
    private EditText passwordEdit;
    private CheckBox chkBox;

    private boolean isVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        backBtn = findViewById(R.id.back_register);
        showPassword = findViewById(R.id.showPass_register);
        registerbtn = findViewById(R.id.register_2);
        loginTxt = findViewById(R.id.login_here);
        nameEdit = findViewById(R.id.usernamebox_register);
        emailEdit = findViewById(R.id.emailbox_register);
        phoneEdit = findViewById(R.id.phonenumberbox_register);
        passwordEdit = findViewById(R.id.passwordbox_register);
        chkBox = findViewById(R.id.studentcheckbox);

        backBtn.setOnClickListener(this);
        showPassword.setOnClickListener(this);
        registerbtn.setOnClickListener(this);
        loginTxt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register_2:
//                Intent intent1 = new Intent(this, ActivityOTP.class);
//                startActivity(intent1);
                HashMap<String, String> map = new HashMap<>();

                map.put("name", nameEdit.getText().toString());
                map.put("email", emailEdit.getText().toString());
                map.put("phoneNumber", phoneEdit.getText().toString());
                map.put("password", passwordEdit.getText().toString());
                if(chkBox.isChecked()){
                    map.put("profession", "Student");
                }else{
                    map.put("profession", "Professor");
                }

                Call<Void> call = retrofitInterface.executeRegister(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.code() == 200){
//                            Toast.makeText(getApplicationContext(), "Signed up successfully", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), ActivityOTP.class));
                        }else if(response.code() == 400){
                            Toast.makeText(getApplicationContext(), "Already exists", Toast.LENGTH_LONG).show();
                        }else if(response.code() == 422){
                            Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Please enter a valid email address (Only IIIT Dharwad emails are allowed)", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

                break;
            case R.id.back_register:
                finish();
                break;
            case R.id.showPass_register:
                if(!isVisible){
                    passwordEdit.setTransformationMethod(null);
                }else{
                    passwordEdit.setTransformationMethod(new PasswordTransformationMethod());
                }
                isVisible = !isVisible;
                break;
            case R.id.login_here:
                Intent intent = new Intent(this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
        }
    }
}