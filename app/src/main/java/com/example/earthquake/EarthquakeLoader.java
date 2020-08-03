package com.example.earthquake;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquakes>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getSimpleName();

    private String mUrl;

    public EarthquakeLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<Earthquakes> loadInBackground() {
        if(mUrl == null){
            return null;
        }

        List<Earthquakes> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
