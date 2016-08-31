package com.example.kamil.machininghelper.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.kamil.machininghelper.Activities.CalculatorParametersActivity;
import com.example.kamil.machininghelper.Activities.MachiningProblemsActivity;
import com.example.kamil.machininghelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 8/30/2016.
 */
public class CalculatorItemFragment extends Fragment {

    private static final String ARGS_FRAGMENT_INDEX = CalculatorItemFragment.class.getName() + "_args_fragment_index";

    @BindView(R.id.calculator_item_image_view)
    ImageView mItemView;

    @BindView(R.id.calculator_button)
    RelativeLayout mCalculatorButton;

    @BindView(R.id.problems_button)
    RelativeLayout mProblemsButton;

    private int mIndex;

    public static Fragment initFragment(int index){
        Fragment fragment = new CalculatorItemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_FRAGMENT_INDEX, index);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIndex = getArguments().getInt(ARGS_FRAGMENT_INDEX);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator_item, container, false);

        ButterKnife.bind(this, view);

        switch (mIndex){
            case 0:
                mItemView.setImageDrawable(getResources().getDrawable(R.drawable.turning));
                break;
            case 1:
                mItemView.setImageDrawable(getResources().getDrawable(R.drawable.milling));
                break;
            case 2:
                mItemView.setImageDrawable(getResources().getDrawable(R.drawable.drilling));
                break;
        }

        mCalculatorButton.setOnClickListener(l -> {
            Intent intent = CalculatorParametersActivity.newIntent(getContext(), mIndex);
            startActivity(intent);
        });

        mProblemsButton.setOnClickListener(l -> {
            Intent intent = MachiningProblemsActivity.newIntent(getContext(), mIndex);
            startActivity(intent);
        });

        return view;
    }
}
