// Make sure you have set up your Google Maps API key in your AndroidManifest.xml file within the <application> tag:

// xml
// Copy code
// <meta-data
//     android:name="com.google.android.geo.API_KEY"
//     android:value="YOUR_API_KEY_HERE" />


// First, ensure you have added the Google Maps SDK to your project. You can do this by adding the following dependency in your app-level build.gradle file:
// gradle
// Copy code
// implementation 'com.google.android.gms:play-services-maps:17.0.1'


package com.example.googlemapsearch;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchLocation(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    private void searchLocation(String location) {
        // Use Geocoder or any other service to get LatLng of the location
        // For simplicity, we'll use a hardcoded LatLng in this example
        LatLng coordinates = new LatLng(37.7749, -122.4194); // San Francisco coordinates

        if (googleMap != null) {
            googleMap.clear(); // Clear previous markers
            googleMap.addMarker(new MarkerOptions().position(coordinates).title(location));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 12f));
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        googleMap = map;
    }
}
