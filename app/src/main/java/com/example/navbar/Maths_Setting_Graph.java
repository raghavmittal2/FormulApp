package com.example.navbar;

import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import io.github.kexanie.library.MathView;


public class Maths_Setting_Graph extends AppCompatActivity {


    private String fct;
    private String[] fctList;
    private MathView formula;
    private RelativeLayout mLayout;
    private Button submitButton;
    private Button newFctButton;
    private EditText currentEdit;
    private EditText variable;
    private EditText fct_init;
    private EditText parentEdit;
    private int nbNewFct;
    private String var;
    private boolean correctFct;

   /* String tex = "This come from string. You can insert inline formula:" +
            " $$cos^2$$ " + "test" +
            "or displayed formula: $$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$";*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths__setting__graph);

        //initialisation
        submitButton = (Button) findViewById(R.id.submit_fct);
        newFctButton = (Button) findViewById(R.id.new_fct);
        mLayout = (RelativeLayout) findViewById(R.id.relative);
        fct_init = (EditText) findViewById(R.id.init_fct);
        formula = (MathView) findViewById(R.id.formula);
        variable = (EditText) findViewById(R.id.variable);
        nbNewFct = 0;
        fctList = new String[100];
        currentEdit = fct_init;

        //Action when we click on the submit button : display the Math View of the fct
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                formula.setText("$$" + currentEdit.getText().toString() + "$$");
                fct = currentEdit.getText().toString();


            }
        });

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

    //Method to create a new EditText
    protected EditText createNewEditText(int i) {
        final EditText editText = new EditText(this);

        //we define an id for each new Edit Text
        editText.setId(i);
        editText.setHint("Enter your function");

        //We need to move the submit fct according to the creation of new editText
        RelativeLayout.LayoutParams mLayout2 = (RelativeLayout.LayoutParams) submitButton.getLayoutParams();
        mLayout2.addRule(RelativeLayout.BELOW, editText.getId());


        //We create a new relative layout to be able to display the new edit text below the others
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        if (i == 1 || i == 0) {
            p.addRule(RelativeLayout.BELOW, R.id.init_fct);


        } else {
            int previous = i--;
            String name = "" + i;
            parentEdit = (EditText) findViewById(getResources().getIdentifier(name, "id", getPackageName()));
            p.addRule(RelativeLayout.BELOW, parentEdit.getId());
        }

        editText.setLayoutParams(p);

        return editText;


    }


    //Action to go to the Graph view
    protected void goToGraphSetting(View view) {
        EditText et;

        ViewGroup editTextsContainer = (ViewGroup) findViewById(R.id.relative);
        int sum = 0;
        int i = editTextsContainer.getChildCount();
        int countTab = 0;

        for (int j = 0; j < i; j++) { // Parcours des fils
            View child = editTextsContainer.getChildAt(j); // We gather all the child of the view
            if (child instanceof EditText && child.getId() != variable.getId()) { // if its an editText, we collect his contents and add it into the array and not if its not the choice of the variable
                   fctList[countTab] = ((EditText) child).getText().toString();
                   countTab++;

            }
        }

        var = variable.getText().toString();
        Intent intent = new Intent(this, Maths_Setting_Graph.class);
        intent.putExtra("fct", fctList);
        intent.putExtra("variable", var);
        if (checkSetting(view, intent)) {
            startActivity(intent);
        }
    }


    //Check if all the information required are presents
    protected boolean checkSetting(final View view, Intent intent) {
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
   /* protected boolean checkFunction(String fct){

        String regex = "([a-zA-z])*[^" +var+ "]";


        if (fct.matches(regex)) { // find another variable that the one defined by the user


            //If not we display an Alert box to explain what's wrong
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("You need to the variable you defined");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //After the close of the dialog box we open the page to choose the profil picture


                }
            });

            builder.show();

            return false;


        }
        return true;

    }*/


}




