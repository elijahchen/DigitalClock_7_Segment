package com.elijahdesign.project1_digitalclockdesign;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.TimeZone;

public class SettingActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // Allows the usage of buttons
        Button colorItGreen = (Button) findViewById(R.id.greenButton);
        colorItGreen.setOnClickListener(this);
        Button colorItRed = (Button) findViewById(R.id.redButton);
        colorItRed.setOnClickListener(this);
        Button colorItPurple = (Button) findViewById(R.id.purpleButton);
        colorItPurple.setOnClickListener(this);
        Button colorItWhite = (Button) findViewById(R.id.whiteButton);
        colorItWhite.setOnClickListener(this);
        // NOTE: Background color uses interactive views
        Button customBg = (Button) findViewById(R.id.nobgButton);
        customBg.setOnClickListener(this);

        // ArrayAdapter is used to create an interactive list of time zones
        Spinner spinThis = (Spinner) findViewById(R.id.timeZoneSpinner);
        spinThis.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> thisAdapter = ArrayAdapter.createFromResource(this, R.array.gmtLabel, android.R.layout.simple_spinner_dropdown_item);
        spinThis.setAdapter(thisAdapter);

    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.greenButton: {
                MainClockActivity.colorEverything = Color.GREEN;
                break;
            }

            case R.id.redButton: {
                MainClockActivity.colorEverything = Color.RED;
                break;
            }

            case R.id.purpleButton: {
                MainClockActivity.colorEverything = Color.MAGENTA;
                break;
            }

            case R.id.whiteButton: {
                MainClockActivity.colorEverything = Color.WHITE;
                break;
            }

            case R.id.nobgButton: {
                MainClockActivity.colorBackground = Color.TRANSPARENT;
                break;
            }

        }
    }

    // Switch back to main activity
    public void goToMain(View view) {
        Switch militarySwitch = (Switch) findViewById(R.id.militarySwitch);

        if (militarySwitch.isChecked()) {
            MainClockActivity.militaryTimeCheck = true;
        } else {
            MainClockActivity.militaryTimeCheck = false;
        }

        finish();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        MainClockActivity.thisTimeZone = parent.getItemAtPosition(position).toString().trim();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        MainClockActivity.thisTimeZone = MainClockActivity.prevTimeZone;

    }

}
