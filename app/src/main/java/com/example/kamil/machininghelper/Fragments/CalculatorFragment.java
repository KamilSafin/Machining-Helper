package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kamil.machininghelper.Adapters.CalculatorParametersAdapter;
import com.example.kamil.machininghelper.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 8/20/2016.
 */
public class CalculatorFragment extends Fragment {

    private static final String ARGS_FRAGMENT_INDEX = CalculatorFragment.class.getName() + "_args_fragment_index";

    @BindView(R.id.calculator_recycler_view)
    RecyclerView mRecyclerView;

    private int mIndex;
    private List<String> mCalculatorParameters;

    public static Fragment initFragment(int index){
        Fragment fragment = new CalculatorFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_FRAGMENT_INDEX, index);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIndex = getArguments().getInt(ARGS_FRAGMENT_INDEX);
        switch (mIndex){
            case 0:
                mCalculatorParameters = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.turning_calculator_parameters)));
                break;
            case 1:
                mCalculatorParameters = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.milling_calculator_parameters)));
                break;
            case 2:
                mCalculatorParameters = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.drilling_calculator_parameters)));
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new CalculatorParametersAdapter(getContext(), mCalculatorParameters, mIndex));

        return view;
    }
}
