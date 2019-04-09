package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cuboid extends AppCompatActivity {
    EditText Cuboidside1, Cuboidside2,Cuboidside3;
    Button solve_button;
    TextView cuboid_result;

    /////ssdfs

    double s1, s2,s3, area, volume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuboid);

        Cuboidside1 = (EditText) findViewById(R.id.Cuboidside1);
        Cuboidside3 = (EditText) findViewById(R.id.Cuboidside3);
        Cuboidside2 = (EditText) findViewById(R.id.Cuboidside2);
        solve_button = (Button) findViewById(R.id.solve_button);
        cuboid_result = (TextView) findViewById(R.id.cuboid_result);


        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Cuboidside1.getText().toString().equals("") &&
                        !Cuboidside2.getText().toString().equals("")&&
                        !Cuboidside3.getText().toString().equals("")){
                    s1= Double.parseDouble(Cuboidside1.getText().toString());
                    s2= Double.parseDouble(Cuboidside2.getText().toString());
                    s3= Double.parseDouble(Cuboidside3.getText().toString());

                    area = (2*(s1*s2 + s3*s1 + s2*s3));
                    volume = ((s1) * (s2*s3) * (1));


                    cuboid_result.setText("Area = " + area + " cm^2" + "\n Volume = "+ volume + " cm^3");

                }
            }
        });//ss

    }
}
