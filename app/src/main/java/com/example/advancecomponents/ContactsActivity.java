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

public class ContactsActivity extends AppCompatActivity {
    public ArrayList<Contact> contactList;
    public ListView contactLv;
    public ArrayAdapter<Contact> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        getSupportActionBar().setTitle("Contacts");
        contactButton();
        setUpContactData();
        setUpContactsLv();
    }

    private void contactButton() {
        Button contactBtn = findViewById(R.id.contact_btn);
        contactBtn.setOnClickListener(view -> {
            EditText nameTxt = findViewById(R.id.name_txt);
            String name = nameTxt.getText().toString();
            EditText phoneNumberNum = findViewById(R.id.phone_number_num);
            String phoneNumber = phoneNumberNum.getText().toString();
            Toast.makeText(this, name + phoneNumber, Toast.LENGTH_SHORT).show();
        });
    }

    private void setUpContactsLv() {
        contactLv = findViewById(R.id.contact_lv);
        arrayAdapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1,contactList);
    }

    private void setUpContactData() {
        contactList = new ArrayList<>();

        Contact contact1 = new Contact();
        contact1.name = "Viswanath";
        contact1.phoneNumber = "+91 9000540052";
        contactList.add(contact1);

        Contact contact2 = new Contact();
        contact2.name = "Renuka";
        contact2.phoneNumber = "+91 9886655979";
        contactList.add(contact2);
    }
}