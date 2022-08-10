package com.example.roombookingapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;


public class HistoryActivity extends AppCompatActivity implements HistoryInterface {

    ArrayList<HistoryModel> historyModel = new ArrayList<>();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);

        RecyclerView history = findViewById(R.id.history_list);
        setUpHistoryModels();

        HistoryAdapter adapter = new HistoryAdapter(this, historyModel, this);

        history.setAdapter(adapter);
        history.setAdapter(adapter);
        history.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpHistoryModels(){

        String[] historyName= {"Palash Bhasme", "Abhishikth Mahajan", "Luffy", "Zoro"};
        String[] historyRoom = {"C202", "C201", "C301", "C302"};
        String[] historyTime= {"11-12 PM", "12-1 PM", "4-5 PM", "9-10 AM" };
        String[] historyDate = {"12/8/2022", "12/8/2022", "13/8/2022", "13/8/2022"};
        String[] historyReason = {"Cultural committee meet ", "Event", "Math Extra Class", ""};
        String[] historyPosition = {"Student", "Student", "Student", "Student"};
        String[] historyStatus = {"ACCEPTED", "DECLINED", "ACCEPTED", "DECLINED"};
        String[] historyEmail = {"21bcs076@iiitdwd.ac.in","21bcs042@iiitdwd.ac.in", "21bcs022@iiitdwd.ac.in", "21bcs021@iiitdwd.ac.in"};
        String[] historyPhone = {"8433568160","8433568160", "8433568160", "8433568160"};

        for(int i = 0; i < historyName.length; i++){
            historyModel.add(new HistoryModel(historyName[i], historyRoom[i], historyTime[i], historyDate[i], historyReason[i], historyPosition[i], historyStatus[i], historyEmail[i], historyPhone[i]));


        }


    }

    @Override
    public void OnItemClick(int position) {
        String name = historyModel.get(position).getHistoryName();
        String reason = historyModel.get(position).getHistoryReason();
        String email = historyModel.get(position).getHistoryEmail();
        String phone = historyModel.get(position).getHistoryPhone();

        final String content [] = {"Email: " + email, "Phone: " + phone, "Purpose: " + reason};

        MaterialAlertDialogBuilder dialog1 = new MaterialAlertDialogBuilder(HistoryActivity.this);
        dialog1.setTitle(name);
        dialog1.setMessage("Email: " + email + "\n" + "Phone: " + phone + "\n" + "Purpose: " + reason);
        dialog1.setBackground(getResources().getDrawable(R.drawable.dialogue_backgorund, null));
        dialog1.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Accepted", Toast.LENGTH_LONG).show();
            }
        });


        dialog1.show();

    }
}
