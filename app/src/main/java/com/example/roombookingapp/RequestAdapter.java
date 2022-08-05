package com.example.roombookingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyViewHolder> {
    private final RequestInterface requestInterface;

    Context context;
    ArrayList<RequestModel> requestModel;

    public RequestAdapter(Context context, ArrayList<RequestModel> requestModel, RequestInterface requestInterface){
        this.context = context;
        this.requestModel = requestModel;
        this.requestInterface = requestInterface;
    }


    @NonNull
    @Override
    public RequestAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_pending_row, parent, false);
        return new RequestAdapter.MyViewHolder(view, requestInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(requestModel.get(position).getRequestName());
        holder.tvRoom.setText((requestModel.get(position).getRequestRoom()));
        holder.tvTime.setText(requestModel.get(position).getRequestTime());
        holder.tvDate.setText(requestModel.get(position).getRequestDay());
        holder.tvReason.setText(requestModel.get(position).getRequestReason());
        holder.tvPosition.setText(requestModel.get(position).getRequestPosition());
    }

    @Override
    public int getItemCount() {
        return  requestModel.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvRoom, tvTime, tvDate, tvReason, tvPosition;

        public MyViewHolder(@NonNull View itemView, RequestInterface requestInterface ) {
            super(itemView);
            tvName = itemView.findViewById(R.id.req_name);
            tvRoom = itemView.findViewById(R.id.req_room_no);
            tvTime = itemView.findViewById((R.id.req_time));
            tvDate = itemView.findViewById(R.id.req_day);
            tvReason = itemView.findViewById(R.id.req_reason);
            tvPosition = itemView.findViewById(R.id.req_position);

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
