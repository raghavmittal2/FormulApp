package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Rectangle extends AppCompatActivity {
    EditText Recside1 , Recside2;
    Button solve_button;
    TextView Recresult;


    double side1,side2, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
        Recside1 = (EditText) findViewById(R.id.Recside1);
        Recside2 = (EditText) findViewById(R.id.Recside2);
        solve_button = (Button) findViewById(R.id.solve_button);
        Recresult = (TextView) findViewById(R.id.Recresult);


        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Recside1.getText().toString().equals("") &&
                        !Recside2.getText().toString().equals("") ){
                    side1= Double.parseDouble(Recside1.getText().toString());
                    side2= Double.parseDouble(Recside2.getText().toString());

                    area = ((1)  * (side1) * (side2) );

                    Recresult.setText("Area = " + area + " cm^2");

                }
            }
        });//ss

    }
}

