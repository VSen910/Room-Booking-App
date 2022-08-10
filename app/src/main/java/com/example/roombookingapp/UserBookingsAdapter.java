package com.example.roombookingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserBookingsAdapter extends RecyclerView.Adapter<UserBookingsAdapter.MyViewHolder> {

    private final RequestInterface requestInterface;
    Context context;
    ArrayList<BookingDetails> bookingDetails;

    public UserBookingsAdapter(Context context, ArrayList<BookingDetails> bookingDetails, RequestInterface requestInterface) {
        this.context = context;
        this.bookingDetails = bookingDetails;
        this.requestInterface = requestInterface;
    }

    @NonNull
    @Override
    public UserBookingsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_booking_row, parent, false);
        return new UserBookingsAdapter.MyViewHolder(view, requestInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull UserBookingsAdapter.MyViewHolder holder, int position) {
        holder.roomNum.setText(bookingDetails.get(position).getRoomNumber());
        holder.date.setText(bookingDetails.get(position).getDate());
        holder.timeSlot.setText(bookingDetails.get(position).getTimeSlot());
    }

    @Override
    public int getItemCount() {
        return bookingDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView roomNum;
        TextView date;
        TextView timeSlot;

        public MyViewHolder(@NonNull View itemView, RequestInterface requestInterface) {
            super(itemView);
            this.roomNum = itemView.findViewById(R.id.roomnum_userbooking);
            this.date = itemView.findViewById(R.id.date_userbooking);
            this.timeSlot = itemView.findViewById(R.id.timeslot_userbooking);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (requestInterface != null) {
                        int pos = getAbsoluteAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            requestInterface.OnItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
