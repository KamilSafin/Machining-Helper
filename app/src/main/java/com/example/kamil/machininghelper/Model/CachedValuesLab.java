package com.example.kamil.machininghelper.Model;

import android.content.Context;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Kamil Safin on 9/8/2016.
 */
public class CachedValuesLab {

    private Context mContext;
    private static CachedValuesLab sCachedValuesLab;

    //turning
    private BigDecimal mTurningCuttingSpeed;
    private BigDecimal mTurningSpindleSpeed;
    private BigDecimal mTurningMetalRemovalRate;
    private BigDecimal mTurningNetPowerRequirement;
    private BigDecimal mTurningMachiningTime;

    private BigDecimal mTurningMachinedDiameter;
    private BigDecimal mTurningCuttingDepth;
    private BigDecimal mTurningFeedPerRevolution;
    private BigDecimal mTurningSpecificCuttingForce;
    private BigDecimal mTurningMachinedLength;

    //milling
    private BigDecimal mMillingCuttingSpeed;
    private BigDecimal mMillingSpindleSpeed;
    private BigDecimal mMillingFeedTooth;
    private BigDecimal mMillingTableFeed;
    private BigDecimal mMillingMetalRemovalRate;
    private BigDecimal mMillingNetPowerRequirement;
    private BigDecimal mMillingTorque;

    private BigDecimal mMillingCuttingDiameterAtDepth;
    private BigDecimal mMillingNumberOfEffectiveTeeth;
    private BigDecimal mMillingDepthOfCut;
    private BigDecimal mMillingWorkingEngagement;
    private BigDecimal mMillingSpecificCuttingForce;

    //drilling
    private BigDecimal mDrillingDrillDiameter;
    private BigDecimal mDrillingSpindleSpeed;
    private BigDecimal mDrillingCuttingSpeed;
    private BigDecimal mDrillingTableFeed;
    private BigDecimal mDrillingFeedPerRevolution;
    private BigDecimal mDrillingMachiningDrillingLength;
    private BigDecimal mDrillingSpecificCuttingForce;
    private BigDecimal mDrillingNetPowerRequirement;

    private CachedValuesLab(Context context){
        mContext = context;
    }

    public static CachedValuesLab getCachedValuesLab(Context context) {
        if (sCachedValuesLab == null)
            sCachedValuesLab = new CachedValuesLab(context.getApplicationContext());

        return sCachedValuesLab;
    }

    public void updateTurningValues(int itemPos){
        switch (itemPos){
            case 0:
                if (mTurningMachinedDiameter != null && mTurningSpindleSpeed != null) {
                    mTurningCuttingSpeed = (mTurningMachinedDiameter.multiply(mTurningSpindleSpeed).multiply(new BigDecimal(Math.PI))).divide(new BigDecimal(1000), 10, RoundingMode.HALF_UP);
                } else if ((mTurningMachinedDiameter != null && mTurningSpindleSpeed == null) || (mTurningMachinedDiameter == null && mTurningSpindleSpeed != null)){
                    mTurningCuttingSpeed = mTurningCuttingSpeed == null ? null : mTurningCuttingSpeed;
                }
                break;
            case 1:
                if (mTurningMachinedDiameter != null && mTurningCuttingSpeed != null) {
                    mTurningSpindleSpeed = (mTurningCuttingSpeed.multiply(new BigDecimal(1000))).divide(mTurningMachinedDiameter.multiply(new BigDecimal(Math.PI)), 10, RoundingMode.HALF_UP);
                } else if ((mTurningMachinedDiameter != null && mTurningCuttingSpeed == null) || (mTurningMachinedDiameter == null && mTurningCuttingSpeed != null)){
                    mTurningSpindleSpeed = mTurningSpindleSpeed == null ? null : mTurningSpindleSpeed;
                }
                break;
            case 2:
                if (mTurningCuttingDepth != null && mTurningCuttingSpeed != null && mTurningFeedPerRevolution != null) {
                    mTurningMetalRemovalRate = (mTurningCuttingDepth.multiply(mTurningCuttingSpeed).multiply(mTurningFeedPerRevolution));
                }
                break;
            case 3:
                if (mTurningCuttingDepth != null && mTurningCuttingSpeed != null && mTurningFeedPerRevolution != null && mTurningSpecificCuttingForce != null) {
                    mTurningNetPowerRequirement = (mTurningCuttingDepth.multiply(mTurningCuttingSpeed).multiply(mTurningFeedPerRevolution).multiply(mTurningSpecificCuttingForce)).divide(new BigDecimal(60 * 1000), 10, RoundingMode.HALF_UP);
                }

                break;
            case 4:
                if (mTurningMachinedLength != null && mTurningSpindleSpeed != null && mTurningFeedPerRevolution != null) {
                    mTurningMachiningTime = mTurningMachinedLength.divide(mTurningSpindleSpeed.multiply(mTurningFeedPerRevolution), 10, RoundingMode.HALF_UP);
                }
                break;
        }
    }

