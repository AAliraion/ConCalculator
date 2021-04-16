package com.example.concalculator.stBalka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.concalculator.R;

import java.util.ArrayList;
import java.util.HashMap;


public class StBalkaSchema1CopyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public EditText loadEditText;
    public EditText lengthEditText;
    private Spinner deflectionSpinner;
    private ArrayList deflectionSpinnerArrayList;
    private ArrayAdapter deflectionSpinnerAdapter;

    private String valueDeflection;

    private RadioGroup radioGroupShveller;
    private RadioGroup radioGroupShvellerX2;
    private RadioGroup radioGroupDvutavr;

    private int valueSelectedGost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_balka_schema1_copy);

        setTitle("Введите нагрузку и пролет балки");

        loadEditText = (EditText) findViewById(R.id.loadEditText);
        lengthEditText = (EditText) findViewById(R.id.lengthEditText);

        radioGroupShveller = findViewById(R.id.radioGroupShveller);
        radioGroupShvellerX2 = findViewById(R.id.radioGroupShvellerX2);
        radioGroupDvutavr = findViewById(R.id.radioGroupDvutavr);

        createDeflectionSpinner();

}

    public void createDeflectionSpinner(){
        deflectionSpinner = findViewById(R.id.deflectionSpinner);
        deflectionSpinner.setOnItemSelectedListener(this);
        deflectionSpinnerArrayList = new ArrayList();

        deflectionSpinnerArrayList.add(120);
        deflectionSpinnerArrayList.add(150);
        deflectionSpinnerArrayList.add(200);
        deflectionSpinnerArrayList.add(250);
        deflectionSpinnerArrayList.add(300);

        deflectionSpinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, deflectionSpinnerArrayList);
        deflectionSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deflectionSpinner.setAdapter(deflectionSpinnerAdapter);
    }

    public void shvellerOnClick(View view) {

        radioGroupShveller.removeAllViews();

        RadioButton shvellerYRadioButton = new RadioButton(this);
        RadioButton shvellerPRadioButton = new RadioButton(this);

        shvellerYRadioButton.setText(R.string.shveller_Y);
        shvellerPRadioButton.setText(R.string.shveller_P);

        radioGroupShveller.addView(shvellerYRadioButton);
        radioGroupShveller.addView(shvellerPRadioButton);

        shvellerPRadioButton.setOnClickListener(radioButtonClickListener);
        shvellerYRadioButton.setOnClickListener(radioButtonClickListener);

        shvellerYRadioButton.setId(R.id.idShvellerYRadioButton);
        shvellerPRadioButton.setId(R.id.idShvellerPRadioButton);

        radioGroupShvellerX2.removeAllViews();
        radioGroupDvutavr.removeAllViews();

        radioGroupShvellerX2.clearCheck();
        radioGroupDvutavr.clearCheck();

    }

    public void dvaShvelleraOnClick(View view) {

        radioGroupShvellerX2.removeAllViews();

        RadioButton shvellerYX2RadioButton = new RadioButton(this);
        RadioButton shvellerPX2RadioButton = new RadioButton(this);

        shvellerYX2RadioButton.setText(R.string.shveller_Y_x2);
        shvellerPX2RadioButton.setText(R.string.shveller_P_x2);

        radioGroupShvellerX2.addView(shvellerYX2RadioButton);
        radioGroupShvellerX2.addView(shvellerPX2RadioButton);

        shvellerYX2RadioButton.setOnClickListener(radioButtonClickListener);
        shvellerPX2RadioButton.setOnClickListener(radioButtonClickListener);

        shvellerYX2RadioButton.setId(R.id.idShvellerYX2RadioButton);
        shvellerPX2RadioButton.setId(R.id.idShvellerPX2RadioButton);

        radioGroupShveller.removeAllViews();
        radioGroupDvutavr.removeAllViews();

        radioGroupShvellerX2.clearCheck();
        radioGroupDvutavr.clearCheck();

    }

    public void dvutavrOnClick(View view) {

        radioGroupDvutavr.removeAllViews();

        RadioButton dvutavrBRadioButton = new RadioButton(this);
        RadioButton dvutavrKRadioButton = new RadioButton(this);

        dvutavrBRadioButton.setText(R.string.dvutavr_B);
        dvutavrKRadioButton.setText(R.string.dvutavr_K);

        radioGroupDvutavr.addView(dvutavrBRadioButton);
        radioGroupDvutavr.addView(dvutavrKRadioButton);

        dvutavrBRadioButton.setOnClickListener(radioButtonClickListener);
        dvutavrKRadioButton.setOnClickListener(radioButtonClickListener);

        dvutavrBRadioButton.setId(R.id.idDvutavBRadioButton);
        dvutavrKRadioButton.setId(R.id.idDvutavKRadioButton);

        radioGroupShveller.removeAllViews();
        radioGroupShvellerX2.removeAllViews();

        radioGroupShvellerX2.clearCheck();
        radioGroupShveller.clearCheck();

    }


    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            switch (rb.getId()) {
                case R.id.idShvellerYRadioButton:
                    valueSelectedGost = 0;
                    break;
                case R.id.idShvellerPRadioButton:
                    valueSelectedGost = 1;
                    break;
                case R.id.idShvellerYX2RadioButton:
                    valueSelectedGost = 10;
                    break;
                case R.id.idShvellerPX2RadioButton:
                    valueSelectedGost = 11;
                    break;
                case R.id.idDvutavBRadioButton:
                    valueSelectedGost = 20;
                    break;
                case R.id.idDvutavKRadioButton:
                    valueSelectedGost = 21;
                    break;
            }
        }
    };


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        valueDeflection = deflectionSpinner.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void vypolnitRaschetOnClick(View view) {

        int putGost = valueSelectedGost;

        Intent performCalculationIntent = new Intent(StBalkaSchema1CopyActivity.this, StBalkaShema1RaschetCopyActivity.class);

        String putLoad = loadEditText.getText().toString();
        performCalculationIntent.putExtra("load", putLoad);

        String putLength = lengthEditText.getText().toString();
        performCalculationIntent.putExtra("length", putLength);

        String putDeflection = deflectionSpinner.getSelectedItem().toString();
        performCalculationIntent.putExtra("deflection", putDeflection);

        performCalculationIntent.putExtra("gostInt", putGost);

        startActivity(performCalculationIntent);
    }

}