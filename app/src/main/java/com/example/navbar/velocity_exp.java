package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class velocity_exp extends AppCompatActivity {

    private Button buttonvel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vel_exp);

        buttonvel = (Button) findViewById(R.id.buttonvel);

        buttonvel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openUVASTcalc();         //function for opening page
            }
        });
    }
    public void openUVASTcalc(){
        Intent intent = new Intent(this,uvast_calc.class);
        startActivity(intent);
    }
}
