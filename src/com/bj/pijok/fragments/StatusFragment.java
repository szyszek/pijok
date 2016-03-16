package com.bj.pijok.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bj.pijok.R;
import com.bj.pijok.activities.AddEntryActivity;

public class StatusFragment extends Fragment {

    private Button openAddDrinkButton;

    private Activity activity;

    public StatusFragment(Activity activity) {
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.status, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeVariables();
        initializeListeners();
    }

    public void initializeVariables() {
        openAddDrinkButton = (Button) activity.findViewById(R.id.openAddDrinkButton);
    }

    public void initializeListeners() {
        openAddDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAddNewEntryActivity();
            }
        });
    }

    private void startAddNewEntryActivity() {
        Intent intent = new Intent(activity, AddEntryActivity.class);
        startActivity(intent);
    }
}
