package com.example.concalculator.steelBeam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.concalculator.R;
import com.example.concalculator.steelBeam.schema1.SteelBeamSchema1Activity;

public class SteelBeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steel_beam);

        setTitle("Выберите расчетную схему");




    }

    public void shema1ButtonOnClick(View view) {
        Intent vvodDannyhSchema1Intent = new Intent (SteelBeamActivity.this, SteelBeamSchema1Activity.class);
        startActivity(vvodDannyhSchema1Intent);

    }
}