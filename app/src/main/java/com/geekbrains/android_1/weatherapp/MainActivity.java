package com.geekbrains.android_1.weatherapp;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String RADIOGROUP_1_CHECKED_KEY = "is_radiogroup_1_checked";
    private static final String RADIOGROUP_2_CHECKED_KEY = "is_radiogroup_2_checked";
    private RadioButton c;
    private RadioButton f;
    private RadioButton kmh;
    private RadioButton ms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Toast.makeText(getApplicationContext(), "Приложение создано", Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle","Приложение создано" );

        c = findViewById(R.id.C);
        f = findViewById(R.id.F);
        kmh = findViewById(R.id.kmh);
        ms = findViewById(R.id.ms);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Приложение запущено", Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle","Приложение запущено" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Приложение остановлено", Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle","Приложение остановлено" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Приложение закрыто", Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle","Приложение закрыто" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Приложение приостановлено", Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle","Приложение приостановлено" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Приложение восстановлено", Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle","Приложение восстановлено" );
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext(), "Данные приложения сохранены", Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle","Данные приложения сохранены" );
        if (c.isChecked()) {
            outState.putString(RADIOGROUP_1_CHECKED_KEY, "c");
        }
        if (f.isChecked()) {
            outState.putString(RADIOGROUP_1_CHECKED_KEY, "f");
        }
        if (kmh.isChecked()) {
            outState.putString(RADIOGROUP_2_CHECKED_KEY, "kmh");
        }
        if (ms.isChecked()) {
            outState.putString(RADIOGROUP_2_CHECKED_KEY, "ms");
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "Данные приложения восстановлены", Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle","Данные приложения восстановлены" );
        String s1 = savedInstanceState.getString(RADIOGROUP_1_CHECKED_KEY);
        String s2 = savedInstanceState.getString(RADIOGROUP_1_CHECKED_KEY);
        if (s1.equals("c")){
            c.setChecked(true);
        }
        if (s1.equals("f")){
            f.setChecked(true);
        }
        if (s2.equals("kmh")){
            kmh.setChecked(true);
        }
        if (s2.equals("ms")){
            ms.setChecked(true);
        }
    }

}
