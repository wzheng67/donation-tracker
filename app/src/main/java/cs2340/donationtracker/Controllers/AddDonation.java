package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import cs2340.donationtracker.Model.Category;
import cs2340.donationtracker.Model.CurrentItems;
import cs2340.donationtracker.Model.CurrentUser;
import cs2340.donationtracker.Model.ItemInfo;
import cs2340.donationtracker.Model.LocationData;
import cs2340.donationtracker.Model.User_type;
import cs2340.donationtracker.R;

public class AddDonation extends AppCompatActivity {

    private final List<String> timeStamp = new LinkedList<>();
    private final List<Category> categoryList = Arrays.asList(Category.values());

    Spinner locationSpinner;
    Spinner categorySpinner;

    EditText shortDes;
    EditText fullDes;
    EditText value;
    EditText comments;

    ItemInfo itemInfo;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);

        initSpinners();
        buildSpinners();

        Button button = (Button) findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTexts();
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
                itemInfo.setTimeStamp(timeStamp);
                CurrentItems.getInstance().getItemList().add(itemInfo);
                addItemIntoFirebase(timeStamp);
                Toast.makeText(AddDonation.this, "Donation Item was made successfully", Toast.LENGTH_SHORT).show();
                goToNextView();
            }
        });
    }

    public void goToNextView() {
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }
    public void cancel(View v) {
        Intent intent = new Intent(this, MainApplication.class);
        startActivity(intent);
    }

    private void addItemIntoFirebase(String timeStamp) {
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("item").child(timeStamp).setValue(itemInfo);
    }

    private void initSpinners() {
        locationSpinner = (Spinner) findViewById(R.id.locationSpinner);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);

        itemInfo = new ItemInfo("",0,null,"","",null,"","");

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (CurrentUser.getInstance().getUserType() == CurrentUser.getInstance().getUserType()) {
                    itemInfo.setLocationData(CurrentUser.getInstance().getLocationData());
                } else {
                    itemInfo.setLocationData(Location.locationList.get(position));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                itemInfo.setLocationData(Location.locationList.get(0));
            }
        });
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemInfo.setCategory(categoryList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                itemInfo.setCategory(categoryList.get(0));
            }
        });
    }
    private void buildSpinners() {
        if (CurrentUser.getInstance().getUserType() == User_type.LOCATION_EMPLOYEE) {
            List list = new LinkedList();
            list.add(CurrentUser.getInstance().getLocationData());
            ArrayAdapter locationAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
            locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            locationSpinner.setAdapter(locationAdapter);
        } else {
            ArrayAdapter locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Location.locationList);
            locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            locationSpinner.setAdapter(locationAdapter);
        }
        ArrayAdapter categroryAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, categoryList);
        categroryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categroryAdapter);
    }
    private void getTexts() {
        shortDes = (EditText) findViewById(R.id.sDescriptionText_value);
        fullDes = (EditText) findViewById(R.id.fDescriptionText_value);
        value = (EditText) findViewById(R.id.valueText_value);
        comments = (EditText) findViewById(R.id.commentsText_value);

        itemInfo.setShortDescription(shortDes.getText().toString());
        itemInfo.setFullDescription(fullDes.getText().toString());
        itemInfo.setValue(Integer.parseInt(value.getText().toString()));
        itemInfo.setComments(comments.getText().toString());
    }
}
