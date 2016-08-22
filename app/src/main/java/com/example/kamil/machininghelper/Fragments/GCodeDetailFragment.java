package com.example.kamil.machininghelper.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kamil.machininghelper.Model.GCode;
import com.example.kamil.machininghelper.Model.GCodeLab;
import com.example.kamil.machininghelper.R;

import java.util.List;

/**
 * Created by Kamil Safin on 8/22/2016.
 */
public class GCodeDetailFragment extends Fragment {

    private static final String ARGS_G_CODE_INDEX = GCodeDetailFragment.class.getName() + "g_code_index";

    private TextView mGCodeTitle;
    private TextView mGCodeFunction;
    private TextView mGCodeParameters;
    private ListView mGCodeSimilar;

    private GCodeFragmentCallback mFragmentCallback;
    private List<GCode> mGCodes;
    private GCode mGCode;

    public static Fragment initFragment(int gCodeIndex){
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_G_CODE_INDEX, gCodeIndex);
        Fragment fragment = new GCodeDetailFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    public interface GCodeFragmentCallback{
        void onSimilarCodeClicked(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFragmentCallback = (GCodeFragmentCallback) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int index = getArguments().getInt(ARGS_G_CODE_INDEX);
        mGCodes = GCodeLab.getGCodeLab(getContext()).getGCodes();
        mGCode = mGCodes.get(index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_g_code_detail, container, false);

        mGCodeTitle = (TextView) view.findViewById(R.id.g_code_detail_text);
        mGCodeFunction = (TextView) view.findViewById(R.id.g_code_detail_function);
        mGCodeParameters = (TextView) view.findViewById(R.id.g_code_detail_parameters);
        mGCodeSimilar = (ListView) view.findViewById(R.id.g_code_detail_similar);

        mGCodeTitle.setText(mGCode.getG());
        mGCodeFunction.setText(mGCode.getFunction());
        mGCodeParameters.setText(mGCode.getParameters());
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.row_g_code_similar, mGCode.getSimilar());
        mGCodeSimilar.setAdapter(arrayAdapter);
        mGCodeSimilar.setOnItemClickListener((adapterView, view1, i, l) -> {
            int index = 0;
            for (int j =0; j < mGCodes.size(); j++) {
                if (mGCodes.get(j).getG().equals(mGCode.getSimilar()[i])){
                    index = j;
                }
            }
            if (mFragmentCallback != null)
                mFragmentCallback.onSimilarCodeClicked(index);
            else throw new RuntimeException(getActivity().getLocalClassName() + "must implement " + GCodeFragmentCallback.class.getName());
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFragmentCallback = null;
    }
}
