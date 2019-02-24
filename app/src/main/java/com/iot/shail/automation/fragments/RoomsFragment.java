package com.iot.shail.automation.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iot.shail.automation.R;

public class RoomsFragment extends Fragment {

    View roomsFragmentView;

    public RoomsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        roomsFragmentView= inflater.inflate(R.layout.fragment_rooms, container, false);
        return roomsFragmentView;
    }
}
