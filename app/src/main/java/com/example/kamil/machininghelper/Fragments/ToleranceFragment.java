package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.Adapters.AccuracyGradeAdapter;
import com.example.kamil.machininghelper.Adapters.ToleranceAdapter;
import com.example.kamil.machininghelper.Model.AccuracyGrades;
import com.example.kamil.machininghelper.Model.Tolerance;
import com.example.kamil.machininghelper.Model.ToleranceLab;
import com.example.kamil.machininghelper.R;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 8/24/2016.
 */
public class ToleranceFragment extends Fragment {

    private static final String ARGS_DIMENSION_ITEM = ToleranceFragment.class.getName() + "_args_dimension_item";
    private static final String ARGS_ACCURACY_ITEM = ToleranceFragment.class.getName() + "_args_accuracy_item";

    private static TextView sToleranceText;

    @BindView(R.id.dimension_recycler_view)
    RecyclerView mDimensionRecylerView;

    @BindView(R.id.accuracy_grade_recycler_view)
    RecyclerView mAccuracyGradeRecyclerView;

    private static List<Tolerance> sTolerances;
    private static AccuracyGrades sAccuracyGrades;
    private static Integer sDimensionIndex;
    private static Integer sAccuracyIndex;

    public static Fragment initFragment(){
        Fragment fragment = new ToleranceFragment();

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ToleranceLab toleranceLab = ToleranceLab.getToleranceLab(getContext());
        sTolerances = toleranceLab.getTolerances();
        sAccuracyGrades = new AccuracyGrades();
        sDimensionIndex = null;
        sAccuracyIndex = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tolerance, container, false);

        ButterKnife.bind(this, view);

        sToleranceText = (TextView) view.findViewById(R.id.tolerance_text);

        mDimensionRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAccuracyGradeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (savedInstanceState != null){
            sDimensionIndex = savedInstanceState.getInt(ARGS_DIMENSION_ITEM, -1);
            sAccuracyIndex = savedInstanceState.getInt(ARGS_ACCURACY_ITEM, -1);

            if (sDimensionIndex == -1)
                sDimensionIndex = null;
            if (sAccuracyIndex == -1)
                sAccuracyIndex = null;

            mDimensionRecylerView.setAdapter(new ToleranceAdapter(getContext(), sTolerances, sDimensionIndex));
            mAccuracyGradeRecyclerView.setAdapter(new AccuracyGradeAdapter(getContext(), new AccuracyGrades(), sAccuracyIndex));
            setToleranceText();
        } else {
            mDimensionRecylerView.setAdapter(new ToleranceAdapter(getContext(), sTolerances, null));
            mAccuracyGradeRecyclerView.setAdapter(new AccuracyGradeAdapter(getContext(), new AccuracyGrades(), null));
        }

        return view;
    }

    public static void setDimension(int dimensionIndex){
        sDimensionIndex = dimensionIndex;
        setToleranceText();
    }

    public static void setAccuracy(int accuracyIndex){
        sAccuracyIndex = accuracyIndex;
        setToleranceText();
    }

    private static void setToleranceText(){
        if (sDimensionIndex == null)
            sToleranceText.setText(R.string.chooose_dimension_text);
        else if (sAccuracyIndex == null)
            sToleranceText.setText(R.string.chooose_accuracy_text);
        else{
            HashMap tolerances = sTolerances.get(sDimensionIndex).getTolerances();
            List<String> accuracyGrades = sAccuracyGrades.getAccuracyGrades();
            String tolerance = (String) tolerances.get(accuracyGrades.get(sAccuracyIndex));

            sToleranceText.setText(tolerance);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (sDimensionIndex != null)
            outState.putInt(ARGS_DIMENSION_ITEM, sDimensionIndex);
        if (sAccuracyIndex != null)
            outState.putInt(ARGS_ACCURACY_ITEM, sAccuracyIndex);
    }
}
