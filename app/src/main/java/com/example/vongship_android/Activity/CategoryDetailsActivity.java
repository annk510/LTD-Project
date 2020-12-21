package com.example.vongship_android.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Adapter.CategoriesAdapter;
import com.example.vongship_android.Adapter.StoresAdapter;
import com.example.vongship_android.DTO.Categories;
import com.example.vongship_android.DTO.Store;
import com.example.vongship_android.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class CategoryDetailsActivity extends AppCompatActivity {
    RecyclerView stores;
    public ArrayList<Store> storeArrayList;
    StoresAdapter storesAdapter;

    void loadStoresRecyclerView(LinearLayoutManager layoutManager) {
        stores = findViewById(R.id.listStore);
        stores.setHasFixedSize(true);
        stores.setLayoutManager(layoutManager);
        storeArrayList = new ArrayList<>();
        final TextView txt1=  findViewById(R.id.txt_location_category);
        final Categories categories = (Categories) getIntent().getSerializableExtra("category");
        TextView categoryname = findViewById(R.id.categoryname);
        categoryname.setText(categories.getCategoryName());
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final ArrayList<String> arrayListStoreID = new ArrayList<>();
        db.collection("Product")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                   @Override
                   public void onComplete(@NonNull Task<QuerySnapshot> task) {
                       if (task.isSuccessful()) {
                           for (QueryDocumentSnapshot document : task.getResult()){
                               if(!arrayListStoreID.contains(document.getString("storeid"))){
                                   if(categories.getCategoryId().equalsIgnoreCase(document.getString("categoryid"))){
                                       arrayListStoreID.add(document.getString("storeid"));
                                  }
                               }
                           }
                       }
                   }
                });
        db.collection("Stores")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                for (String storeid: arrayListStoreID) {
                                    if(document.getId().equals(storeid)){
                                        Store store = new Store();
                                        store.setStoreId(document.getId());
                                        store.setStoreName(document.getString("storename"));
                                        store.setDistance(document.getString("distance"));
                                        store.setImage(document.getString("image"));
                                        store.setSale(document.getString("sale"));
                                        storeArrayList.add(store);
                                    }
                                }
                            }
                        }
                    }
                });
        storeArrayList.add(new Store("BLaL8OexEXEXbffpvi2l","Cơm Tấm test Anh","0.8 km","Sale 7%","https://firebasestorage.googleapis.com/v0/b/doanltdd-60a15.appspot.com/o/Image%2Fshopcom2.png?alt=media&token=9977eac5-aa61-4ebf-9df7-79283da75e09"));
        //storeArrayList.add(new Store());
        storesAdapter = new StoresAdapter(storeArrayList,this,LinearLayoutManager.VERTICAL);
        stores.setAdapter(storesAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        loadStoresRecyclerView(layoutManager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarCategory);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.abc);    //logo muốn hiện thị trên action bar
        actionBar.setDisplayUseLogoEnabled(true);

        actionBar.setDisplayHomeAsUpEnabled(true);//của nút quay lại trên toolbar, có cái func ở dưới nữa.

        actionBar.setTitle("");
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    }


