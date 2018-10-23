package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

    public void logout(View v) {
        Intent intent = new Intent(this, Welcomescreen.class);
        startActivity(intent);
    }
}
