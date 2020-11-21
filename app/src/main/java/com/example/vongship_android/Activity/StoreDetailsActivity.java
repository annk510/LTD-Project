package com.example.vongship_android.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Adapter.ProductAdapter;
import com.example.vongship_android.DTO.Product;
import com.example.vongship_android.R;

import java.util.ArrayList;

public class StoreDetailsActivity extends AppCompatActivity {
    RecyclerView product;
    ArrayList<Product> productArrayList;
    ProductAdapter productAdapter;
    void loadProductRecyclerView(LinearLayoutManager layoutManager){
        product = findViewById(R.id.listStore);
        product.setHasFixedSize(true);
        product.setLayoutManager(layoutManager);
        productArrayList = new ArrayList<>();
        productArrayList.add(new Product("1","Tên sản phẩm1","Giả","Mô tả",R.drawable.trsua));
        productArrayList.add(new Product("1","Tên sản phẩm2","Giả","Mô tả",R.drawable.trsua));
        productArrayList.add(new Product("1","Tên sản phẩm3","Giả","Mô tả",R.drawable.trsua));
        productArrayList.add(new Product("1","Tên sản phẩm4","Giả","Mô tả",R.drawable.trsua));
        productArrayList.add(new Product("1","Tên sản phẩm5","Giả","Mô tả",R.drawable.trsua));
        productArrayList.add(new Product("1","Tên sản phẩm6","Giả","Mô tả",R.drawable.trsua));
        productAdapter = new ProductAdapter(productArrayList,this,LinearLayoutManager.VERTICAL);
        product.setAdapter(productAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        loadProductRecyclerView(layoutManager);
    }
}
