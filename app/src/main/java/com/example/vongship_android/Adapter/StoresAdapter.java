package com.example.vongship_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.DTO.Store;
import com.example.vongship_android.R;
import com.example.vongship_android.ViewHolder.StoreHolder;

import java.util.ArrayList;

public class StoresAdapter extends RecyclerView.Adapter<StoreHolder>{
    ArrayList<Store> storeArrayList;
    Context context;

    public StoresAdapter(ArrayList<Store> storeArrayList, Context context) {
        this.storeArrayList = storeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public StoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.store_item,parent,false);
        return new StoreHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreHolder holder, int position) {
        holder.getName().setText(storeArrayList.get(position).getStoreName());
        holder.getDistance().setText(storeArrayList.get(position).getDistance());
        holder.getSales().setText(storeArrayList.get(position).getSales());
        holder.getImg().setImageResource(storeArrayList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
