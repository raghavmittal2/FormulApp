package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sphere extends AppCompatActivity {

    EditText SphereRadius;
    Button solve_sphere_button;
    TextView Sphere_result;
    /////ssdfs

    double sphere_radius, area , volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);


        SphereRadius = (EditText) findViewById(R.id.Sphere_radius);
        solve_sphere_button = (Button) findViewById(R.id.solve_sphere_button);
        Sphere_result = (TextView) findViewById(R.id.Sphere_result);




        solve_sphere_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!SphereRadius.getText().toString().equals("")){
                    sphere_radius= Double.parseDouble(SphereRadius.getText().toString());


                    area = ( 4 * (sphere_radius) * (sphere_radius) * (3.14));
                    volume = ((1.333) *  (sphere_radius*sphere_radius*sphere_radius) * (3.14));

                    Sphere_result.setText("Area = " + area + " cm^2" + "\n Volume = "+ volume + " cm^3");

                }
            }
        });

    }
}
