package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReasonActivity extends AppCompatActivity implements View.OnClickListener {

    private Button cancelbtn;
    private Button submitbtn;
    private TextInputEditText purposeEdit;

    private TextView requestertxt;
    private TextView classtxt;
    private TextView datetxt;
    private TextView timeslottxt;

    private LoginResult loginParams;
    private String roomNumber;
    private String date;
    private String timeSlot;

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        cancelbtn = findViewById(R.id.cancel_3);
        cancelbtn.setOnClickListener(this);

        submitbtn = findViewById(R.id.sbmtbutton);
        submitbtn.setOnClickListener(this);

        purposeEdit = findViewById(R.id.textInputEditText);

        loginParams = (LoginResult) getIntent().getSerializableExtra("loginParams");
        roomNumber = getIntent().getStringExtra("ROOM_NUMBER");
        date = getIntent().getStringExtra("date");
        timeSlot = getIntent().getStringExtra("timeSlot");

        classtxt = findViewById(R.id.classtxt);
        datetxt = findViewById(R.id.datetxt);
        timeslottxt = findViewById(R.id.timeslottxt);
        requestertxt = findViewById(R.id.reqtxt);

        classtxt.setText("Classroom: " + roomNumber);
        datetxt.setText("Date: " + date);
        timeslottxt.setText("Timings: " + timeSlot);
        requestertxt.setText("Request by: " + loginParams.getName());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cancel_3:
                finish();
                break;
            case R.id.sbmtbutton:
                String purpose = purposeEdit.getText().toString();

                if(purpose != null){
                    HashMap<String, String> map = new HashMap<>();

                    map.put("roomNumber", roomNumber);
                    map.put("date", date);
                    map.put("timeSlot", timeSlot);
                    map.put("purpose", purpose);

                    map.put("name", loginParams.getName());
                    map.put("email", loginParams.getEmail());
                    map.put("phoneNumber", loginParams.getPhoneNumber());
                    map.put("profession", loginParams.getProfession());

                    Call<Void> call = retrofitInterface.executeBookingAddition(map);

                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.code() == 200){
                                Toast.makeText(ReasonActivity.this, "Request submitted successfully", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(ReasonActivity.this, "Someone already booked it", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(ReasonActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Please provide your purpose", Toast.LENGTH_LONG).show();
                }

                break;
        }
    }
}