package com.example.roombookingapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TimeSlotActivity extends AppCompatActivity implements View.OnClickListener{

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    private TextView roomnum;

    private EditText dateEditTxt;
    private Calendar cal;
    private int mDate, mMonth, mYear;

    private Button ts1;
    private Button ts2;
    private Button ts3;
    private Button ts4;
    private Button ts5;
    private Button ts6;
    private Button ts7;
    private Button ts8;

    private String roomNumber;
    private LoginResult loginParams;
    private String pickedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        roomNumber = getIntent().getStringExtra("ROOM_NUMBER");
        loginParams = (LoginResult) getIntent().getSerializableExtra("loginParams");

        roomnum = findViewById(R.id.roomnumber);
        roomnum.setText(roomNumber);

        dateEditTxt = findViewById(R.id.day_date_picker);
        cal = Calendar.getInstance();

        dateEditTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDate = cal.get(Calendar.DATE);
                mMonth = cal.get(Calendar.MONTH);
                mYear = cal.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(TimeSlotActivity.this,
                        android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        pickedDate = date + "-" + ((int) (month) + 1) + "-" + year;
                        dateEditTxt.setText(pickedDate);

                        HashMap<String, String> map = new HashMap<>();
                        map.put("roomNumber", roomNumber);
                        map.put("date", pickedDate);

                        map.put("timeSlot", ts1.getText().toString());
                        Call<Void> call1 = retrofitInterface.executeRoomAvailability(map);
                        call1.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code() != 200){
                                    ts1.setElevation(0);
                                    ts1.setTextColor(Color.parseColor("#717171"));
                                }else{
                                    ts1.setElevation(8 * getApplicationContext().getResources().getDisplayMetrics().density);
                                    ts1.setTextColor(Color.parseColor("#FF000000"));
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        map.put("timeSlot", ts2.getText().toString());
                        Call<Void> call2 = retrofitInterface.executeRoomAvailability(map);
                        call2.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code() != 200){
                                    ts2.setElevation(0);
                                    ts2.setTextColor(Color.parseColor("#717171"));
                                }else{
                                    ts2.setElevation(8 * getApplicationContext().getResources().getDisplayMetrics().density);
                                    ts2.setTextColor(Color.parseColor("#FF000000"));
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        map.put("timeSlot", ts3.getText().toString());
                        Call<Void> call3 = retrofitInterface.executeRoomAvailability(map);
                        call3.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code() != 200){
                                    ts3.setElevation(0);
                                    ts3.setTextColor(Color.parseColor("#717171"));
                                }else{
                                    ts3.setElevation(8 * getApplicationContext().getResources().getDisplayMetrics().density);
                                    ts3.setTextColor(Color.parseColor("#FF000000"));
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        map.put("timeSlot", ts4.getText().toString());
                        Call<Void> call4 = retrofitInterface.executeRoomAvailability(map);
                        call4.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code() != 200){
                                    ts4.setElevation(0);
                                    ts4.setTextColor(Color.parseColor("#717171"));
                                }else{
                                    ts4.setElevation(8 * getApplicationContext().getResources().getDisplayMetrics().density);
                                    ts4.setTextColor(Color.parseColor("#FF000000"));
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        map.put("timeSlot", ts5.getText().toString());
                        Call<Void> call5 = retrofitInterface.executeRoomAvailability(map);
                        call5.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code() != 200){
                                    ts5.setElevation(0);
                                    ts5.setTextColor(Color.parseColor("#717171"));
                                }else{
                                    ts5.setElevation(8 * getApplicationContext().getResources().getDisplayMetrics().density);
                                    ts5.setTextColor(Color.parseColor("#FF000000"));
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        map.put("timeSlot", ts6.getText().toString());
                        Call<Void> call6 = retrofitInterface.executeRoomAvailability(map);
                        call6.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code() != 200){
                                    ts6.setElevation(0);
                                    ts6.setTextColor(Color.parseColor("#717171"));
                                }else{
                                    ts6.setElevation(8 * getApplicationContext().getResources().getDisplayMetrics().density);
                                    ts6.setTextColor(Color.parseColor("#FF000000"));
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        map.put("timeSlot", ts7.getText().toString());
                        Call<Void> call7 = retrofitInterface.executeRoomAvailability(map);
                        call7.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code() != 200){
                                    ts7.setElevation(0);
                                    ts7.setTextColor(Color.parseColor("#717171"));
                                }else{
                                    ts7.setElevation(8 * getApplicationContext().getResources().getDisplayMetrics().density);
                                    ts7.setTextColor(Color.parseColor("#FF000000"));
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        map.put("timeSlot", ts8.getText().toString());
                        Call<Void> call8 = retrofitInterface.executeRoomAvailability(map);
                        call8.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code() != 200){
                                    ts8.setElevation(0);
                                    ts8.setTextColor(Color.parseColor("#717171"));
                                }else{
                                    ts8.setElevation(8 * getApplicationContext().getResources().getDisplayMetrics().density);
                                    ts8.setTextColor(Color.parseColor("#FF000000"));
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }, mYear, mMonth, mDate);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()+1);
                datePickerDialog.show();
            }
        });

        ts1 = findViewById(R.id.ninetenTS);
        ts1.setOnClickListener(this);

        ts2 = findViewById(R.id.tenelevenTS);
        ts2.setOnClickListener(this);

        ts3 = findViewById(R.id.eleventwelveTS);
        ts3.setOnClickListener(this);

        ts4 = findViewById(R.id.twelveoneTS);
        ts4.setOnClickListener(this);

        ts5 = findViewById(R.id.onetwoTS);
        ts5.setOnClickListener(this);

        ts6 = findViewById(R.id.twothreeTS);
        ts6.setOnClickListener(this);

        ts7 = findViewById(R.id.threefourTS);
        ts7.setOnClickListener(this);

        ts8 = findViewById(R.id.fourfiveTS);
        ts8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), ReasonActivity.class);
        intent.putExtra("loginParams", loginParams);
        intent.putExtra("ROOM_NUMBER", roomNumber);
        intent.putExtra("date", pickedDate);

        HashMap<String, String> map = new HashMap<>();
        map.put("roomNumber", roomNumber);
        map.put("date", pickedDate);

        if(pickedDate != null){
            switch (view.getId()){
                case R.id.ninetenTS:
                    map.put("timeSlot", ts1.getText().toString());
                    Call<Void> call1 = retrofitInterface.executeRoomAvailability(map);
                    call1.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.code() == 200){
                                intent.putExtra("timeSlot", ts1.getText().toString());
                                startActivity(intent);
                            }else{
                                Toast.makeText(TimeSlotActivity.this, "Someone has already booked it", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case R.id.tenelevenTS:
                    map.put("timeSlot", ts2.getText().toString());
                    Call<Void> call2 = retrofitInterface.executeRoomAvailability(map);
                    call2.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.code() == 200){
                                intent.putExtra("timeSlot", ts2.getText().toString());
                                startActivity(intent);
                            }else{
                                Toast.makeText(TimeSlotActivity.this, "Someone has already booked it", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case R.id.eleventwelveTS:
                    map.put("timeSlot", ts3.getText().toString());
                    Call<Void> call3 = retrofitInterface.executeRoomAvailability(map);
                    call3.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.code() == 200){
                                intent.putExtra("timeSlot", ts3.getText().toString());
                                startActivity(intent);
                            }else{
                                Toast.makeText(TimeSlotActivity.this, "Someone has already booked it", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case R.id.twelveoneTS:
                    map.put("timeSlot", ts4.getText().toString());
                    Call<Void> call4 = retrofitInterface.executeRoomAvailability(map);
                    call4.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.code() == 200){
                                intent.putExtra("timeSlot", ts4.getText().toString());
                                startActivity(intent);
                            }else{
                                Toast.makeText(TimeSlotActivity.this, "Someone has already booked it", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case R.id.onetwoTS:
                    map.put("timeSlot", ts5.getText().toString());
                    Call<Void> call5 = retrofitInterface.executeRoomAvailability(map);
                    call5.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.code() == 200){
                                intent.putExtra("timeSlot", ts5.getText().toString());
                                startActivity(intent);
                            }else{
                                Toast.makeText(TimeSlotActivity.this, "Someone has already booked it", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case R.id.twothreeTS:
                    map.put("timeSlot", ts6.getText().toString());
                    Call<Void> call6 = retrofitInterface.executeRoomAvailability(map);
                    call6.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.code() == 200){
                                intent.putExtra("timeSlot", ts6.getText().toString());
                                startActivity(intent);
                            }else{
                                Toast.makeText(TimeSlotActivity.this, "Someone has already booked it", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case R.id.threefourTS:
                    map.put("timeSlot", ts7.getText().toString());
                    Call<Void> call7 = retrofitInterface.executeRoomAvailability(map);
                    call7.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.code() == 200){
                                intent.putExtra("timeSlot", ts7.getText().toString());
                                startActivity(intent);
                            }else{
                                Toast.makeText(TimeSlotActivity.this, "Someone has already booked it", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case R.id.fourfiveTS:
                    map.put("timeSlot", ts8.getText().toString());
                    Call<Void> call8 = retrofitInterface.executeRoomAvailability(map);
                    call8.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            intent.putExtra("timeSlot", ts8.getText().toString());
                            if(response.code() == 200){
                                startActivity(intent);
                            }else{
                                Toast.makeText(TimeSlotActivity.this, "Someone has already booked it", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(TimeSlotActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
            }
        }else{
            Toast.makeText(getApplicationContext(), "Select a date", Toast.LENGTH_LONG).show();
        }

    }

    public void onBackClick(View view) {
        finish();
    }
}