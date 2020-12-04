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

import com.example.vongship_android.DTO.Comments;
import com.example.vongship_android.DTO.ProductPoint;
import com.example.vongship_android.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentsAdapter extends BaseAdapter {
    private Context context;
    int layout;
    List<Comments> commentsList;

    public CommentsAdapter(Context context, int layout, ArrayList<Comments> commentsList) {
        this.context = context;
        this.layout = layout;
        this.commentsList = commentsList;
    }

    @Override
    public int getCount() {
        return commentsList.size();
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
        convertView = layoutInflater.inflate(R.layout.item_comment, null);

        CircleImageView Avatar = (CircleImageView) convertView.findViewById(R.id.profile_image);
        TextView Name = (TextView) convertView.findViewById(R.id.name);
        TextView Shop = (TextView) convertView.findViewById(R.id.shop);
        TextView Time = (TextView) convertView.findViewById(R.id.time);
        TextView Title = (TextView) convertView.findViewById(R.id.title);
        ImageView Food = (ImageView) convertView.findViewById(R.id.cmt_image);

        Comments comments = commentsList.get(position);

        Avatar.setImageResource(comments.getAvatar());
        Name.setText(comments.getName());
        Shop.setText(comments.getShop());
        Time.setText(comments.getTime());
        Title.setText(comments.getTitle());
        Food.setImageResource(comments.getFood());
        return convertView;
    }
}

