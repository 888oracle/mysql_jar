//Add following code in manifest file before activity tag
//<meta-data
//        android:name="com.google.android.geo.API_KEY"
//        android:value="YOUR_API_KEY" />

//Add following code in build.gradle.kts(Module:app)
//implementation ("com.google.android.gms:play-services-maps:17.0.1")
//implementation ("androidx.appcompat:appcompat:1.3.1")

package com.example.slips;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapType;

public class MainActivity extends AppCompatActivity {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Initialize the map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                // Enable zoom controls
                mMap.getUiSettings().setZoomControlsEnabled(true);

                // Set initial camera position
                LatLng sydney = new LatLng(-34, 151);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));

                // Set satellite view
                mMap.setMapType(MapType.SATELLITE);

                // Add zoom in button
                Button zoomInButton = findViewById(R.id.zoom_in_button);
                zoomInButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMap.animateCamera(CameraUpdateFactory.zoomIn());
                    }
                });

                // Add zoom out button
                Button zoomOutButton = findViewById(R.id.zoom_out_button);
                zoomOutButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMap.animateCamera(CameraUpdateFactory.zoomOut());
                    }
                });
            }
        });
    }
}