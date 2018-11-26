package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cs2340.donationtracker.R;

/**
 * implementation of FailedLogin page
 */
@SuppressWarnings("CyclicClassDependency")
public class FailedLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed_login);
    }

    /**
     * This method takes user to login page.
     * @param v an object of View class
     */
    @SuppressWarnings("unused")
    public void goBackToLogin(View v) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
