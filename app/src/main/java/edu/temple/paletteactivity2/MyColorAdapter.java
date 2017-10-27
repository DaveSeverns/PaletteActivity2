package edu.temple.paletteactivity2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by davidseverns on 9/21/17.
 */

public class MyColorAdapter extends BaseAdapter {

    Context ctx;
    String[] collection;
    String[] colors;

    HashMap<String,String> colorTranslator;

    //constructor takes in context and data source to adapt
    public MyColorAdapter(Context ctx, String[] collection, String[] colors){
        this.colors = colors;
        this.ctx = ctx;
        this.collection = collection;



    }
    // change

    @Override
    public int getCount() {
        return collection.length;
    }

    @Override
    public Object getItem(int i) {
        return collection[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //Overrode this method to send view to adapter view
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(ctx);
        //Resources colorRes = ctx.getResources();

        textView.setText(collection[i]);
        textView.setTextColor(Color.GRAY);

        textView.setBackgroundColor(Color.parseColor(colors[i]));
        textView.setTextSize(28);
        return textView;
    }

    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}