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

    public double getMinFeedPerRevolution(double drillDiameter) {
            if (drillDiameter > 0 && drillDiameter < 3.175) {
                return 0;
            } else if (drillDiameter >= 3.175 && drillDiameter < 6.35) {
                return 0.002;
            } else if (drillDiameter >= 6.35 && drillDiameter < 12.7) {
                return 0.004;
            } else if (drillDiameter >= 12.7 && drillDiameter < 25.4) {
                return 0.008;
            } else if (drillDiameter >= 25.4) {
                return 0.012;
            }
        return -1;
    }

    public double getMaxFeedPerRevolution(double drillDiameter) {
            if (drillDiameter > 0 && drillDiameter < 3.175) {
                return 0.002;
            } else if (drillDiameter >= 3.175 && drillDiameter < 6.35) {
                return 0.004;
            } else if (drillDiameter >= 6.35 && drillDiameter < 12.7) {
                return 0.008;
            } else if (drillDiameter >= 12.7 && drillDiameter < 25.4) {
                return 0.012;
            } else if (drillDiameter >= 25.4) {
                return 0.02;
            }
        return -1;
    }
}
