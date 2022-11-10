package com.example.advancecomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class LuckyNumberActivity extends AppCompatActivity {
    public ArrayList<Integer> numberList;
    public Spinner luckyNumberSp;
    public ArrayAdapter<Integer> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);
        getSupportActionBar().setTitle("Lucky Number");
        setupData();
        handleSpinner();
    }

    private void setupData() {
        numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(6);
        numberList.add(7);
        numberList.add(8);
        numberList.add(9);
        numberList.add(10);
    }

    public void handleSpinner() {
        luckyNumberSp = findViewById(R.id.lucky_number_sp);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, R.layout.dropdown_iteam, numberList);
        luckyNumberSp.setAdapter(arrayAdapter);
        luckyNumberSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(LuckyNumberActivity.this, "lucky Number : " + numberList, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}