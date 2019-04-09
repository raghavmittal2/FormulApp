package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Hexagon extends AppCompatActivity {
    EditText Hexaside ;
    Button solve_button;
    TextView Hexaresult;



    double side, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexagon);

        Hexaside = (EditText) findViewById(R.id.Hexaside);
        solve_button = (Button) findViewById(R.id.solve_button);
        Hexaresult = (TextView) findViewById(R.id.Hexaresult);


        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Hexaside.getText().toString().equals("") ){
                    side= Double.parseDouble(Hexaside.getText().toString());

                    area = ((1)  * (side) * (side) * (1.7204));

                    Hexaresult.setText("Area = " + area + " cm^2");

                }
            }
        });//ss

    }
}
