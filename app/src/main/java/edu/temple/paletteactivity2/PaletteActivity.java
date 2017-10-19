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
    boolean twoPainz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);


        fm = getFragmentManager();
        Fragment paletteFragment = new PaletteFragment();
        canvas = new CanvasFragment();
        if(findViewById(R.id.canvasFrame)!= null){
            twoPainz = true;
        }

        //add fragment to the given frame in activity layout
        fm.beginTransaction().add(R.id.paletteFrame,paletteFragment).commit();

        // if twoPainz is truuuuuu then I just add the fragment to the container
        if(twoPainz){
            fm.beginTransaction().add(R.id.canvasFrame,canvas).commit();
        }

    }

    /*
    * Overriding the method from the palette fragment when the parent is called to do this method in the
    * fragments on item clicked will call this method which will then begin transaction to replace the palette
    * fragment with th canvas fragment and use the canvas fragments public method to change the background of the
    * canvasFrame and replace the palette GridView
    * */
    @Override
    public void changeColor(String color){

        //if not in landscape and on portrait the canvasFrame doesn't exist then the canvas fragment will just
        //replace the palette picker.
        if(!twoPainz){
            // begin transaction, replace instead of add to replace the palette with the canvas fragment
            //addToBackStack will allow us to "undo" and go back to previous state, ie from canvas back to palette
            //instace of the fragment being removed saved to back stack
            fm.beginTransaction().replace(R.id.paletteFrame,canvas).addToBackStack(null).commit();

        }
        //immediately execute the requested commit to load new fragment sooner
        fm.executePendingTransactions();
        canvas.changeBackGroundToColor(color);

    }
}
