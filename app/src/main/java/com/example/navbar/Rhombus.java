package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Rhombus extends AppCompatActivity {
    EditText Rhodia1 , Rhodia2;
    Button solve_button;
    TextView Rhoresult;


    double side1,side2, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_rhobus);
        Rhodia1 = (EditText) findViewById(R.id.Rhodia1);
        Rhodia2 = (EditText) findViewById(R.id.Rhodia2);
        solve_button = (Button) findViewById(R.id.solve_button);
        Rhoresult = (TextView) findViewById(R.id.Rhoresult);


        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Rhodia1.getText().toString().equals("") &&
                        !Rhodia2.getText().toString().equals("") ){
                    side1= Double.parseDouble(Rhodia1.getText().toString());
                    side2= Double.parseDouble(Rhodia2.getText().toString());

                    area = ((0.5)  * (side1) * (side2) );

                    Rhoresult.setText("Area = " + area + " cm^2");

                }
            }
        });//ss

    }
}

