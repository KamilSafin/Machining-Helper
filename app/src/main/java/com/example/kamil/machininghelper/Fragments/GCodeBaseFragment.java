package com.example.kamil.machininghelper.Fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kamil.machininghelper.Adapters.GCodeBaseAdapter;
import com.example.kamil.machininghelper.Model.GCodeLab;
import com.example.kamil.machininghelper.R;

/**
 * Created by Kamil Safin on 8/20/2016.
 */
public class GCodeBaseFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private GCodeBaseAdapter mGCodeBaseAdapter;

    private GCodeLab mGCodeLab;

    public static Fragment initFragment(){
        Fragment fragment = new GCodeBaseFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_g_code_base, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.g_code_recyler_view);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        else
            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));

        mGCodeLab = GCodeLab.getGCodeLab(getContext());

        mGCodeBaseAdapter = new GCodeBaseAdapter(getContext(), mGCodeLab.getGCodes());
        mRecyclerView.setAdapter(mGCodeBaseAdapter);

        return view;
    }
}
