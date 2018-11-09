package cs2340.donationtracker.Controllers;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import cs2340.donationtracker.R;

@SuppressWarnings("SpellCheckingInspection")
public class Welcomescreen extends AppCompatActivity {

    private Button login;
    private Button register;
    private ImageView imageView;
    private TextView text;

    private Animation frombottom1;
    private Animation frombottom2;
    private Animation fadeInIcon;
    private Animation fadeInText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Location.locationList = Location.getLocationData(this);
        setContentView(R.layout.activity_welcomescreen);

        imageView = (ImageView) findViewById(R.id.imageView2);
        text = (TextView) findViewById(R.id.editText3);
        login = (Button) findViewById(R.id.Login);
        register = (Button ) findViewById(R.id.Registration);

        frombottom1 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        frombottom2 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        fadeInIcon =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fadeInText =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fadeInIcon.setStartOffset(500);
        imageView.startAnimation(fadeInIcon);


        ObjectAnimator animation = ObjectAnimator.ofFloat(imageView, "translationY", -350f);
        animation.setDuration(1000);
        animation.setStartDelay(1400);
        animation.start();


        fadeInText.setStartOffset(2250);
        text.startAnimation(fadeInText);
        frombottom1.setStartOffset(3000);
        login.setAnimation(frombottom1);
        frombottom2.setStartOffset((3100));
        register.setAnimation(frombottom2);

    }
    public void goToLogin(View v) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void goToRegistration(View v) {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
}
