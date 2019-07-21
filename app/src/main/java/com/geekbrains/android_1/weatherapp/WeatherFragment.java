package com.geekbrains.android_1.weatherapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    private static final int REQUEST_CODE_SETTINGS = 2;
    private TextView temperature;
    private TextView windSpeedUnits;

    public static WeatherFragment create (String index){
        WeatherFragment f = new WeatherFragment();

        Bundle args = new Bundle();
        args.putString("CITY", index);
        f.setArguments(args);
        return f;
    }

    public String getIndex(){
        String index = getArguments().getString("CITY");
        return index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Button info;
        Button settings;

        View layout = inflater.inflate(R.layout.fragment_weather, container, false);

        final TextView tv = layout.findViewById(R.id.city);
        temperature = layout.findViewById(R.id.temperature);
        windSpeedUnits = layout.findViewById(R.id.windSpeed_units);
        tv.setText(getIndex());

        info = (Button)layout.findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://ru.wikipedia.org/wiki/" + tv.getText().toString();
                Uri uri = Uri.parse(url);
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browser);
            }
        });

        settings = (Button)layout.findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Settings.class);
                startActivityForResult(intent, REQUEST_CODE_SETTINGS);
            }
        });

        return layout;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_SETTINGS) {
            if (resultCode == RESULT_OK) {
                if (data.getExtras().getString("TMP").equals("c")) {
                    temperature.setText("16°c");
                } else temperature.setText("16°f");
                if (data.getExtras().getString("SPD").equals("ms")) {
                    windSpeedUnits.setText("м/с");
                } else windSpeedUnits.setText("км/ч");
            }
        }
    }
}
