package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Trapezuim extends AppCompatActivity {
    EditText Traside1 , Traside2, Traheight;
    Button solve_button;
    TextView Traresult;


    double side1,side2, height,area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapezuim);
        Traside1 = (EditText) findViewById(R.id.Traside1);
        Traside2 = (EditText) findViewById(R.id.Traside2);
        Traheight = (EditText) findViewById(R.id.Traheight);
        solve_button = (Button) findViewById(R.id.solve_button);
        Traresult = (TextView) findViewById(R.id.Traresult);


        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Traside1.getText().toString().equals("") &&
                        !Traside2.getText().toString().equals("")
                        &&
                        !Traheight.getText().toString().equals("")){
                    side1= Double.parseDouble(Traside1.getText().toString());
                    side2= Double.parseDouble(Traside2.getText().toString());
                    height= Double.parseDouble(Traheight.getText().toString());

                    area = ((0.5)  * ((side1) * (side2)) * height);

                    Traresult.setText("Area = " + area + " cm^2");

                }
            }
        });//ss

    }
}

