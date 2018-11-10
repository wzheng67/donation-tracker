package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import cs2340.donationtracker.R;

@SuppressWarnings("CyclicClassDependency")
public class MainApplication_user extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_application_user);
    }
    @SuppressWarnings("unused")
    public void goLocation(View v) {
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }
    @SuppressWarnings("unused")
    public void goCheckDonation(View v) {
        Intent intent = new Intent(this, CheckDonation.class);
        startActivity(intent);
    }
    @SuppressWarnings("unused")
    public void goMap(View v) {
        Intent intent = new Intent(this, MapLocation.class);
        startActivity(intent);
    }
    @SuppressWarnings({"unused", "ChainedMethodCall"})
    public void logout(View v) {
        Intent intent = new Intent(this, WelcomeScreen.class);
        FirebaseAuth.getInstance().signOut();
        startActivity(intent);
    }
}
