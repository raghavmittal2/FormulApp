package com.example.navbar;




import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.app.ActionBar.*;


import java.util.regex.*;

import io.github.kexanie.library.MathView;


public class Maths_Function extends AppCompatActivity {


    private String fct;
    private String[] fctList;
    private MathView formula;
    private RelativeLayout mLayout;
    private Button submitButton;
    private Button newFctButton;
    private ImageButton imageBtn;
    private EditText currentEdit;
    private EditText variable;
    private EditText fct_init;
    private EditText parentEdit;
    private int nbNewFct;
    private String var;
    private boolean correctFct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths__function);

        //initialisation
        newFctButton = (Button) findViewById(R.id.new_fct);
        mLayout = (RelativeLayout) findViewById(R.id.relative);
        fct_init = (EditText) findViewById(R.id.init_fct);
        formula = (MathView) findViewById(R.id.formula);
        variable = (EditText) findViewById(R.id.variable);
        nbNewFct = 0;

        currentEdit = fct_init;



        //Action when we click ont the button new function : add a new EditText
        newFctButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nbNewFct++;
                mLayout.addView(createNewEditText(nbNewFct));
                String nameCurrent = "" + nbNewFct;
                //We change the current EditText
                currentEdit = (EditText) findViewById(getResources().getIdentifier(nameCurrent, "id", getPackageName()));


            }
        });
    }


    protected void displayTips(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(Maths_Function.this);
        builder.setCancelable(true);
        builder.setTitle("Tips");
        builder.setMessage("Double click on your function to display it and to check if this is the function you want to display");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //After the display of the message, we close the alert box


            }
        });
        builder.show();
    }



    //Action when we click on the submit button : display the Math View of the fct
    protected void displayCheckView(View view) {
        formula.setText("$$" + fct_init.getText().toString() + "$$");
        fct = fct_init.getText().toString();

    }

    //Method to create a new EditText
    protected EditText createNewEditText(int i) {
        final EditText editText = new EditText(this);

        //we define an id for each new Edit Text
        editText.setId(i);
        editText.setHint("Enter your function");

        //We need to move the Math view(to display fct) according to the creation of new editText
        RelativeLayout.LayoutParams mLayout2 = (RelativeLayout.LayoutParams) formula.getLayoutParams();
        mLayout2.addRule(RelativeLayout.BELOW, editText.getId());


        //We create a new relative layout to be able to display the new edit text above the others
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        if (i == 1 || i == 0) {
            p.addRule(RelativeLayout.BELOW, R.id.init_fct);


        } else {
            int previous = i--;
            String name = "" + i;
            parentEdit = (EditText) findViewById(getResources().getIdentifier(name, "id", getPackageName()));
            p.addRule(RelativeLayout.BELOW, parentEdit.getId());
        }
        editText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { // we put a listener to display the editText(fct) chose by the user
                // TODO Auto-generated method stub
                formula.setText("$$" + editText.getText().toString() + "$$");
                fct = editText.getText().toString();
            }


        });


        editText.setLayoutParams(p);

        return editText;


    }


    //Action to go to the Graph Setting
    protected void goToGraphSetting(View view) {
        EditText et;
        ViewGroup editTextsContainer = (ViewGroup) findViewById(R.id.relative);
        fctList = new String[100];
        int i = editTextsContainer.getChildCount();
        int countTab = 0;

        for (int j = 0; j < i; j++) { //Browsing of the sons
            View child = editTextsContainer.getChildAt(j); // We gather all the child of the view

            // if its an editText, we collect his content and add it into the array
            //we dont collect the first Edit Text which is the choice of the variable

            if (child instanceof EditText && child.getId() != variable.getId()) {

                String childContent = ((EditText) child).getText().toString();
                if (!((EditText) child).getText().toString().isEmpty()) { // if the edit text is empty we dont take it

                    fctList[countTab] = childContent;
                }

                countTab++;

            }
        }

        var = variable.getText().toString();
        Intent intent = new Intent(this, Maths_Setting_Graph.class);
        intent.putExtra("fct", fctList);
        intent.putExtra("variable", var);
        if (checkSetting(view) && checkFunction(view)) { //The fct need to be correct and all the requires fields completed
            startActivity(intent);
        }
    }


    //Check if all the information required are presents
    protected boolean checkSetting(final View view) {
        //At least the first EditText must be completed with a function and the variable EditTExt

        if (variable.getText().toString().equals("")) {
            variable.setError("Required!");
            return false;
        }
        if (fct_init.getText().toString().equals("")) {
            fct_init.setError("Required!");
            return false;

        }


        return true; // All the function must be true, if that ok it will return true
    }


    //Check if the user uses well the variable he defines and not another one
    protected boolean checkFunction(final View view) {
        ViewGroup editTextsContainer = (ViewGroup) findViewById(R.id.relative);
        boolean correct = true;

        int i = editTextsContainer.getChildCount();
        for (int j = 0; j < i; j++) { // Parcours des fils
            View child = editTextsContainer.getChildAt(j); // We gather all the child of the view
            // if its an editText, we test if the fucntion is ok : user use the variable he defined earlier


            if (child instanceof EditText && child.getId() != variable.getId()) { // we dont check the edit text which contains the variable


                if (!((EditText) child).getText().toString().isEmpty()) { // if the edit text is empty we dont take it

                    // String to be scanned to find the pattern.
                    String regex = "\\b(?!(\\bln\\b))(?!(\\blog\\b))(?!(\\be\\b))(?!(\\bsqrt\\b))[^" + var + "0-9+\\-^*()][a-zA-Z]*\\b";
                    String fctText = ((EditText) child).getText().toString();
                    // Create a Pattern object
                    Pattern r = Pattern.compile(regex);

                    // Now create matcher object.
                    Matcher m = r.matcher(fctText);
                    if (m.find()&&correct) {
                        //find another variable than the one defined by the user
                        ((EditText) child).setError("You have to use the variable you defined");
                        correct = false;
                    } else {
                        //no match
                        //we do nothing
                    }


                }


            }
        }


        return correct;

    }


}




