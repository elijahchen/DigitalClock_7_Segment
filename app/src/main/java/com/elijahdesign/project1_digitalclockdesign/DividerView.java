package com.elijahdesign.project1_digitalclockdesign;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Elijah on 6/22/2016.
 */
public class DividerView extends RelativeLayout {

    public DividerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.divider_template, this, true);

        View dot1 = findViewById(R.id.dividerDotTop);
        View dot2 = findViewById(R.id.dividerDotBottom);

        dot1.setBackgroundColor(MainClockActivity.colorEverything);
        dot2.setBackgroundColor(MainClockActivity.colorEverything);

    }

}