package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cs2340.donationtracker.Model.CurrentUser;
import cs2340.donationtracker.Model.LocationData;
import cs2340.donationtracker.Model.User_type;
import cs2340.donationtracker.R;

@SuppressWarnings({"ConstantConditions", "CyclicClassDependency", "ChainedMethodCall"})
public class MapLocation extends AppCompatActivity implements OnMapReadyCallback {

    @SuppressWarnings("ChainedMethodCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);

    }
    @SuppressWarnings("FeatureEnvy")
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        LatLng[] donationCenters = new LatLng[Location.locationList.size()];

        for (int i = 0; i < Location.locationList.size(); i++) {
            LocationData locationData = Location.locationList.get(i);
            donationCenters[i] = new LatLng(Double.parseDouble(locationData.getLatitude()),
                    Double.parseDouble(locationData.getLongitude()));
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(donationCenters[i]);
            markerOptions.title(locationData.getLocation_name());
            markerOptions.snippet(locationData.getPhone_number());
            googleMap.addMarker(markerOptions);

        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(donationCenters[0]));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
    @SuppressWarnings({"unused", "LawOfDemeter", "ChainedMethodCall"})
    public void goBack(View v) {
        if (CurrentUser.getInstance().getUserType() == User_type.USER) {
            Intent intent = new Intent(this, MainApplication_user.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MainApplication.class);
            startActivity(intent);
        }
    }
}
