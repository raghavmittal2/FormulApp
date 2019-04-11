package com.example.navbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class OhmLawCalc extends AppCompatActivity {
    EditText et_I, et_R;
    Button bt_go3;
    Button clr2;
    TextView answer01;
    //TextView answer02;
    //TextView answer03;
    TextView answer04;

    double Current, Voltage, Resistance, Power;

    //char req;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohm_calc);

        et_I = (EditText) findViewById(R.id.et_I);
        et_R = (EditText) findViewById(R.id.et_R);
        //et_V = (EditText) findViewById(R.id.et_V);
        bt_go3 = (Button) findViewById(R.id.bt_go3);
        clr2 = (Button) findViewById(R.id.clr2);
        answer01 = (TextView) findViewById(R.id.answer01);
        //answer02 = (TextView) findViewById(R.id.answer02);
        //answer03 = (TextView) findViewById(R.id.answer03);
        answer04 = (TextView) findViewById(R.id.answer04);

        bt_go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_I.getText().toString().equals("") && !et_R.getText().toString().equals("")) {
                    Current = Double.parseDouble(et_I.getText().toString());
                    Resistance = Double.parseDouble(et_R.getText().toString());

                }

                Voltage = Current * Resistance;
                answer01.setText("\n Voltage is " + "\n" + Voltage);

                /*Resistance = Voltage / Current;
                answer02.setText("\nResistance is " + "\n" + Resistance);

                Current = Voltage / Resistance;
                answer03.setText("\nCurrent is " + "\n" + Current); */

                Power = Current * Current * Resistance;
                answer04.setText("\n Power is " + "\n" + Power);


            }
        });

        clr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_I.getText().clear();
                et_R.getText().clear();
                answer01.setText("");
                answer04.setText("");
            }
        });
    }
}