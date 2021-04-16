package com.example.concalculator.stBalka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.concalculator.R;

public class StBalkaCopyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_balka_copy);

        setTitle("Выберите расчетную схему");




    }

    public void shema1ButtonOnClick(View view) {
        Intent vvodDannyhSchema1Intent = new Intent (StBalkaCopyActivity.this, StBalkaSchema1CopyActivity.class);
        startActivity(vvodDannyhSchema1Intent);

    }
}