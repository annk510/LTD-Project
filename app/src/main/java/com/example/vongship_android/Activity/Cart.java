package com.example.vongship_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.vongship_android.R;

public class Cart extends AppCompatActivity {
    public static TextView totalmoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        totalmoney = findViewById(R.id.totalmoney);

    }
}