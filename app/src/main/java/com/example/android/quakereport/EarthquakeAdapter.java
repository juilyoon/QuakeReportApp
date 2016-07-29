package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by juil on 16-07-28.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if existing view is being used, otherwise inflate
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_item, parent, false);
        }

        final Earthquake currentEarthquake = getItem(position);

        // Populate magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude_view);
        magnitudeView.setText(currentEarthquake.getMagnitude() + "");
        // Populate location
        TextView locationView = (TextView) listItemView.findViewById(R.id.location_view);
        locationView.setText(currentEarthquake.getLocation());
        // Populate date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date_view);
        dateView.setText(currentEarthquake.getDate().toString());

        // Return whole list item layout
        return listItemView;
    }
}
