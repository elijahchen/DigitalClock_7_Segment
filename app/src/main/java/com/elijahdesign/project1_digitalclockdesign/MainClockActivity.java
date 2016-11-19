package com.elijahdesign.project1_digitalclockdesign;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.os.Handler;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class MainClockActivity extends AppCompatActivity {

    // Containers for integers upon calling update method
    int currentHour;
    int currentMinute;
    int currentSecond;
    int dayOrNight;
    int globalTime;
    public static String thisTimeZone = "America/New_York";
    public static String prevTimeZone;
    boolean sunlightCheck;
    boolean onOff = true;
    public static boolean militaryTimeCheck;
    public static int colorBackground = Color.BLACK;
    public static int colorEverything = Color.WHITE;


    // Calls a static method to get current instance
    Calendar thisCalendar;

    // Containers for the corresponding Views
    DigitView hourLeft;
    DigitView hourRight;
    DigitView minuteLeft;
    DigitView minuteRight;
    DigitView secondLeft;
    DigitView secondRight;
    View divideThis;
    View divideThisToo;
    TextView thisDay;
    View thisBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clock);

        updateDisplay();

        runHandler();
    }

    Handler handleThis;

    public void runHandler() {
        handleThis = new Handler();
        handleThis.postDelayed(runThis, 1000);
    }

    Runnable runThis = new Runnable() {
        @Override
        public void run() {

            updateDisplay();

            handleThis.postDelayed(runThis, 1000);
        }
    };

    private void updateDisplay(){

        // Retrieves current calendar values
        thisCalendar = Calendar.getInstance();
        thisCalendar.setTimeZone(TimeZone.getTimeZone(thisTimeZone));

        // Instantiates the layout for the numbers
        hourLeft = (DigitView) findViewById(R.id.leftHourView);
        hourRight = (DigitView) findViewById(R.id.rightHourView);
        minuteLeft = (DigitView) findViewById(R.id.leftMinuteView);
        hourLeft = (DigitView) findViewById(R.id.leftHourView);
        hourRight = (DigitView) findViewById(R.id.rightHourView);
        minuteLeft = (DigitView) findViewById(R.id.leftMinuteView);
        minuteRight = (DigitView) findViewById(R.id.rightMinuteView);
        secondLeft = (DigitView) findViewById(R.id.leftSecondView);
        secondRight = (DigitView) findViewById(R.id.rightSecondView);



        //Instantiates the date
        thisDay = (TextView) findViewById(R.id.weekView);

        // Instantiates the layout for the divider
        divideThis = findViewById(R.id.dividerDotTop);
        divideThisToo = findViewById(R.id.dividerDotBottom);

        // Instantiates the background layout
        thisBackground = findViewById(R.id.OuterBound);

        display7Segments();

    }

    public void display7Segments() {
        // Calls for an update
        this.updateAll();

        int leftHourDigit = currentHour / 10;
        int rightHourDigit = currentHour % 10;
        int leftMinuteDigit = currentMinute / 10;
        int rightMinuteDigit = currentMinute % 10;
        int leftSecondDigit = currentSecond / 10;
        int rightSecondDigit = currentSecond % 10;

        hourLeft.lightSwitch(leftHourDigit);
        hourRight.lightSwitch(rightHourDigit);
        minuteLeft.lightSwitch(leftMinuteDigit);
        minuteRight.lightSwitch(rightMinuteDigit);
        secondLeft.lightSwitch(leftSecondDigit);
        secondRight.lightSwitch(rightSecondDigit);

        // Makes the divider blink every two seconds
        if(onOff){
            divideThis.setBackgroundColor(colorEverything);
            divideThisToo.setBackgroundColor(colorEverything);
            onOff = false;
        } else {
            divideThis.setBackgroundColor(Color.TRANSPARENT);
            divideThisToo.setBackgroundColor(Color.TRANSPARENT);
            onOff = true;
        }

        thisDay.setText(displayDate());
        thisDay.setTextColor(colorEverything);

        // Displays image for the background rather than a solid color
        if(colorBackground == Color.TRANSPARENT){
            thisBackground.setBackgroundResource(R.drawable.snowpaper);
        } else {
            thisBackground.setBackgroundColor(colorBackground);
        }

        TextView amToggle = (TextView) findViewById(R.id.amView);
        TextView pmToggle = (TextView) findViewById(R.id.pmView);

        if (sunlightCheck) {
            //DONE: TOGGLE AM
            amToggle.setTextColor(colorEverything);
            pmToggle.setTextColor(Color.DKGRAY);
        } else {
            //DONE: TOGGLE PM
            amToggle.setTextColor(Color.DKGRAY);
            pmToggle.setTextColor(colorEverything);
        }

    }

    private void updateAll() {
        // Gets the current values from java
        currentMinute = thisCalendar.get(Calendar.MINUTE);
        currentSecond = thisCalendar.get(Calendar.SECOND);
        dayOrNight = thisCalendar.get(Calendar.AM_PM);
        globalTime = thisCalendar.get(Calendar.HOUR_OF_DAY);

        // Flags false if not AM
        if (globalTime <= 12) {
            sunlightCheck = true;
        } else {
            sunlightCheck = false;
        }

        // Flags true if 24 hour display is desired
        if (!militaryTimeCheck) {
            currentHour = thisCalendar.get(Calendar.HOUR);
            if (thisCalendar.get(Calendar.HOUR) == 0 && thisCalendar.get(Calendar.HOUR_OF_DAY) == 0 ||
                    thisCalendar.get(Calendar.HOUR_OF_DAY) == 12 ) {
                currentHour = 12;
            }
        } else {
            currentHour = thisCalendar.get(Calendar.HOUR_OF_DAY);
            if (thisCalendar.get(Calendar.HOUR_OF_DAY) == 0) {
                currentHour = 24;
            }
        }

    }

    public String displayDate (){
        Date currentDay = new Date();

        SimpleDateFormat formatThis = new SimpleDateFormat("E,  dd  MMM  yyyy");
        String dateToString = formatThis.format(currentDay);

        return dateToString;
    }

    public void goToSettings(View view) {
        prevTimeZone = thisTimeZone;

        Intent settings = new Intent(this, SettingActivity.class);
        startActivityForResult(settings, 1001);
        // Alternatively from startActivity(new Intent(this, SettingActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // This returns information from the returning activity, this is an alternative to setting a static variable

        super.onActivityResult(requestCode, resultCode, data);
        Log.i("onActivityResult", "requestCode: " + requestCode);


    }



}
