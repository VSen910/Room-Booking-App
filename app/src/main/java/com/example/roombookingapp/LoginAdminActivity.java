package com.example.roombookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginAdminActivity extends AppCompatActivity implements View.OnClickListener {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    private ImageButton backbtn;
    private Button loginbtn;
    private EditText userEdit;
    private EditText passEdit;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        userEdit = findViewById(R.id.username_admin);
        passEdit = findViewById(R.id.passwordbox_admin);

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
                HashMap<String, String> map = new HashMap<>();
                map.put("username", userEdit.getText().toString());
                map.put("password", passEdit.getText().toString());

                Call<Void> call = retrofitInterface.executeAdminLogin(map);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.code() == 200){
                            Intent intent = new Intent(getApplicationContext(), PendingRequestActivity.class);
                            startActivity(intent);
                            userEdit.setText("");
                            passEdit.setText("");
                        }else if(response.code() == 400){
                            Toast.makeText(LoginAdminActivity.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginAdminActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(LoginAdminActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
}
