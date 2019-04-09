package com.example.navbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class gravity_page extends AppCompatActivity {
    EditText et_m1, et_m2, et_d;

    TextView instr,res;

    Button bt_go;

    double F,m1,m2,d,G=0.0000000000667408;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);

        instr = (TextView) findViewById(R.id.instr);
        et_m1 = (EditText) findViewById(R.id.et_m1);
        et_m2= (EditText) findViewById(R.id.et_m2);
        et_d = (EditText) findViewById(R.id.et_d);
        res = (TextView) findViewById(R.id.res);

        bt_go = (Button) findViewById(R.id.bt_go);

        bt_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_m1.getText().toString().equals("") && !et_m2.getText().toString().equals("") && !et_d.getText().toString().equals("")){
                    m1= Double.parseDouble(et_m1.getText().toString());
                    m2= Double.parseDouble(et_m2.getText().toString());
                    d= Double.parseDouble(et_d.getText().toString());
                    F = (G*m1*m2)/(d*d);
                    res.setText("\nThe force of attraction between these objects is:\n-->" + F + "Newtons");
                }

            }
        });
    }
}
