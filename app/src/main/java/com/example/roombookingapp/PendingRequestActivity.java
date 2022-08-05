package com.example.roombookingapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class PendingRequestActivity extends AppCompatActivity implements RequestInterface {

    ArrayList<RequestModel>  requestModel = new ArrayList<>();
    Dialog dialog;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_req);

//        dialog = new Dialog(PendingRequestActivity.this);
//        dialog.setContentView(R.layout.request_dialogbox);
//        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialogue_backgorund));
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        Recycler view

        RecyclerView recyclerView = findViewById(R.id.pending);

        setUpRequestModels();

        RequestAdapter adapter = new RequestAdapter(this, requestModel, this );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
    private void setUpRequestModels(){
        //data to be shown in recycler view
        String[] requestName= {"Palash Bhasme", "Abhishikth Mahajan", "Luffy", "Zoro"};
        String[] reqestRoom = {"C202", "C201", "C301", "C302"};
        String[] requestTime= {"11-12 PM", "12-1 PM", "4-5 PM", "9-10 AM" };
        String [] requestDate = {"12/8/2022", "12/8/2022", "13/8/2022", "13/8/2022"};
        String[] requestReason = {"Cultural committee meet ", "Event", "Math Extra Class", ""};
        String [] requestPosition = {"Student", "Student", "Student", "Student"};

        for(int i = 0; i<requestName.length; i++){
            requestModel.add(new RequestModel(requestName[i], reqestRoom[i], requestTime[i], requestDate[i], requestReason[i], requestPosition[i]));
        }
    }

    @Override
    public void OnItemClick(int position) {
        String reason = requestModel.get(position).getRequestReason();
        String name = requestModel.get(position).getRequestName();

        MaterialAlertDialogBuilder  dialog1 = new MaterialAlertDialogBuilder(PendingRequestActivity.this);
        dialog1.setTitle(name);
        dialog1.setMessage(reason);
        dialog1.setBackground(getResources().getDrawable(R.drawable.dialogue_backgorund, null));
        dialog1.setPositiveButton("ACCEPT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(PendingRequestActivity.this, "Accepted", Toast.LENGTH_SHORT).show();
            }
        });

        dialog1.setNegativeButton("DECLINE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(PendingRequestActivity.this, "Declined", Toast.LENGTH_SHORT).show();
            }
        });
        dialog1.show();




    }


}
