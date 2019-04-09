package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Circle extends AppCompatActivity {
    EditText Circleradius ;
    Button solve_button;
    TextView Circleresult;



    double radius, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        Circleradius = (EditText) findViewById(R.id.Circleradius);
        solve_button = (Button) findViewById(R.id.solve_button);
        Circleresult = (TextView) findViewById(R.id.Circleresult);


        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Circleradius.getText().toString().equals("") ){
                    radius= Double.parseDouble(Circleradius.getText().toString());

                    area = ((1)  * (radius) * (radius) * (3.14));

                    Circleresult.setText("Area = " + area + " cm^2");

                }
            }
        });//ss

    }
}
