package cs2340.donationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import cs2340.donationtracker.Model.Model;
import cs2340.donationtracker.Model.User;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        String[] arraySpinner = new String[] {
                "user", "location employee", "admin"
        };
        Spinner s = findViewById(R.id.type);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }

    public void onAddUser(View v) {
        Log.d("smt", "got here");
        EditText email = findViewById(R.id.email);
        EditText user = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        Spinner type = findViewById(R.id.type);
        Log.d("smtg", "got else");

        Model model = Model.getInstance();
        User newuser = new User(email.getText().toString(), user.getText().toString(),
                pass.getText().toString(), type.getSelectedItem().toString());
        if (model.addUser(newuser)) {
            Intent intent = new Intent(this, mainApplication.class);
            startActivity(intent);
        } else {
            TextView fail = findViewById(R.id.fail);
            fail.setText("Registration Failed: Email already in use");
        }
    }

    public void cancel(View v) {
        Intent intent = new Intent(this, welcomescreen.class);
        startActivity(intent);
    }
}
