package edu.temple.paletteactivity2;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    FrameLayout frameLayout;

    public CanvasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_canvas, container, false);;
        frameLayout = (FrameLayout) view.findViewById(R.id.canvasFragment);


        return view;
    }

    public void changeBackGroundToColor(String color){
        if(frameLayout != null){
            frameLayout.setBackgroundColor(Color.parseColor(color));
        }
    }

}
