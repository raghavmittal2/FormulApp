package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cube extends AppCompatActivity {

    EditText Cubeside;
    Button solve_button;
    TextView Cube_result;
    /////ssdfs

    double side, area , volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);


        Cubeside = (EditText) findViewById(R.id.Cubeside);
        solve_button = (Button) findViewById(R.id.solve_button);
        Cube_result = (TextView) findViewById(R.id.Cube_result);




        solve_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!Cubeside.getText().toString().equals("")){
                    side= Double.parseDouble(Cubeside.getText().toString());


                    area = ( 6 * (side) * (side) * (1));
                    volume = ((1) *  (side*side*side) * (1));

                    Cube_result.setText("Area = " + area + " cm^2" + "\n Volume = "+ volume + " cm^3");

                }
            }
        });

    }
}
