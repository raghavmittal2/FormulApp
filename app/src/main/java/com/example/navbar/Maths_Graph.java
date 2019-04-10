package com.example.navbar;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.*;
import com.jjoe64.graphview.LegendRenderer;

import org.nfunk.jep.JEP;

import java.util.HashMap;
import java.util.Random;

import android.graphics.*;
import android.view.*;
import android.os.*;
import java.io.*;

import android.net.*;


public class Maths_Graph extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;
    private String[] fctList;
    private String var;
    private String lowerBoundx;
    private String upperBoundx;
    private String lowerBoundy;
    private String upperBoundy;
    private String color;
    private double x;
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private double y;
    private HashMap<Integer, String> colorFctList;
    private GraphView graph;
    public static final int STORAGE_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //We get back the information of the previous activity
        Intent intent = getIntent();
        fctList = intent.getStringArrayExtra("fct");
        var = intent.getStringExtra("variable");
        lowerBoundx = intent.getStringExtra("lowerx");
        upperBoundx= intent.getStringExtra("upperx");
        lowerBoundy = intent.getStringExtra("lowery");
        upperBoundy= intent.getStringExtra("uppery");
        //color = intent.getStringExtra("color");
        colorFctList=(HashMap<Integer, String>) intent.getSerializableExtra("hashmap");

        //We create the parser with a call to the library JEP
        JEP myParser = new JEP();
        myParser.addStandardFunctions();
        myParser.addStandardConstants();

        //Creation of a new Graph
        graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<>();

        //Define the number of data point we use to build the graph
        int numPoints = 500000;
        for (int j = 0; j < fctList.length - 1; j++) {

            if (fctList[j] != null && !fctList[j].isEmpty()) { // for each function enter by the user


                // returns double primitive
                minX = Double.parseDouble(lowerBoundx); //min x = lower bound define by user for horizontal axis
                maxX = Double.parseDouble(upperBoundx);

                // returns double primitive
                minY = Double.parseDouble(lowerBoundy); //min y = lower bound define by user for horizontal axis
                maxY = Double.parseDouble(upperBoundy);

                x = minX;//the first value of x is the minimum defined byt the user

                series = new LineGraphSeries<>();

                for (int i = 0; i < numPoints; i++) {
                    while (x < maxX) {
                        x = x + 0.1; //We increase the value of x of 0.1, to have a continue graph
                        myParser.addVariable(var, x);
                        //We parse each function(string) that the user entered
                        myParser.parseExpression(fctList[j]);
                        y = myParser.getValue();
                        // We add the point to the series
                        series.appendData(new DataPoint(x, y), true, 500000);

                    }
                }
                //Now we add the series to the graph
                graph.addSeries(series);
                //Add a title to each function
                series.setTitle(fctList[j]);
                graph.getLegendRenderer().setVisible(true);
                graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                graph.getLegendRenderer().setBackgroundColor(Color.LTGRAY);

                graph.setBackgroundColor(getResources().getColor(android.R.color.white));



                //Change color for each function

                String color = colorFctList.get(j);
                int intColor = colorTreatment(color);
                series.setColor(intColor);


            }
        }
        // set manual X bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(minY);
        graph.getViewport().setMaxY(maxY);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(minX);
        graph.getViewport().setMaxX(maxX);

        // enable scaling and scrolling
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);


    }

    // Take a capture of the graph and share it
    public void takeSnap(View view) {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) { // Check the permission


            // get the bitmap
            Bitmap bitmap = graph.takeSnapshot();

            try {
                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
                File file = new File(this.getExternalCacheDir(), "myImage.png");
                FileOutputStream fOut = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 80, fOut);

                // Flushes the output stream and forces any buffered output bytes to be written out
                fOut.flush();
                fOut.close();
                file.setReadable(true, false);

                //Sharing intent
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                intent.setType("image/png");
                startActivity(Intent.createChooser(intent, "Share Image via"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }


        } else { // if we don't have the permission we ask for it
            requestStoragePermission();
        }


    }

    // Request for permission
    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed to share the graph")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(Maths_Graph.this,
                                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }


    public int colorTreatment(String color){
        int numColor=0;
        switch (color){
            case "Blue":
                numColor= getResources().getColor(R.color.blue);
                break;
            case "Dark":
                numColor= getResources().getColor(R.color.colorPrimaryDark);
                break;

            case "Red":
                numColor= getResources().getColor(R.color.colorAccent);
                break;

            case "Green":
                numColor= getResources().getColor(R.color.colorPrimary);
                break;

            case "Random":
                Random rand = new Random();
                numColor = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                break;
        }
        return numColor;
    }
}
