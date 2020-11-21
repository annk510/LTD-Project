package com.example.vongship_android.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Adapter.ProductAdapter;
import com.example.vongship_android.Adapter.StoresAdapter;
import com.example.vongship_android.DTO.Product;
import com.example.vongship_android.DTO.Store;
import com.example.vongship_android.R;

import java.util.ArrayList;

public class ProductDetailsActivity  extends AppCompatActivity {
    RecyclerView products;
    ArrayList<Product> productArrayList;
    ProductAdapter productAdapter;
    void loadProductRecyclerView(LinearLayoutManager layoutManager){
        products = findViewById(R.id.listProductInStore);
        products.setHasFixedSize(true);
        products.setLayoutManager(layoutManager);
        productArrayList = new ArrayList<>();
        productArrayList.add(new Product("1","Tên sản phẩm 1","Giá sản phẩm 1","Mô tả của sản phẩm 1",R.drawable.trsua));
        productArrayList.add(new Product("2","Tên sản phẩm 2","Giá sản phẩm 2","Mô tả của sản phẩm 2",R.drawable.trsua));
        productArrayList.add(new Product("3","Tên sản phẩm 3","Giá sản phẩm 3","Mô tả của sản phẩm 3",R.drawable.trsua));
        productArrayList.add(new Product("4","Tên sản phẩm 4","Giá sản phẩm 4","Mô tả của sản phẩm 4",R.drawable.trsua));
        productArrayList.add(new Product("5","Tên sản phẩm 5","Giá sản phẩm 5","Mô tả của sản phẩm 5",R.drawable.trsua));
        productArrayList.add(new Product("6","Tên sản phẩm 6","Giá sản phẩm 6","Mô tả của sản phẩm 6",R.drawable.trsua));
        productAdapter = new ProductAdapter(productArrayList,this,LinearLayoutManager.VERTICAL);
        products.setAdapter(productAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        loadProductRecyclerView(layoutManager)                                                                                                                        ;
    }
}
