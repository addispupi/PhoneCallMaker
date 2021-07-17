package com.gashadigital.phonecallmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText numCall;
    ImageButton btnCall, btnCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numCall = findViewById(R.id.txtDigit);
        btnCall = findViewById(R.id.btnCall);
        btnCont = findViewById(R.id.btnContacts);

//        Intent intent = getIntent();
//        String num = intent.getStringExtra("phoneNum").toString();
//        if(num != null)
//            numCall.setText(num);

        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Contacts.class));
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNum = numCall.getText().toString();

                if(phoneNum.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter Phone Number !", Toast.LENGTH_LONG).show();
                }
                else {
                    String str = "tel:" + phoneNum;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(str));
                    startActivity(intent);
                }
            }
        });
    }
}