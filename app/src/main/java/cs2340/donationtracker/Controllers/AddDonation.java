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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import cs2340.donationtracker.Model.Category;
import cs2340.donationtracker.Model.ItemInfo;
import cs2340.donationtracker.Model.LocationData;
import cs2340.donationtracker.R;

public class AddDonation extends AppCompatActivity {
    public static List<ItemInfo> Itemlist = new LinkedList<>();
    private final List<String> hourList = new LinkedList<>();
    private final List<String> minList = new LinkedList<>();
    private final List<String> monthList = new LinkedList<>();
    private final List<String> dayList = new LinkedList<>();
    private final List<String> yearList = new LinkedList<>();
    private final List<Category> categoryList = Arrays.asList(Category.values());

    Spinner hourSpinner;
    Spinner minSpinner;
    Spinner daySpinner;
    Spinner monthSpinner;
    Spinner yearSpinner;
    Spinner locationSpinner;
    Spinner categorySpinner;

    EditText shortDes;
    EditText fullDes;
    EditText value;
    EditText comments;

    ItemInfo itemInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);

        init();
        initSpinners();
        buildSpinners();

        Button button = (Button) findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTexts();
                Itemlist.add(itemInfo);
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
        Intent intent = new Intent(this, mainApplication.class);
        startActivity(intent);
    }

    private void init() {
        for (int i = 0; i < 24; i++) {
            hourList.add("" + i);
        }
        for (int i = 0; i < 60; i++) {
            minList.add("" + i);
        }
        for (int i = 1; i <= 12; i++) {
            monthList.add("" + i);
        }
        for (int i = 1; i <= 29; i++) {
            dayList.add("" + i);
        }
        String year = new java.text.SimpleDateFormat("yyyy").format(new java.util.Date());
        for (int i = 2009; i <= Integer.parseInt(year); i++) {
            yearList.add("" + i);
        }
    }
    private void initSpinners() {
        hourSpinner = (Spinner) findViewById(R.id.hourSpinner);
        minSpinner = (Spinner) findViewById(R.id.minuteSpinner);
        daySpinner = (Spinner) findViewById(R.id.daySpinner);
        monthSpinner = (Spinner) findViewById(R.id.monthSpinner);
        yearSpinner = (Spinner) findViewById(R.id.yearSpinner);
        locationSpinner = (Spinner) findViewById(R.id.locationSpinner);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);

        itemInfo = new ItemInfo(0,0,0,0,0,0,null,"","",null,"","");

        hourSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemInfo.setHour(Integer.parseInt(hourList.get(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                itemInfo.setHour(0);
            }
        });

        minSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemInfo.setMin(Integer.parseInt(minList.get(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                itemInfo.setMin(0);
            }
        });

        daySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemInfo.setDay(Integer.parseInt(dayList.get(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                itemInfo.setDay(1);
            }
        });

        monthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemInfo.setMonth(Integer.parseInt(monthList.get(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                itemInfo.setMonth(1);
            }
        });

        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemInfo.setYear(Integer.parseInt(yearList.get(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                itemInfo.setYear(2009);
            }
        });

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemInfo.setLocationData(Location.locationList.get(position));
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
        ArrayAdapter hourAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, hourList);
        hourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hourSpinner.setAdapter(hourAdapter);

        ArrayAdapter minAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, minList);
        minAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minSpinner.setAdapter(minAdapter);

        ArrayAdapter dayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, dayList);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);

        ArrayAdapter monthAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, monthList);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        ArrayAdapter yearAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, yearList);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        ArrayAdapter locationAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, Location.locationList);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);

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
