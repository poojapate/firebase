package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    EditText number;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryCodePicker=findViewById(R.id.ccp);
        number=findViewById(R.id.number);
        login=findViewById(R.id.login);

        countryCodePicker.registerCarrierNumberEditText( number);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent a= new Intent(MainActivity.this,VerificationActivity.class);
                a.putExtra("number",countryCodePicker.getFullNumberWithPlus());
                startActivity(a);
                finish();
            }
        });

    }
}