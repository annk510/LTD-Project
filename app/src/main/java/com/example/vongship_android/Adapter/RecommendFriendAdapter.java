package com.example.vongship_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.vongship_android.DTO.InvFriend;
import com.example.vongship_android.R;

import java.util.List;

public class RecommendFriendAdapter extends BaseAdapter {
    private Context context;
    int layout;
    List<InvFriend> friendList;

    public RecommendFriendAdapter(Context context, int layout, List<InvFriend> friendList) {
        this.context = context;
        this.layout = layout;
        this.friendList = friendList;
    }

    @Override
    public int getCount() {
        return friendList.size();
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.item_recommend_fr, null);

        ImageView Image = (ImageView) convertView.findViewById(R.id.img);
        TextView Name = (TextView) convertView.findViewById(R.id.name);

        InvFriend Friend = friendList.get(position);

        Image.setImageResource(Friend.getImg());
        Name.setText(Friend.getName());
        return convertView;
    }


}

