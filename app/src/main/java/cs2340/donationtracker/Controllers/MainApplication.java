package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import cs2340.donationtracker.R;

/**
 * This MainApplication implements goLocation, goDonation, logout method.
 */
@SuppressWarnings("CyclicClassDependency")
public class MainApplication extends AppCompatActivity {

    private Animation fadeInText;
    private TextView text;

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;

    private Animation frombottom1;
    private Animation frombottom2;
    private Animation frombottom3;
    private Animation frombottom4;
    private Animation frombottom5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_application);
        frombottom1 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        frombottom2 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        frombottom3 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        frombottom4 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        frombottom5 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);

        bt1 = (Button) findViewById(R.id.button_locationInfo);
        bt2 = (Button) findViewById(R.id.button_checkItems);
        bt3 = (Button) findViewById(R.id.button_add_donation);
        bt4 = (Button) findViewById(R.id.button_map);
        bt5 = (Button) findViewById(R.id.button);


        bt1.setAnimation(frombottom1);
        frombottom2.setStartOffset((200));
        bt2.setAnimation(frombottom2);
        frombottom3.setStartOffset((400));
        bt3.setAnimation(frombottom3);
        frombottom4.setStartOffset((600));
        bt4.setAnimation(frombottom4);
        frombottom5.setStartOffset((800));
        bt5.setAnimation(frombottom5);




        text = (TextView) findViewById(R.id.textView);
        fadeInText =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fadeInText.setDuration(1800);
        text.startAnimation(fadeInText);
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