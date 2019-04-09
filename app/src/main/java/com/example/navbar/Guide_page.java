package com.example.navbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.kexanie.library.MathView;

public class Guide_page extends AppCompatActivity {

    MathView formula,formula1,formula2,formula3,formula4,formula5
            ,formula6;
    String text,text1,text2,text3,text4,text5,text6 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page);
        formula = (MathView) findViewById(R.id.formula);
        formula1 = (MathView) findViewById(R.id.formula1);
        formula2 = (MathView) findViewById(R.id.formula2);
        formula3 = (MathView) findViewById(R.id.formula3);
        formula4 = (MathView) findViewById(R.id.formula4);
        formula5 = (MathView) findViewById(R.id.formula5);
        formula6 = (MathView) findViewById(R.id.formula6);

        text = "x^2";
        text1 = "e^x";
        text2 = "ln(x)";
        text3 = "sin(x)";
        text4 = "cos(x)";
        text5 = "tan(x)";
        text6 = "\\sqrt{x}";
        formula.setText("$$"+ text +"$$");
        formula1.setText("$$"+text1 + "$$");
        formula2.setText("$$"+text2+"$$");
        formula3.setText("$$"+text3+"$$");
        formula4.setText("$$"+text4+"$$");
        formula5.setText("$$"+text5+"$$");
        formula6.setText("$$"+text6+"$$");
        //formula6.setText("$$"+text6+"$$");

        //formula5.setText("$$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$");



    }
}
