package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cylinder extends AppCompatActivity {
    EditText CylinderRadius, Cylinder_height;
    Button solve_button;
    TextView cylinder_result;

    /////ssdfs

    double cylinder_r, cylinder_h, area, volume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        CylinderRadius = (EditText) findViewById(R.id.CylinderRadius);
        Cylinder_height = (EditText) findViewById(R.id.Cylinder_length);
        solve_button = (Button) findViewById(R.id.solve_button);
        cylinder_result = (TextView) findViewById(R.id.cylinder_result);


        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!CylinderRadius.getText().toString().equals("") &&
                        !Cylinder_height.getText().toString().equals("")){
                    cylinder_r= Double.parseDouble(CylinderRadius.getText().toString());
                    cylinder_h= Double.parseDouble(Cylinder_height.getText().toString());

                    area = ((2)  * (cylinder_r) * (cylinder_h) * (3.14));
                    volume = ((cylinder_h) * (cylinder_r*cylinder_r) * (3.14));


                    cylinder_result.setText("Area = " + area + " cm^2" + "\n Volume = "+ volume + " cm^3");

                }
            }
        });//ss

    }
}
