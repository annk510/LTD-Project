package com.example.vongship_android.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vongship_android.Adapter.RecommendFriendAdapter;
import com.example.vongship_android.DTO.InvFriend;
import com.example.vongship_android.R;

import java.util.ArrayList;

public class RecommendAppActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<InvFriend> listFriend;
    RecommendFriendAdapter adapter;
    private Button bt_doi, bt_copy, bt_invite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_app);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_notification_detail);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Chia sẻ mã giới thiệu");
        bt_doi = (Button) findViewById(R.id.bt_doi);
        bt_doi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecommendAppActivity.this, PointShopActivity.class);
                startActivity(intent);
            }
        });
        bt_copy = (Button) findViewById(R.id.bt_copy);
        bt_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecommendAppActivity.this, "Đã sao chép", Toast.LENGTH_SHORT).show();
            }
        });
        bt_invite = (Button) findViewById(R.id.bt_invite);
        bt_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecommendAppActivity.this, "Đã sao chép", Toast.LENGTH_SHORT).show();
            }
        });
        anhXa();
        adapter = new RecommendFriendAdapter(this, R.layout.item_recommend_fr, listFriend);
        listView.setAdapter(adapter);
    }

    public void anhXa() {
        listView = (ListView) findViewById(R.id.lv_recommend_fr);
        listFriend = new ArrayList<>();
        listFriend.add(new InvFriend(R.drawable.cat_avatar, "Võ Thành Luân"));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // nút back
                onBackPressed();
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}