    public void updateMillingValues(int itemPos){
        switch (itemPos){
            case 0:
                if (mMillingCuttingDiameterAtDepth != null && mMillingSpindleSpeed != null) {
                    mMillingCuttingSpeed = (mMillingCuttingDiameterAtDepth.multiply(new BigDecimal(Math.PI)).multiply(mMillingSpindleSpeed)).divide(new BigDecimal(1000), 10, RoundingMode.HALF_UP);
                } else if ((mMillingCuttingDiameterAtDepth == null && mMillingSpindleSpeed != null) || (mMillingCuttingDiameterAtDepth != null && mMillingSpindleSpeed == null)){
                    mMillingCuttingSpeed = mMillingCuttingSpeed == null ? null : mMillingCuttingSpeed;
                }
                break;
            case 1:
                if (mMillingCuttingDiameterAtDepth != null && mMillingCuttingSpeed != null) {
                    mMillingSpindleSpeed = (mMillingCuttingSpeed.multiply(new BigDecimal(1000))).divide((new BigDecimal(Math.PI)).multiply(mMillingCuttingDiameterAtDepth), 10, RoundingMode.HALF_UP);
                } else if ((mMillingCuttingDiameterAtDepth == null && mMillingCuttingSpeed != null) || (mMillingCuttingDiameterAtDepth != null && mMillingCuttingSpeed == null)){
                    mMillingSpindleSpeed = mMillingSpindleSpeed == null ? null : mMillingSpindleSpeed;
                }
                break;
            case 2:
                if(mMillingTableFeed != null && mMillingSpindleSpeed != null && mMillingNumberOfEffectiveTeeth != null) {
                    mMillingFeedTooth = mMillingTableFeed.divide((mMillingSpindleSpeed.multiply(mMillingNumberOfEffectiveTeeth)), 10, RoundingMode.HALF_UP);
                } else if((mMillingTableFeed != null && mMillingSpindleSpeed == null && mMillingNumberOfEffectiveTeeth == null) || (mMillingTableFeed == null && mMillingSpindleSpeed != null && mMillingNumberOfEffectiveTeeth == null) || (mMillingTableFeed == null && mMillingSpindleSpeed == null && mMillingNumberOfEffectiveTeeth != null)){
                    mMillingFeedTooth = mMillingFeedTooth == null ? null : mMillingFeedTooth;
                }
                break;
            case 3:
                if (mMillingFeedTooth != null && mMillingSpindleSpeed != null && mMillingNumberOfEffectiveTeeth != null) {
                    mMillingTableFeed = mMillingFeedTooth.multiply(mMillingSpindleSpeed).multiply(mMillingNumberOfEffectiveTeeth);
                } else if ((mMillingFeedTooth != null && mMillingSpindleSpeed == null && mMillingNumberOfEffectiveTeeth == null) || (mMillingFeedTooth == null && mMillingSpindleSpeed != null && mMillingNumberOfEffectiveTeeth == null) || (mMillingFeedTooth == null && mMillingSpindleSpeed == null && mMillingNumberOfEffectiveTeeth != null)){
                    mMillingTableFeed = mMillingTableFeed == null ? null : mMillingTableFeed;
                }
                break;
            case 4:
                if (mMillingDepthOfCut != null && mMillingWorkingEngagement != null && mMillingTableFeed != null) {
                    mMillingMetalRemovalRate = (mMillingDepthOfCut.multiply(mMillingWorkingEngagement).multiply(mMillingTableFeed)).divide(new BigDecimal(1000));
                }
                break;
            case 5:
                if (mMillingDepthOfCut != null && mMillingWorkingEngagement != null && mMillingTableFeed != null && mMillingSpecificCuttingForce != null) {
                    mMillingNetPowerRequirement = (mMillingDepthOfCut.multiply(mMillingWorkingEngagement).multiply(mMillingTableFeed).multiply(mMillingSpecificCuttingForce)).divide(new BigDecimal(60 * 1_000_000), 10, RoundingMode.HALF_UP);
                }
                break;
            case 6:
                if (mMillingNetPowerRequirement != null && mMillingSpindleSpeed != null) {
                    mMillingTorque = (mMillingNetPowerRequirement.multiply(new BigDecimal(30 * 1000))).divide((new BigDecimal(Math.PI)).multiply(mMillingSpindleSpeed), 10, RoundingMode.HALF_UP);
                }
                break;
        }
    }

