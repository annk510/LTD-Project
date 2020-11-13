package com.example.vongship_android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.vongship_android.Adapter.CategoriesAdapter;
import com.example.vongship_android.Model.Categories;
import com.example.vongship_android.R;

import java.util.ArrayList;

public class FoodDeliveryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Categories> categoriesArrayList;
    CategoriesAdapter categoriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_delivery);
        recyclerView = findViewById(R.id.CategoriesRecyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        categoriesArrayList = new ArrayList<>();
        categoriesArrayList.add(new Categories(1,"Trà Sữa1",R.drawable.trsua));
        categoriesArrayList.add(new Categories(2,"Trà Sữa2",R.drawable.trsua));
        categoriesArrayList.add(new Categories(3,"Trà Sữa3",R.drawable.trsua));
        categoriesArrayList.add(new Categories(4,"Trà Sữa4",R.drawable.trsua));
        categoriesArrayList.add(new Categories(5,"Trà Sữa5",R.drawable.trsua));
        categoriesArrayList.add(new Categories(7,"Trà Sữa6",R.drawable.trsua));
        categoriesAdapter = new CategoriesAdapter(categoriesArrayList,this);
        recyclerView.setAdapter(categoriesAdapter);
    }
}