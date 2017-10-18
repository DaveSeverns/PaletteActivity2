package edu.temple.paletteactivity2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class PaletteActivity extends Activity implements PaletteFragment.PaletteInterface {

    FragmentManager fm;
    CanvasFragment canvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        fm = getFragmentManager();
        Fragment paletteFragment = new PaletteFragment();
        canvas = new CanvasFragment();

        fm.beginTransaction().add(R.id.paletteFrame,paletteFragment).commit();

    }

    @Override
    public void changeColor(String color){

        canvas.changeBackGroundToColor(color);

        fm.beginTransaction().replace(R.id.palette_fragment,canvas).commit();

    }
}
//  Spinner mySpinner;

//final ConstraintLayout myLayout;
//myLayout = (ConstraintLayout)findViewById(R.id.myLayout);

/** Resources res = this.getResources();
 final String[] myList = res.getStringArray(R.array.color_array);
 final String[] colorList = res.getStringArray(R.array.parse_color_array);
 **/

//String locale = Locale.getDefault().toString();

//instantiate my custom adapter
//MyColorAdapter colorAdapter = new MyColorAdapter(this, myList,colorList);

//mySpinner = (Spinner) findViewById(R.id.spinner);
// mySpinner.setAdapter(colorAdapter);

//GridView gridView = (GridView) findViewById(R.id.myGridView);
//gridView.setAdapter(colorAdapter);

/**gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
Intent canvasIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
canvasIntent.putExtra("Color List", colorList[i]);
startActivity(canvasIntent);
}
});**/