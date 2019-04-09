package com.example.navbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Getting_Area_Volume extends AppCompatActivity {
    EditText CylinderRadius, Cylinder_height;
    Button solve_button;
    TextView cylinder_result;

    EditText ConeRadius,ConeHeight,ConeLength;
    Button solve_cone_button;
    TextView Cone_result;

    EditText SphereRadius;
    Button solve_sphere_button;
    TextView Sphere_result;
    /////ssdfs

    double cylinder_r, cylinder_h, area, volume;
    double cone_r,cone_l,cone_h;
    double sphere_radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_area_volume);

        CylinderRadius = (EditText) findViewById(R.id.CylinderRadius);
        Cylinder_height = (EditText) findViewById(R.id.Cylinder_length);
        solve_button = (Button) findViewById(R.id.solve_button);
        cylinder_result = (TextView) findViewById(R.id.cylinder_result);

        ConeRadius = (EditText) findViewById(R.id.ConeRadius);
        ConeHeight = (EditText) findViewById(R.id.Cone_height);
        ConeLength = (EditText) findViewById(R.id.Cone_length);
        solve_cone_button = (Button) findViewById(R.id.solve_cone_button);
        Cone_result = (TextView) findViewById(R.id.Cone_result);

        SphereRadius = (EditText) findViewById(R.id.Sphere_radius);
        solve_sphere_button = (Button) findViewById(R.id.solve_sphere_button);
        Sphere_result = (TextView) findViewById(R.id.Sphere_result);

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
