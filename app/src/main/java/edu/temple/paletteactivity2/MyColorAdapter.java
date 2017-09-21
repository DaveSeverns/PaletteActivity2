package edu.temple.paletteactivity2;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by davidseverns on 9/21/17.
 */

public class MyColorAdapter extends BaseAdapter {

    Context ctx;
    ArrayList collection;

    //constructor takes in context and data source to adapt
    public MyColorAdapter(Context ctx, ArrayList collection){
        this.ctx = ctx;
        this.collection = collection;

    }

    @Override
    public int getCount() {
        return collection.size();
    }

    @Override
    public Object getItem(int i) {
        return collection.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(ctx);
        textView.setText(collection.get(i).toString());
        textView.setBackgroundColor(Color.parseColor(collection.get(i).toString()));
        textView.setTextSize(28);
        return textView;
    }

    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}