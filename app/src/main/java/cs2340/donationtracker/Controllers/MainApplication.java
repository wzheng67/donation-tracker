package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import cs2340.donationtracker.R;

/**
 * This MainApplication implements goLocation, goDonation, logout method.
 */
@SuppressWarnings("CyclicClassDependency")
public class MainApplication extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_application);
    }

    /**
     * This method changes current view to location display.
     * @param v an object of view class
     */
    @SuppressWarnings("unused")
    public void goLocation(View v) {
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }

    /**
     * This method changes current view to AddDonation display.
     * @param v an object of view class
     */
    @SuppressWarnings("unused")
    public void goDonation(View v) {
        Intent intent = new Intent(this, AddDonation.class);
        startActivity(intent);
    }

    /**
     * This method changes current view to MapLocation.
     * @param v an object of view class
     */
    @SuppressWarnings("unused")
    public void goMap(View v) {
        Intent intent = new Intent(this, MapLocation.class);
        startActivity(intent);
    }

    /**
     * This method changes current view to CheckDonation.
     * @param v an object of view class
     */
    @SuppressWarnings("unused")
    public void goCheckDonation(View v) {
        Intent intent = new Intent(this, CheckDonation.class);
        startActivity(intent);
    }

    /**
     * This method takes user to welcome screen.
     * @param v an object of view class
     */
    @SuppressWarnings({"unused", "ChainedMethodCall"})
    public void logout(View v) {
        Intent intent = new Intent(this, WelcomeScreen.class);
        FirebaseAuth.getInstance().signOut();
        startActivity(intent);
    }
}