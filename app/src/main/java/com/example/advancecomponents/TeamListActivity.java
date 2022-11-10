package com.example.advancecomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TeamListActivity extends AppCompatActivity {
    public ArrayList<String> teamList;
    public ListView listViewLv;
    public ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        getSupportActionBar().setTitle("Team List");
        setUpTeamListButton();
        setUpDataOfTeamList();
        handleTeamList();
    }

    private void setUpTeamListButton() {
        Button addTeamListBtn = findViewById(R.id.add_team_list_btn);
        addTeamListBtn.setOnClickListener(view -> {
            EditText memberNameTxt = findViewById(R.id.member_name_txt);
            String memberName = memberNameTxt.getText().toString();
            arrayAdapter.add(memberName);
            arrayAdapter.notifyDataSetChanged();
            memberNameTxt.setText("");
        });
    }

    private void setUpDataOfTeamList() {
        teamList = new ArrayList<>();
        teamList.add("Viswanath");
        teamList.add("Renuka");
    }

    public void handleTeamList() {
        listViewLv = findViewById(R.id.listview_lv);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamList);
        listViewLv.setAdapter(arrayAdapter);
        listViewLv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(TeamListActivity.this, "Team List : " + teamList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}