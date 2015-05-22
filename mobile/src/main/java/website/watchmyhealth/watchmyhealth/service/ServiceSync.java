package website.watchmyhealth.watchmyhealth.service;

/**
 * Created by Fabrice on 17/05/2015.
 */

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import website.watchmyhealth.watchmyhealth.fragment.FragmentMap;

public class ServiceSync extends Service implements LocationListener{
    private LocationManager locationMgr = null;

    @Override
    public void onCreate() {
        locationMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationMgr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000,0, this);
        locationMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);
        super.onCreate();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onLocationChanged(Location location) {
        Double latitude = location.getLatitude();
        Double longitude = location.getLongitude();
        Toast.makeText(getBaseContext(),"Voici les coordonnees de votre telephone : " + latitude + " " + longitude,Toast.LENGTH_LONG).show();
    }


    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        locationMgr.removeUpdates(this);
    }
}