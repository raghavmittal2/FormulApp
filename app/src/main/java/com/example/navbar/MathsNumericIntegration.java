package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.RombergIntegrator;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.nfunk.jep.JEP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.kexanie.library.MathView;


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
        EditText lowerV = findViewById(R.id.ni_lower);
        EditText upperV = findViewById(R.id.ni_upper);
        EditText variableT = findViewById(R.id.ni_variable);

        boolean emptyF,emptyUpper,emptyLower,emptyVariable,variableRegex;
        emptyF = TextUtils.isEmpty(ni_f.getText().toString());
        emptyUpper = TextUtils.isEmpty(upperV.getText().toString());
        emptyLower = TextUtils.isEmpty(lowerV.getText().toString());
        emptyVariable = TextUtils.isEmpty(variableT.getText().toString());


        if ( emptyF || emptyUpper || emptyLower || emptyVariable){
            if (emptyF){
                ni_f.setError("You need to enter a function");
            }
            if ( emptyLower){
                lowerV.setError("You need to enter a lower range value");
            }
            if (emptyUpper){
                upperV.setError("You need to enter an upper range value");
            }
            if (emptyVariable){
                upperV.setError("You need to enter the variable of the function");
            }
            return;
        }
        final String variable = variableT.getText().toString();
        final String fct = ni_f.getText().toString();
        TextView errorView = findViewById(R.id.ni_error);
        MathView result = findViewById(R.id.ni_result);
        result.config(
                "MathJax.Hub.Config({\n"+
                        "  { TeX: { extensions: [\"color.js\"] } }\n"+
                        "});"
        );

        //checking if variable is in the string
        Pattern variablePattern = Pattern.compile(".*" + variableT.getText().toString()+ ".*");
        Matcher matcher = variablePattern.matcher(fct);
        variableRegex = matcher.find();
        if (!variableRegex){
            String error = "Variable isn't in the function given";
            errorView.setText(error);
            return;

        }
        //parse function for fast evaluation
        myParser.addVariable(variable, 0);
        myParser.parseExpression(fct);
        //Initialize Univariate function to pass to the integrator
        UnivariateFunction f = new UnivariateFunction() {
            @Override
            public double value(double x) {
                // this implements the value() function of the UnivariateFunction interface
                myParser.addVariable(variable, x);
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

        double upper = Double.valueOf(upperV.getText().toString());
        double lower = Double.valueOf(lowerV.getText().toString());
        while (!converged) {
            try {
                double eval = solver.integrate(iterations, f, lower, upper);
                //System.out.println("ESTIMATE: " + eval);
                String resultString = "$$\\color{white}{\\int_{" + lowerV.getText().toString() + "}^{" + upperV.getText().toString() + "} " + fct +  " d" + variable + " = " + eval +"}$$";
                result.setText(resultString);
                converged = true;
            } catch (TooManyEvaluationsException e) {
                //Error handling for when the function passed doesn't converge
                if (attempts > 3) {
                    String error = "The algorithm wasn't able to converge. Make sure the function is univariate and real (no asymptotes)";
                    errorView.setText(error);
                    break;

                }
                // If the number of attempts doesn't exceed max, multiply iterations by 10 and try again
                attempts += 1;
                //System.out.println(iterations + " iterations wasn't enough to find converging point");
                iterations *= 10;
                //System.out.println("Trying to find converging point with " + iterations + " of iterations");
            } catch (MathIllegalArgumentException e) {
                String error = "The lower bound was higher than the upper bound";
                errorView.setText(error);
                break;
            }
        }
    }


    public void goToHome(View v) {
        Intent intent = new Intent(this, fragmentMaths.class);
        startActivity(intent);
    }
}
