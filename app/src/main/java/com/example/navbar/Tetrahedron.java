package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tetrahedron extends AppCompatActivity {

    EditText Tetraside;
    Button solve_button;
    TextView Tetra_result;
    /////ssdfs

    double side, area , volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tetrahedron);


        Tetraside = (EditText) findViewById(R.id.Tetraside);
        solve_button = (Button) findViewById(R.id.solve_sphere_button);
        Tetra_result = (TextView) findViewById(R.id.Tetra_result);




        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Tetraside.getText().toString().equals("")){
                    side= Double.parseDouble(Tetraside.getText().toString());


                    area = (  (side) * (side) * (1.732));
                    volume = ((1) *  (side*side*side) * (1.4142));

                    Tetra_result.setText("Area = " + area + " cm^2" + "\n Volume = "+ volume + " cm^3");

                }
            }
        });

    }
}
