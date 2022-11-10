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
import java.util.List;

public class AddMembersActivity extends AppCompatActivity {
    public ArrayList<String> teamChoose;
    public Spinner selectTeamSp;
    public ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);
        getSupportActionBar().setTitle("Add Members");
        handleButton();
        setUpData();
        handleSelectTeam();
    }

    private void handleButton() {
        Button addBtn = findViewById(R.id.add_Btn);
        addBtn.setOnClickListener(view -> {
            EditText enterNameChooseTxt = findViewById(R.id.enter_name_choose_txt);
            String enterNameChoose = enterNameChooseTxt.getText().toString();
            arrayAdapter.add(enterNameChoose);
            arrayAdapter.notifyDataSetChanged();
            enterNameChooseTxt.setText("");
        });
    }

    private void setUpData() {
        teamChoose = new ArrayList<>();
        teamChoose.add("Team A");
        teamChoose.add("Team B");
    }

    public void handleSelectTeam() {
        selectTeamSp = findViewById(R.id.select_team_sp);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamChoose);
        selectTeamSp.setAdapter(arrayAdapter);
        selectTeamSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(AddMembersActivity.this, "SelectTeam : " + teamChoose, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}