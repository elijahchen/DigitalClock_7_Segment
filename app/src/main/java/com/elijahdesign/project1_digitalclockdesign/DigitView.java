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
public class DigitView extends RelativeLayout {

    // Set on and off colors
    int currentColorOff = Color.DKGRAY;

    public DigitView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.digit, this, true);

    }


    public void lightSwitch(int n) {

        View s1 = findViewById(R.id.segment1);
        View s2 = findViewById(R.id.segment2);
        View s3 = findViewById(R.id.segment3);
        View s4 = findViewById(R.id.segment4);
        View s5 = findViewById(R.id.segment5);
        View s6 = findViewById(R.id.segment6);
        View s7 = findViewById(R.id.segment7);

        switch (n) {
            case 1:
                s1.setBackgroundColor(currentColorOff);
                s2.setBackgroundColor(currentColorOff);
                s3.setBackgroundColor(MainClockActivity.colorEverything);
                s4.setBackgroundColor(currentColorOff);
                s5.setBackgroundColor(currentColorOff);
                s6.setBackgroundColor(MainClockActivity.colorEverything);
                s7.setBackgroundColor(currentColorOff);
                break;
            case 2:
                s1.setBackgroundColor(MainClockActivity.colorEverything);
                s2.setBackgroundColor(currentColorOff);
                s3.setBackgroundColor(MainClockActivity.colorEverything);
                s4.setBackgroundColor(MainClockActivity.colorEverything);
                s5.setBackgroundColor(MainClockActivity.colorEverything);
                s6.setBackgroundColor(currentColorOff);
                s7.setBackgroundColor(MainClockActivity.colorEverything);
                break;
            case 3:
                s1.setBackgroundColor(MainClockActivity.colorEverything);
                s2.setBackgroundColor(currentColorOff);
                s3.setBackgroundColor(MainClockActivity.colorEverything);
                s4.setBackgroundColor(MainClockActivity.colorEverything);
                s5.setBackgroundColor(currentColorOff);
                s6.setBackgroundColor(MainClockActivity.colorEverything);
                s7.setBackgroundColor(MainClockActivity.colorEverything);
                break;
            case 4:
                s1.setBackgroundColor(currentColorOff);
                s2.setBackgroundColor(MainClockActivity.colorEverything);
                s3.setBackgroundColor(MainClockActivity.colorEverything);
                s4.setBackgroundColor(MainClockActivity.colorEverything);
                s5.setBackgroundColor(currentColorOff);
                s6.setBackgroundColor(MainClockActivity.colorEverything);
                s7.setBackgroundColor(currentColorOff);
                break;
            case 5:
                s1.setBackgroundColor(MainClockActivity.colorEverything);
                s2.setBackgroundColor(MainClockActivity.colorEverything);
                s3.setBackgroundColor(currentColorOff);
                s4.setBackgroundColor(MainClockActivity.colorEverything);
                s5.setBackgroundColor(currentColorOff);
                s6.setBackgroundColor(MainClockActivity.colorEverything);
                s7.setBackgroundColor(MainClockActivity.colorEverything);
                break;
            case 6:
                s1.setBackgroundColor(MainClockActivity.colorEverything);
                s2.setBackgroundColor(MainClockActivity.colorEverything);
                s3.setBackgroundColor(currentColorOff);
                s4.setBackgroundColor(MainClockActivity.colorEverything);
                s5.setBackgroundColor(MainClockActivity.colorEverything);
                s6.setBackgroundColor(MainClockActivity.colorEverything);
                s7.setBackgroundColor(MainClockActivity.colorEverything);
                break;
            case 7:
                s1.setBackgroundColor(MainClockActivity.colorEverything);
                s2.setBackgroundColor(currentColorOff);
                s3.setBackgroundColor(MainClockActivity.colorEverything);
                s4.setBackgroundColor(currentColorOff);
                s5.setBackgroundColor(currentColorOff);
                s6.setBackgroundColor(MainClockActivity.colorEverything);
                s7.setBackgroundColor(currentColorOff);
                break;
            case 8:
                s1.setBackgroundColor(MainClockActivity.colorEverything);
                s2.setBackgroundColor(MainClockActivity.colorEverything);
                s3.setBackgroundColor(MainClockActivity.colorEverything);
                s4.setBackgroundColor(MainClockActivity.colorEverything);
                s5.setBackgroundColor(MainClockActivity.colorEverything);
                s6.setBackgroundColor(MainClockActivity.colorEverything);
                s7.setBackgroundColor(MainClockActivity.colorEverything);
                break;
            case 9:
                s1.setBackgroundColor(MainClockActivity.colorEverything);
                s2.setBackgroundColor(MainClockActivity.colorEverything);
                s3.setBackgroundColor(MainClockActivity.colorEverything);
                s4.setBackgroundColor(MainClockActivity.colorEverything);
                s5.setBackgroundColor(currentColorOff);
                s6.setBackgroundColor(MainClockActivity.colorEverything);
                s7.setBackgroundColor(MainClockActivity.colorEverything);
                break;
            default:
                s1.setBackgroundColor(MainClockActivity.colorEverything);
                s2.setBackgroundColor(MainClockActivity.colorEverything);
                s3.setBackgroundColor(MainClockActivity.colorEverything);
                s4.setBackgroundColor(currentColorOff);
                s5.setBackgroundColor(MainClockActivity.colorEverything);
                s6.setBackgroundColor(MainClockActivity.colorEverything);
                s7.setBackgroundColor(MainClockActivity.colorEverything);
                break;
        }
    }


}
