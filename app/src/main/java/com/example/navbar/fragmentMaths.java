package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragmentMaths extends Fragment {
    private Button Trig_btn;
    private Button Physics_btn;
    private Button quadrix_btn;
    private Button LandA_btn;
    private Button VandA_btn;
    private Button graph_btn;
    private Button differentiate_btn;
    private Button mathsnumericintegeration;
    private Button two_d_btn;
    private Button three_d_btn;
    private Button logs_btn;
    private Button maths_func_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.fragment_maths, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Trig_btn = (Button) view.findViewById(R.id.Trig_btn);
        Trig_btn.getBackground().setAlpha(64);
        Physics_btn = (Button) view.findViewById(R.id.Physics_btn);
        Physics_btn.getBackground().setAlpha(64);
        LandA_btn = (Button) view.findViewById(R.id.LandA_btn);
        LandA_btn.getBackground().setAlpha(64);
        quadrix_btn = (Button) view.findViewById(R.id.quadrix_btn);
        quadrix_btn.getBackground().setAlpha(64);
        VandA_btn = (Button) view.findViewById(R.id.VandA_btn);
        VandA_btn.getBackground().setAlpha(64);
        graph_btn = (Button) view.findViewById(R.id.graph_btn);
        graph_btn.getBackground().setAlpha(64);
        differentiate_btn = (Button) view.findViewById(R.id.differentiate_btn);
        differentiate_btn.getBackground().setAlpha(64);
        mathsnumericintegeration = (Button) view.findViewById(R.id.mathsnumericintegeration);
        mathsnumericintegeration.getBackground().setAlpha(64);
        two_d_btn = (Button) view.findViewById(R.id.two_d_shapes_btn);
        two_d_btn.getBackground().setAlpha(64);
        three_d_btn = (Button) view.findViewById(R.id.three_d_shapes_btn);
        three_d_btn.getBackground().setAlpha(64);
        logs_btn = (Button) view.findViewById(R.id.log_btn);
        logs_btn.getBackground().setAlpha(64);
        maths_func_btn = (Button) view.findViewById(R.id.func_btn);
        maths_func_btn.getBackground().setAlpha(64);

        Trig_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openTrigPage(v);         //function for opening page
            }
        });

        Physics_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openPhysicsPage(v);         //function for opening page
            }
        });

        LandA_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openLengthandAreaPage(v);         //function for opening page
            }
        });

        quadrix_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openQuadrixPage(v);         //function for opening page
            }
        });

        VandA_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openVandAPage(v);         //function for opening page
            }
        });

        graph_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openGraphPage(v);         //function for opening page
            }
        });

        maths_func_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openMathsFunction(v);         //function for opening page
            }
        });

        differentiate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openDifferentiatePage(v);         //function for opening page
            }
        });

        mathsnumericintegeration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openMathsNumericIntegeration(v);         //function for opening page
            }
        });

        two_d_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openTwoDShapes(v);         //function for opening page
            }
        });

        three_d_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openThreeDShapes(v);         //function for opening page
            }
        });

        logs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openLogsPage(v);         //function for opening page
            }
        });
    }

    public void openTrigPage(View v) {//Not really sure how this work will have to look into it

        Intent intent = new Intent(getActivity(), Trig_page.class);
        startActivity(intent);
    }

    public void openPhysicsPage(View v) {
        Intent intent = new Intent(getActivity(), Physics_page.class);
        startActivity(intent);
    }

    public void openVandAPage(View v) {
        Intent intent = new Intent(getActivity(), Getting_Area_Volume.class);
        startActivity(intent);
    }

    public void openQuadrixPage(View v) {
        Intent intent = new Intent(getActivity(), quadrix.class);
        startActivity(intent);
    }

    public void openLengthandAreaPage(View v) {
        Intent intent = new Intent(getActivity(), Length_Area_page.class);
        startActivity(intent);
    }

    public void openGraphPage(View v) {
        Intent intent = new Intent(getActivity(), Maths_Setting_Graph.class);
        startActivity(intent);
    }

    public void openMathsFunction(View v) {
        Intent intent = new Intent(getActivity(), Maths_Function.class);
        startActivity(intent);
    }

    public void openDifferentiatePage(View v) {
        Intent intent = new Intent(getActivity(), differentiation.class);
        startActivity(intent);
    }

    public void openMathsNumericIntegeration(View v) {
        Intent intent = new Intent(getActivity(), MathsNumericIntegration.class);
        startActivity(intent);
    }

    public void openTwoDShapes(View v) {
        Intent intent = new Intent(getActivity(), Two_d_page.class);
        startActivity(intent);
    }

    public void openThreeDShapes(View v) {
        Intent intent = new Intent(getActivity(), Three_d_page.class);
        startActivity(intent);
    }

    public void openLogsPage(View v) {
        Intent intent = new Intent(getActivity(), Logs_page.class);
        startActivity(intent);
    }
}
