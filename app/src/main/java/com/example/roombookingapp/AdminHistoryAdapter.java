package com.example.roombookingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminHistoryAdapter extends RecyclerView.Adapter<AdminHistoryAdapter.MyViewHolder> {
    Context context;
    ArrayList<BookingDetails> bookingDetails;
    private final AdminHistoryInterface adminHistoryInterface;

    public AdminHistoryAdapter(Context context, ArrayList<BookingDetails> bookingDetails, AdminHistoryInterface adminHistoryInterface){
        this.context = context;
        this.bookingDetails = bookingDetails;
        this.adminHistoryInterface = adminHistoryInterface;
    }


    @NonNull
    @Override
    public AdminHistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater1 = LayoutInflater.from(context);
        View view = inflater1.inflate(R.layout.admin_history_row, parent, false);
        return new AdminHistoryAdapter.MyViewHolder(view, adminHistoryInterface);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName1.setText(bookingDetails.get(position).getName());
        holder.tvRoom1.setText(bookingDetails.get(position).getRoomNumber());
        holder.tvTime1.setText(bookingDetails.get(position).getTimeSlot());
        holder.tvDate1.setText(bookingDetails.get(position).getDate());
        holder.tvPosition1.setText(bookingDetails.get(position).getProfession());
//        holder.tvStatus1.setText(bookingDetails.get(position).getConfirm());
        if(bookingDetails.get(position).getConfirm().equals("true")){
            holder.tvStatus1.setText("ACCEPTED");
        }else{
            holder.tvStatus1.setText("DECLINED");
        }

    }

    @Override
    public int getItemCount() {
        return bookingDetails.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvName1, tvRoom1, tvTime1, tvDate1, tvReason1, tvPosition1, tvStatus1;

        public MyViewHolder(@NonNull View itemView, AdminHistoryInterface adminHistoryInterface) {
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
                    if(adminHistoryInterface !=null){
                        int position = getAbsoluteAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                            adminHistoryInterface.OnItemClick(position);
                    }
                }
            });
        }


    }
}

