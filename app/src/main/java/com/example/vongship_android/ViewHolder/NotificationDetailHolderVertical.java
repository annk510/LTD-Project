package com.example.vongship_android.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.R;

public class NotificationDetailHolderVertical extends RecyclerView.ViewHolder{
    private TextView name,distance,sales;
    private ImageView img;

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getDistance() {
        return distance;
    }

    public void setDistance(TextView distance) {
        this.distance = distance;
    }

    public TextView getSales() {
        return sales;
    }

    public void setSales(TextView sales) {
        this.sales = sales;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public NotificationDetailHolderVertical(@NonNull View itemView) {
        super(itemView);
        this.setName((TextView) itemView.findViewById(R.id.item_notification_detail_name)) ;
        this.setDistance((TextView) itemView.findViewById(R.id.item_notification_detail_distance)); ;
        this.setSales((TextView) itemView.findViewById(R.id.item_notification_detail_sales)); ;
        this.setImg((ImageView) itemView.findViewById(R.id.item_notification_detail_image));
    }
}
