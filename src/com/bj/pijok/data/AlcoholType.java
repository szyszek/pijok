package com.bj.pijok.data;

public class AlcoholType {
    private String image;
    private int volume;
    private int alcoholPercentage;
    private int kcalFactor;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getKcalFactor() {
        return kcalFactor;
    }

    public void setKcalFactor(int kcalFactor) {
        this.kcalFactor = kcalFactor;
    }
}
