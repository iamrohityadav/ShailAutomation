package com.iot.shail.automation.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iot.shail.automation.R;

public class ThemesFragment extends Fragment {

    View themesFragmentView;

    public ThemesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        themesFragmentView= inflater.inflate(R.layout.fragment_themes, container, false);
        return themesFragmentView;
    }
}
