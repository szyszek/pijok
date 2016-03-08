package com.bj.pijok.data;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.prefs.Preferences;

public class DimensionsDataProvider {

    private final static int DEFAULT_AGE_PROGRESS = 22;
    private final static int DEFAULT_WEIGHT_PROGRESS = 25;
    private final static int DEFAULT_HEIGHT_PROGRESS = 25;

    private final static String WEIGHT = "weight";
    private final static String HEIGHT = "height";
    private final static String AGE = "age";

    private final static String DIMENSIONS_PREFERENCES = "dimensions";

    private Activity activity;

    public DimensionsDataProvider(Activity activity) {
        this.activity = activity;
    }

    public int loadWeight() {
        return loadInt(WEIGHT, DEFAULT_WEIGHT_PROGRESS);
    }

    public void saveWeight(int weight) {
        saveInt(WEIGHT, weight);
    }

    public int loadHeight() {
        return loadInt(HEIGHT, DEFAULT_HEIGHT_PROGRESS);
    }

    public void saveHeight(int height) {
        saveInt(HEIGHT, height);
    }

    public int loadAge() {
        return loadInt(AGE, DEFAULT_AGE_PROGRESS);
    }

    public void saveAge(int age) {
        saveInt(AGE, age);
    }

    public boolean isDataProvided() {
        SharedPreferences pref = activity.getSharedPreferences(DIMENSIONS_PREFERENCES, Context.MODE_PRIVATE);
        return pref.contains(WEIGHT);
    }

    private int loadInt(String key, int defaultValue) {
        SharedPreferences pref = activity.getSharedPreferences(DIMENSIONS_PREFERENCES, Context.MODE_PRIVATE);
        return pref.getInt(key, defaultValue);
    }

    private void saveInt(String key, int value) {
        SharedPreferences pref = activity.getSharedPreferences(DIMENSIONS_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }
}
