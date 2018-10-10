package cs2340.donationtracker.Model;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs2340.donationtracker.Controllers.Location;


public class AllLocations {
    private static final AllLocations ourInstance = new AllLocations(new Location());
    public static AllLocations getInstance() {
        return ourInstance;
    }

    private HashMap<Integer,List<LocationData>> allLocationData;
    private List<LocationData> locationList;

    private AllLocations(Context context) {
        allLocationData = new HashMap<>();
        locationList = new ArrayList<>();
        // not yet tested
    }

    public void loadLocationData(Context context) {
        int key = 0;
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(context.getAssets().open("LocationData.csv")));
            String[] nextLine;
            nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                key = Integer.parseInt(nextLine[0]);
                String address = nextLine[4] + nextLine[5] + nextLine[6] + nextLine[7];
                LocationData Ldata = new LocationData(nextLine[1], nextLine[8], nextLine[3],
                        nextLine[2], address, nextLine[9]);
                locationList.add(Ldata);
                allLocationData.put(key,locationList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public HashMap<Integer, List<LocationData>> getRowData() {
        return allLocationData;
    }
    public String toString() {
        String str = "";
        for (Map.Entry<Integer,List<LocationData>> entry : allLocationData.entrySet()) {
            str += "" + entry.getKey() + " " + entry.getValue() + "\n";
        }
        return str;
    }
    //retriview
    //variable static
}
