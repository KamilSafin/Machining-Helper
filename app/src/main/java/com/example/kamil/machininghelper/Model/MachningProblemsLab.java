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

        String[] millingProblemsNames = mContext.getResources().getStringArray(R.array.milling_problems_name);
        String[] millingSolution = mContext.getResources().getStringArray(R.array.milling_solution);
        mMillingProblems = new ArrayList<>();
        mMillingProblems.add(new MachiningProblem(millingProblemsNames[0], Arrays.asList(millingSolution[0],millingSolution[6])));
        mMillingProblems.add(new MachiningProblem(millingProblemsNames[1], Arrays.asList(millingSolution[0],millingSolution[2])));
        mMillingProblems.add(new MachiningProblem(millingProblemsNames[2], Arrays.asList(millingSolution[0],millingSolution[6],millingSolution[7])));
        mMillingProblems.add(new MachiningProblem(millingProblemsNames[3], Arrays.asList(millingSolution[0],millingSolution[4], millingSolution[7])));
        mMillingProblems.add(new MachiningProblem(millingProblemsNames[4], Arrays.asList(millingSolution[1],millingSolution[6], millingSolution[4], millingSolution[7])));
        mMillingProblems.add(new MachiningProblem(millingProblemsNames[5], Arrays.asList(millingSolution[5],millingSolution[4])));
        mMillingProblems.add(new MachiningProblem(millingProblemsNames[6], Arrays.asList(millingSolution[5],millingSolution[4], millingSolution[3])));
        mMillingProblems.add(new MachiningProblem(millingProblemsNames[7], Arrays.asList(millingSolution[6],millingSolution[8], millingSolution[3])));

        String[] drillingProblemsNames = mContext.getResources().getStringArray(R.array.drilling_problems_name);
        String[] drillingSolution = mContext.getResources().getStringArray(R.array.drilling_solution);
        mDrillingProblems = new ArrayList<>();
        mDrillingProblems.add(new MachiningProblem(drillingProblemsNames[0], Arrays.asList(drillingSolution[0], drillingSolution[1], drillingSolution[2], drillingSolution[3])));
        mDrillingProblems.add(new MachiningProblem(drillingProblemsNames[1], Arrays.asList(drillingSolution[0], drillingSolution[1], drillingSolution[2], drillingSolution[3])));
        mDrillingProblems.add(new MachiningProblem(drillingProblemsNames[2], Arrays.asList(drillingSolution[0], drillingSolution[4], drillingSolution[2])));
        mDrillingProblems.add(new MachiningProblem(drillingProblemsNames[3], Arrays.asList(drillingSolution[5], drillingSolution[4], drillingSolution[6], drillingSolution[1], drillingSolution[2])));
        mDrillingProblems.add(new MachiningProblem(drillingProblemsNames[4], Arrays.asList(drillingSolution[0], drillingSolution[6], drillingSolution[3])));
        mDrillingProblems.add(new MachiningProblem(drillingProblemsNames[5], Arrays.asList(drillingSolution[4])));
        mDrillingProblems.add(new MachiningProblem(drillingProblemsNames[6], Arrays.asList(drillingSolution[5], drillingSolution[1], drillingSolution[2], drillingSolution[3])));
        mDrillingProblems.add(new MachiningProblem(drillingProblemsNames[7], Arrays.asList(drillingSolution[4], drillingSolution[1], drillingSolution[2])));
    }

    public static MachningProblemsLab getMachningProblemsLab(Context context) {
        if (sMachningProblemsLab == null)
            sMachningProblemsLab = new MachningProblemsLab(context.getApplicationContext());

        return sMachningProblemsLab;
    }

    public List<MachiningProblem> getTurningProblems() {
        return mTurningProblems;
    }

    public List<MachiningProblem> getMillingProblems() {
        return mMillingProblems;
    }

    public List<MachiningProblem> getDrillingProblems() {
        return mDrillingProblems;
    }
}
