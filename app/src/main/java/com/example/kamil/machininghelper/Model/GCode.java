package com.example.kamil.machininghelper.Model;

/**
 * Created by Kamil Safin on 8/22/2016.
 */
public class GCode {

    private String mG;
    private String mFunction;
    private String mParameters;
    private String[] mSimilar;

    public GCode(String g, String function, String parameters, String similar) {
        mG = g;
        mFunction = function;
        mParameters = parameters;
        mSimilar = similar.split(",");
    }

    public String getG() {
        return mG;
    }

    public void setG(String g) {
        mG = g;
    }

    public String getFunction() {
        return mFunction;
    }

    public void setFunction(String function) {
        mFunction = function;
    }

    public String getParameters() {
        return mParameters;
    }

    public void setParameters(String parameters) {
        mParameters = parameters;
    }

    public String[] getSimilar() {
        return mSimilar;
    }

    public void setSimilar(String[] similar) {
        mSimilar = similar;
    }
}
