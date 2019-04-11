package com.example.navbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class fragmentHome extends Fragment {

    SearchView searchView;
    ListView listView;
    Context context;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.fragmenthome, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchView = (SearchView)view.findViewById(R.id.search_view);
        listView = (ListView)view.findViewById(R.id.list_view);
        list = new ArrayList<String>();
        context = getActivity();

        list.add("Trigonometry");
        list.add("Fundamental Physical Constraints");
        list.add("Surface Area and Volume");
        list.add("Solve Quadratic Equation");
        list.add("Get Area and Volume");
        list.add("Graphing");
        list.add("Integrate Functions");
        list.add("2-D Shapes");
        list.add("3-D Shapes");
        list.add("Calculate Log");
        list.add("Mechanics");
        list.add("Electricity");
        list.add("Light/Optics");
        list.add("UVAST Calculator");
        list.add("Conservation of Momentum Experiment");
        list.add("Lens Calculator");
        list.add("Ohm Calculator");
        list.add("Calculate Gravity");
        list.add("Guide");
        list.add("Base Units");
        list.add("SI Units");
        //list.add();


        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        listView.setVisibility(View.GONE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if ( adapter.getItem(position)== "Trigonometry") {
                    Intent intent = new Intent(getActivity(), Trig_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Fundamental Physical Constraints") {
                    Intent intent = new Intent(getActivity(), Physics_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Surface Area and Volume") {
                    Intent intent = new Intent(getActivity(), Length_Area_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Solve Quadratic Equation") {
                    Intent intent = new Intent(getActivity(), quadrix.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Get Area and Volume") {
                    Intent intent = new Intent(getActivity(), Getting_Area_Volume.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Graphing") {
                    Intent intent = new Intent(getActivity(), Maths_Function.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Integrate Functions") {
                    Intent intent = new Intent(getActivity(), MathsNumericIntegration.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "2-D Shapes") {
                    Intent intent = new Intent(getActivity(), Two_d_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "3-D Shapes") {
                    Intent intent = new Intent(getActivity(), Three_d_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Calculate Log") {
                    Intent intent = new Intent(getActivity(), Logs_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Mechanics") {
                    Intent intent = new Intent(getActivity(), mechanics_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Electricity") {
                    Intent intent = new Intent(getActivity(), elec_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Light/Optics ") {
                    Intent intent = new Intent(getActivity(), light_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "UVAST Calculator") {
                    Intent intent = new Intent(getActivity(), uvast_calc.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Conservation of Momentum Experiment") {
                    Intent intent = new Intent(getActivity(), conservation_of_momentum.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Lens Calculator") {
                    Intent intent = new Intent(getActivity(), lens_calc.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Ohm Calculator") {
                    Intent intent = new Intent(getActivity(), OhmLawCalc.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position)== "Calculate Gravity") {
                    Intent intent = new Intent(getActivity(), gravity_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Guide") {
                    Intent intent = new Intent(getActivity(), Guide_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "Base Units") {
                    Intent intent = new Intent(getActivity(), Base_Units_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }if (adapter.getItem(position) == "SI Units") {
                    Intent intent = new Intent(getActivity(), SI_Units_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                listView.setVisibility(View.VISIBLE);
                if(list.contains(query)) {
                    adapter.getFilter().filter(query);
                    listView.setVisibility(View.GONE);
                } else {
                    Toast.makeText(getContext(), "No Match Found!", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
