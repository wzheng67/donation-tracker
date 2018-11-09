package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;

import cs2340.donationtracker.Model.LocationAdapter;
import cs2340.donationtracker.Model.LocationData;
import cs2340.donationtracker.R;

@SuppressWarnings("RedundantCast")
public class Location_display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_display);

        Intent intent = getIntent();
        int position = intent.getIntExtra("Item_position", 0);
        ListView listview = (ListView) findViewById(R.id.location_display);

        LinkedList<LocationData> list = new LinkedList<>();
        list.add(Location.locationList.get(position));
        @SuppressWarnings("TypeMayBeWeakened") LocationAdapter locationAdapter = new LocationAdapter(this, list, listview);
        listview.setAdapter(locationAdapter);

        Button back = (Button) findViewById(R.id.button_Ldisplay_Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    public void goBack() {
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }

}
