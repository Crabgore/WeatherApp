package com.geekbrains.android_1.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Settings extends AppCompatActivity {

    private RadioGroup tempVal;
    private RadioGroup spdUnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        tempVal = findViewById(R.id.temp);
        spdUnt = findViewById(R.id.wind);
    }

    public void settings_accept(View view) {
        Intent intentResult = new Intent();
        if (((RadioButton)tempVal.getChildAt(0)).isChecked()){
            intentResult.putExtra("TMP", "c");
        } else if (((RadioButton)tempVal.getChildAt(1)).isChecked()){
            intentResult.putExtra("TMP", "f");
        }
        if (((RadioButton)spdUnt.getChildAt(0)).isChecked()){
            intentResult.putExtra("SPD", "ms");
        } else if (((RadioButton)spdUnt.getChildAt(1)).isChecked()){
            intentResult.putExtra("SPD", "kmh");
        }
        setResult(RESULT_OK, intentResult);
        finish();
    }
}
