package com.example.vongship_android.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.vongship_android.Adapter.ProductAdapter;
import com.example.vongship_android.DTO.Product;
import com.example.vongship_android.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity {
    RecyclerView products;
    ArrayList<Product> productArrayList;
    ProductAdapter productAdapter;
    Product product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        loadProductRecyclerView(layoutManager);

        Toolbar toolbar =findViewById(R.id.toolbarSearch);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.abc);    //logo muốn hiện thị trên action bar
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);//của nút quay lại trên toolbar, có cái func ở dưới nữa.
        actionBar.setTitle("");

        TextView key = findViewById(R.id.txt_keyw);
        Intent intent = getIntent();
        key.setText(intent.getStringExtra("key"));
        TextView location = findViewById(R.id.txt_location_search);
        location.setText(VT());

    }
    public String VT() {
        LocationManager locationManager = (LocationManager) SearchActivity.this.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(SearchActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(SearchActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
        Criteria criteria = new Criteria();

        Location lastLocation = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        double latitude = 0;
        double longitude = 0;
        if(lastLocation!= null){
            latitude = lastLocation.getLatitude();
            longitude = lastLocation.getLongitude();
        }
        Geocoder geoCoder = new Geocoder(SearchActivity.this, Locale.getDefault());
        List<Address> matches = null;
        try {
            matches = geoCoder.getFromLocation(latitude, longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String address=null;
        if(matches != null){
            Address bestMatch = (matches.isEmpty() ? null : matches.get(0));
            if(bestMatch != null){
                address= bestMatch.getAddressLine(0);
            }

        }

        return address;

    }
    void loadProductRecyclerView(LinearLayoutManager layoutManager){
        products = findViewById(R.id.listSearch);
        products.setHasFixedSize(true);
        products.setLayoutManager(layoutManager);
        Intent intent = getIntent();
        String keyw=intent.getStringExtra("key");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Product").whereGreaterThanOrEqualTo("name",keyw).limit(5)
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
                                product.setStoreid(document.getString("storeid"));
                                productArrayList.add(product);
                            }
                            productAdapter = new ProductAdapter(productArrayList,SearchActivity.this, LinearLayoutManager.VERTICAL);
                            products.setAdapter(productAdapter);
                        } else {
                            Log.w("adad", "Error getting documents.", task.getException());
                        }
                    }
                });

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
    LocationListener locationListener= new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            double longitude= location.getLongitude();
            double lat= location.getLatitude();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    };
}