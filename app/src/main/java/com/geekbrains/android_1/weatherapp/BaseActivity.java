package com.geekbrains.android_1.weatherapp;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private final static String NameSharedPreferences = "WEATHERAPP";
    private final static String IsDarkTheme = "IS_DARK_THEME";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isDarkTheme()){
            setTheme(R.style.DarkTheme);
        }
        else setTheme(R.style.AppTheme);
    }

    protected boolean isDarkTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(NameSharedPreferences, MODE_PRIVATE);
        return sharedPreferences.getBoolean(IsDarkTheme, true);
    }

    protected void setDarkTheme(boolean isDarkTheme){
        SharedPreferences sharedPreferences = getSharedPreferences(NameSharedPreferences, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IsDarkTheme, isDarkTheme);
        editor.apply();
    }

}
