package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForgotPasswordConfimPass extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    private EditText newPassEdit;
    private EditText confirmPassEdit;
    private Button changePassBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_confim_pass);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        newPassEdit = findViewById(R.id.newPassEdit_forgetPass);
        confirmPassEdit = findViewById(R.id.confirmPassEdit_forgetPass);

        changePassBtn = findViewById(R.id.changePassBtn_forgetPass);
        changePassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPass = newPassEdit.getText().toString();
                String confirmPass = confirmPassEdit.getText().toString();

                if(newPass.equals(confirmPass)){
                    HashMap<String, String> map = new HashMap<>();
                    map.put("newPass", newPass);

                    Call<Void> call = retrofitInterface.executeChangePass(map);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.code() == 200){
                                Toast.makeText(ForgotPasswordConfimPass.this, "Your password has been changed successfully", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                finish();
                            }else{
                                Toast.makeText(ForgotPasswordConfimPass.this, "Some error", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(ForgotPasswordConfimPass.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(ForgotPasswordConfimPass.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}