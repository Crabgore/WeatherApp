package com.geekbrains.android_1.weatherapp;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityChooserFragment extends Fragment {

    private static final int REQUEST_CODE_WEATHER_ACTIVITY = 42;
    private boolean isLand;
    private String currentPosition;
    private ListView lv;
    private TextView tv;


    public CityChooserFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city_chooser, container, false);

    }

    public void onSaveInstanceState(@NonNull Bundle outstate){
        outstate.getString("CITY", lv.getItemAtPosition(0).toString());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isLand = getResources().getConfiguration().orientation == Configuration. ORIENTATION_LANDSCAPE ;

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (isLand){
                    WeatherFragment detail = (WeatherFragment)getFragmentManager().findFragmentById(R.id.weather);
                    detail = WeatherFragment.create(lv.getItemAtPosition(position).toString());
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.weather, detail);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                } else {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), WeatherActivity.class);
                    intent.putExtra("CITY", lv.getItemAtPosition(position).toString());
                    startActivityForResult(intent, REQUEST_CODE_WEATHER_ACTIVITY);
                }
            }
        };

        lv = (ListView)getActivity().findViewById(R.id.list_item);
        tv = (TextView)getActivity().findViewById(R.id.city);
        lv.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_WEATHER_ACTIVITY){
            getActivity().recreate();
        }
    }
}
