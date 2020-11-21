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

        storeArrayList.add(new Store("Cơm Chiên Hảo Hảo","1.3 km","Sale 11%",R.drawable.comchien));
        storeArrayList.add(new Store("Bánh Cuốn Lê Duẫn","2.5 km","Freeship 3km",R.drawable.banhcuon));
        storeArrayList.add(new Store("Milk Tea & Coffe - Bông","500 m","Sale 17 %",R.drawable.trasua));
        storeArrayList.add(new Store("Bánh Ép Huế Kim Ngân","700 m","Freeship 2km",R.drawable.banhep));
        storeArrayList.add(new Store("Cơm Gà Trần Cao Vân","300 m","Sale 15%",R.drawable.comga));
        storeArrayList.add(new Store("Quán Ngố - Nước Dừa","2 km","Freeship 2km",R.drawable.nuocdua));
        storesAdapter = new StoresAdapter(storeArrayList,this,LinearLayoutManager.VERTICAL);

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

