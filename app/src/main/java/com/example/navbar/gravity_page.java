package com.example.navbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class gravity_page extends AppCompatActivity {
    EditText et_m1, et_m2, et_d;

    TextView instr,res,res2,res3;

    Button bt_go;

    double F,fm1,fm2,m1,m2,d,G=0.0000000000667408, grav=9.8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);

        instr = (TextView) findViewById(R.id.instr);
        et_m1 = (EditText) findViewById(R.id.et_m1);
        et_m2= (EditText) findViewById(R.id.et_m2);
        et_d = (EditText) findViewById(R.id.et_d);
        res = (TextView) findViewById(R.id.res);
        res2 = (TextView) findViewById(R.id.res2);
        res3 = (TextView) findViewById(R.id.res3);

        bt_go = (Button) findViewById(R.id.bt_go);

        bt_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_m1.getText().toString().equals("") && !et_m2.getText().toString().equals("") && !et_d.getText().toString().equals("")){
                    m1= Double.parseDouble(et_m1.getText().toString());
                    m2= Double.parseDouble(et_m2.getText().toString());
                    d= Double.parseDouble(et_d.getText().toString());
                    F = (G*m1*m2)/(d*d);
                    res.setText("The force of attraction between these objects is:\n-->" + F + "Newtons");
                    fm1 = grav*m1;
                    fm2 = grav*m2;
                    res2.setText("The force on mass m1 is:\n-->" + fm1 + "Newtons");
                    res3.setText("The force on mass m2 is:\n-->" + fm2 + "Newtons");
                }

            }
        });
    }
}
