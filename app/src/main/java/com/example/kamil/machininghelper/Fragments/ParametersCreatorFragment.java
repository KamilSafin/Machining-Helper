package com.example.kamil.machininghelper.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kamil.machininghelper.Activities.DetailCreatorActivity;
import com.example.kamil.machininghelper.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kamil Safin on 8/20/2016.
 */
public class ParametersCreatorFragment extends Fragment {

    public static Fragment initFragment(){
        Fragment fragment = new ParametersCreatorFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parameters_creator, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.turning_creator)
    void onTurningCreatorClick() {
        Intent intent = DetailCreatorActivity.newIntent(getContext(), 0);
        startActivity(intent);
    }

    @OnClick(R.id.milling_creator)
    void onMillingCreatorClick() {
        Intent intent = DetailCreatorActivity.newIntent(getContext(), 1);
        startActivity(intent);
    }

    @OnClick(R.id.drilling_creator)
    void onDrillingCreatorClick() {
        Intent intent = DetailCreatorActivity.newIntent(getContext(), 2);
        startActivity(intent);
    }
}
