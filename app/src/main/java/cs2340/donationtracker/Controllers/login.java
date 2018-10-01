package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import cs2340.donationtracker.Model.Model;
import cs2340.donationtracker.R;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginAttempt(View v) {
        Model model = Model.getInstance();
        EditText user = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        if (model.findUserByUserPass(user.getText().toString(), pass.getText().toString())) {
            Intent intent = new Intent(this, mainApplication.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, failedLogin.class);
            startActivity(intent);
        }
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, welcomescreen.class);
        startActivity(intent);
    }
}
