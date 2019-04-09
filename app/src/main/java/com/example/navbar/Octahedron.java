package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Octahedron extends AppCompatActivity {

    EditText Octaside;
    Button solve_button;
    TextView Octa_result;
    /////ssdfs

    double side, area , volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_octahedron);


        Octaside = (EditText) findViewById(R.id.Octaside);
        solve_button = (Button) findViewById(R.id.solve_button);
        Octa_result = (TextView) findViewById(R.id.Octa_result);




        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Octaside.getText().toString().equals("")){
                    side= Double.parseDouble(Octaside.getText().toString());


                    area = (  (side) * (side) * (1.732));
                    volume = ((1) *  (side*side*side) * (0.471));

                    Octaside.setText("Area = " + area + " cm^2" + "\n Volume = "+ volume + " cm^3");

                }
            }
        });

    }
}
