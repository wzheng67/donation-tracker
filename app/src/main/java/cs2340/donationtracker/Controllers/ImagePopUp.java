package cs2340.donationtracker.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import cs2340.donationtracker.R;

public class ImagePopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_image_pop_up);
    }
}
