package com.example.vongship_android.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.vongship_android.Adapter.ImageAdapter;
import com.example.vongship_android.Activity.MapsActivity;
import com.example.vongship_android.DownloadImageTask;
import com.example.vongship_android.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.content.Context.LOCATION_SERVICE;
import static com.example.vongship_android.R.id.location_click;

public class HomeFragment extends Fragment {
    LinearLayout location;
    LocationManager locationManager;

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        location = root.findViewById(location_click);
        ViewPager viewPager = root.findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(getActivity());
        viewPager.setAdapter(adapter);
        envent();
        double lat = 16.078151;
        double lon = 108.213201;

        TextView txtAdress = (TextView) root.findViewById(R.id.txt_Address);

//        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return null;
//        }
//        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
//        Criteria criteria = new Criteria();
//        Location lastLocation = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        Geocoder geoCoder = new Geocoder(getActivity(), Locale.getDefault());
        List<Address> matches = null;
        try {
            matches = geoCoder.getFromLocation(lat, lon, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address bestMatch = (matches.isEmpty() ? null : matches.get(0));
        String address= bestMatch.getAddressLine(0);
        txtAdress.setText(address);

        new DownloadImageTask((ImageView) root.findViewById(R.id.IMGprofile_home))
                .execute("https://firebasestorage.googleapis.com/v0/b/doanltdd-60a15.appspot.com/o/Image%2FprofileImage.jpg?alt=media&token=40d48a63-1ac3-4e2c-946d-4b8515f79c62");
        return root;
    }

    private Object getSystemService(String locationService) {
        return LOCATION_SERVICE;
    }

    public void envent(){
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });
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