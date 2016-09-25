package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kamil.machininghelper.R;

/**
 * Created by Kamil Safin on 9/18/2016.
 */
public class MillingCreatorFragment extends Fragment {

    public static Fragment initFragment(){
        Fragment fragment = new MillingCreatorFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_milling_creator, container, false);

        return view;
    }
}
