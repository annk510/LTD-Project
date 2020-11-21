package com.example.vongship_android.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.R;

public class CategoryHolderHorizontal extends RecyclerView.ViewHolder {
    private TextView name;
    private ImageView img;

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
    public CategoryHolderHorizontal(@NonNull View itemView) {
        super(itemView);
        this.setName((TextView) itemView.findViewById(R.id.itemcategory_name));
        this.setImg((ImageView) itemView.findViewById(R.id.itemcategory_image));
    }

}
