package com.example.kamil.machininghelper.Model;

import android.content.Context;

/**
 * Created by Kamil Safin on 9/8/2016.
 */
public class CachedValuesLab {

    private Context mContext;
    private static CachedValuesLab sCachedValuesLab;

    //turning
    private Double mTurningCuttingSpeed;
    private Double mTurningSpindleSpeed;
    private Double mTurningMetalRemovalRate;
    private Double mTurningNetPower;
    private Double mTurningMachiningTime;

    private Double mTurningMachinedDiameter;
    private Double mTurningCuttingDepth;
    private Double mTurningFeedPerRevolution;
    private Double mTurningSpecificCuttingForce;
    private Double mTurningMachinedLength;

    //milling
    private Double mMillingCuttingDiameterAtDepth;
    private Double mMillingTurningSpindleSpeed;
    private Double mMillingTurningCuttingSpeed;
    private Double mMillingTableFeed;
    private Double mMillingNumberOfEffectiveTeeth;
    private Double mMillingFeedTooth;
    private Double mMillingDepthOfCut;
    private Double mMillingWorkingEngagement;
    private Double mMillingNetPowerRequirement;

    //drilling
    private Double mDrillingDrillDiameter;
    private Double mDrillingTurningSpindleSpeed;
    private Double mDrillingTurningCuttingSpeed;
    private Double mDrillingTableFeed;
    private Double mDrillingFeedPerRevolution;
    private Double mDrillingMachiningDrillingLength;
    private Double mDrillingSpecificCuttingForce;
    private Double mDrillingNetPowerRequirement;

    private CachedValuesLab(Context context){
        mContext = context;
    }

    public static CachedValuesLab getCachedValuesLab(Context context) {
        if (sCachedValuesLab == null)
            sCachedValuesLab = new CachedValuesLab(context.getApplicationContext());

        return sCachedValuesLab;
    }

    private void updateTurningValues(){

        if (mTurningMachinedDiameter != null && mTurningSpindleSpeed != null)
            mTurningCuttingSpeed= (mTurningMachinedDiameter * Math.PI * mTurningSpindleSpeed)/1000;

        if (mTurningMachinedDiameter != null && mTurningCuttingSpeed != null)
            mTurningSpindleSpeed = (mTurningCuttingSpeed * 1000) / (Math.PI * mTurningMachinedDiameter);

        if (mTurningCuttingDepth != null && mTurningCuttingSpeed != null && mTurningFeedPerRevolution != null)
            mTurningMetalRemovalRate = (mTurningCuttingDepth * mTurningCuttingSpeed * mTurningFeedPerRevolution);

        if (mTurningCuttingDepth != null && mTurningCuttingSpeed != null && mTurningFeedPerRevolution != null && mTurningSpecificCuttingForce != null)
            mTurningNetPower = (mTurningCuttingDepth * mTurningCuttingSpeed * mTurningFeedPerRevolution * mTurningSpecificCuttingForce) / (60 * 1000);

        if (mTurningMachinedLength != null && mTurningSpindleSpeed != null && mTurningFeedPerRevolution != null)
            mTurningMachiningTime = mTurningMachinedLength / (mTurningSpindleSpeed * mTurningFeedPerRevolution);
    }

    public Double getTurningMachinedDiameter() {
        return mTurningMachinedDiameter;
    }

    public void setTurningMachinedDiameter(Double turningMachinedDiameter) {
        mTurningMachinedDiameter = turningMachinedDiameter;
        updateTurningValues();
    }

    public Double getTurningSpindleSpeed() {
        return mTurningSpindleSpeed;
    }

    public void setTurningSpindleSpeed(Double turningSpindleSpeed) {
        mTurningSpindleSpeed = turningSpindleSpeed;
        updateTurningValues();
    }

    public Double getTurningCuttingSpeed() {
        return mTurningCuttingSpeed;
    }

    public void setTurningCuttingSpeed(Double turningCuttingSpeed) {
        mTurningCuttingSpeed = turningCuttingSpeed;
        updateTurningValues();
    }

    public Double getTurningCuttingDepth() {
        return mTurningCuttingDepth;
    }

    public void setTurningCuttingDepth(Double turningCuttingDepth) {
        mTurningCuttingDepth = turningCuttingDepth;
        updateTurningValues();
    }

    public Double getTurningFeedPerRevolution() {
        return mTurningFeedPerRevolution;
    }

    public void setTurningFeedPerRevolution(Double turningFeedPerRevolution) {
        mTurningFeedPerRevolution = turningFeedPerRevolution;
        updateTurningValues();
    }

    public Double getTurningSpecificCuttingForce() {
        return mTurningSpecificCuttingForce;
    }

    public void setTurningSpecificCuttingForce(Double turningSpecificCuttingForce) {
        mTurningSpecificCuttingForce = turningSpecificCuttingForce;
        updateTurningValues();
    }

    public Double getTurningMachinedLength() {
        return mTurningMachinedLength;
    }

    public void setTurningMachinedLength(Double turningMachinedLength) {
        mTurningMachinedLength = turningMachinedLength;
        updateTurningValues();
    }

    public Double getMillingCuttingDiameterAtDepth() {
        return mMillingCuttingDiameterAtDepth;
    }

