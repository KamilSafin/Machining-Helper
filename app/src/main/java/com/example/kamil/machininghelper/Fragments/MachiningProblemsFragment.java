package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kamil.machininghelper.Adapters.MachiningProblemsAdapter;
import com.example.kamil.machininghelper.Model.MachiningProblem;
import com.example.kamil.machininghelper.Model.MachningProblemsLab;
import com.example.kamil.machininghelper.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 8/31/2016.
 */
public class MachiningProblemsFragment extends Fragment {

    private static final String ARGS_PROBLEM_FRAGMENT_INDEX = MachiningProblemsFragment.class.getName() + "_args_problem_fragment_index";

    @BindView(R.id.machining_problems_recycler_view)
    RecyclerView mRecyclerView;

    private MachningProblemsLab mMachningProblemsLab;
    private int mIndex;
    private List<MachiningProblem> mMachiningProblems;

    public static Fragment initFragment(int index){
        Fragment fragment = new MachiningProblemsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_PROBLEM_FRAGMENT_INDEX, index);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIndex = getArguments().getInt(ARGS_PROBLEM_FRAGMENT_INDEX);
        mMachningProblemsLab = MachningProblemsLab.getMachningProblemsLab(getContext());
        switch (mIndex){
            case 0:
                mMachiningProblems = mMachningProblemsLab.getTurningProblems();
                break;
            case 1:
                mMachiningProblems = mMachningProblemsLab.getMillingProblems();
                break;
            case 2:
                mMachiningProblems = mMachningProblemsLab.getDrillingProblems();
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_machining_problem, container, false);

        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new MachiningProblemsAdapter(getContext(), mMachiningProblems));

        return view;
    }
}
