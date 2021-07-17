package com.gashadigital.phonecallmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormatSymbols;

public class Contacts extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    String[] contacts;
    EditText call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        Resources res = getResources();

        listView = findViewById(R.id.list_contacts);
        contacts = res.getStringArray(R.array.contact_list);
        call = findViewById(R.id.txtDigit);

        ArrayAdapter<String> contAdapter = new ArrayAdapter<>(Contacts.this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(contAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String keyNum = parent.getItemAtPosition(position).toString();
        Intent intent = new Intent(this, MainActivity.class);
        Bundle extra = new Bundle();
        extra.putString("phoneNum", keyNum);
        intent.putExtras(extra);
        startActivity(intent);
        finish();

        Toast.makeText(Contacts.this, keyNum, Toast.LENGTH_LONG).show();
    }
}