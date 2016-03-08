package com.bj.pijok.data;

import java.util.ArrayList;
import java.util.List;

public class AlcoholTypeProvider {
    private static List<AlcoholType> alcoholTypes;

    static {
        alcoholTypes = new ArrayList<>();
        AlcoholType at = new AlcoholType();
        at.setImage("piwo");
        at.setAlcoholPercentage(50);
        at.setKcalFactor(6);
        at.setVolume(50);
        alcoholTypes.add(at);

        at = new AlcoholType();
        at.setImage("cydr");
        at.setAlcoholPercentage(50);
        at.setKcalFactor(6);
        at.setVolume(33);
        alcoholTypes.add(at);

        at = new AlcoholType();
        at.setImage("wino");
        at.setAlcoholPercentage(120);
        at.setKcalFactor(6);
        at.setVolume(15);
        alcoholTypes.add(at);

        at = new AlcoholType();
        at.setImage("drink");
        at.setAlcoholPercentage(40);
        at.setKcalFactor(8);
        at.setVolume(4);
        alcoholTypes.add(at);

        at = new AlcoholType();
        at.setImage("szot");
        at.setAlcoholPercentage(40);
        at.setKcalFactor(8);
        at.setVolume(4);
        alcoholTypes.add(at);
    }

    public static List<AlcoholType> getAlcoholTypes() {
        return alcoholTypes;
    }
}
