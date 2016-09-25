package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kamil.machininghelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kamil Safin on 9/18/2016.
 */
public class MillingCreatorFragment extends Fragment {

    @BindView(R.id.mill_hss_bg)
    View mMillHSSBg;

    @BindView(R.id.mill_carboned_bg)
    View mMillCarbonedBg;

    public static Fragment initFragment(){
        Fragment fragment = new MillingCreatorFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_milling_creator, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.mill_hss)
    public void setMillHSS(ImageView imageView){
        mMillHSSBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
        mMillCarbonedBg.setBackground(null);
    }

    @OnClick(R.id.mill_carboned)
    public void setMillCarboned(ImageView imageView){
        mMillHSSBg.setBackground(null);
        mMillCarbonedBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
    }
}
