package com.iot.shail.automation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iot.shail.automation.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphFragment extends Fragment {
    View graphFragmentView;

    public GraphFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        graphFragmentView= inflater.inflate(R.layout.fragment_graph, container, false);

        GraphView graph = (GraphView) graphFragmentView.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);
        series.setTitle("Random Curve 1");
        series.setColor(R.color.colorPrimaryDark);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(2);

        return graphFragmentView;
    }
}
