package com.example.vongship_android.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.vongship_android.Adapter.CategoriesAdapter;
import com.example.vongship_android.Adapter.ImageAdapter;
import com.example.vongship_android.Model.Categories;
import com.example.vongship_android.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FoodDeliveryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Categories> categoriesArrayList;
    CategoriesAdapter categoriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_delivery);

        recyclerView = findViewById(R.id.CategoriesRecyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        categoriesArrayList = new ArrayList<>();
        categoriesArrayList.add(new Categories(1,"Trà Sữa1",R.drawable.trsua));
        categoriesArrayList.add(new Categories(2,"Trà Sữa2",R.drawable.trsua));
        categoriesArrayList.add(new Categories(3,"Trà Sữa3",R.drawable.trsua));
        categoriesArrayList.add(new Categories(4,"Trà Sữa4",R.drawable.trsua));
        categoriesArrayList.add(new Categories(5,"Trà Sữa5",R.drawable.trsua));
        categoriesArrayList.add(new Categories(7,"Trà Sữa6",R.drawable.trsua));
        categoriesAdapter = new CategoriesAdapter(categoriesArrayList,this);
        recyclerView.setAdapter(categoriesAdapter);
        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        TextView currentLocation = (TextView) findViewById(R.id.currentLocation);
        currentLocation.setText(VT());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFood);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.abc);    //logo muốn hiện thị trên action bar
        actionBar.setDisplayUseLogoEnabled(true);

        actionBar.setDisplayHomeAsUpEnabled(true);//của nút quay lại trên toolbar, có cái func ở dưới nữa.

        actionBar.setTitle("");


    }

    public String VT() {
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
        Geocoder geoCoder = new Geocoder(this, Locale.getDefault());
        List<Address> matches = null;
        try {
            matches = geoCoder.getFromLocation(latitude, longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address bestMatch = (matches.isEmpty() ? null : matches.get(0));
        String address=null;
        if(bestMatch !=null){
            address= bestMatch.getAddressLine(0);
        }

        return address;

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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}