package com.example.roombookingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roombookingapp.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> room_names;

    public RecyclerViewAdapter(Context context, ArrayList<String> room_names) {
        this.context = context;
        this.room_names = room_names;
    }

    //Where to get single card as the Viewholder object
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    //What will happen after we create the viewholder object
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.room.setText(room_names.get(position));
    }

    //How many items?
    @Override
    public int getItemCount() {
        return room_names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView room;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            room = itemView.findViewById(R.id.roomName);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context.getApplicationContext(), "Clicked", Toast.LENGTH_SHORT);
        }
    }
}
