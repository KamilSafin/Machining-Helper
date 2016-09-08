package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kamil.machininghelper.Adapters.MachiningProblemSolutionAdapter;
import com.example.kamil.machininghelper.Model.MachiningProblem;
import com.example.kamil.machininghelper.Model.MachningProblemsLab;
import com.example.kamil.machininghelper.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 9/7/2016.
 */
public class MachiningProblemsSolutionFragment extends Fragment {

    private static final String ARGS_SOLUTION_FRAGMENT_INDEX = MachiningProblemsSolutionFragment.class.getName() + "_args_soluton_fragment_index";
    private static final String ARGS_SOLUTION_FRAGMENT_ITEM_POS = MachiningProblemsSolutionFragment.class.getName() + "_args_soluton_fragment_item_pos";

    @BindView(R.id.problems_solution_recyler_view)
    RecyclerView mRecyclerView;

    private MachningProblemsLab mMachningProblemsLab;
    private List<MachiningProblem> mMachiningProblems;
    private int mIndex;
    private int mItemPos;

    public static Fragment initFragment(int index, int itemPos){
        Fragment fragment = new MachiningProblemsSolutionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_SOLUTION_FRAGMENT_INDEX, index);
        bundle.putInt(ARGS_SOLUTION_FRAGMENT_ITEM_POS, itemPos);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIndex = getArguments().getInt(ARGS_SOLUTION_FRAGMENT_INDEX);
        mItemPos = getArguments().getInt(ARGS_SOLUTION_FRAGMENT_ITEM_POS);
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
        View view = inflater.inflate(R.layout.fragment_machning_problems_solution, container, false);

        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new MachiningProblemSolutionAdapter(getContext(), mMachiningProblems.get(mItemPos).getSolution()));

        return view;
    }
}
