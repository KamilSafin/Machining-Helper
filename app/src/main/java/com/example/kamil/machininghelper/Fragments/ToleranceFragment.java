package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kamil.machininghelper.R;

/**
 * Created by Kamil Safin on 8/24/2016.
 */
public class ToleranceFragment extends Fragment {

    public static Fragment initFragment(){
        Fragment fragment = new ToleranceFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tolerance, container, false);

        return view;
    }
}
