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
        productArrayList.add(new Product("1","Nước Dừa Trần Cao Vân","20.000 VNĐ","Freeship 2km",R.drawable.nuocdua));
        productArrayList.add(new Product("2","Cơm Chiên Dương Châu","50.000 VNĐ","Sale 10%",R.drawable.comchien));
        productArrayList.add(new Product("3","Cà Phê Trung Nguyên","25.000 VNĐ","Freeship 1.5km",R.drawable.caphe));
        productArrayList.add(new Product("4","Bánh Ép Huế","15.000 VNĐ","Freeship 2km",R.drawable.banhep));
        productArrayList.add(new Product("5","Trà Sữa Trân Châu","35.000 VNĐ","Sale 5%",R.drawable.trasua));
        productArrayList.add(new Product("6","Trà Chanh","20.000 VNĐ","Freeship 2km",R.drawable.trachanh));
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
