package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class lens_exp extends AppCompatActivity {

    private Button buttonlc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lens_exp);

        buttonlc = (Button) findViewById(R.id.buttonlc);

        buttonlc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openlenscalc();         //function for opening page
            }
        });
    }
    public void openlenscalc(){
        Intent intent = new Intent(this,lens_calc.class);
        startActivity(intent);
    }
}
