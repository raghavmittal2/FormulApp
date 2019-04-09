package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Frustum extends AppCompatActivity {

    EditText FrustRadius,FrustHeight,Frustradius;
    Button solve_button;
    TextView Frust_result;




    double r,Ra,h, area , volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frustum);

        FrustRadius = (EditText) findViewById(R.id.FrustRadius);
        FrustHeight = (EditText) findViewById(R.id.FrustHeight);
        Frustradius = (EditText) findViewById(R.id.Frustradius);
        solve_button = (Button) findViewById(R.id.solve_button);
        Frust_result = (TextView) findViewById(R.id.Frust_result);



        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!FrustRadius.getText().toString().equals("") &&
                        !FrustHeight.getText().toString().equals("") &&
                        !Frustradius.getText().toString().equals("")){
                    r= Double.parseDouble(FrustRadius.getText().toString());
                    h= Double.parseDouble(FrustHeight.getText().toString());
                    Ra= Double.parseDouble(Frustradius.getText().toString());

                    area = ( (r+Ra) * (3.14)* ((Ra-r)*(Ra-r) + h*h));
                    volume = ((0.333) * (h) * (r*Ra + Ra*Ra + r*r) * (3.14));

                    Frust_result.setText("Area = " + area + " cm^2" + "\n Volume = "+ volume + " cm^3");

                }
            }
        });



    }
}
