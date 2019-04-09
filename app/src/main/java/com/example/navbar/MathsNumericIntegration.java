package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.RombergIntegrator;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.nfunk.jep.JEP;


public class MathsNumericIntegration extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical_integration);

    }


    protected void onIntegrate(View v) {
        //initialize jep parser
        final JEP myParser = new JEP();
        myParser.addStandardFunctions();
        myParser.addStandardConstants();
        EditText ni_f = findViewById(R.id.ni_f);
        final String fct = ni_f.getText().toString();
        //parse function for fast evaluation
        //TODO get variable name from edit text and not a dummy
        myParser.addVariable("x", 0);
        myParser.parseExpression(fct);
        //Initialize Univariate function to pass to the integrator
        UnivariateFunction f = new UnivariateFunction() {
            @Override
            public double value(double x) {
                // this implements the value() function of the UnivariateFunction interface
                myParser.addVariable("x", x);
                double eval = myParser.getValue();
                return eval;
            }
        };
        //initialize integrator, using Romberg integrator since it seemed the quickest to converge
        RombergIntegrator solver = new RombergIntegrator();
        // amount of initial iterations
        int iterations = 100;
        // check how many attempts have been made
        int attempts = 0;
        // tag
        boolean converged = false;
        EditText lowerV = findViewById(R.id.ni_lower);
        EditText upperV = findViewById(R.id.ni_upper);
        double upper = Double.valueOf(upperV.getText().toString());
        double lower = Double.valueOf(lowerV.getText().toString());
        while (!converged) {
            try {
                double eval = solver.integrate(iterations, f, lower, upper);
                //System.out.println("ESTIMATE: " + eval);
                TextView result = findViewById(R.id.ni_result);
                String resultString = "The result is : " + eval;
                //TODO make MathView
                result.setText(resultString);
                converged = true;
            } catch (TooManyEvaluationsException e) {
                //Error handling for when the function passed doesn't converge
                if (attempts > 3) {
                    String error = "The algorithm wasn't able to converge. Make sure the function is univariate and real (no asymptotes)";
                    TextView result = findViewById(R.id.ni_result);
                    result.setText(error);
                    break;

                }
                // If the number of attempts doesn't exceed max, multiply iterations by 10 and try again
                attempts += 1;
                //System.out.println(iterations + " iterations wasn't enough to find converging point");
                iterations *= 10;
                //System.out.println("Trying to find converging point with " + iterations + " of iterations");
            } catch (MathIllegalArgumentException e) {
                String error = "The bounds were inappropriate for the function given";
                TextView result = findViewById(R.id.ni_result);
                result.setText(error);
                break;
            }
        }
    }


    public void goToHome(View v) {
        Intent intent = new Intent(this, fragmentMaths.class);
        startActivity(intent);
    }
}
