package cs2340.donationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import cs2340.donationtracker.Model.Model;
import cs2340.donationtracker.Model.User;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void onAddUser(View v) {
        EditText email = findViewById(R.id.email);
        EditText user = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        Spinner type = findViewById(R.id.type);

        Model model = Model.getInstance();
        User newuser = new User(email.getText().toString(), user.getText().toString(),
                pass.getText().toString(), type.getSelectedItem().toString());
        if (model.addUser(newuser)) {
            Intent intent = new Intent(this, mainApplication.class);
            startActivity(intent);
        } else {
            EditText fail = findViewById(R.id.fail);
            fail.setText("Registration Failed: Email already in use");
        }
    }

    public void cancel(View v) {
        Intent intent = new Intent(this, welcomescreen.class);
        startActivity(intent);
    }
}
