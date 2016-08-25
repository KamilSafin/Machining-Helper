package com.example.kamil.machininghelper.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Kamil Safin on 8/25/2016.
 */
public class Tolerance {

    private String mDimension;
    private List<HashMap> mTolerances;

    public Tolerance(String dimension, String... tolerances){
        mDimension = dimension;
        List<String> accuracyGrades = new AccuracyGrades().getAccuracyGrades();
        mTolerances = new ArrayList<>();

        for (int i = 0; i < tolerances.length; i++){
            HashMap<String, String> tolerance = new HashMap<>();
            tolerance.put(accuracyGrades.get(i), tolerances[i]);
            mTolerances.add(tolerance);
        }
    }

    public String getDimension() {
        return mDimension;
    }

    public List<HashMap> getTolerances() {
        return mTolerances;
    }
}
