package com.iot.shail.automation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iot.shail.automation.R;
import com.iot.shail.automation.fragments.GraphFragment;

public class ReportsFragment extends Fragment {

    View reportFragmentView;

    public ReportsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        reportFragmentView= inflater.inflate(R.layout.fragment_reports, container, false);

        reportFragmentView.findViewById(R.id.generate_report_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               GraphFragment graphFragment = new GraphFragment();
               setFragment(graphFragment);

            }
        });

        return reportFragmentView;
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
