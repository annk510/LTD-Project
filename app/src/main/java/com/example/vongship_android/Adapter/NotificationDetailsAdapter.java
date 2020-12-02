package com.example.vongship_android.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Activity.NotificationsDetailActivity;
import com.example.vongship_android.DTO.NotificationDetails;
import com.example.vongship_android.R;
import com.example.vongship_android.ViewHolder.NotificationDetailHolderVertical;

import java.util.ArrayList;

public class NotificationDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<NotificationDetails> notificationDetailsArrayList;
    Context context;
    int orientationOfList;

    public NotificationDetailsAdapter(ArrayList<NotificationDetails> notificationDetailsArrayList, Context context, int orientationOfList) {
        this.notificationDetailsArrayList = notificationDetailsArrayList;
        this.context = context;
        this.orientationOfList = orientationOfList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_notification_details,parent,false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NotificationsDetailActivity.class);
                context.startActivity(intent);
            }
        });
        return new NotificationDetailHolderVertical(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NotificationDetailHolderVertical viewHolder = (NotificationDetailHolderVertical)holder;
        viewHolder.getName().setText(notificationDetailsArrayList.get(position).getName());
        viewHolder.getDistance().setText(notificationDetailsArrayList.get(position).getDistance());
        viewHolder.getSales().setText(notificationDetailsArrayList.get(position).getSales());
        viewHolder.getImg().setImageResource(notificationDetailsArrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return notificationDetailsArrayList.size();
    }
}
