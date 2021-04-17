package com.example.concalculator.stBalka.schema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.concalculator.R;
import com.example.concalculator.cechenie.dvutavr.DvutavrB_Gost26020_83;
import com.example.concalculator.cechenie.dvutavr.DvutavrK_Gost26020_83;
import com.example.concalculator.cechenie.shveller.ShvellerP_GOST_8240_89;
import com.example.concalculator.cechenie.shveller.ShvellerPx2_GOST_8240_89;
import com.example.concalculator.cechenie.shveller.ShvellerU_GOST_8240_89;
import com.example.concalculator.cechenie.shveller.ShvellerUx2_GOST_8240_89;

public class StBalkaSchema1RaschetActivity extends AppCompatActivity{

    private ImageView selectedProfileImageView;
    private TextView loadTextView;
    private TextView lengthTextView;
    private TextView deflectionTextView;
    private TextView formulaQmaxTextView;

    private TextView formulaMmaxTextView;
    private TextView formulaWtrTextView;
    private TextView formulaItrTextView;
    private TextView epuraQpolozhZnachTextView;
    private TextView epuraQotricZnachTextView;
    private TextView epuraMTextView;
    private TextView selectedProfileTextView;
    private TextView infoSelectedProfileTextView;

    private TextView textViewGostInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_balka_schema1_raschet);
        setTitle("Решение");

        Intent intent = getIntent();
        String getLoad = intent.getStringExtra("load");
        String getLength = intent.getStringExtra("length");
        String getDeflection = intent.getStringExtra("deflection");
        int getGostInt = intent.getIntExtra("gostInt",0);


        selectedProfileImageView = (ImageView) findViewById(R.id.selectedProfileImegeView);
        selectedProfileTextView = (TextView) findViewById(R.id.selectedProfileTextView);

        loadTextView = (TextView) findViewById(R.id.loadTextView);
        lengthTextView = (TextView) findViewById(R.id.lengthTextView);
        deflectionTextView = (TextView) findViewById(R.id.deflectionTextView);
        formulaQmaxTextView = (TextView) findViewById(R.id.formulaQmaxTextView);

        formulaMmaxTextView = (TextView) findViewById(R.id.formulaMmaxTextView);
        formulaWtrTextView = (TextView) findViewById(R.id.formulaWtrTextView);
        formulaItrTextView = (TextView) findViewById(R.id.formulaItrTextView);
        epuraQpolozhZnachTextView = (TextView) findViewById(R.id.epuraQpolozhZnachTextView);
        epuraQotricZnachTextView = (TextView) findViewById(R.id.epuraQotricZnachTextView);
        epuraMTextView = (TextView) findViewById(R.id.epuraMTextView);

        infoSelectedProfileTextView = (TextView) findViewById(R.id.infoSelectionProfileTextView);

        textViewGostInt = (TextView) findViewById(R.id.textViewGostInt);



        textViewGostInt.setText("" + getGostInt);

        loadTextView.setText(getLoad);
        lengthTextView.setText(getLength);
        deflectionTextView.setText(getDeflection);


        double loadToFormula = Double.parseDouble(loadTextView.getText().toString());
        double lengthToFormula = Double.parseDouble(lengthTextView.getText().toString());
        double deflectionToFormula = Double.parseDouble(deflectionTextView.getText().toString());

        double lengthMToFormula = lengthToFormula / 1000;
        double resultQmax = loadToFormula / 1000 * lengthMToFormula /2;
        double resultMmax = loadToFormula / 1000 * Math.pow(lengthMToFormula, 2) /8;
        double resultWtr = resultMmax * 100 / (1.12*2.1);
        double resultItr = resultMmax * Math.pow(10, 5) * lengthMToFormula * Math.pow(10, 2) * deflectionToFormula / (10 * 2.1 * Math.pow(10, 6));
        String resultQmaxOkr = String.format("%.2f",resultQmax);
        String resultMmaxOkr = String.format("%.2f",resultMmax);
        String resultWtrOkr = String.format("%.2f",resultWtr);
        String resultItrOkr = String.format("%.2f",resultItr);


        if (getGostInt >= 0 & getGostInt <= 9){
            selectedProfileImageView.setImageResource(R.drawable.shveller);
            if (getGostInt == 0){
                ShvellerU_GOST_8240_89.addShvellerU();
                infoSelectedProfileTextView.setText(ShvellerU_GOST_8240_89.getClosestInertiaResistance(resultItr, resultWtr));
                selectedProfileTextView.setText(R.string.shveller_Y);
            } else if (getGostInt == 1){
                ShvellerP_GOST_8240_89.addShvellerP();
                infoSelectedProfileTextView.setText(ShvellerP_GOST_8240_89.getClosestInertiaResistance(resultItr, resultWtr));
                selectedProfileTextView.setText(R.string.shveller_P);
            }else {
                infoSelectedProfileTextView.setText("Профиль не выбран");
                selectedProfileTextView.setText("Профиль не выбран");
            }

        } else if (getGostInt >= 10 & getGostInt <= 19){
            selectedProfileImageView.setImageResource(R.drawable.dva_shvellera);
            if(getGostInt == 10){
                ShvellerUx2_GOST_8240_89.addShvellerUx2();
                infoSelectedProfileTextView.setText(ShvellerUx2_GOST_8240_89.getClosestInertiaResistance(resultItr, resultWtr));
                selectedProfileTextView.setText(R.string.shveller_Y_x2);
            } else if (getGostInt == 11){
                ShvellerPx2_GOST_8240_89.addShvellerPx2();
                infoSelectedProfileTextView.setText(ShvellerPx2_GOST_8240_89.getClosestInertiaResistance(resultItr, resultWtr));
                selectedProfileTextView.setText(R.string.shveller_P_x2);
            } else {
                infoSelectedProfileTextView.setText("Профиль не выбран");
                selectedProfileTextView.setText("Профиль не выбран");
            }

        } else if (getGostInt >= 20 & getGostInt <= 29) {
            selectedProfileImageView.setImageResource(R.drawable.dvutavr);
            if (getGostInt == 20){
                DvutavrB_Gost26020_83.addDvutavrB();
                infoSelectedProfileTextView.setText(DvutavrB_Gost26020_83.getClosestInertiaResistance(resultItr, resultWtr));
                selectedProfileTextView.setText(R.string.dvutavr_B);
            } else if (getGostInt == 21){
                DvutavrK_Gost26020_83.addDvutavrK();
                infoSelectedProfileTextView.setText(DvutavrK_Gost26020_83.getClosestInertiaResistance(resultItr, resultWtr));
                selectedProfileTextView.setText(R.string.dvutavr_K);
            }else {
                infoSelectedProfileTextView.setText("Профиль не выбран");
                selectedProfileTextView.setText("Профиль не выбран");
            }
        }

        epuraQpolozhZnachTextView.setText(resultQmaxOkr + "т");
        epuraQotricZnachTextView.setText("-"+ resultQmaxOkr + "т");
        epuraMTextView.setText("Mmax =" + resultMmaxOkr + "т" + "\u00D7" +"2");

        String formulaQmax = "Qₘₐₓ = (q /1000 " + "\u00D7" + " L) / 2 ="
                + System.lineSeparator() + "(" + loadToFormula +"/1000 " + "\u00D7" + lengthMToFormula + ") / 2 =" + resultQmaxOkr + "т";
        formulaQmaxTextView.setText(formulaQmax);

        String formulaMmax = "Mₘₐₓ = (q /1000" + "\u00D7" + "L" + "²" + " ) / 8 ="
                + System.lineSeparator() + "(" + loadToFormula +"/1000 " + "\u00D7" + lengthMToFormula + "²" + " ) / 8 =" + resultMmaxOkr + "т" + "\u00D7" +"2";
        formulaMmaxTextView.setText(formulaMmax);

        String formulaWtr = "Wₜᵣ = Mₘₐₓ" + "\u00D7" + "100" + " / (1.12" + "\u00D7" + " R) ="
                + System.lineSeparator()  + resultMmaxOkr + "\u00D7" + "100" + " / (1.12" + "\u00D7" + " 2.1) = " + resultWtrOkr + "см³";
        formulaWtrTextView.setText(formulaWtr);

        String formulaItr = "Tₜᵣ = Mₘₐₓ" + "\u00D7" + "10⁵" + "\u00D7" + "L" + "\u00D7" + "10²" + "\u00D7" + "filt" + "/" + "(10" +
                "\u00D7" + "E) = "
                + System.lineSeparator()  + resultMmaxOkr + "\u00D7" + "10⁵" + "\u00D7" + lengthMToFormula + "\u00D7" + "10²" + "\u00D7" + deflectionToFormula + "/" + "(10" +
                "\u00D7" + "2.1" + "\u00D7" + "10⁶) = " + resultItrOkr + "см⁴";
        formulaItrTextView.setText(formulaItr);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}