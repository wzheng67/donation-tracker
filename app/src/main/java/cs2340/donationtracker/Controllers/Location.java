package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;
import cs2340.donationtracker.Model.AllLocations;
import cs2340.donationtracker.R;

public class Location extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        AllLocations.getInstance().loadLocationData(this);
        TextView textView_location = new TextView(this);
        textView_location.setText(AllLocations.getInstance().toString());
        AllLocations.getInstance().getRowData().get(1);

    }
    public void goBack(View v) {
        Intent intent = new Intent(this, mainApplication.class);
        startActivity(intent);
    }
}
