package com.example.vongship_android.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Adapter.CategoriesAdapter;
import com.example.vongship_android.Adapter.StoresAdapter;
import com.example.vongship_android.DTO.Categories;
import com.example.vongship_android.DTO.Store;
import com.example.vongship_android.R;

import java.util.ArrayList;

public class CategoryDetailsActivity extends AppCompatActivity {
    RecyclerView stores;
    ArrayList<Store> storeArrayList;
    StoresAdapter storesAdapter;

    void loadStoresRecyclerView(LinearLayoutManager layoutManager) {
        stores = findViewById(R.id.listStore);
        stores.setHasFixedSize(true);
        stores.setLayoutManager(layoutManager);
        storeArrayList = new ArrayList<>();
        storeArrayList.add(new Store("Tên Cửa Hàng1", "Khoảng cách", "Khuyến mãi", R.drawable.trsua));
        storeArrayList.add(new Store("Tên Cửa Hàng2", "Khoảng cách", "Khuyến mãi", R.drawable.trsua));
        storeArrayList.add(new Store("Tên Cửa Hàng3", "Khoảng cách", "Khuyến mãi", R.drawable.trsua));
        storeArrayList.add(new Store("Tên Cửa Hàng4", "Khoảng cách", "Khuyến mãi", R.drawable.trsua));
        storeArrayList.add(new Store("Tên Cửa Hàng5", "Khoảng cách", "Khuyến mãi", R.drawable.trsua));
        storeArrayList.add(new Store("Tên Cửa Hàng6", "Khoảng cách", "Khuyến mãi", R.drawable.trsua));
        storesAdapter = new StoresAdapter(storeArrayList, this, LinearLayoutManager.VERTICAL);
        stores.setAdapter(storesAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        loadStoresRecyclerView(layoutManager);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarCategory);
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setLogo(R.drawable.abc);    //logo muốn hiện thị trên action bar
//        actionBar.setDisplayUseLogoEnabled(true);
//
//        actionBar.setDisplayHomeAsUpEnabled(true);//của nút quay lại trên toolbar, có cái func ở dưới nữa.
//
//        actionBar.setTitle("");
//    }
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                onBackPressed();
//                return true;
//
//            default:
//                break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    }
}
