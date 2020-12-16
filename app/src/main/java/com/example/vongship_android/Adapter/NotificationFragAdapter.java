package com.example.vongship_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vongship_android.DTO.NotificationFrag;
import com.example.vongship_android.R;

import java.util.List;

public class NotificationFragAdapter extends BaseAdapter {
    private Context context;
    int layout;
    List<NotificationFrag> notificationFragList;

    public NotificationFragAdapter(Context context, int layout, List<NotificationFrag> notificationList) {
        this.context = context;
        this.layout = layout;
        notificationFragList = notificationList;
    }

    @Override
    public int getCount() {
        return notificationFragList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);

        TextView txtTitle=(TextView) view.findViewById(R.id.text);
        TextView txtDescription=(TextView)view.findViewById(R.id.time);
        ImageView images=(ImageView)view.findViewById(R.id.image);

        NotificationFrag notificationFrag = notificationFragList.get(i);

        txtTitle.setText(notificationFrag.getmTitle());
        txtDescription.setText(notificationFrag.getmDescription());
        images.setImageResource(notificationFrag.getImages());
        return view;
    }
}
