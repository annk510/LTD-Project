package com.example.vongship_android.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.R;

public class CategoryHolder extends RecyclerView.ViewHolder{
    private TextView tame;
    private ImageView img;

    public TextView getTame() {
        return tame;
    }

    public void setTame(TextView tame) {
        this.tame = tame;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
    public CategoryHolder(@NonNull View itemView) {
        super(itemView);
        this.setTame((TextView) itemView.findViewById(R.id.nameOfCategory));
        this.setImg((ImageView) itemView.findViewById(R.id.imgOfCategory)) ;
    }
}
