package com.example.vongship_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.vongship_android.Model.Categories;
import com.example.vongship_android.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder>{
    ArrayList<Categories> categoriesArrayList;
    Context context;

    public CategoriesAdapter(ArrayList<Categories> categoriesArrayList, Context context) {
        this.categoriesArrayList = categoriesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.recylerview_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tame.setText(categoriesArrayList.get(position).getCategoryName());
        holder.img.setImageResource(categoriesArrayList.get(position).getIdImg());
    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tame;
        CircleImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tame = (TextView) itemView.findViewById(R.id.nameOfCategory);
            img = (CircleImageView) itemView.findViewById(R.id.imgOfCategory);
        }
    }
}
