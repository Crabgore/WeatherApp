package com.geekbrains.android_1.weatherapp;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView city;
    TextView windSpeed;
    TextView windSpeedValue;
    TextView windSpeedUnits;
    TextView pressure;
    TextView pressureValue;
    TextView pressureUnits;
    TextView temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);
        windSpeed = findViewById(R.id.windSpeed);
        windSpeedValue = findViewById(R.id.windSpeed_value);
        windSpeedUnits = findViewById(R.id.windSpeed_units);
        pressure = findViewById(R.id.pressure);
        pressureValue = findViewById(R.id.pressure_value);
        pressureUnits = findViewById(R.id.pressure_units);
        temperature = findViewById(R.id.temperature);

    }

    public void city_choose(View view) {
        Intent intent = new Intent(MainActivity.this, CityChooser.class);
        startActivityForResult(intent, 1);
    }

    public void settings(View view) {
        Intent intent = new Intent(MainActivity.this, Settings.class);
        startActivityForResult(intent, 2);
    }

    public void infoBtn(View view) {
        String url = "https://ru.wikipedia.org/wiki/" + city.getText().toString();
        Uri uri = Uri.parse(url);
        Intent browser = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(browser);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1){
            city.setText(data.getStringExtra("CITY"));
            if (!data.getExtras().getBoolean("WINDSPEED")){
                windSpeed.setVisibility(View.INVISIBLE);
                windSpeedValue.setVisibility(View.INVISIBLE);
                windSpeedUnits.setVisibility(View.INVISIBLE);
            } else {
                windSpeed.setVisibility(View.VISIBLE);
                windSpeedValue.setVisibility(View.VISIBLE);
                windSpeedUnits.setVisibility(View.VISIBLE);
            }
            if (!data.getExtras().getBoolean("PRESSURE")){
                pressure.setVisibility(View.INVISIBLE);
                pressureValue.setVisibility(View.INVISIBLE);
                pressureUnits.setVisibility(View.INVISIBLE);
            } else {
                pressure.setVisibility(View.VISIBLE);
                pressureValue.setVisibility(View.VISIBLE);
                pressureUnits.setVisibility(View.VISIBLE);
            }
        }
        if (requestCode == 2){
            if (data.getExtras().getString("TMP").equals("c")){
                temperature.setText("16°c");
            } else temperature.setText("16°f");
            if (data.getExtras().getString("SPD").equals("ms")){
                windSpeedUnits.setText("м/с");
            } else  windSpeedUnits.setText("км/ч");
        }
    }
}
