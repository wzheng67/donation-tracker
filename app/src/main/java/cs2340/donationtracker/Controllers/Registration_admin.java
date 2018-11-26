package cs2340.donationtracker.Controllers;

import android.os.Bundle;
import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import cs2340.donationtracker.R;


public class Registration_admin extends Activity {

    private Animation fadeInText;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation_admin);

        text = (TextView) findViewById(R.id.textView10);
        fadeInText =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fadeInText.setDuration(1800);
        text.startAnimation(fadeInText);
    }
}
