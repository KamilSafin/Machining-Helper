package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.Adapters.SimilarAdapter;
import com.example.kamil.machininghelper.Model.GCode;
import com.example.kamil.machininghelper.Model.GCodeLab;
import com.example.kamil.machininghelper.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 8/22/2016.
 */
public class GCodeDetailFragment extends Fragment {

    private static final String ARGS_G_CODE_INDEX = GCodeDetailFragment.class.getName() + "g_code_index";

    @BindView(R.id.g_code_detail_text)
    TextView mGCodeTitle;

    @BindView(R.id.g_code_detail_function)
    TextView mGCodeFunction;

    @BindView(R.id.g_code_detail_parameters)
    TextView mGCodeParameters;

    @BindView(R.id.g_code_detail_no_similar)
    TextView mGCodeNoSimilar;

    @BindView(R.id.g_code_detail_similar)
    RecyclerView mSimilarRecyclerView;

    private List<GCode> mGCodes;
    private GCode mGCode;
    private int mIndex;

    public static Fragment initFragment(int gCodeIndex){
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_G_CODE_INDEX, gCodeIndex);
        Fragment fragment = new GCodeDetailFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIndex = getArguments().getInt(ARGS_G_CODE_INDEX);
        mGCodes = GCodeLab.getGCodeLab(getContext()).getGCodes();
        mGCode = mGCodes.get(mIndex);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_g_code_detail, container, false);

        ButterKnife.bind(this, view);

        mGCodeTitle.setText(mGCode.getG());
        mGCodeFunction.setText(mGCode.getFunction());
        mGCodeParameters.setText(mGCode.getParameters());
        if (!mGCode.getSimilar()[0].equals("brak")) {
            if (mGCode.getSimilar().length == 1) {
                mSimilarRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
            } else {
                mSimilarRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            }

            mSimilarRecyclerView.setAdapter(new SimilarAdapter(getContext(), mIndex));

        } else {
            mSimilarRecyclerView.setVisibility(View.GONE);
            mGCodeNoSimilar.setVisibility(View.VISIBLE);
            mGCodeNoSimilar.setText(mGCode.getSimilar()[0]);
        }

        return view;
    }
}
