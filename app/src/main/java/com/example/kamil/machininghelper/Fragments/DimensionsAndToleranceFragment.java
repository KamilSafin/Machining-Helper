package com.example.kamil.machininghelper.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.kamil.machininghelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 8/20/2016.
 */
public class DimensionsAndToleranceFragment extends Fragment {

    @BindView(R.id.tolerance_button)
    RelativeLayout mToleranceButton;

    @BindView(R.id.thread_button)
    RelativeLayout mThreadButton;

    DimensionAndToleranceCallback mDimensionAndToleranceCallback;

    public static Fragment initFragment(){
        Fragment fragment = new DimensionsAndToleranceFragment();

        return fragment;
    }

    public interface DimensionAndToleranceCallback{
        void startFragment(Fragment fragment, String title);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mDimensionAndToleranceCallback = (DimensionAndToleranceCallback) context;
        }catch (RuntimeException ex){
            throw new RuntimeException(getActivity().getLocalClassName() + " must implements " + DimensionAndToleranceCallback.class.getName());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dimensions_and_tolerance, container, false);

        ButterKnife.bind(this, view);

        mToleranceButton.setOnClickListener(l -> mDimensionAndToleranceCallback.startFragment(ToleranceFragment.initFragment(), getResources().getString(R.string.tolerance)));

        mThreadButton.setOnClickListener(l -> mDimensionAndToleranceCallback.startFragment(ThreadsFragment.initFragment(), getResources().getString(R.string.holes_for_drill)));

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mDimensionAndToleranceCallback = null;
    }
}
