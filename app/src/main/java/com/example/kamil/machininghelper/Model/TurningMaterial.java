package com.example.kamil.machininghelper.Model;


public class TurningMaterial {

    private String mName;
    private String mCuttingType;
    private double mMinDepthOfCut;
    private double mMaxDepthOfCut;
    private double mMinFeedPerRevolution;
    private Double mRecommendedFeedPerRevolution;
    private double mMaxFeedPerRevolution;
    private double mMinCuttingSpeed;
    private Double mRecommendedCuttingSpeed;
    private double mMaxCuttingSpeed;
    private Integer mGroupId;

    public TurningMaterial(String name, String cuttingType, double minDepthOfCut, double maxDepthOfCut, double minFeedPerRevolution, Double recommendedFeedPerRevolution, double maxFeedPerRevolution, double minCuttingSpeed, Double recommendedCuttingSpeed, double maxCuttingSpeed) {
        mName = name;
        mCuttingType = cuttingType;
        mMinDepthOfCut = minDepthOfCut;
        mMaxDepthOfCut = maxDepthOfCut;
        mMinFeedPerRevolution = minFeedPerRevolution;
        mRecommendedFeedPerRevolution = recommendedFeedPerRevolution;
        mMaxFeedPerRevolution = maxFeedPerRevolution;
        mMinCuttingSpeed = minCuttingSpeed;
        mRecommendedCuttingSpeed = recommendedCuttingSpeed;
        mMaxCuttingSpeed = maxCuttingSpeed;
    }

    public TurningMaterial(String name, String cuttingType, double minDepthOfCut, double maxDepthOfCut, double minFeedPerRevolution, Double recommendedFeedPerRevolution, double maxFeedPerRevolution, double minCuttingSpeed, Double recommendedCuttingSpeed, double maxCuttingSpeed, Integer groupId) {
        mName = name;
        mCuttingType = cuttingType;
        mMinDepthOfCut = minDepthOfCut;
        mMaxDepthOfCut = maxDepthOfCut;
        mMinFeedPerRevolution = minFeedPerRevolution;
        mRecommendedFeedPerRevolution = recommendedFeedPerRevolution;
        mMaxFeedPerRevolution = maxFeedPerRevolution;
        mMinCuttingSpeed = minCuttingSpeed;
        mRecommendedCuttingSpeed = recommendedCuttingSpeed;
        mMaxCuttingSpeed = maxCuttingSpeed;
        mGroupId = groupId;
    }

    public String getName() {
        return mName;
    }

    public String getCuttingType() {
        return mCuttingType;
    }

    public double getMinDepthOfCut() {
        return mMinDepthOfCut;
    }

    public double getMaxDepthOfCut() {
        return mMaxDepthOfCut;
    }

    public double getMinFeedPerRevolution() {
        return mMinFeedPerRevolution;
    }

    public Double getRecommendedFeedPerRevolution() {
        return mRecommendedFeedPerRevolution;
    }

    public double getMaxFeedPerRevolution() {
        return mMaxFeedPerRevolution;
    }

    public double getMinCuttingSpeed() {
        return mMinCuttingSpeed;
    }

    public Double getRecommendedCuttingSpeed() {
        return mRecommendedCuttingSpeed;
    }

    public double getMaxCuttingSpeed() {
        return mMaxCuttingSpeed;
    }

    public Integer getGroupId() {
        return mGroupId;
    }
}
