package com.bj.pijok.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bj.pijok.R;
import com.bj.pijok.data.DimensionsDataProvider;

public class DimensionsFragment extends Fragment {

    private SeekBar heightSeekBar;
    private SeekBar weightSeekBar;
    private SeekBar ageSeekBar;

    private TextView heightText;
    private TextView weightText;
    private TextView ageText;

    private DimensionsDataProvider dataProvider;

    private Activity activity;

    public DimensionsFragment(Activity activity) {
        this.activity = activity;
        dataProvider = new DimensionsDataProvider(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dimensions, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeVariables();
        initializeListeners();

        dataProvider.saveAge(dataProvider.loadAge());
        dataProvider.saveWeight(dataProvider.loadWeight());
        dataProvider.saveHeight(dataProvider.loadHeight());
    }

    public void initializeVariables() {
        heightSeekBar = (SeekBar) activity.findViewById(R.id.heightSeekBar);
        weightSeekBar = (SeekBar) activity.findViewById(R.id.weightSeekBar);
        ageSeekBar = (SeekBar) activity.findViewById(R.id.ageSeekBar);

        heightText = (TextView) activity.findViewById(R.id.heightText);
        weightText = (TextView) activity.findViewById(R.id.weightText);
        ageText = (TextView) activity.findViewById(R.id.ageText);

        heightSeekBar.setProgress(dataProvider.loadHeight());
        weightSeekBar.setProgress(dataProvider.loadWeight());
        ageSeekBar.setProgress(dataProvider.loadAge());
    }

    public void initializeListeners() {
        heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                dataProvider.saveHeight(progressValue);
                heightText.setText("Height: " + (150 + progressValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                dataProvider.saveWeight(progressValue);
                weightText.setText("Weight: " + (50 + progressValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        ageSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                dataProvider.saveAge(progressValue);
                ageText.setText("Age: " + (18 + progressValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
