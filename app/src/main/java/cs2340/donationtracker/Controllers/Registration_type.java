package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import cs2340.donationtracker.Model.User;
import cs2340.donationtracker.Model.User_type;
import cs2340.donationtracker.R;

public class Registration_type extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_type);
    }
    public void goAdmin(View v) {
        Intent intent = new Intent(this, Registration_admin.class);
        intent.putExtra("Admin", User_type.ADMIN);
        startActivity(intent);
    }
    public void goManager(View v) {
        Intent intent = new Intent(this, Registration.class);
        intent.putExtra("Manager", User_type.MANAGER);
        startActivity(intent);
    }
    public void goEmployee(View v) {
        Intent intent = new Intent(this, Welcomescreen.class);
        intent.putExtra("Employee", User_type.LOCATION_EMPLOYEE);
        startActivity(intent);
    }
    public void goUser(View v) {
        Intent intent = new Intent(this, Welcomescreen.class);
        intent.putExtra("User", User_type.USER);
        startActivity(intent);
    }
}
