package edu.temple.paletteactivity2;


import android.app.Activity;
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

    PaletteInterface parent;
    GridView colorGrid;

    public PaletteFragment() {
        // Required empty public constructor
    }

    //attach fragment to the activity
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            parent = (PaletteInterface) activity;
        }catch(ClassCastException e){
            e.printStackTrace();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_palette, container, false);
        //associate grid view
        //get grid view in fragment layout file and associate it with view
        colorGrid = (GridView) view.findViewById(R.id.fragmentColorGrid);

        //forgot to give context of activity to parent this allows for the
        //fragment to communicate with the parent activity
        //parent = (PaletteInterface) getContext();
        //get the resources associated at the activity level
        Resources res = getActivity().getResources();
        //get array resource for text based on language
        final String[] colorText = res.getStringArray(R.array.color_array);
        //get the array that is always the english or parseable copy
        final String[] colorsToParse = res.getStringArray(R.array.parse_color_array);
        final MyColorAdapter adapter = new MyColorAdapter(getActivity(),colorText, colorsToParse);

        //set the color adapter for the grid view
        colorGrid.setAdapter(adapter);

        colorGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                parent.changeColor(colorsToParse[i]);
            }
        });

        return view;
    }

    public interface PaletteInterface{
        public void changeColor(String color);
    }

}
