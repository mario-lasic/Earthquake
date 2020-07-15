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

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EarthquakesAdapter extends ArrayAdapter<Earthquakes> {

    private static final String String_Separator = " of ";

    public EarthquakesAdapter(@NonNull Context context, ArrayList<Earthquakes> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View earthquakeListView = convertView;
        if (earthquakeListView == null) {
            earthquakeListView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Earthquakes currentEarthquake = getItem(position);

        String originalLocation = currentEarthquake.getPlace();

        String place, offset;

        if (originalLocation.contains(String_Separator)){
            String[] parts = originalLocation.split(String_Separator);
            offset = parts[0] + String_Separator;
            place = parts [1];
        } else {
            offset = getContext().getString(R.string.near_the);
            place = originalLocation;
        }

        //Find TextViews in the list_item.xml
        TextView tvPower = (TextView)earthquakeListView.findViewById(R.id.tvPower);
        TextView tvPlace = (TextView)earthquakeListView.findViewById(R.id.tvPlace);
        TextView tvDate = (TextView)earthquakeListView.findViewById(R.id.tvDate);
        TextView tvTime = (TextView)earthquakeListView.findViewById(R.id.tvTime);
        TextView tvOffset = (TextView)earthquakeListView.findViewById(R.id.tvOffset);

        //Formating date

        Date date = new Date(currentEarthquake.getDate());

        SimpleDateFormat sdfDate = new SimpleDateFormat("DD MMM, yyyy");
        SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm");

        String Date = sdfDate.format(date);
        String Time = sdfTime.format(date);

        //Formating double
        DecimalFormat formatter = new DecimalFormat("0.0");
        String mag = formatter.format(currentEarthquake.getPower());

        //Setup TextViews
        tvPower.setText(mag);
        tvPlace.setText(place);
        tvDate.setText(Date);
        tvTime.setText(Time);
        tvOffset.setText(offset);


        return earthquakeListView;
    }

}
