package com.example.slips;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;

public class GPSTracker implements LocationListener {
    private final Context mContext;
    private Location location;
    private final LocationManager locationManager;
    private boolean canGetLocation;

    public GPSTracker(Context context) {
        mContext = context;
        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
    }

    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    public double getLatitude() {
        return location.getLatitude();
    }

    public double getLongitude() {
        return location.getLongitude();
    }

    public void showSettingsAlert() {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        mContext.startActivity(intent);
    }

    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO: Handle provider disabled
    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO: Handle provider enabled
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO: Handle status changed
    }
}
