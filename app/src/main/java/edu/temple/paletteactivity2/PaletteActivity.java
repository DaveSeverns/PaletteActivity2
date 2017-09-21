package edu.temple.paletteactivity2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PaletteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        Spinner mySpinner;

        final ConstraintLayout myLayout;
        myLayout = (ConstraintLayout)findViewById(R.id.myLayout);

        // data for adapter to collect
        ArrayList myList = new ArrayList<String>();
        myList.add("White");
        myList.add("Blue");

        myList.add("Red");
        myList.add("Purple");
        myList.add("Green");

        //instantiate my custom adapter
        MyColorAdapter colorAdapter = new MyColorAdapter(this, myList);

        mySpinner = (Spinner) findViewById(R.id.spinner);
        mySpinner.setAdapter(colorAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                myLayout.setBackgroundColor(Color.parseColor((((TextView)view).getText().toString())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
