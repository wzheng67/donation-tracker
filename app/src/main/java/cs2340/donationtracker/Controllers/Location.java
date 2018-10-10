package cs2340.donationtracker.Controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.view.View;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cs2340.donationtracker.Model.LocationAdapter;
import cs2340.donationtracker.Model.LocationData;
import cs2340.donationtracker.R;

public class Location extends AppCompatActivity {
    public static List<LocationData> locationList = new ArrayList<>();
    public ListView listview;
    private static boolean isCreated = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        listview = (ListView) findViewById(R.id.listview_location);
        LocationAdapter locationAdapter = new LocationAdapter(this, getLocationData(this), listview);
        listview.setAdapter(locationAdapter);

    }
    public static List<LocationData> getLocationData(Context context) {
        if (!isCreated) {
            try {
                CSVReader reader = new CSVReader(new InputStreamReader(context.getAssets().open("LocationData.csv")));
                String[] nextLine;
                nextLine = reader.readNext();
                while ((nextLine = reader.readNext()) != null) {
                    String address = nextLine[4] + "," + nextLine[5] + "," + nextLine[6] + "," + nextLine[7];
                    locationList.add(new LocationData(nextLine[0], nextLine[1], nextLine[8], nextLine[3], nextLine[2], address, nextLine[9]));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            isCreated = true;
        }
        return locationList;
    }
    public void goBack(View v) {
        Intent intent = new Intent(this, mainApplication.class);
        startActivity(intent);
    }

}
