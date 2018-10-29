package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

import cs2340.donationtracker.Model.Category;
import cs2340.donationtracker.Model.CurrentItems;
import cs2340.donationtracker.Model.CurrentUser;
import cs2340.donationtracker.Model.ItemInfo;
import cs2340.donationtracker.Model.ItemInfoAdapter;
import cs2340.donationtracker.Model.LocationData;
import cs2340.donationtracker.Model.User_type;
import cs2340.donationtracker.R;

public class CheckDonation extends Activity {
    private DatabaseReference databaseReference;
    private List<String> searchList;
    private List<String> locationList;
    private String currentCategory;
    private String searchKeyword;
    private String currentLocation;

    private final String ALL_LOCATIONS = "All Locations";
    private final String ALL_Categories = "All Categories";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_donation);
        init();
        initSearchTextView();
        initCategorySpinner();
        display();
    }
    private void init() {
        searchKeyword = "";
        currentCategory = ALL_Categories;
        currentLocation = ALL_LOCATIONS;
        initCategoryAndLocationList();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("item").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<ItemInfo> list = CurrentItems.getInstance().getItemList();
                list.clear();
                for (DataSnapshot i : dataSnapshot.getChildren()) {
                    ItemInfo mItemInfo = i.getValue(ItemInfo.class);
                    list.add(mItemInfo);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CheckDonation.this, "Data loading failed.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initCategoryAndLocationList() {
        searchList = new LinkedList<>();
        searchList.add(ALL_Categories);
        for (Category data : Category.values()) {
            searchList.add(data.toString());
        }
        locationList = new LinkedList<>();
        locationList.add(ALL_LOCATIONS);
        for (LocationData data : Location.locationList) {
            locationList.add(data.getLocation_name());
        }
    }
    private void initSearchTextView() {
        final EditText textView = (EditText) findViewById(R.id.searchByName);
        textView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) ) {
                    searchKeyword = textView.getText().toString();
                    display();
                    return true;
                }
                return false;
            }
        });
    }
    private void initCategorySpinner() {
        Spinner categorySpinner = findViewById(R.id.categorySpinner);
        ArrayAdapter categoryAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, searchList);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentCategory = searchList.get(position);
                display();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                currentCategory = searchList.get(0);
                display();
            }
        });

        Spinner locationSpinner = findViewById(R.id.locationSpinner);
        ArrayAdapter locationAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locationList);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentLocation = locationList.get(position);
                display();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                currentLocation = locationList.get(0);
                display();
            }
        });
    }
    private void display() {
        ListView itemListview = (ListView) findViewById(R.id.listview_location);
        List<ItemInfo> tempList = new LinkedList<>();

        for (ItemInfo i : CurrentItems.getInstance().getItemList()) {
            System.out.println(i.getLocationData());
            if (currentCategory.equals(ALL_Categories)
                    && isVaildKeyword(i.getShortDescription())
                    && currentLocation.equals(ALL_LOCATIONS)) {
                tempList.add(i);
            } else if (currentCategory.equals(ALL_Categories)
                    && isVaildKeyword(i.getShortDescription())
                    && i.getLocationData().getLocation_name().equals(currentLocation)) {
                tempList.add(i);
            } else if (i.getCategory().toString().equals(currentCategory)
                    && isVaildKeyword(i.getShortDescription())
                    && currentLocation.equals(ALL_LOCATIONS)) {
                tempList.add(i);
            } else if (i.getCategory().toString().equals(currentCategory)
                    && isVaildKeyword(i.getShortDescription())
                    && i.getLocationData().getLocation_name().equals(currentLocation)) {
                tempList.add(i);
            }
        }
        ItemInfoAdapter itemInfoAdapter = new ItemInfoAdapter(this, tempList, itemListview);
        itemListview.setAdapter(itemInfoAdapter);
    }
    private boolean isVaildKeyword(String i) {
        if (!searchKeyword.isEmpty()) {
            String a = searchKeyword.toLowerCase();
            String b;
            if (i.length() >= a.length()) {
               b = i.substring(0, searchKeyword.length()).toLowerCase();
            } else {
                return false;
            }
            System.out.println(a +" 111111");
            System.out.println(b +" 222222");
            System.out.println(a.equals(b) + "비교");
            if (a.equals(b)) {
                System.out.println("통과");
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
    public void goBack(View v) {
        if (CurrentUser.getInstance().getUserType() == User_type.USER) {
            Intent intent = new Intent(this, MainApplication_user.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MainApplication.class);
            startActivity(intent);
        }
    }
}
