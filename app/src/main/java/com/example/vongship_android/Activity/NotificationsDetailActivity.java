package com.example.vongship_android.Activity;

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

import java.util.ArrayList;

public class NotificationsDetailActivity extends AppCompatActivity {
    RecyclerView notifications;
    //    ArrayList<NotificationDetails> notificationDetailsArrayList;
//    NotificationDetailsAdapter notificationDetailsAdapter;
    ArrayList<Store> storeArrayList;
    StoresAdapter storesAdapter;

    void loadProductRecyclerView(LinearLayoutManager layoutManager){
        notifications = findViewById(R.id.list_in_detail_notification);
        notifications.setHasFixedSize(true);
        notifications.setLayoutManager(layoutManager);
        storeArrayList = new ArrayList<>();
        storeArrayList.add(new Store("Xôi Lá chuối - Võ Chí Công ","152.0 km","Giảm 20%",R.drawable.xoi));
        storeArrayList.add(new Store("Xôi Lá chuối - Núi Thành ","152.0 km","Giảm 20%",R.drawable.xoi));
        storeArrayList.add(new Store("Xanh - Bún Măng Gà & Xôi Gà","152.0 km","Giảm 20%",R.drawable.xoi));
        storesAdapter = new StoresAdapter(storeArrayList,this,LinearLayoutManager.VERTICAL);
        notifications.setAdapter(storesAdapter);

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