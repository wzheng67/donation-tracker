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

@SuppressWarnings({"SpellCheckingInspection", "MagicNumber", "AssignmentToStaticFieldFromInstanceMethod"})
public class Welcomescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Location.locationList = Location.getLocationData(this);
        setContentView(R.layout.activity_welcomescreen);

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        TextView text = (TextView) findViewById(R.id.editText3);
        Button login = (Button) findViewById(R.id.Login);
        Button register = (Button) findViewById(R.id.Registration);

        Animation frombottom1 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        Animation frombottom2 = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        Animation fadeInIcon = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        Animation fadeInText = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        int offset = 500;
        fadeInIcon.setStartOffset(offset);
        imageView.startAnimation(fadeInIcon);

        float distance = -350f;
        int duration = 1000;
        int delay = 1400;
        ObjectAnimator animation = ObjectAnimator.ofFloat(imageView, "translationY", distance);
        animation.setDuration(duration);
        animation.setStartDelay(delay);
        animation.start();


        int textDelay = 2250;
        int loginDelay = 3000;
        int registerDelay= 3100;
        fadeInText.setStartOffset(textDelay);
        text.startAnimation(fadeInText);
        frombottom1.setStartOffset(loginDelay);
        login.setAnimation(frombottom1);
        frombottom2.setStartOffset(registerDelay);
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
