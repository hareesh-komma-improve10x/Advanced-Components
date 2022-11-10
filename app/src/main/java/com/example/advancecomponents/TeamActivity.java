package com.example.advancecomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class TeamActivity extends AppCompatActivity {
    public ArrayList<String> nameList;
    public Spinner teamSp;
    public ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        getSupportActionBar().setTitle("Team");
        handleButton();
        setUpData();
        handleTeam();
    }

    public void handleButton() {
        Button addTeamBtn = findViewById(R.id.add_team_btn);
        addTeamBtn.setOnClickListener(view -> {
            EditText enterNameTxt = findViewById(R.id.enter_name_choose_txt);
            String enterName = enterNameTxt.getText().toString();
            if(enterName.equals("") == false) {
                arrayAdapter.add(enterName);
                arrayAdapter.notifyDataSetChanged();
            }
            enterNameTxt.setText("");
        });
    }

    public void setUpData() {
        nameList = new ArrayList<>();
        nameList.add("Viswanath");
        nameList.add("Renuka");
    }

    public void handleTeam() {
        teamSp = findViewById(R.id.team_sp);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList);
        teamSp.setAdapter(arrayAdapter);
        teamSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(TeamActivity.this, "Team : " + nameList, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}