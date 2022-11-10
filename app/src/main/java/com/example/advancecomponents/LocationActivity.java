package com.example.advancecomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity {
    public ArrayList<String> namesOfStates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        getSupportActionBar().setTitle("Location");
        setUpDataOfStates();
        handleLocation();
    }

    private void setUpDataOfStates() {
        namesOfStates = new ArrayList<>();
        namesOfStates.add("Andhra Pradesh");
        namesOfStates.add("Arunachal Pradesh");
        namesOfStates.add("Assam");
        namesOfStates.add("Bihar");
        namesOfStates.add("Chhattisgarh");
        namesOfStates.add("Goa");
        namesOfStates.add("Gujarat");
        namesOfStates.add("Haryana");
        namesOfStates.add("Himachal Pradesh");
        namesOfStates.add("Jammu and Kashmir");
        namesOfStates.add("Jharkhand");
        namesOfStates.add("Karnataka");
        namesOfStates.add("Kerala");
        namesOfStates.add("Madhya Pradesh");
        namesOfStates.add("Maharashtra");
        namesOfStates.add("Manipur");
        namesOfStates.add("Meghalaya");
        namesOfStates.add("Mizoram");
        namesOfStates.add("Nagaland");
        namesOfStates.add("Uttarakhand");
        namesOfStates.add("Uttar Pradesh");
        namesOfStates.add("Punjab");
        namesOfStates.add("Rajasthan");
        namesOfStates.add("Sikkim");
        namesOfStates.add("West Bengal");
        namesOfStates.add("Tamil Nadu");
        namesOfStates.add("Telangana");
        namesOfStates.add("Tripura");
    }

    public void handleLocation() {
        Spinner locationStateSp = findViewById(R.id.location_state_sp);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.state_dropdown_iteam, namesOfStates);
        locationStateSp.setAdapter(arrayAdapter);
        locationStateSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(LocationActivity.this, "location : " + namesOfStates, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}