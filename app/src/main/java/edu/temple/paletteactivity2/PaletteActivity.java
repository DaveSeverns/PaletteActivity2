package edu.temple.paletteactivity2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PaletteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

      //  Spinner mySpinner;

        final ConstraintLayout myLayout;
        myLayout = (ConstraintLayout)findViewById(R.id.myLayout);

        // data for adapter to collect
        final ArrayList myList = new ArrayList<String>();
        myList.add("White");
        myList.add("Blue");

        myList.add("Red");
        myList.add("Purple");
        myList.add("Green");
        myList.add("Cyan");
        myList.add("Yellow");
        myList.add("Black");
        myList.add("Magenta");
        myList.add("Olive");
        //instantiate my custom adapter
        MyColorAdapter colorAdapter = new MyColorAdapter(this, myList);

        //mySpinner = (Spinner) findViewById(R.id.spinner);
       // mySpinner.setAdapter(colorAdapter);

        GridView gridView = (GridView) findViewById(R.id.myGridView);
        gridView.setAdapter(colorAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent canvasIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                canvasIntent.putExtra("Color List", myList.get(i).toString());
                startActivity(canvasIntent);
            }
        });
    }
}