    public void setMillingCuttingDiameterAtDepth(Double millingCuttingDiameterAtDepth) {
        mMillingCuttingDiameterAtDepth = millingCuttingDiameterAtDepth;
    }

    public Double getMillingTableFeed() {
        return mMillingTableFeed;
    }

    public void setMillingTableFeed(Double millingTableFeed) {
        mMillingTableFeed = millingTableFeed;
    }

    public Double getMillingNumberOfEffectiveTeeth() {
        return mMillingNumberOfEffectiveTeeth;
    }

    public void setMillingNumberOfEffectiveTeeth(Double millingNumberOfEffectiveTeeth) {
        mMillingNumberOfEffectiveTeeth = millingNumberOfEffectiveTeeth;
    }

    public Double getMillingFeedTooth() {
        return mMillingFeedTooth;
    }

    public void setMillingFeedTooth(Double millingFeedTooth) {
        mMillingFeedTooth = millingFeedTooth;
    }

    public Double getMillingDepthOfCut() {
        return mMillingDepthOfCut;
    }

    public void setMillingDepthOfCut(Double millingDepthOfCut) {
        mMillingDepthOfCut = millingDepthOfCut;
    }

    public Double getMillingWorkingEngagement() {
        return mMillingWorkingEngagement;
    }

    public void setMillingWorkingEngagement(Double millingWorkingEngagement) {
        mMillingWorkingEngagement = millingWorkingEngagement;
    }

    public Double getMillingNetPowerRequirement() {
        return mMillingNetPowerRequirement;
    }

    public void setMillingNetPowerRequirement(Double millingNetPowerRequirement) {
        mMillingNetPowerRequirement = millingNetPowerRequirement;
    }

    public Double getDrillingDrillDiameter() {
        return mDrillingDrillDiameter;
    }

    public void setDrillingDrillDiameter(Double drillingDrillDiameter) {
        mDrillingDrillDiameter = drillingDrillDiameter;
    }

    public Double getDrillingMachiningDrillingLength() {
        return mDrillingMachiningDrillingLength;
    }

    public void setDrillingMachiningDrillingLength(Double drillingMachiningDrillingLength) {
        mDrillingMachiningDrillingLength = drillingMachiningDrillingLength;
    }

    public Double getMillingTurningSpindleSpeed() {
        return mMillingTurningSpindleSpeed;
    }

    public void setMillingTurningSpindleSpeed(Double millingTurningSpindleSpeed) {
        mMillingTurningSpindleSpeed = millingTurningSpindleSpeed;
    }

    public Double getMillingTurningCuttingSpeed() {
        return mMillingTurningCuttingSpeed;
    }

    public void setMillingTurningCuttingSpeed(Double millingTurningCuttingSpeed) {
        mMillingTurningCuttingSpeed = millingTurningCuttingSpeed;
    }

    public Double getDrillingTurningSpindleSpeed() {
        return mDrillingTurningSpindleSpeed;
    }

    public void setDrillingTurningSpindleSpeed(Double drillingTurningSpindleSpeed) {
        mDrillingTurningSpindleSpeed = drillingTurningSpindleSpeed;
    }

    public Double getDrillingTurningCuttingSpeed() {
        return mDrillingTurningCuttingSpeed;
    }

    public void setDrillingTurningCuttingSpeed(Double drillingTurningCuttingSpeed) {
        mDrillingTurningCuttingSpeed = drillingTurningCuttingSpeed;
    }

    public Double getDrillingTableFeed() {
        return mDrillingTableFeed;
    }

    public void setDrillingTableFeed(Double drillingTableFeed) {
        mDrillingTableFeed = drillingTableFeed;
    }

    public Double getDrillingFeedPerRevolution() {
        return mDrillingFeedPerRevolution;
    }

    public void setDrillingFeedPerRevolution(Double drillingFeedPerRevolution) {
        mDrillingFeedPerRevolution = drillingFeedPerRevolution;
    }

    public Double getDrillingSpecificCuttingForce() {
        return mDrillingSpecificCuttingForce;
    }

    public void setDrillingSpecificCuttingForce(Double drillingSpecificCuttingForce) {
        mDrillingSpecificCuttingForce = drillingSpecificCuttingForce;
    }

    public Double getDrillingNetPowerRequirement() {
        return mDrillingNetPowerRequirement;
    }

    public void setDrillingNetPowerRequirement(Double drillingNetPowerRequirement) {
        mDrillingNetPowerRequirement = drillingNetPowerRequirement;
    }

    public Double getTurningMetalRemovalRate() {
        return mTurningMetalRemovalRate;
    }

    public void setTurningMetalRemovalRate(Double turningMetalRemovalRate) {
        mTurningMetalRemovalRate = turningMetalRemovalRate;
    }

    public Double getTurningNetPower() {
        return mTurningNetPower;
    }

    public void setTurningNetPower(Double turningNetPower) {
        mTurningNetPower = turningNetPower;
    }

    public Double getTurningMachiningTime() {
        return mTurningMachiningTime;
    }

    public void setTurningMachiningTime(Double turningMachiningTime) {
        mTurningMachiningTime = turningMachiningTime;
    }
}
