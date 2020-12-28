package com.example.vongship_android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.vongship_android.Adapter.Product_OrderAdapter;
import com.example.vongship_android.DTO.Product_order;
import com.example.vongship_android.R;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    public static TextView totalmoneytext;
    public static RecyclerView cart;
    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        totalmoneytext = findViewById(R.id.totalmoney);
        int totalmoney =0;
        for (Product_order product_order:ProductDetailsActivity.product_orderArrayList
             ) {
            totalmoney += Integer.parseInt(product_order.getQuatity())*Integer.parseInt(product_order.getPrice());
        }
        totalmoneytext.setText(String.valueOf(totalmoney));
        cart = findViewById(R.id.cart);
        context = Cart.this;
        Product_OrderAdapter product_orderAdapter = new Product_OrderAdapter(ProductDetailsActivity.product_orderArrayList,this);
        cart.setHasFixedSize(true);
        cart.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        cart.setAdapter(product_orderAdapter);


    }
}