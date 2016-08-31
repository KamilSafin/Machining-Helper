package com.example.kamil.machininghelper.Model;

import java.util.List;

/**
 * Created by Kamil Safin on 8/31/2016.
 */
public class MachiningProblem {

    private String mName;
    private List<String> mSolution;

    public MachiningProblem(String name, List<String> solution) {
        mName = name;
        mSolution = solution;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<String> getSolution() {
        return mSolution;
    }

    public void setSolution(List<String> solution) {
        mSolution = solution;
    }
}
