package com.elijahdesign.project1_digitalclockdesign;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Elijah on 6/29/2016.
 */
public class ColorView extends LinearLayout implements View.OnClickListener {

    public ColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.color_background, this, true);

        findViewById(R.id.whiteSpace).setOnClickListener(this);
        findViewById(R.id.yellowSpace).setOnClickListener(this);
        findViewById(R.id.graySpace).setOnClickListener(this);
        findViewById(R.id.blackSpace).setOnClickListener(this);

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.whiteSpace: {
                MainClockActivity.colorBackground = Color.WHITE;
                break;
            }

            case R.id.yellowSpace: {
                MainClockActivity.colorBackground = Color.YELLOW;
                break;
            }

            case R.id.graySpace: {
                MainClockActivity.colorBackground = Color.GRAY;
                break;
            }

            case R.id.blackSpace: {
                MainClockActivity.colorBackground = Color.BLACK;
                break;
            }

        }
    }
}
