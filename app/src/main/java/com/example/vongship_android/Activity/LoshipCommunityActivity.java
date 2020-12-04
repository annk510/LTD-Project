package com.example.vongship_android.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import com.example.vongship_android.Adapter.CommentsAdapter;
import com.example.vongship_android.Adapter.ProductPointAdapter;
import com.example.vongship_android.DTO.Comments;
import com.example.vongship_android.DTO.ProductPoint;
import com.example.vongship_android.R;

import java.util.ArrayList;

public class LoshipCommunityActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<Comments> listComments;
    CommentsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loship_community);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_notification_detail);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Cộng đồng Loship");
        anhXa();
        adapter = new CommentsAdapter(this, R.layout.item_comment, listComments);
        listView.setAdapter(adapter);
    }

    private void anhXa() {
        listView = (ListView) findViewById(R.id.lv_comment);
        listComments = new ArrayList<>();
        listComments.add(new Comments(R.drawable.cat_avatar, R.drawable.trachanh, "Phương Thảo", "Boom Trà Sữa", "1 giờ trước", "Trà sữa ngon lắm cả nhà"));
        listComments.add(new Comments(R.drawable.avatar_meo, R.drawable.banhep, "Nguyễn Quỳnh", "Bánh Ép Huế", "3 giờ trước", "Bánh ngon, giá rẻ"));
        listComments.add(new Comments(R.drawable.sia_avatar, R.drawable.banhmy, "Vân Anh", "Bánh Mỳ Cao Thắng", "6 giờ trước", "Bánh mỳ ngon lắm ạ"));
        listComments.add(new Comments(R.drawable.avatar3, R.drawable.comchien, "vợ thế huân", "Cơm Chiên Gà", "7 giờ trước", "Cơm ngon mà giá hơi cao"));
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