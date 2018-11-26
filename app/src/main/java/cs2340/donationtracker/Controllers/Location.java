package cs2340.donationtracker.Controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cs2340.donationtracker.Model.CurrentUser;
import cs2340.donationtracker.Model.LocationData;
import cs2340.donationtracker.Model.NameAdapter;
import cs2340.donationtracker.Model.User_type;
import cs2340.donationtracker.R;

/**
 * implementation of location class
 */
@SuppressWarnings({"WeakerAccess", "FieldCanBeLocal", "NestedAssignment", "CyclicClassDependency"})
public class Location extends AppCompatActivity {
    @SuppressWarnings("PublicField")
    public static List<LocationData> locationList = new ArrayList<>();
    private ListView listview;
    @SuppressWarnings("RedundantFieldInitialization")
    private static boolean isCreated = false;
    @SuppressWarnings("TypeMayBeWeakened")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        listview = findViewById(R.id.listView_location);
        NameAdapter NameAdapter = new NameAdapter(this, getLocationData(this),
                listview);
        listview.setAdapter(NameAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goLocationDisplay(position);
            }
        });
    }

    /**
     * This class returns a list of location data.
     * @param context an object of Context class
     * @return location data
     */
    @SuppressWarnings({"UnusedAssignment", "NestedAssignment",
            "AssignmentOrReturnOfFieldWithMutableType", "ChainedMethodCall"})
    public static List<LocationData> getLocationData(Context context) {
        if (!isCreated) {
            try {
                CSVReader reader = new CSVReader(new InputStreamReader(context.getAssets().
                        open("LocationData.csv")));
                String[] nextLine;
                nextLine = reader.readNext();
                while ((nextLine = reader.readNext()) != null) {
                    String address = nextLine[4] + "," + nextLine[5] + "," + nextLine[6] + "," +
                            nextLine[7];
                    locationList.add(new LocationData(nextLine[0], nextLine[1], nextLine[8],
                            nextLine[3], nextLine[2], address, nextLine[9]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            isCreated = true;
        }
        return locationList;
    }

    /**
     * This method takes user to previous page.
     * @param v an object of View class
     */
    @SuppressWarnings({"unused", "ChainedMethodCall"})
    public void goBack(View v) {
        //noinspection LawOfDemeter
        if (CurrentUser.getInstance().getUserType() == User_type.USER) {
            Intent intent = new Intent(this, MainApplication_user.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MainApplication.class);
            startActivity(intent);
        }
    }
    private void goLocationDisplay(int position) {
        Intent intent = new Intent(this, Location_display.class);
        intent.putExtra("Item_position", position);
        startActivity(intent);
    }

}
