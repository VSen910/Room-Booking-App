package com.example.roombookingapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
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


public class AdminHistoryActivity extends AppCompatActivity implements AdminHistoryInterface {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    private RecyclerView recyclerView;
    private AdminHistoryAdapter adapter;
    private TextView nothingToShow;
    private ImageButton backBtn;

    ArrayList<BookingDetails> bookingDetails = new ArrayList<>();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        nothingToShow = findViewById(R.id.nothingtoshowtxt_adminHistory);

        backBtn = findViewById(R.id.back_adminHistory);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.history_list);
        adapter = new AdminHistoryAdapter(this, bookingDetails, this);

        Call<ArrayList<BookingDetails>> call = retrofitInterface.executeAdminHistory();
        call.enqueue(new Callback<ArrayList<BookingDetails>>() {
            @Override
            public void onResponse(Call<ArrayList<BookingDetails>> call, Response<ArrayList<BookingDetails>> response) {

                for(BookingDetails obj: response.body()){
                    bookingDetails.add(obj);
                }

                if(!bookingDetails.isEmpty()){
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }else{
                    nothingToShow.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<BookingDetails>> call, Throwable t) {
                Toast.makeText(AdminHistoryActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void OnItemClick(int position) {
        String name = bookingDetails.get(position).getName();
        String reason = bookingDetails.get(position).getPurpose();
        String email = bookingDetails.get(position).getEmail();
        String phone = bookingDetails.get(position).getPhoneNumber();

        MaterialAlertDialogBuilder dialog1 = new MaterialAlertDialogBuilder(AdminHistoryActivity.this);
        dialog1.setTitle(name);
        dialog1.setMessage("Email: " + email + "\n" + "Phone: " + phone + "\n" + "Purpose: " + reason);
        dialog1.setBackground(getResources().getDrawable(R.drawable.dialogue_backgorund, null));
        dialog1.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });


        dialog1.show();

    }
}
