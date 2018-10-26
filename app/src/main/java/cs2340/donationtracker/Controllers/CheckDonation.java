package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import cs2340.donationtracker.Model.CurrentUser;
import cs2340.donationtracker.Model.User_type;
import cs2340.donationtracker.R;

public class CheckDonation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_donation);
    }
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