    public void removeTurningValues(){
        mTurningCuttingSpeed = null;
        mTurningSpindleSpeed = null;
        mTurningMetalRemovalRate = null;
        mTurningNetPowerRequirement = null;
        mTurningMachiningTime = null;
        mTurningMachinedDiameter = null;
        mTurningCuttingDepth = null;
        mTurningFeedPerRevolution = null;
        mTurningSpecificCuttingForce = null;
        mTurningMachinedLength = null;
    }

    public void removeMillingValues(){
        mMillingCuttingSpeed = null;
        mMillingSpindleSpeed = null;
        mMillingFeedTooth = null;
        mMillingTableFeed = null;
        mMillingMetalRemovalRate = null;
        mMillingNetPowerRequirement = null;
        mMillingTorque = null;
        mMillingCuttingDiameterAtDepth = null;
        mMillingNumberOfEffectiveTeeth = null;
        mMillingDepthOfCut = null;
        mMillingWorkingEngagement = null;
    }

    public BigDecimal getTurningCuttingSpeed() {
        return mTurningCuttingSpeed;
    }

    public void setTurningCuttingSpeed(BigDecimal turningCuttingSpeed) {
        mTurningCuttingSpeed = turningCuttingSpeed;
    }

    public BigDecimal getTurningSpindleSpeed() {
        return mTurningSpindleSpeed;
    }

    public void setTurningSpindleSpeed(BigDecimal turningSpindleSpeed) {
        mTurningSpindleSpeed = turningSpindleSpeed;
    }

    public BigDecimal getTurningMetalRemovalRate() {
        return mTurningMetalRemovalRate;
    }

    public void setTurningMetalRemovalRate(BigDecimal turningMetalRemovalRate) {
        mTurningMetalRemovalRate = turningMetalRemovalRate;
    }

    public BigDecimal getTurningNetPowerRequirement() {
        return mTurningNetPowerRequirement;
    }

    public void setTurningNetPowerRequirement(BigDecimal turningNetPowerRequirement) {
        mTurningNetPowerRequirement = turningNetPowerRequirement;
    }

    public BigDecimal getTurningMachiningTime() {
        return mTurningMachiningTime;
    }

    public void setTurningMachiningTime(BigDecimal turningMachiningTime) {
        mTurningMachiningTime = turningMachiningTime;
    }

    public BigDecimal getTurningMachinedDiameter() {
        return mTurningMachinedDiameter;
    }

    public void setTurningMachinedDiameter(BigDecimal turningMachinedDiameter) {
        mTurningMachinedDiameter = turningMachinedDiameter;
    }

    public BigDecimal getTurningCuttingDepth() {
        return mTurningCuttingDepth;
    }

    public void setTurningCuttingDepth(BigDecimal turningCuttingDepth) {
        mTurningCuttingDepth = turningCuttingDepth;
    }

    public BigDecimal getTurningFeedPerRevolution() {
        return mTurningFeedPerRevolution;
    }

    public void setTurningFeedPerRevolution(BigDecimal turningFeedPerRevolution) {
        mTurningFeedPerRevolution = turningFeedPerRevolution;
    }

    public BigDecimal getTurningSpecificCuttingForce() {
        return mTurningSpecificCuttingForce;
    }

    public void setTurningSpecificCuttingForce(BigDecimal turningSpecificCuttingForce) {
        mTurningSpecificCuttingForce = turningSpecificCuttingForce;
    }

    public BigDecimal getTurningMachinedLength() {
        return mTurningMachinedLength;
    }

    public void setTurningMachinedLength(BigDecimal turningMachinedLength) {
        mTurningMachinedLength = turningMachinedLength;
    }

    public BigDecimal getMillingCuttingSpeed() {
        return mMillingCuttingSpeed;
    }

    public void setMillingCuttingSpeed(BigDecimal millingCuttingSpeed) {
        mMillingCuttingSpeed = millingCuttingSpeed;
    }

    public BigDecimal getMillingSpindleSpeed() {
        return mMillingSpindleSpeed;
    }

    public void setMillingSpindleSpeed(BigDecimal millingSpindleSpeed) {
        mMillingSpindleSpeed = millingSpindleSpeed;
    }

    public BigDecimal getMillingFeedTooth() {
        return mMillingFeedTooth;
    }

    public void setMillingFeedTooth(BigDecimal millingFeedTooth) {
        mMillingFeedTooth = millingFeedTooth;
    }

    public BigDecimal getMillingTableFeed() {
        return mMillingTableFeed;
    }

