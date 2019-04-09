package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Two_d_page extends AppCompatActivity {

    private Button cir_btn;
    private Button squ_btn;
    private Button tri_btn;
    private Button rec_btn;
    private Button tra_btn;
    private Button pen_btn;
    private Button oct_btn;
    private Button hex_btn;
    private Button rho_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_d);



        cir_btn = (Button) findViewById(R.id.cir_btn);
        cir_btn.getBackground().setAlpha(64);//declaring buttons
        squ_btn = (Button) findViewById(R.id.squ_btn);
        squ_btn.getBackground().setAlpha(64);
        tri_btn = (Button) findViewById(R.id.tri_btn);
        tri_btn.getBackground().setAlpha(64);
        rec_btn = (Button) findViewById(R.id.rec_btn);
        rec_btn.getBackground().setAlpha(64);
        tra_btn = (Button) findViewById(R.id.tra_btn);
        tra_btn.getBackground().setAlpha(64);
        pen_btn = (Button) findViewById(R.id.pen_btn);
        pen_btn.getBackground().setAlpha(64);
        oct_btn = (Button) findViewById(R.id.oct_btn);
        oct_btn.getBackground().setAlpha(64);
        hex_btn = (Button) findViewById(R.id.hex_btn);
        hex_btn.getBackground().setAlpha(64);
        rho_btn = (Button) findViewById(R.id.rho_btn);
        rho_btn.getBackground().setAlpha(64);


        cir_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                opencirPage();         //function for opening page
            }
        });

        squ_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opensquPage();   //function for opening page
            }

        });

        tri_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opentriPage(); // function for opening page
            }
        });

        rec_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openrecPage(); // function for opening page
            }
        });
        tra_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opentraPage(); // function for opening page
            }
        });
        pen_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openpenPage(); // function for opening page
            }
        });
        oct_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openoctPage(); // function for opening page
            }
        });
        hex_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openhexPage(); // function for opening page
            }
        });
        rho_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openrhoPage(); // function for opening page
            }
        });
    }
    public void opencirPage(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(this,Circle.class);
        startActivity(intent);
    }
    public void opensquPage(){
        Intent intent = new Intent(this,Square.class);
        startActivity(intent);
    }
    public void opentriPage(){
        Intent intent = new Intent(this,Triangle.class);
        startActivity(intent);
    }
    public void openrecPage(){
        Intent intent = new Intent(this,Rectangle.class);
        startActivity(intent);
    }
    public void opentraPage(){
        Intent intent = new Intent(this,Trapezuim.class);
        startActivity(intent);
    }
    public void openpenPage(){
        Intent intent = new Intent(this,Pentagon.class);
        startActivity(intent);
    }
    public void openoctPage(){
        Intent intent = new Intent(this,Octagon.class);
        startActivity(intent);
    }
    public void openhexPage(){
        Intent intent = new Intent(this,Hexagon.class);
        startActivity(intent);
    }
    public void openrhoPage(){
        Intent intent = new Intent(this,Rhombus.class);
        startActivity(intent);
    }
}
