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
import com.example.kamil.machininghelper.Activities.DimensionsAndToleranceActivity;
import com.example.kamil.machininghelper.Activities.GCodeBaseActivity;
import com.example.kamil.machininghelper.Activities.ParametersCreatorActivity;
import com.example.kamil.machininghelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kamil Safin on 8/20/2016.
 */
public class MainFragment extends Fragment {

    public static MainFragment initFragment(){
        MainFragment fragment = new MainFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.parameters_creator_button)
    void onParametersCreatorClick() {
        Intent intent = ParametersCreatorActivity.newIntent(getContext());
        startActivity(intent);
    }

    @OnClick(R.id.calculator_button)
    void onCalculatorClick() {
        Intent intent = CalculatorActivity.newIntent(getContext());
        startActivity(intent);
    }

    @OnClick(R.id.g_code_base_button)
    void onGCodeBaseClick() {
        Intent intent = GCodeBaseActivity.newIntent(getContext());
        startActivity(intent);
    }

    @OnClick(R.id.dimensions_and_tolerance_button)
    void onDimensionAndToleranceClick() {
        Intent intent = DimensionsAndToleranceActivity.newIntent(getContext());
        startActivity(intent);
    }
}
