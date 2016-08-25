package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kamil.machininghelper.Adapters.AccuracyGradeAdapter;
import com.example.kamil.machininghelper.Adapters.ToleranceAdapter;
import com.example.kamil.machininghelper.Model.AccuracyGrades;
import com.example.kamil.machininghelper.Model.Tolerance;
import com.example.kamil.machininghelper.Model.ToleranceLab;
import com.example.kamil.machininghelper.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 8/24/2016.
 */
public class ToleranceFragment extends Fragment {

    @BindView(R.id.find_tolerance_button)
    Button mFindToleraceButton;

    @BindView(R.id.dimension_recycler_view)
    RecyclerView mDimensionRecylerView;

    @BindView(R.id.accuracy_grade_recycler_view)
    RecyclerView mAccuracyGradeRecyclerView;

    private List<Tolerance> mTolerances;

    public static Fragment initFragment(){
        Fragment fragment = new ToleranceFragment();

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ToleranceLab toleranceLab = ToleranceLab.getToleranceLab(getContext());
        mTolerances = toleranceLab.getTolerances();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tolerance, container, false);

        ButterKnife.bind(this, view);

        mDimensionRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mDimensionRecylerView.setAdapter(new ToleranceAdapter(getContext(), mTolerances));

        mAccuracyGradeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAccuracyGradeRecyclerView.setAdapter(new AccuracyGradeAdapter(getContext(), new AccuracyGrades()));

        return view;
    }
}
