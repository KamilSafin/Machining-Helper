package com.example.kamil.machininghelper.Model;

/**
 * Created by Kamil Safin on 8/24/2016.
 */
public class MetricThread implements Threads{

    private String mMetricThreadName;
    private double mMetricThreadDiameter;

    public MetricThread(String metricThreadName, double metricThreadDiameter) {
        mMetricThreadName = metricThreadName;
        mMetricThreadDiameter = metricThreadDiameter;
    }

    @Override
    public String getThreadName() {
        return mMetricThreadName;
    }

    @Override
    public void setThreadName(String threadName) {
        mMetricThreadName = threadName;
    }

    @Override
    public double getThreadDiameter() {
        return mMetricThreadDiameter;
    }

    @Override
    public void setThreadDiameter(double threadDiameter) {
        mMetricThreadDiameter = threadDiameter;
    }
}
