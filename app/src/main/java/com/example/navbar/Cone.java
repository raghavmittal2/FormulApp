package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cone extends AppCompatActivity {

    EditText ConeRadius,ConeHeight,ConeLength;
    Button solve_cone_button;
    TextView Cone_result;




    double cone_r,cone_l,cone_h, area , volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cone);

        ConeRadius = (EditText) findViewById(R.id.ConeRadius);
        ConeHeight = (EditText) findViewById(R.id.Cone_height);
        ConeLength = (EditText) findViewById(R.id.Cone_length);
        solve_cone_button = (Button) findViewById(R.id.solve_cone_button);
        Cone_result = (TextView) findViewById(R.id.Cone_result);



        solve_cone_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!ConeRadius.getText().toString().equals("") &&
                        !ConeHeight.getText().toString().equals("") &&
                        !ConeLength.getText().toString().equals("")){
                    cone_r= Double.parseDouble(ConeRadius.getText().toString());
                    cone_h= Double.parseDouble(ConeHeight.getText().toString());
                    cone_l= Double.parseDouble(ConeLength.getText().toString());

                    area = ( (cone_l) * (cone_r) * (3.14));
                    volume = ((0.333) * (cone_h) * (cone_r*cone_r) * (3.14));

                    Cone_result.setText("Area = " + area + " cm^2" + "\n Volume = "+ volume + " cm^3");

                }
            }
        });



    }
}
