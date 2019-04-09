package com.example.navbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class lens_calc extends AppCompatActivity {
    EditText et_u2,et_v2;
    Button bt_go2,clr;
    TextView result01;
    TextView result02;
    TextView result03;

    double object,image,mag,f,power;
    //char req;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lens);

        et_u2 = (EditText) findViewById(R.id.et_u2);
        et_v2 = (EditText) findViewById(R.id.et_v2);
        bt_go2 = (Button) findViewById(R.id.bt_go2);
        result01 = (TextView) findViewById(R.id.result01);
        result02 = (TextView) findViewById(R.id.result02);
        result03 = (TextView) findViewById(R.id.result03);



        bt_go2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!et_u2.getText().toString().equals("") && !et_v2.getText().toString().equals("")){
                    object= Double.parseDouble(et_u2.getText().toString());
                    image= Double.parseDouble(et_v2.getText().toString());
                }

                f = (1/object) + (1/image);
                result01.setText("\nfocal point is 1/"+"\n" + f);

                mag = -image/object;
                result02.setText("\nmagnification is "+"\n" + mag);

                power = 1/f;
                result03.setText("\nLens power is "+"\n" + power);

            }
        });
    }
}
