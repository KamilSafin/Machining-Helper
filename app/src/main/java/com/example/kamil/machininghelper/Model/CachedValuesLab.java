package com.example.kamil.machininghelper.Model;

import android.content.Context;

/**
 * Created by Kamil Safin on 9/8/2016.
 */
public class CachedValuesLab {

    private Context mContext;
    private static CachedValuesLab sCachedValuesLab;

    //turning
    private double mMachinedDiameter;
    private double mSpindleSpeed;
    private double mCuttingSpeed;
    private double mCuttingDepth;
    private double mFeedPerRevolution;
    private double mSpecificCuttingForce;
    private double mMachinedLength;

    private CachedValuesLab(Context context){
        mContext = context;
    }

    public static CachedValuesLab getCachedValuesLab(Context context) {
        if (sCachedValuesLab == null)
            sCachedValuesLab = new CachedValuesLab(context.getApplicationContext());

        return sCachedValuesLab;
    }

    public double getMachinedDiameter() {
        return mMachinedDiameter;
    }

    public void setMachinedDiameter(double machinedDiameter) {
        mMachinedDiameter = machinedDiameter;
    }

    public double getSpindleSpeed() {
        return mSpindleSpeed;
    }

    public void setSpindleSpeed(double spindleSpeed) {
        mSpindleSpeed = spindleSpeed;
    }

    public double getCuttingSpeed() {
        return mCuttingSpeed;
    }

    public void setCuttingSpeed(double cuttingSpeed) {
        mCuttingSpeed = cuttingSpeed;
    }

    public double getCuttingDepth() {
        return mCuttingDepth;
    }

    public void setCuttingDepth(double cuttingDepth) {
        mCuttingDepth = cuttingDepth;
    }

    public double getFeedPerRevolution() {
        return mFeedPerRevolution;
    }

    public void setFeedPerRevolution(double feedPerRevolution) {
        mFeedPerRevolution = feedPerRevolution;
    }

    public double getSpecificCuttingForce() {
        return mSpecificCuttingForce;
    }

    public void setSpecificCuttingForce(double specificCuttingForce) {
        mSpecificCuttingForce = specificCuttingForce;
    }

    public double getMachinedLength() {
        return mMachinedLength;
    }

    public void setMachinedLength(double machinedLength) {
        mMachinedLength = machinedLength;
    }
}
