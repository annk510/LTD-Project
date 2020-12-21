package com.example.vongship_android.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Activity.ProductDetailsActivity;
import com.example.vongship_android.Activity.StoreDetailsActivity;
import com.example.vongship_android.Class.DownloadImageTask;
import com.example.vongship_android.DTO.Product;
import com.example.vongship_android.R;
import com.example.vongship_android.ViewHolder.CategoryHolderHorizontal;
import com.example.vongship_android.ViewHolder.ItemClickListener;
import com.example.vongship_android.ViewHolder.ProductHolderVertical;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<Product> productArrayList;
    Context context;
    int orientationOfList;

    public ProductAdapter(ArrayList<Product> productArrayList, Context context, int orientationOfList) {
        this.productArrayList = productArrayList;
        this.context = context;
        this.orientationOfList = orientationOfList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_product_vertical,parent,false);
        return new ProductHolderVertical(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductHolderVertical viewHolder = (ProductHolderVertical)holder;
        viewHolder.getName().setText(productArrayList.get(position).getProductname());
        new DownloadImageTask(viewHolder.getImg()).execute(productArrayList.get(position).getImg());
        viewHolder.getDescription().setText(productArrayList.get(position).getDescription());
        viewHolder.getPrice().setText(productArrayList.get(position).getPrice()+ "VNĐ");
        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("Product",productArrayList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
}
