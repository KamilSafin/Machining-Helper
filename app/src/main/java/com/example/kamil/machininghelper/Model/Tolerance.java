package com.example.kamil.machininghelper.Model;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Kamil Safin on 8/25/2016.
 */
public class Tolerance {

    private String mDimension;
    private HashMap mTolerances;

    public Tolerance(String dimension, String... tolerances){
        mDimension = dimension;
        List<String> accuracyGrades = new AccuracyGrades().getAccuracyGrades();
        mTolerances = new HashMap();

        for (int i = 0; i < tolerances.length; i++){
            mTolerances.put(accuracyGrades.get(i), tolerances[i]);
        }
    }

    public String getDimension() {
        return mDimension;
    }

    public HashMap getTolerances() {
        return mTolerances;
    }
}