    public void setMillingTableFeed(BigDecimal millingTableFeed) {
        mMillingTableFeed = millingTableFeed;
    }

    public BigDecimal getMillingMetalRemovalRate() {
        return mMillingMetalRemovalRate;
    }

    public void setMillingMetalRemovalRate(BigDecimal millingMetalRemovalRate) {
        mMillingMetalRemovalRate = millingMetalRemovalRate;
    }

    public BigDecimal getMillingNetPowerRequirement() {
        return mMillingNetPowerRequirement;
    }

    public void setMillingNetPowerRequirement(BigDecimal millingNetPowerRequirement) {
        mMillingNetPowerRequirement = millingNetPowerRequirement;
    }

    public BigDecimal getMillingTorque() {
        return mMillingTorque;
    }

    public void setMillingTorque(BigDecimal millingTorque) {
        mMillingTorque = millingTorque;
    }

    public BigDecimal getMillingCuttingDiameterAtDepth() {
        return mMillingCuttingDiameterAtDepth;
    }

    public void setMillingCuttingDiameterAtDepth(BigDecimal millingCuttingDiameterAtDepth) {
        mMillingCuttingDiameterAtDepth = millingCuttingDiameterAtDepth;
    }

    public BigDecimal getMillingNumberOfEffectiveTeeth() {
        return mMillingNumberOfEffectiveTeeth;
    }

    public void setMillingNumberOfEffectiveTeeth(BigDecimal millingNumberOfEffectiveTeeth) {
        mMillingNumberOfEffectiveTeeth = millingNumberOfEffectiveTeeth;
    }

    public BigDecimal getMillingDepthOfCut() {
        return mMillingDepthOfCut;
    }

    public void setMillingDepthOfCut(BigDecimal millingDepthOfCut) {
        mMillingDepthOfCut = millingDepthOfCut;
    }

    public BigDecimal getMillingWorkingEngagement() {
        return mMillingWorkingEngagement;
    }

    public void setMillingWorkingEngagement(BigDecimal millingWorkingEngagement) {
        mMillingWorkingEngagement = millingWorkingEngagement;
    }

    public BigDecimal getMillingSpecificCuttingForce() {
        return mMillingSpecificCuttingForce;
    }

    public void setMillingSpecificCuttingForce(BigDecimal millingSpecificCuttingForce) {
        mMillingSpecificCuttingForce = millingSpecificCuttingForce;
    }

    public BigDecimal getDrillingDrillDiameter() {
        return mDrillingDrillDiameter;
    }

    public void setDrillingDrillDiameter(BigDecimal drillingDrillDiameter) {
        mDrillingDrillDiameter = drillingDrillDiameter;
    }

    public BigDecimal getDrillingSpindleSpeed() {
        return mDrillingSpindleSpeed;
    }

    public void setDrillingSpindleSpeed(BigDecimal drillingSpindleSpeed) {
        mDrillingSpindleSpeed = drillingSpindleSpeed;
    }

    public BigDecimal getDrillingCuttingSpeed() {
        return mDrillingCuttingSpeed;
    }

    public void setDrillingCuttingSpeed(BigDecimal drillingCuttingSpeed) {
        mDrillingCuttingSpeed = drillingCuttingSpeed;
    }

    public BigDecimal getDrillingTableFeed() {
        return mDrillingTableFeed;
    }

    public void setDrillingTableFeed(BigDecimal drillingTableFeed) {
        mDrillingTableFeed = drillingTableFeed;
    }

    public BigDecimal getDrillingFeedPerRevolution() {
        return mDrillingFeedPerRevolution;
    }

    public void setDrillingFeedPerRevolution(BigDecimal drillingFeedPerRevolution) {
        mDrillingFeedPerRevolution = drillingFeedPerRevolution;
    }

    public BigDecimal getDrillingMachiningDrillingLength() {
        return mDrillingMachiningDrillingLength;
    }

    public void setDrillingMachiningDrillingLength(BigDecimal drillingMachiningDrillingLength) {
        mDrillingMachiningDrillingLength = drillingMachiningDrillingLength;
    }

    public BigDecimal getDrillingSpecificCuttingForce() {
        return mDrillingSpecificCuttingForce;
    }

    public void setDrillingSpecificCuttingForce(BigDecimal drillingSpecificCuttingForce) {
        mDrillingSpecificCuttingForce = drillingSpecificCuttingForce;
    }

    public BigDecimal getDrillingNetPowerRequirement() {
        return mDrillingNetPowerRequirement;
    }

    public void setDrillingNetPowerRequirement(BigDecimal drillingNetPowerRequirement) {
        mDrillingNetPowerRequirement = drillingNetPowerRequirement;
    }
}
