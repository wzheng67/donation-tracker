package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.LinkedList;
import java.util.List;

import cs2340.donationtracker.Model.User;
import cs2340.donationtracker.R;

public class MainApplication extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_application);
    }
    public void goLocation(View v) {
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }
    public void goDonation(View v) {
        Intent intent = new Intent(this, AddDonation.class);
        startActivity(intent);
    }
    public void goMap(View v) {
        Intent intent = new Intent(this, MapLocation.class);
        startActivity(intent);
    }
    public void goCheckDonation(View v) {
        Intent intent = new Intent(this, CheckDonation.class);
        startActivity(intent);
    }

    public void logout(View v) {
        Intent intent = new Intent(this, Welcomescreen.class);
        FirebaseAuth.getInstance().signOut();
        startActivity(intent);
    }
}
