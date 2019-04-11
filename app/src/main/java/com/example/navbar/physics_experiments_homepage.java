package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class physics_experiments_homepage extends AppCompatActivity {

    private Button Physics_exp_btn1;
    private Button Physics_exp_btn2;
    private Button Physics_exp_btn3;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics_exp_homepage);

        Physics_exp_btn1 = (Button) findViewById(R.id.Physics_exp_btn1);         //declaring buttons
        Physics_exp_btn2 = (Button) findViewById(R.id.Physics_exp_btn2);
        Physics_exp_btn3 = (Button) findViewById(R.id.Physics_exp_btn3);

        Physics_exp_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openExpPage(0);         //function for opening page
            }
        });

        Physics_exp_btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openExpPage(1);   //function for opening page
            }

        });

        Physics_exp_btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openExpPage(2); // function for opening page
            }
        });
    }
    public void openExpPage(int pageno){
        Intent intent = new Intent(this,conservation_of_momentum.class);
        switch(pageno){
            case 0:
                intent = new Intent(this,conservation_of_momentum.class);
                break;
            case 1:
                intent = new Intent(this,lens_exp.class);
                break;
            case 2:
                intent = new Intent(this,velocity_exp.class);
                break;
            default:
                break;
        }

        startActivity(intent);
    }


}

