package com.iot.shail.automation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iot.shail.automation.R;

public class LocationFragment extends Fragment {

    View locationFragmentView;

    public LocationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        locationFragmentView= inflater.inflate(R.layout.fragment_location, container, false);
        return locationFragmentView;
    }
}
