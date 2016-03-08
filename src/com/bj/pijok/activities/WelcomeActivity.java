package com.bj.pijok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import com.bj.pijok.R;
import com.bj.pijok.data.DimensionsDataProvider;
import com.bj.pijok.fragments.DimensionsFragment;

public class WelcomeActivity extends FragmentActivity {

    private Button okButton;

    private DimensionsDataProvider dimensionsDataProvider = new DimensionsDataProvider(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (dimensionsDataProvider.isDataProvided()) {
            startMainActivity();
        } else {
            setContentView(R.layout.welcome);
            setupDimensionsFragment();
            initializeVariables();
            initializeListeners();
        }
    }

    private void setupDimensionsFragment() {
        Fragment dimensionsFragment = new DimensionsFragment(this);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragmentWelcomeView, dimensionsFragment);
        transaction.commit();
    }

    private void initializeVariables() {
        okButton = (Button) findViewById(R.id.okButton);
    }

    private void initializeListeners() {
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, PijokActivity.class);
        startActivity(intent);
    }
}
