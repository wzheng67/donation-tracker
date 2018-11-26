package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import cs2340.donationtracker.R;

public class MainApplication_user extends Activity {

    private Animation fadeInText;
    private TextView text;

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;

    private Animation frombottom1;
    private Animation frombottom2;
    private Animation frombottom3;
    private Animation frombottom4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_application_user);

        frombottom1 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        frombottom2 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        frombottom3 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        frombottom4 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);

        bt1 = (Button) findViewById(R.id.button_locationInfo3);
        bt2 = (Button) findViewById(R.id.button_checkItems_user);
        bt3 = (Button) findViewById(R.id.button_map_user);
        bt4 = (Button) findViewById(R.id.button8);


        bt1.setAnimation(frombottom1);
        frombottom2.setStartOffset((200));
        bt2.setAnimation(frombottom2);
        frombottom3.setStartOffset((400));
        bt3.setAnimation(frombottom3);
        frombottom4.setStartOffset((600));
        bt4.setAnimation(frombottom4);




        text = (TextView) findViewById(R.id.textView20);
        fadeInText =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fadeInText.setDuration(1800);
        text.startAnimation(fadeInText);






    }
    public void goLocation(View v) {
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }
    public void goCheckDonation(View v) {
        Intent intent = new Intent(this, CheckDonation.class);
        startActivity(intent);
    }
    public void goMap(View v) {
        Intent intent = new Intent(this, MapLocation.class);
        startActivity(intent);
    }
    public void logout(View v) {
        Intent intent = new Intent(this, Welcomescreen.class);
        FirebaseAuth.getInstance().signOut();
        startActivity(intent);
    }
}
