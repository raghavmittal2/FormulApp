package com.example.navbar;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.*;

import java.util.*;

import android.widget.AdapterView.OnItemSelectedListener;


public class Maths_Setting_Graph extends AppCompatActivity {


    private Button okButton;
    private TextView fctTextInit;
    private TextView parentText;
    private TextView upperText;
    private TextView lowerText;
    private TextView boundariesText;
    private EditText lowerEditx;
    private EditText upperEditx;
    private EditText lowerEdity;
    private EditText upperEdity;
    private String upperx;
    private String lowerx;
    private String uppery;
    private String lowery;
    private HashMap<Integer, String> colorFctList;

    private TextView first_fct;
    private String[] fctList;
    private String var;
    private RelativeLayout mLayout;
    private int previous = 0;
    private Double dlowerx;
    private Double dupperx;
    private Double dlowery;
    private Double duppery;
    private String clickedColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths__setting__graph);

        //initialisation
        okButton = (Button) findViewById(R.id.ok_btn);
        mLayout = (RelativeLayout) findViewById(R.id.relative_setting);
        lowerEditx = (EditText) findViewById(R.id.lower_bound_x);
        upperEditx = (EditText) findViewById(R.id.upper_bound_x);
        lowerEdity = (EditText) findViewById(R.id.lower_bound_y);
        upperEdity = (EditText) findViewById(R.id.upper_bound_y);
        upperText = (TextView) findViewById(R.id.txt_upper_bound);
        lowerText = (TextView) findViewById(R.id.txt_lower_bound);
        first_fct = (TextView) findViewById(R.id.first_fct);
        colorFctList = new HashMap<Integer, String>();
        boundariesText=(TextView) findViewById(R.id.txt_boundaries);


        //We gather the information of the previous activity
        Intent intent = getIntent();
        fctList = intent.getStringArrayExtra("fct");
        var = intent.getStringExtra("variable");
        first_fct.setText("Function 1: " + fctList[0]);
        for (int i = 0; i < fctList.length; i++) {
            if (fctList[i] != null) {
                if (i != 0) {// The textView already created for the first function which is mandatory
                    mLayout.addView(createNewTextView(i, fctList[i]));
                }

                mLayout.addView(createNewSpinner(i)); // we create a new spinner for each editTextEmail, for the choice of the color


            }
        }
    }


    //Method to create a new TextView
    protected TextView createNewTextView(int i, String currentFct) {

        final TextView textView = new TextView(this);

        //we define an id for each new TextView
        textView.setId(i);


        //We need to move the upper and lower boundaries display according to the creation of new textView
        RelativeLayout.LayoutParams mLayout2 = (RelativeLayout.LayoutParams) boundariesText.getLayoutParams();
        mLayout2.addRule(RelativeLayout.BELOW, textView.getId());



        //We create a new relative layout to be able to display the new text view above the others
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);

        if (i == 1) {

            p.addRule(RelativeLayout.BELOW, first_fct.getId());

        } else {
            p.addRule(RelativeLayout.BELOW, parentText.getId());


        }
        int numFct = i + 1;

        textView.setText("Function " + numFct + ": " + currentFct);
        parentText = textView;
        textView.setLayoutParams(p);
        textView.setTextColor(getResources().getColor(android.R.color.white));
        return textView;


    }


    //Method to create a new spinner
    protected Spinner createNewSpinner(int id) {

        final int numId = id;
        Spinner spin = new Spinner(this);

        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);
        RelativeLayout.LayoutParams pbis = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);


        //Dropdown layoutstyle
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching  data adapter to spinner
        spin.setAdapter(dataAdapter);
        spin.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                clickedColor = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), clickedColor, Toast.LENGTH_SHORT).show();
                colorFctList.put(numId, clickedColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //we define constraint for the layout
        if (id == 0) {


            pbis.addRule(RelativeLayout.ALIGN_BASELINE, first_fct.getId());
            pbis.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, first_fct.getId());
            previous = id;


        }

        if (id == 1) {
            pbis.addRule(RelativeLayout.BELOW, first_fct.getId());
            previous = id;
            pbis.addRule(RelativeLayout.ALIGN_BASELINE, id);
            pbis.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, id);

        } else {
            if (id != 0) {
                pbis.addRule(RelativeLayout.BELOW, previous);
                pbis.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, previous);
                previous = id;
            }


        }


        spin.setLayoutParams(pbis);

        spin.setBackgroundColor(getResources().getColor(android.R.color.white));


        return spin;

    }


    //Action to go to the Graph view
    protected void goToGraph(View view) {
        upperx = upperEditx.getText().toString();
        lowerx = lowerEditx.getText().toString();
        uppery = upperEdity.getText().toString();
        lowery = lowerEdity.getText().toString();

        Intent intent = new Intent(this, Maths_Graph.class);
        intent.putExtra("fct", fctList);
        intent.putExtra("variable", var);
        intent.putExtra("lowerx", lowerx);
        intent.putExtra("upperx", upperx);
        intent.putExtra("lowery", lowery);
        intent.putExtra("uppery", uppery);
        intent.putExtra("color", clickedColor);
        intent.putExtra("hashmap", colorFctList);

        if (checkSetting(view, intent)) {

            startActivity(intent);
        }
    }


    //Check if all the information required are presents
    protected boolean checkSetting(final View view, Intent intent) {
        //The user must provide the upper and the lower bound

        if (lowerEditx.getText().toString().equals("")) {
            lowerEditx.setError("Required!");
            return false;

        }

        if (upperEditx.getText().toString().equals("")) {
            upperEditx.setError("Required!");
            return false;

        }
        //We need to check that upperboundarie is bigger than lowerboundarie otherwise its not going to work
        dlowerx = Double.valueOf(lowerx);
        dupperx = Double.valueOf(upperx);
        dlowery = Double.valueOf(lowery);
        duppery = Double.valueOf(uppery);

        if (!upperValid(dlowerx, dupperx)) {
            upperEditx.setError("Upper limit needs to be bigger than the lower limit");
            return false;
        }

        if (!upperValid(dlowery, duppery)) {
            upperEdity.setError("Upper limit needs to be bigger than the lower limit");
            return false;
        }

        return true;
    }

    //Check that upperbound bigger than lower boundarie
    public boolean upperValid(double lower, double upper) {

        return (lower < upper);
    }


}
