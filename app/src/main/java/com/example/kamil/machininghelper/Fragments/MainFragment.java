package com.example.kamil.machininghelper.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.kamil.machininghelper.Activities.CalculatorActivity;
import com.example.kamil.machininghelper.Activities.GCodeBaseActivity;
import com.example.kamil.machininghelper.R;

/**
 * Created by Kamil Safin on 8/20/2016.
 */
public class MainFragment extends Fragment {

    private RelativeLayout mCalculatorButton;
    private RelativeLayout mGCodeBaseButton;
    private RelativeLayout mParametersCreatorButton;
    private RelativeLayout mDimensionsAndToleranceButton;

    public static MainFragment initFragment(){
        MainFragment fragment = new MainFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mParametersCreatorButton = (RelativeLayout) view.findViewById(R.id.parameters_creator_button);
        mParametersCreatorButton.setOnClickListener(l -> {
            Intent intent = GCodeBaseActivity.newIntent(getContext());
            startActivity(intent);
        });

        mCalculatorButton = (RelativeLayout) view.findViewById(R.id.calculator_button);
        mCalculatorButton.setOnClickListener(l -> {
            Intent intent = CalculatorActivity.newIntent(getContext());
            startActivity(intent);
        });

        mGCodeBaseButton = (RelativeLayout) view.findViewById(R.id.g_code_base_button);
        mGCodeBaseButton.setOnClickListener(l -> {
            Intent intent = GCodeBaseActivity.newIntent(getContext());
            startActivity(intent);
        });

        mDimensionsAndToleranceButton = (RelativeLayout) view.findViewById(R.id.dimensions_and_tolerance_button);
        mDimensionsAndToleranceButton.setOnClickListener(l -> {
            Intent intent = GCodeBaseActivity.newIntent(getContext());
            startActivity(intent);
        });

        return view;
    }
}
