package com.example.vongship_android.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Activity.CategoryDetailsActivity;
import com.example.vongship_android.Activity.ProductDetailsActivity;
import com.example.vongship_android.Class.DownloadImageTask;
import com.example.vongship_android.DTO.Categories;
import com.example.vongship_android.R;
import com.example.vongship_android.ViewHolder.CategoryHolderHorizontal;
import com.example.vongship_android.ViewHolder.CategoryHolderVertical;
import com.example.vongship_android.ViewHolder.ItemClickListener;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<Categories> categoriesArrayList;
    Context context;
    int orientationOfList;

    public CategoriesAdapter(ArrayList<Categories> categoriesArrayList, Context context, int orientationOfList) {
        this.categoriesArrayList = categoriesArrayList;
        this.context = context;
        this.orientationOfList = orientationOfList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(orientationOfList == LinearLayoutManager.HORIZONTAL){
            View itemView = inflater.inflate(R.layout.item_category_horizontal,parent,false);
            return new CategoryHolderHorizontal(itemView);
        }else {
            View itemView = inflater.inflate(R.layout.item_category_vertical,parent,false);

            return new CategoryHolderVertical(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(orientationOfList == LinearLayoutManager.HORIZONTAL){
            CategoryHolderHorizontal viewHolder = (CategoryHolderHorizontal)holder;
            viewHolder.getName().setText(categoriesArrayList.get(position).getCategoryName());
            new DownloadImageTask(viewHolder.getImg()).execute(categoriesArrayList.get(position).getImage());
            viewHolder.setItemClickListener(new ItemClickListener(){
                @Override
                public void onClick(View view, int position, boolean isLongClick) {
                    Intent intent = new Intent(context, CategoryDetailsActivity.class);
                    intent.putExtra("category",categoriesArrayList.get(position));
                    context.startActivity(intent);
                }
            });
        }else{
            CategoryHolderVertical viewHolder = (CategoryHolderVertical)holder;
            viewHolder.getName().setText(categoriesArrayList.get(position).getCategoryName());
            new DownloadImageTask(viewHolder.getImg()).execute(categoriesArrayList.get(position).getImage());
            viewHolder.setItemClickListener(new ItemClickListener(){
                @Override
                public void onClick(View view, int position, boolean isLongClick) {
                    Intent intent = new Intent(context, CategoryDetailsActivity.class);
                    intent.putExtra("category",categoriesArrayList.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }

}
