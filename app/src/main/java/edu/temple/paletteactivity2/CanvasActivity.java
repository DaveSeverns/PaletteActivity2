package edu.temple.paletteactivity2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;

public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent myIntent = getIntent();
        String color = myIntent.getStringExtra("Color List");

        ConstraintLayout canvasLayout = (ConstraintLayout) findViewById(R.id.canvasLayout);
        canvasLayout.setBackgroundColor(Color.parseColor(color));
    }
}
