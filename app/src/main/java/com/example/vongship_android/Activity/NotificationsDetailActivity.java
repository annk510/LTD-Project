package com.example.vongship_android.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vongship_android.Adapter.StoresAdapter;
import com.example.vongship_android.Class.DownloadImageTask;
import com.example.vongship_android.DTO.Store;
import com.example.vongship_android.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class NotificationsDetailActivity extends AppCompatActivity {
    RecyclerView notifications;
    ArrayList<Store> storeArrayList;
    StoresAdapter storesAdapter;

    void loadProductRecyclerView(LinearLayoutManager layoutManager){
        notifications = findViewById(R.id.list_in_detail_notification);
        notifications.setHasFixedSize(true);
        notifications.setLayoutManager(layoutManager);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Stores")
            .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                 @Override
                 public void onComplete(@NonNull Task<QuerySnapshot> task) {
                 if(task.isSuccessful()){
                     storeArrayList = new ArrayList<Store>();
                     for (QueryDocumentSnapshot document : task.getResult()) {
                         Store store = new Store();
                         store.setStoreId(document.getId());
                         store.setStoreName(document.getString("storename"));
                         store.setDistance(document.getString("distance"));
                         store.setImage(document.getString("image"));
                         store.setSale(document.getString("sale"));
                         storeArrayList.add(store);
                     }
                     storeArrayList.add(new Store("yLd8mWjPtzORB3aHxDuD","Cà Phê Trung Nguyên","2 km","Sale 12%","https://firebasestorage.googleapis.com/v0/b/doanltdd-60a15.appspot.com/o/Image%2Fshopcf1.png?alt=media&token=94d36d69-e67c-473a-930b-8bfd63d6b6d2"));
                     storesAdapter = new StoresAdapter(storeArrayList,NotificationsDetailActivity.this,LinearLayoutManager.VERTICAL);
                     notifications.setAdapter(storesAdapter);
                 }
                                             }});

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_detail);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        loadProductRecyclerView(layoutManager);

        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.toolbar_notification_detail);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        //actionBar.setLogo(R.drawable.ic_baseline_keyboard_backspace);    //logo muốn hiện thị trên action bar
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);//của nút quay lại trên toolbar, có cái func ở dưới nữa.

        Intent intent = getIntent();
        actionBar.setTitle(intent.getStringExtra("content"));
        TextView title =(TextView) findViewById(R.id.title);
        TextView content = findViewById(R.id.detail_content);
        TextView saleTime = findViewById(R.id.saleTime);

        saleTime.setText("Thời gian chương trình: "+intent.getStringExtra("saleTime"));
        title.setText(intent.getStringExtra("title"));
        content.setText(intent.getStringExtra("content"));
        new DownloadImageTask((ImageView) findViewById(R.id.detail_img))
                .execute(intent.getStringExtra("img"));



    }
    //bắt sự kiện cho các nút
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // nút back
                onBackPressed();
                return true;
            case R.id.menu:
                //code xử lý khi bấm menu
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //thêm các icon tren toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_notification, menu);
        return true;
    }

}