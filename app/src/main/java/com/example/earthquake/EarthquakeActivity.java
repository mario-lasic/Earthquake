package com.example.earthquake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        // Create a fake list of earthquake locations.
        final ArrayList<Earthquakes> earthquakes = new ArrayList<Earthquakes>();
        earthquakes.add(new Earthquakes("San Francisco","Feb 2, 2016", "7.2"));
        earthquakes.add(new Earthquakes("London","July 20, 2015", "6.1"));
        earthquakes.add(new Earthquakes("Tokyo","Nov 10, 2014", "3.9"));
        earthquakes.add(new Earthquakes("Mexico City","May 3, 2014", "5.4"));
        earthquakes.add(new Earthquakes("Moscow","Jan 31, 2013", "2.8"));
        earthquakes.add(new Earthquakes("Rio de Jeneiro","Aug 19, 2012", "4.9"));
        earthquakes.add(new Earthquakes("Paris","Oct 30, 2011", "1.6"));


        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        //Create adapter
        EarthquakesAdapter adapter = new EarthquakesAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

    }
}
