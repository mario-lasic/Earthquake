package com.example.earthquake;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Earthquakes>> {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    private static final String USGS_REQUSET_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";
    private EarthquakesAdapter mAdapter;
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private TextView mEmptyStateTextView;
    private ListView earthquakeListView;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute(USGS_REQUSET_URL);*/
        LoaderManager loaderManager = getSupportLoaderManager();
        loaderManager.initLoader(EARTHQUAKE_LOADER_ID,null,this);
        mAdapter = new EarthquakesAdapter(this, new ArrayList<Earthquakes>());
        mEmptyStateTextView = (TextView)findViewById(R.id.empty_view);
        earthquakeListView = (ListView) findViewById(R.id.list);
        earthquakeListView.setEmptyView(mEmptyStateTextView);

    }

    @NonNull
    @Override
    public Loader<List<Earthquakes>> onCreateLoader(int id, @Nullable Bundle args) {
        return new EarthquakeLoader(this,USGS_REQUSET_URL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Earthquakes>> loader, List<Earthquakes> earthquakes) {
        mAdapter.clear();

        mProgressBar = (ProgressBar)findViewById(R.id.loading_spinner);
        mProgressBar.setVisibility(View.INVISIBLE);
        if (earthquakes != null && !earthquakes.isEmpty()) {
            mAdapter.addAll(earthquakes);
            updateUi(earthquakes);
        }
        mEmptyStateTextView.setText(R.string.no_earthquake);

    }



    @Override
    public void onLoaderReset(@NonNull Loader<List<Earthquakes>> loader) {
        mAdapter.clear();
    }

    /** private class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Earthquakes>> {
            @Override
            protected List<Earthquakes> doInBackground(String... urls) {
                if (urls.length < 1 || urls[0] == null) {
                    return null;
                }
                List<Earthquakes> earthquakes = QueryUtils.fetchEarthquakeData(urls[0]);
                return earthquakes;

            }

            protected void onPostExecute(List<Earthquakes> earthquakes) {
                mAdapter.clear();

                if (earthquakes != null && !earthquakes.isEmpty()) {
                    mAdapter.addAll(earthquakes);


                    }
                }
            }
     **/

    private void updateUi(List<Earthquakes> earthquakes) {
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(mAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Earthquakes currentEarthquake = mAdapter.getItem(position);

                Uri earthquakeURI = Uri.parse(currentEarthquake.getUrl());

                Intent intent = new Intent(Intent.ACTION_VIEW, earthquakeURI);
                startActivity(intent);

            }
        });
    }
}
