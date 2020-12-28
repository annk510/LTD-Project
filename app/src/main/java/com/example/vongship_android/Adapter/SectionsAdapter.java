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
import com.example.vongship_android.DTO.Categories;
import com.example.vongship_android.DTO.Product;
import com.example.vongship_android.DTO.Section;
import com.example.vongship_android.DTO.Store;
import com.example.vongship_android.Fragment.HomeFragment;
import com.example.vongship_android.R;
import com.example.vongship_android.ViewHolder.ProductHolderVertical;
import com.example.vongship_android.ViewHolder.SectionHolder;

import java.util.ArrayList;

public class SectionsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<Section> sections;
    Context context;

    public SectionsAdapter(ArrayList sections, Context context) {
        this.sections = sections;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_section_vertical,parent,false);
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, ProductDetailsActivity.class);
//                context.startActivity(intent);
//            }
//        });
        return new SectionHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SectionHolder viewHolder = (SectionHolder)holder;
        viewHolder.getTitle().setText(sections.get(position).getHeaderTitle());
        ArrayList list = sections.get(position).getListContent();
        if (list.get(0) instanceof Store){
            StoresAdapter storesAdapter = new StoresAdapter(sections.get(position).getListContent(),context, LinearLayoutManager.HORIZONTAL);
            viewHolder.getContent().setHasFixedSize(true);
            viewHolder.getContent().setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            viewHolder.getContent().setAdapter(storesAdapter);
        }

        if (sections.get(position).getListContent().get(0) instanceof Categories){
            CategoriesAdapter categoriesAdapter = new CategoriesAdapter(sections.get(position).getListContent(),context, LinearLayoutManager.HORIZONTAL);
            viewHolder.getContent().setHasFixedSize(true);
            viewHolder.getContent().setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            viewHolder.getContent().setAdapter(categoriesAdapter);
        }
        if (sections.get(position).getListContent().get(0) instanceof Product){
            ProductAdapter productAdapter = new ProductAdapter(sections.get(position).getListContent(),context, LinearLayoutManager.HORIZONTAL);
            viewHolder.getContent().setHasFixedSize(true);
            viewHolder.getContent().setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            viewHolder.getContent().setAdapter(productAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }
}
