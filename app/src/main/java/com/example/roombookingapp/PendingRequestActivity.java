package com.example.roombookingapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PendingRequestActivity extends AppCompatActivity implements RequestInterface {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    ArrayList<BookingDetails> bookingDetails = new ArrayList<>();
    RecyclerView recyclerView;
    RequestAdapter adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_req);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        recyclerView = findViewById(R.id.pending);

        Call<ArrayList<BookingDetails>> call = retrofitInterface.executeAdminPendingReq();
        call.enqueue(new Callback<ArrayList<BookingDetails>>() {
            @Override
            public void onResponse(Call<ArrayList<BookingDetails>> call, Response<ArrayList<BookingDetails>> response) {
                if(response.code() == 200){
                    bookingDetails = response.body();
                    Log.i("Something", bookingDetails.get(0).getName());

                    adapter = new RequestAdapter(getApplicationContext(), bookingDetails, PendingRequestActivity.this::OnItemClick);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }else{
                    Toast.makeText(PendingRequestActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
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
        String reason = bookingDetails.get(position).getPurpose();
        String name = bookingDetails.get(position).getName();

        MaterialAlertDialogBuilder  dialog1 = new MaterialAlertDialogBuilder(PendingRequestActivity.this);
        dialog1.setTitle(name);
        dialog1.setMessage(reason);
        dialog1.setBackground(getResources().getDrawable(R.drawable.dialogue_backgorund, null));
        dialog1.setPositiveButton("ACCEPT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Accepted", Toast.LENGTH_LONG).show();
            }
        });

        dialog1.setNegativeButton("DECLINE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Declined", Toast.LENGTH_LONG).show();
            }
        });
        dialog1.show();
    }
}
