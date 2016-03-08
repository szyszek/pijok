package com.bj.pijok.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import com.bj.pijok.fragments.DimensionsFragment;
import com.bj.pijok.fragments.StatusFragment;
import com.bj.pijok.fragments.HistoryFragment;
import com.bj.pijok.R;


public class PijokActivity extends FragmentActivity {
    private Button view1Button;
    private Button view2Button;
    private Button view3Button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializeVariables();
        initializeListeners();
        startStatusFragment();
    }

    private void initializeVariables() {
        view1Button = (Button) findViewById(R.id.view1Button);
        view2Button = (Button) findViewById(R.id.view2Button);
        view3Button = (Button) findViewById(R.id.view3Button);
    }

    private void initializeListeners() {
        view1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStatusFragment();
            }
        });

        view2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment1 = new HistoryFragment();

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.fragmentMainView, fragment1);
                transaction.commit();
            }
        });

        Activity activity = this;

        view3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment dimensionsFragment = new DimensionsFragment(activity);

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.fragmentMainView, dimensionsFragment);
                transaction.commit();
            }
        });
    }

    private void startStatusFragment() {
        Fragment statusFragment = new StatusFragment(this);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragmentMainView, statusFragment);
        transaction.commit();
    }
}
