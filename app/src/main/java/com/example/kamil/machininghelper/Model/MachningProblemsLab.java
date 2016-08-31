package com.example.kamil.machininghelper.Model;

import android.content.Context;

import com.example.kamil.machininghelper.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kamil Safin on 8/31/2016.
 */
public class MachningProblemsLab {

    private static MachningProblemsLab sMachningProblemsLab;
    private Context mContext;
    private List<MachiningProblem> mTurningProblems;
    private List<MachiningProblem> mMillingProblems;
    private List<MachiningProblem> mDrillingProblems;

    private MachningProblemsLab(Context context){

        mContext = context;

        String[] turningProblemsNames = mContext.getResources().getStringArray(R.array.turning_problems_name);
        String[] turningSolution = mContext.getResources().getStringArray(R.array.turning_solution);
        mTurningProblems = new ArrayList<>();
        mTurningProblems.add(new MachiningProblem(turningProblemsNames[0], Arrays.asList(turningSolution[0], turningSolution[2], turningSolution[3])));
        mTurningProblems.add(new MachiningProblem(turningProblemsNames[1], Arrays.asList(turningSolution[0], turningSolution[2])));
        mTurningProblems.add(new MachiningProblem(turningProblemsNames[2], Arrays.asList(turningSolution[0], turningSolution[3])));
        mTurningProblems.add(new MachiningProblem(turningProblemsNames[3], Arrays.asList(turningSolution[4])));
        mTurningProblems.add(new MachiningProblem(turningProblemsNames[4], Arrays.asList(turningSolution[0], turningSolution[4], turningSolution[3])));
        mTurningProblems.add(new MachiningProblem(turningProblemsNames[5], Arrays.asList(turningSolution[5], turningSolution[7], turningSolution[4])));
        mTurningProblems.add(new MachiningProblem(turningProblemsNames[6], Arrays.asList(turningSolution[6])));
        mTurningProblems.add(new MachiningProblem(turningProblemsNames[7], Arrays.asList(turningSolution[0], turningSolution[6], turningSolution[7], turningSolution[3])));
    }

    public static MachningProblemsLab getMachningProblemsLab(Context context) {
        if (sMachningProblemsLab == null)
            sMachningProblemsLab = new MachningProblemsLab(context.getApplicationContext());

        return sMachningProblemsLab;
    }

    public List<MachiningProblem> getTurningProblems() {
        return mTurningProblems;
    }
}
