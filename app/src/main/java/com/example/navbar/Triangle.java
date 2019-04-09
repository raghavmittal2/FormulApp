package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Triangle extends AppCompatActivity {
    EditText Tribase , Triheight;
    Button solve_button;
    TextView Triresult;



    double height,base, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        Tribase = (EditText) findViewById(R.id.Tribase);
        Triheight = (EditText) findViewById(R.id.Triheight);
        solve_button = (Button) findViewById(R.id.solve_button);
        Triresult = (TextView) findViewById(R.id.Triresult);


        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Tribase.getText().toString().equals("") &&
                        !Triheight.getText().toString().equals("") ){
                    height= Double.parseDouble(Triheight.getText().toString());
                    base= Double.parseDouble(Tribase.getText().toString());

                    area = ((1)  * (height) * (base) * (0.5));

                    Triresult.setText("Area = " + area + " cm^2");

                }
            }
        });//ss

    }
}
