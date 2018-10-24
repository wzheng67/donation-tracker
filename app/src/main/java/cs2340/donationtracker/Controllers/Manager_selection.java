package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import cs2340.donationtracker.Model.CurrentUser;
import cs2340.donationtracker.R;

public class Manager_selection extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_selection);

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, Location.locationList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CurrentUser.getInstance().setLocationData(Location.locationList.get(position));
                goToRegistration();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                CurrentUser.getInstance().setLocationData(Location.locationList.get(0));
            }
        });
    }
    private void goToRegistration() {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
}
