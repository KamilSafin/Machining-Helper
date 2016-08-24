package com.example.kamil.machininghelper.Model;

/**
 * Created by Kamil Safin on 8/24/2016.
 */
public class FineThread implements Threads{

    private String mFineThreadName;
    private double mFineThreadDiameter;

    public FineThread(String fineThreadName, double fineThreadDiameter) {
        mFineThreadName = fineThreadName;
        mFineThreadDiameter = fineThreadDiameter;
    }

    @Override
    public String getThreadName() {
        return mFineThreadName;
    }

    @Override
    public void setThreadName(String threadName) {
        mFineThreadName = threadName;
    }

    @Override
    public double getThreadDiameter() {
        return mFineThreadDiameter;
    }

    @Override
    public void setThreadDiameter(double threadDiameter) {
        mFineThreadDiameter = threadDiameter;
    }
}
