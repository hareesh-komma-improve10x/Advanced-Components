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
        setUpTeamListAddButton();
        setUpDeleteButton();
        setUpTeamListData();
        handleTeamList();
    }

    private void setUpDeleteButton() {
        Button deleteBtn = findViewById(R.id.delete_btn);
        deleteBtn.setOnClickListener(view -> {
            EditText memberNameTxt = findViewById(R.id.member_name_txt);
            String memberName = memberNameTxt.getText().toString();
            arrayAdapter.remove(memberName);
            arrayAdapter.notifyDataSetChanged();
            memberNameTxt.setText("");
        });
    }

    private void setUpTeamListAddButton() {
        Button addTeamListBtn = findViewById(R.id.add_team_list_btn);
        addTeamListBtn.setOnClickListener(view -> {
            EditText memberNameTxt = findViewById(R.id.member_name_txt);
            String memberName = memberNameTxt.getText().toString();
            if(memberName.equals("") == false) {
                arrayAdapter.add(memberName);
                arrayAdapter.notifyDataSetChanged();
            }
            memberNameTxt.setText("");
        });
    }

    private void setUpTeamListData() {
        teamList = new ArrayList<>();
        teamList.add("Viswanath");
        teamList.add("Renuka");
    }

    public void handleTeamList() {
        listViewLv = findViewById(R.id.listview_lv);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamList);
        listViewLv.setAdapter(arrayAdapter);
        listViewLv.setOnItemClickListener((adapterView, view, position, l) -> {
            Toast.makeText(this, "Clicked : " + teamList.get(position), Toast.LENGTH_SHORT).show();
            String memberName = teamList.get(position);
            EditText memberNameTxt = findViewById(R.id.member_name_txt);
            memberNameTxt.setText(memberName);
        });
    }
}