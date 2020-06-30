package com.example.earthquake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EarthquakesAdapter extends ArrayAdapter<Earthquakes> {

    public EarthquakesAdapter(@NonNull Context context, ArrayAdapter<Earthquakes> earthquakes) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View earthquakeListView = convertView;
        if (earthquakeListView == null) {
            earthquakeListView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Earthquakes currentWord = getItem(position);
        //Find TextViews in the list_item.xml
        TextView tvPower = (TextView)earthquakeListView.findViewById(R.id.tvPower);
        TextView tvPlace = (TextView)earthquakeListView.findViewById(R.id.tvPlace);
        TextView tvDate = (TextView)earthquakeListView.findViewById(R.id.tvDate);

        //Setup TextViews
        tvPower.setText(currentWord.getPower());
        tvPlace.setText(currentWord.getPlace());
        tvDate.setText(currentWord.getDate());

        LinearLayout container = (LinearLayout)earthquakeListView.findViewById(R.id.llContainer);

        return earthquakeListView;
    }

}
