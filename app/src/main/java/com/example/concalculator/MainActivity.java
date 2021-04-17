package com.example.concalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.concalculator.derBalka.DerBalkaActivity;
import com.example.concalculator.stBalka.StBalkaActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    public void stBalkaOnClick(View view) {

    Intent vyborRaschetaIntent = new Intent (MainActivity.this, StBalkaActivity.class);
    startActivity(vyborRaschetaIntent);
    }

    public void derBalkaOnClick(View view) {
        Intent vyborRaschetaIntent = new Intent (MainActivity.this, DerBalkaActivity.class);
        startActivity(vyborRaschetaIntent);
    }

    public void lentFundamentOnClick(View view) {
        Intent testIntent = new Intent(this, NavigationDrawerActivity.class);
            startActivity(testIntent);

     }

    public void derStoykaOnClick(View view) {
    }

    public void stStoykaOnClick(View view) {
    }


}