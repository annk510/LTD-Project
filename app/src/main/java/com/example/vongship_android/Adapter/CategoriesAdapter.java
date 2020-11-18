package com.example.vongship_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.vongship_android.DTO.Categories;
import com.example.vongship_android.R;
import com.example.vongship_android.ViewHolder.CategoryHolder;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryHolder>{
    ArrayList<Categories> categoriesArrayList;
    Context context;

    public CategoriesAdapter(ArrayList<Categories> categoriesArrayList, Context context) {
        this.categoriesArrayList = categoriesArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.category_item,parent,false);
        return new CategoryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        holder.getTame().setText(categoriesArrayList.get(position).getCategoryName());
        holder.getImg().setImageResource(categoriesArrayList.get(position).getIdImg());
    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }


}
