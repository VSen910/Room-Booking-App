package com.example.roombookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserBookingsActivity extends AppCompatActivity implements RequestInterface{

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    private ArrayList<BookingDetails> bookingDetails = new ArrayList<>();
    private RecyclerView ubRecyclerView;
    private UserBookingsAdapter userBookingsAdapter;
    private TextView nothingToShow;
    private ImageButton backBtn;

    private HashMap<String, String> map = new HashMap<>();
    private LoginResult loginParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_bookings);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        loginParams = (LoginResult) getIntent().getSerializableExtra("loginParams");

        nothingToShow = findViewById(R.id.nothingtoshowtxt_userbookings);

        backBtn = findViewById(R.id.back_userBooking);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ubRecyclerView = findViewById(R.id.recyclerview_userBooking);
        userBookingsAdapter = new UserBookingsAdapter(getApplicationContext(), bookingDetails, this);

        map.put("name", loginParams.getName());
        map.put("email", loginParams.getEmail());

        Call<ArrayList<BookingDetails>> call = retrofitInterface.executeUserBooking(map);
        call.enqueue(new Callback<ArrayList<BookingDetails>>() {
            @Override
            public void onResponse(Call<ArrayList<BookingDetails>> call, Response<ArrayList<BookingDetails>> response) {
                if(response.code() == 200){
                    for(BookingDetails obj: response.body()){
                        bookingDetails.add(obj);
                    }

                    Log.i("Something", bookingDetails.get(0).getPurpose());

                    if(!bookingDetails.isEmpty()){
                        ubRecyclerView.setAdapter(userBookingsAdapter);
                        ubRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }else{
                        nothingToShow.setVisibility(View.VISIBLE);
                    }
                }else{
                    Toast.makeText(UserBookingsActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<BookingDetails>> call, Throwable t) {
                Toast.makeText(UserBookingsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void OnItemClick(int position) {
        String status = getString(R.string.await_confirm);
        if(bookingDetails.get(position).getIsChecked().equals("true")){
            if(bookingDetails.get(position).getConfirm().equals("true")){
                status = getString(R.string.req_accepted);
            }else{
                status = getString(R.string.req_declined);
            }
        }

        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(UserBookingsActivity.this);
        dialog.setTitle(status);
        dialog.setMessage("\"" + bookingDetails.get(position).getPurpose() + "\"");
        dialog.setBackground(getResources().getDrawable(R.drawable.dialogue_backgorund, null));
        dialog.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });
        dialog.show();
    }
}