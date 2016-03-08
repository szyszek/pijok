package com.bj.pijok.data;

import java.io.Serializable;

public class AlcoholEntry implements Serializable {
    static final long serialVersionUID = 2L;

    private AlcoholType alcoholType;
    private int hour;
    private int minute;
    private int volume;
    private int alcoholPercentage;

    public AlcoholEntry(AlcoholType alcoholType) {
        setAlcoholType(alcoholType);
    }

    public AlcoholType getAlcoholType() {
        return alcoholType;
    }

    private void setAlcoholType(AlcoholType alcoholType) {
        this.alcoholType = alcoholType;
        volume = alcoholType.getVolume();
        alcoholPercentage = alcoholType.getAlcoholPercentage();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(int alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public int getCalories() {
        return (int) (getVolume() * (getAlcoholPercentage() * 0.01) * alcoholType.getKcalFactor());
    }
}
