package com.example.gb_calc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initButtons();

    }

    private void initButtons() {
        initButtonLightDarkMode();
        iniButtonBack();

    }

    private void iniButtonBack() {
        Button buttonReturn = findViewById(R.id.buttonBack);
        buttonReturn.setOnClickListener(v -> finish());
    }

    private void initButtonLightDarkMode() {
        Button buttonDarkLightTheme = findViewById(R.id.buttonLightDarkMode);
        buttonDarkLightTheme.setOnClickListener(v -> {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        });
    }


}