package com.example.vongship_android.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Adapter.ProductAdapter;
import com.example.vongship_android.DTO.Product;
import com.example.vongship_android.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class StoreDetailsActivity extends AppCompatActivity {
    RecyclerView product;
    ArrayList<Product> productArrayList;
    ProductAdapter productAdapter;
    void loadProductRecyclerView(LinearLayoutManager layoutManager){
        product = findViewById(R.id.listProductInStore);
        product.setHasFixedSize(true);
        product.setLayoutManager(layoutManager);
        productArrayList = new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Product")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            productArrayList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product product = new Product();
                                product.setProductid(document.getId());
                                product.setProductname(document.getString("name"));
                                product.setDescription(document.getString("description"));
                                product.setPrice(document.get("price").toString());
                                product.setImg(document.getString("image"));
                                productArrayList.add(product);
                            }

                        } else {
                            Log.w("adad", "Error getting documents.", task.getException());
                        }
                    }
                });
        productAdapter = new ProductAdapter(productArrayList,this,LinearLayoutManager.VERTICAL);
        product.setAdapter(productAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        loadProductRecyclerView(layoutManager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarStoreDetail);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.abc);    //logo muốn hiện thị trên action bar
        actionBar.setDisplayUseLogoEnabled(true);

        actionBar.setDisplayHomeAsUpEnabled(true);//của nút quay lại trên toolbar, có cái func ở dưới nữa.

        actionBar.setTitle("");
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
