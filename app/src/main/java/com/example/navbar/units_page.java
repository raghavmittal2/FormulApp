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

public class units_page extends Fragment {

    private Button Base_units_btn;
    private Button SI_units_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.activity_units_page, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Base_units_btn   =  (Button) view.findViewById(R.id.Base_units_btn);         //declaring buttons
        Base_units_btn.getBackground().setAlpha(64);
        SI_units_btn = (Button) view.findViewById(R.id.SI_unit_btn);
        SI_units_btn.getBackground().setAlpha(64);

        Base_units_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openBaseUnits_page();         //function for opening page
            }
        });

        SI_units_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openSIUnits_page();      //function for opening page
            }
        });
    }

    public void openBaseUnits_page(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(getActivity(), Base_Units_page.class);
        startActivity(intent);
    }

    public void openSIUnits_page(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(getActivity(), SI_Units_page.class);
        startActivity(intent);
    }
}
