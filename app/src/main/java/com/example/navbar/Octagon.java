package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Octagon extends AppCompatActivity {
    EditText Octaside ;
    Button solve_button;
    TextView Octaresult;



    double side, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octagon);

        Octaside = (EditText) findViewById(R.id.Octaside);
        solve_button = (Button) findViewById(R.id.solve_button);
        Octaresult = (TextView) findViewById(R.id.Octaresult);


        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Octaside.getText().toString().equals("") ){
                    side= Double.parseDouble(Octaside.getText().toString());

                    area = ((1)  * (side) * (side) * (4.828));

                    Octaresult.setText("Area = " + area + " cm^2");

                }
            }
        });//ss

    }
}
