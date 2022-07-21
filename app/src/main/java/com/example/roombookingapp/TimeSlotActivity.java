package com.example.roombookingapp;

import android.app.DatePickerDialog;
import android.content.Intent;
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
import java.util.Locale;

public class TimeSlotActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView roomnum;

    private EditText dateEditTxt;
    private Calendar cal;
    private int mDate, mMonth, mYear;

    private Button ts1;
    private  Button ts2;
    private  Button ts3;
    private  Button ts4;
    private  Button ts5;
    private  Button ts6;
    private  Button ts7;
    private  Button ts8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);

        dateEditTxt = findViewById(R.id.day_date_picker);
        cal = Calendar.getInstance();

//        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
//                cal.set(Calendar.YEAR, year);
//                cal.set(Calendar.MONTH, month);
//                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//
//                updateCalender();
//            }
//
//            private void updateCalender() {
//                String format = "dd/MM/yyyy";
//                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
//
//                datePicker.setText(sdf.format(cal.getTime()));
//            }
//        };

        dateEditTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new DatePickerDialog(TimeSlotActivity.this, date, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
//                        cal.get(Calendar.DAY_OF_MONTH)).show();
                mDate = cal.get(Calendar.DATE);
                mMonth = cal.get(Calendar.MONTH);
                mYear = cal.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(TimeSlotActivity.this,
                        android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        dateEditTxt.setText(date + "/" + ((int) (month) + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDate);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()+1);
                datePickerDialog.show();
            }
        });

        roomnum = findViewById(R.id.roomnumber);
        roomnum.setText(getIntent().getStringExtra("ROOM_NUMBER"));

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
        switch (view.getId()){
            case R.id.ninetenTS:
                startActivity(intent);
                break;
            case R.id.tenelevenTS:
                startActivity(intent);
                break;

            case R.id.eleventwelveTS:
                startActivity(intent);
                break;
            case R.id.twelveoneTS:
                startActivity(intent);
                break;
            case R.id.onetwoTS:
                startActivity(intent);
                break;
            case R.id.twothreeTS:
                startActivity(intent);
                break;
            case R.id.threefourTS:
                startActivity(intent);
                break;
            case R.id.fourfiveTS:
                startActivity(intent);
                break;


        }
    }

    public void onBackClick(View view) {
        finish();
    }
}