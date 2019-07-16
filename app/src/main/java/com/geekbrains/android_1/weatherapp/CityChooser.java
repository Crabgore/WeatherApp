package com.geekbrains.android_1.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;

public class CityChooser extends AppCompatActivity {

    private Spinner spinner;
    private CheckBox windSpeed;
    private CheckBox pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_chooser);

        spinner = findViewById(R.id.citySpinner);
        windSpeed = findViewById(R.id.windSpeed);
        pressure = findViewById(R.id.pressure);
    }

    public void city_choose_accept(View view) {
        Intent intentResult = new Intent();
        intentResult.putExtra("CITY", spinner.getSelectedItem().toString());
        intentResult.putExtra("WINDSPEED", windSpeed.isChecked());
        intentResult.putExtra("PRESSURE", pressure.isChecked());
        setResult(RESULT_OK, intentResult);
        finish();
    }
}
