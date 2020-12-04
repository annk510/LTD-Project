package com.example.vongship_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.example.vongship_android.Adapter.ProductPointAdapter;
import com.example.vongship_android.Adapter.RecommendFriendAdapter;
import com.example.vongship_android.DTO.InvFriend;
import com.example.vongship_android.DTO.Product;
import com.example.vongship_android.DTO.ProductPoint;
import com.example.vongship_android.R;

import java.util.ArrayList;

public class PointShopActivity extends AppCompatActivity {
    private GridView gridView;
    ArrayList<ProductPoint> listProduct;
    ProductPointAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_shop);
        anhXa();
        adapter = new ProductPointAdapter(this, R.layout.item_point_shop, listProduct);
        gridView.setAdapter(adapter);
    }
    public void anhXa() {
        gridView = (GridView) findViewById(R.id.grid_lopoint);
        listProduct = new ArrayList<>();
        listProduct.add(new ProductPoint(R.drawable.taphoa, "Tạp hóa Loship - Đà Nẵng", "[ĐN] Giảm 200.000", "150000 LP"));
        listProduct.add(new ProductPoint(R.drawable.taphoa, "Tạp hóa Loship - Cần Thơ", "[CT] Giảm 200.000", "150000 LP"));
        listProduct.add(new ProductPoint(R.drawable.vinamilk, "Vinamil  Giấc Mơ Sữa Việt", "Giảm 200.000", "120000 LP"));
        listProduct.add(new ProductPoint(R.drawable.nhansam, "Vietnamese Ginseng Store", "Giảm 100.000", "80000 LP"));
        listProduct.add(new ProductPoint(R.drawable.laubo, "Lẩu Bò Gian", "[ĐN] Giảm 100.000", "80000 LP"));
        listProduct.add(new ProductPoint(R.drawable.galuoc, "Tiệm Gà Luộc", "Giảm 210.000", "80000 LP"));
    }
}