package com.example.kamil.machininghelper.Model;


import java.io.Serializable;

public class Material implements Serializable {

    private String mName;
    private double mMinCuttingSpeed;
    private double mMaxCuttingSpeed;
    private double mMinFeedPerTooth;
    private double mMaxFeedPerTooth;

    public Material(String name, double minCuttingSpeed, double maxCuttingSpeed, double minFeedPerTooth, double maxFeedPerTooth) {
        mName = name;
        mMinCuttingSpeed = minCuttingSpeed;
        mMaxCuttingSpeed = maxCuttingSpeed;
        mMinFeedPerTooth = minFeedPerTooth;
        mMaxFeedPerTooth = maxFeedPerTooth;
    }

    public String getName() {
        return mName;
    }

    public double getMinCuttingSpeed() {
        return mMinCuttingSpeed;
    }

    public double getMaxCuttingSpeed() {
        return mMaxCuttingSpeed;
    }

    public double getMinFeedPerTooth() {
        return mMinFeedPerTooth;
    }

    public double getMaxFeedPerTooth() {
        return mMaxFeedPerTooth;
    }
}
