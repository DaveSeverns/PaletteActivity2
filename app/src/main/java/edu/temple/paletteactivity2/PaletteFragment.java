package edu.temple.paletteactivity2;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {

    View v;

    public PaletteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Resources res = this.getResources();
        final String[] myList = res.getStringArray(R.array.color_array);
        final String[] colorList = res.getStringArray(R.array.parse_color_array);

        MyColorAdapter colorAdapter = new MyColorAdapter(getActivity(), myList,colorList);

        GridView gridView = (GridView) getView().findViewById(R.id.colorGrid);
        gridView.setAdapter(colorAdapter);



        return inflater.inflate(R.layout.fragment_palette, container, false);
    }

}
