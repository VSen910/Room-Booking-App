package com.example.roombookingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    Context context;
    ArrayList<HistoryModel> historyModels;
    private final HistoryInterface historyInterface;

    public HistoryAdapter(Context context, ArrayList<HistoryModel> historyModels, HistoryInterface historyInterface){
        this.context = context;
        this.historyModels = historyModels;
        this.historyInterface = historyInterface;
    }


    @NonNull
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater1 = LayoutInflater.from(context);
        View view = inflater1.inflate(R.layout.admin_history_row, parent, false);
        return new HistoryAdapter.MyViewHolder(view, historyInterface);
    }


    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder holder, int position) {
        holder.tvName1.setText(historyModels.get(position).getHistoryName());
        holder.tvRoom1.setText(historyModels.get(position).getHistoryRoom());
        holder.tvTime1.setText(historyModels.get(position).getHistoryTime());
        holder.tvDate1.setText(historyModels.get(position).getHistoryDate());
        holder.tvPosition1.setText(historyModels.get(position).getHistoryPosition());
        holder.tvStatus1.setText(historyModels.get(position).getHistoryStatus());


    }

    @Override
    public int getItemCount() {
        return historyModels.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvName1, tvRoom1, tvTime1, tvDate1, tvReason1, tvPosition1, tvStatus1;

        public MyViewHolder(@NonNull View itemView, HistoryInterface historyInterface) {
            super(itemView);

            tvName1 = itemView.findViewById(R.id.history_name);
            tvRoom1 = itemView.findViewById(R.id.history_room_no);
            tvTime1 = itemView.findViewById(R.id.history_time);
            tvDate1 = itemView.findViewById(R.id.history_date);
            //reason?
            tvPosition1 = itemView.findViewById(R.id.history_profession);
            tvStatus1 = itemView.findViewById(R.id.history_status);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(historyInterface!=null){
                        int position = getAbsoluteAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                            historyInterface.OnItemClick(position);
                    }
                }
            });
        }


    }
}

