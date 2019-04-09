package com.example.navbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class quadrix extends AppCompatActivity {
    EditText et_a, et_b, et_c;
    Button bt_go;
    TextView tv_result;

    double a, b, c, d, x1, x2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quadrix);

        et_a = (EditText) findViewById(R.id.et_a);
        et_b = (EditText) findViewById(R.id.et_b);
        et_c = (EditText) findViewById(R.id.et_c);
        bt_go = (Button) findViewById(R.id.bt_go);
        tv_result = (TextView) findViewById(R.id.tv_result);

        bt_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!et_a.getText().toString().equals("") && !et_b.getText().toString().equals("") &&
                        !et_c.getText().toString().equals("")){
                    a= Double.parseDouble(et_a.getText().toString());
                    b= Double.parseDouble(et_b.getText().toString());
                    c= Double.parseDouble(et_c.getText().toString());

                    d= Math.pow(b, 2) - 4*a*c;

                    if(d==0){
                        x1= -b/ 2*a;
                        tv_result.setText("Equal roots found!"+"\n d= "+ d +"\n x = "+x1);
                    }
                    else if(d<0){
                        tv_result.setText("No roots found!");
                    }
                    else if(d>0){
                        x1 = (-b + Math.sqrt(d))/ 2*a;
                        x2 = (-b - Math.sqrt(d))/ 2*a;
                        tv_result.setText("Real and Distinct Roots Found!" + "\n d= "+d+"\n x1 ="+x1+"\n x2 = "+x2);
                    }
                }
            }
        });
    }
}
