package com.example.vongship_android.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Activity.ProductDetailsActivity;
import com.example.vongship_android.Activity.StoreDetailsActivity;
import com.example.vongship_android.Class.DownloadImageTask;
import com.example.vongship_android.DTO.Store;
import com.example.vongship_android.R;
import com.example.vongship_android.ViewHolder.ItemClickListener;
import com.example.vongship_android.ViewHolder.StoreHolderHorizontal;
import com.example.vongship_android.ViewHolder.StoreHolderVertical;

import java.util.ArrayList;

public class StoresAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<Store> storeArrayList;
    Context context;
    int orientationOfList;

    public StoresAdapter(ArrayList<Store> storeArrayList, Context context, int orientationOfList) {
        this.storeArrayList = storeArrayList;
        this.context = context;
        this.orientationOfList = orientationOfList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(orientationOfList == LinearLayoutManager.HORIZONTAL){
            View itemView = inflater.inflate(R.layout.item_store_horizontal,parent,false);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, StoreDetailsActivity.class);
                    context.startActivity(intent);
                }
            });
            return new StoreHolderHorizontal(itemView);
        }else {
            View itemView = inflater.inflate(R.layout.item_store_vertical,parent,false);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, StoreDetailsActivity.class);
                    context.startActivity(intent);
                }
            });
            return new StoreHolderVertical(itemView);
        }

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(orientationOfList == LinearLayoutManager.HORIZONTAL){
            StoreHolderHorizontal viewHolder = (StoreHolderHorizontal)holder;
            viewHolder.getName().setText(storeArrayList.get(position).getStoreName());
            viewHolder.getImg().setImageResource(R.drawable.ansang);
            new DownloadImageTask(viewHolder.getImg()).execute(storeArrayList.get(position).getImage());
            viewHolder.getDistance().setText(storeArrayList.get(position).getDistance());
            viewHolder.getSales().setText(storeArrayList.get(position).getSale());
            viewHolder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int position, boolean isLongClick) {
                    Intent intent = new Intent(context, StoreDetailsActivity.class);
                    intent.putExtra("Store",storeArrayList.get(position));
                    context.startActivity(intent);
                }
            });


        }else{
            StoreHolderVertical viewHolder = (StoreHolderVertical)holder;
            viewHolder.getName().setText(storeArrayList.get(position).getStoreName());
            viewHolder.getImg().setImageResource(R.drawable.ansang);
            new DownloadImageTask(viewHolder.getImg()).execute(storeArrayList.get(position).getImage());
            viewHolder.getDistance().setText(storeArrayList.get(position).getDistance());
            viewHolder.getSales().setText(storeArrayList.get(position).getSale());

        }

    }
    @Override
    public int getItemCount() {
        return storeArrayList.size();
    }

}
