package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import cs2340.donationtracker.R;

/**
 * implementation of main application display for users
 */
@SuppressWarnings("CyclicClassDependency")
public class MainApplication_user extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_application_user);
    }

    /**
     * This method takes user to location class.
     * @param v an object of View class.
     */
    @SuppressWarnings("unused")
    public void goLocation(View v) {
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }

    /**
     * This method displays goCheckDonation class to users.
     * @param v an object of View class
     */
    @SuppressWarnings("unused")
    public void goCheckDonation(View v) {
        Intent intent = new Intent(this, CheckDonation.class);
        startActivity(intent);
    }

    /**
     * This method displays MapLocation class to users.
     * @param v an object of View class
     */
    @SuppressWarnings("unused")
    public void goMap(View v) {
        Intent intent = new Intent(this, MapLocation.class);
        startActivity(intent);
    }

    /**
     * This method takes users to welcome screen.
     * @param v object of View class
     */
    @SuppressWarnings({"unused", "ChainedMethodCall"})
    public void logout(View v) {
        Intent intent = new Intent(this, WelcomeScreen.class);
        FirebaseAuth.getInstance().signOut();
        startActivity(intent);
    }
}