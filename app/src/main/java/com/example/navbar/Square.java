package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Square extends AppCompatActivity {
    EditText Squareside ;
    Button solve_button;
    TextView Squareresult;



    double side, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        Squareside = (EditText) findViewById(R.id.Squareside);
        solve_button = (Button) findViewById(R.id.solve_button);
        Squareresult = (TextView) findViewById(R.id.Squareresult);


        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Squareside.getText().toString().equals("") ){
                    side= Double.parseDouble(Squareside.getText().toString());

                    area = ((1)  * (side) * (side) * (1));

                    Squareresult.setText("Area = " + area + " cm^2");

                }
            }
        });//ss

    }
}
