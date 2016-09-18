package com.example.kamil.machininghelper.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.kamil.machininghelper.Activities.DetailCreatorActivity;
import com.example.kamil.machininghelper.R;

import butterknife.BindView;

/**
 * Created by Kamil Safin on 8/20/2016.
 */
public class ParametersCreatorFragment extends Fragment {

    @BindView(R.id.turning_creator)
    RelativeLayout mTurningCreator;

    @BindView(R.id.milling_creator)
    RelativeLayout mMillingCreator;

    @BindView(R.id.drilling_creator)
    RelativeLayout mDrillingCreator;

    public static Fragment initFragment(){
        Fragment fragment = new ParametersCreatorFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parameters_creator, container, false);

        mTurningCreator.setOnClickListener(l -> {
            Intent intent = DetailCreatorActivity.newIntent(getContext(), 0);
            startActivity(intent);
        });

        mMillingCreator.setOnClickListener(l -> {
            Intent intent = DetailCreatorActivity.newIntent(getContext(), 1);
            startActivity(intent);
        });

        mDrillingCreator.setOnClickListener(l -> {
            Intent intent = DetailCreatorActivity.newIntent(getContext(), 2);
            startActivity(intent);
        });

        return view;
    }
}
