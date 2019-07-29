package com.geekbrains.android_1.weatherapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Settings extends BaseActivity {

    private RadioGroup tempVal;
    private RadioGroup spdUnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        tempVal = findViewById(R.id.temp);
        spdUnt = findViewById(R.id.wind);
        SwitchCompat switchTheme = findViewById(R.id.dark_theme_enabler);
        switchTheme.setChecked(isDarkTheme());
        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setDarkTheme(isChecked);
                recreate();
            }
        });
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
