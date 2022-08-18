package com.example.roombookingapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PendingRequestActivity extends AppCompatActivity implements RequestInterface {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    private ArrayList<BookingDetails> bookingDetails = new ArrayList<>();
    private RecyclerView recyclerView;
    private RequestAdapter adapter;
    private TextView nothingToShow;
    private FloatingActionButton fabBtn;

    private int toReturn = -1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_req);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        nothingToShow = findViewById(R.id.nothingtoshowtxt);

        fabBtn = findViewById(R.id.FABbtn);
        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AdminHistoryActivity.class));
            }
        });

        recyclerView = findViewById(R.id.pending);
        adapter = new RequestAdapter(getApplicationContext(), bookingDetails, this);

        Call<ArrayList<BookingDetails>> call = retrofitInterface.executeAdminPendingReq();
        call.enqueue(new Callback<ArrayList<BookingDetails>>() {
            @Override
            public void onResponse(Call<ArrayList<BookingDetails>> call, Response<ArrayList<BookingDetails>> response) {
                if(response.code() == 200){
                    for(BookingDetails obj: response.body()){
                        if(obj.getIsChecked().equals("false")){
                            bookingDetails.add(obj);
                        }
                    }

                    if(!bookingDetails.isEmpty()){
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }else{
                        nothingToShow.setVisibility(View.VISIBLE);
                    }

                }else{
                    Toast.makeText(PendingRequestActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<BookingDetails>> call, Throwable t) {
                Toast.makeText(PendingRequestActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void OnItemClick(int position) {
        String name = bookingDetails.get(position).getName();
        String reason = bookingDetails.get(position).getPurpose();
        String email = bookingDetails.get(position).getEmail();
        String phone = bookingDetails.get(position).getPhoneNumber();

        MaterialAlertDialogBuilder  dialog1 = new MaterialAlertDialogBuilder(PendingRequestActivity.this);
        dialog1.setTitle(name);
        dialog1.setMessage("Email: " + email + "\n" + "Phone: " + phone + "\n" + "Purpose: " + reason);
        dialog1.setBackground(getResources().getDrawable(R.drawable.dialogue_backgorund, null));
        dialog1.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                reqAccept(bookingDetails.get(position), position);

                if(bookingDetails.isEmpty()){
                    nothingToShow.setVisibility(View.VISIBLE);
                }else{
                    nothingToShow.setVisibility(View.INVISIBLE);
                }
            }
        });

        dialog1.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                reqDecline(bookingDetails.get(position));
                bookingDetails.remove(position);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, bookingDetails.size());
                Toast.makeText(getApplicationContext(), "Request declined", Toast.LENGTH_LONG).show();

                if(bookingDetails.isEmpty()){
                    nothingToShow.setVisibility(View.VISIBLE);
                }else{
                    nothingToShow.setVisibility(View.INVISIBLE);
                }
            }
        });
        dialog1.show();
    }

    public void reqDecline(BookingDetails obj){
        HashMap<String, String> map = new HashMap<>();
        map.put("name", obj.getName());
        map.put("email", obj.getEmail());
        map.put("roomNumber", obj.getRoomNumber());
        map.put("date", obj.getDate());
        map.put("timeSlot", obj.getTimeSlot());
        map.put("purpose", obj.getPurpose());

        Call<Void> call = retrofitInterface.executeAdminReqDecline(map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code() == 200){
                    return;
                }else{
                    Toast.makeText(PendingRequestActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(PendingRequestActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void reqAccept(BookingDetails obj, int position){
        HashMap<String, String> map = new HashMap<>();
        map.put("name", obj.getName());
        map.put("email", obj.getEmail());
        map.put("roomNumber", obj.getRoomNumber());
        map.put("date", obj.getDate());
        map.put("timeSlot", obj.getTimeSlot());
        map.put("purpose", obj.getPurpose());

        Call<Void> call = retrofitInterface.executeAdminReqAccept(map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code() == 200){
                    bookingDetails.remove(position);
                    adapter.notifyItemRemoved(position);
                    adapter.notifyItemRangeChanged(position, bookingDetails.size());
                    Toast.makeText(getApplicationContext(), "Request accepted", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(PendingRequestActivity.this, "This slot has already been booked", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(PendingRequestActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
