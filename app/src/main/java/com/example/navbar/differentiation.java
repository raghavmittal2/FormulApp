package com.example.navbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

import io.github.kexanie.library.MathView;


public class differentiation extends AppCompatActivity {
    EditText function;
    protected String functionword;
    MathView  function2;
    private Button diff_view_btn;
    TextView diff_result;

    double a,b,c,d,e,h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_differentiation);
        diff_view_btn = (Button) findViewById(R.id.diff_view_btn);
        Button clickButton = (Button) findViewById(R.id.show_function);
        diff_result = (TextView) findViewById(R.id.diff_result);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                function2 = (MathView) findViewById(R.id.function2);
                EditText tex = (EditText) findViewById(R.id.function);
                function2.setText("$$"+tex.getText().toString()+"$$");
                functionword = tex.getText().toString();

            }
        });
        diff_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DerivativeStructure x = new DerivativeStructure(1, 3,0, 4);

                DerivativeStructure x2 = x.pow(3);

                DerivativeStructure y = new DerivativeStructure(4.0, x2, 2.0, x);

                a = y.getValue();
                b = y.getPartialDerivative(1);
                c = y.getPartialDerivative(2);
                d = y.getPartialDerivative(3);

                diff_result.setText(" y = " + a + "\n  dy/dx= " + b +  "\n   d2y/dx2= " + c + "\n   d3y/d3x= " + d );

            }
        });
    }

}



