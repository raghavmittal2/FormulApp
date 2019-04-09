package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Pentagon extends AppCompatActivity {
    EditText Pentaside ;
    Button solve_button;
    TextView Pentaresult;



    double side, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pentagon);

        Pentaside = (EditText) findViewById(R.id.Pentaside);
        solve_button = (Button) findViewById(R.id.solve_button);
        Pentaresult = (TextView) findViewById(R.id.Pentaresult);


        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Pentaside.getText().toString().equals("") ){
                    side= Double.parseDouble(Pentaside.getText().toString());

                    area = ((1)  * (side) * (side) * (1.7204));

                    Pentaresult.setText("Area = " + area + " cm^2");

                }
            }
        });//ss

    }
}
