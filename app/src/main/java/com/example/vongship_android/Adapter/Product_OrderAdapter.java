package com.example.vongship_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Activity.Cart;
import com.example.vongship_android.DTO.Product_order;
import com.example.vongship_android.R;
import com.example.vongship_android.ViewHolder.CategoryHolderHorizontal;
import com.example.vongship_android.ViewHolder.Product_OrderViewHolder;

import java.util.ArrayList;

public class Product_OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<Product_order> product_orders;
    Context context;

    public Product_OrderAdapter(ArrayList<Product_order> product_orders, Context context) {
        this.product_orders = product_orders;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_product_order,parent,false);
        return new Product_OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final Product_OrderViewHolder product_orderViewHolder = (Product_OrderViewHolder) holder;
        product_orderViewHolder.getName().setText(product_orders.get(position).getProductname());
        product_orderViewHolder.getQuantity().setText(product_orders.get(position).getQuatity());
        product_orderViewHolder.getTotalmoney().setText(Integer.parseInt(product_orders.get(position).getQuatity())*Integer.parseInt(product_orders.get(position).getPrice()));
        product_orderViewHolder.getCong1().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentQuantity = Integer.parseInt((String) product_orderViewHolder.getQuantity().getText());
                currentQuantity ++;
                product_orderViewHolder.getQuantity().setText(currentQuantity);
                product_orderViewHolder.getTotalmoney().setText(currentQuantity*Integer.parseInt(product_orders.get(position).getPrice()));
                product_orders.get(position).setQuatity(String.valueOf(currentQuantity));
                int summoney = 0;
                for (Product_order product_order: product_orders) {
                    summoney += (Integer.parseInt(product_order.getQuatity())*Integer.parseInt(product_order.getPrice()));
                }
                Cart.totalmoney.setText(String.valueOf(summoney));
            }
        });
        product_orderViewHolder.getTru1().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentQuantity = Integer.parseInt((String) product_orderViewHolder.getQuantity().getText());
                currentQuantity--;
                if (currentQuantity>0) {
                    product_orderViewHolder.getQuantity().setText(currentQuantity);
                    product_orderViewHolder.getTotalmoney().setText(currentQuantity*Integer.parseInt(product_orders.get(position).getPrice()));
                    product_orders.get(position).setQuatity(String.valueOf(currentQuantity));
                }else {
                    product_orders.remove(product_orders.get(position));
                }
                int summoney = 0;
                for (Product_order product_order: product_orders ) {
                    summoney += (Integer.parseInt(product_order.getQuatity())*Integer.parseInt(product_order.getPrice()));
                }
                Cart.totalmoney.setText(String.valueOf(summoney));
            }
        });
    }

    @Override
    public int getItemCount() {
        return product_orders.size();
    }
}
