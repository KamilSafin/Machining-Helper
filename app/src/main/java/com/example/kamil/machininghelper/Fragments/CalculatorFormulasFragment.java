package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kamil.machininghelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 9/8/2016.
 */
public class CalculatorFormulasFragment extends Fragment {

    private static final String ARGS_FRAGMENT_ITEM_POS = CalculatorFormulasFragment.class.getName() + "_args_fragment_item_pos";
    private static final String ARGS_FRAGMENT_INDEX = CalculatorFormulasFragment.class.getName() + "_args_fragment_index";

    @BindView(R.id.machined_diameter)
    LinearLayout mMachinedDiameter;

    @BindView(R.id.machined_diameter_text)
    TextView mMachinedDiameterText;

    @BindView(R.id.machined_diameter_edit_text)
    EditText mMachiningDiameterEditText;

    @BindView(R.id.spindle_speed)
    LinearLayout mSpindleSpeed;

    @BindView(R.id.spindle_speed_text)
    TextView mSpindleSpeedText;

    @BindView(R.id.spindle_speed_edit_text)
    EditText mSpindleSpeedEditText;

    @BindView(R.id.cutting_speed)
    LinearLayout mCuttingSpeed;

    @BindView(R.id.cutting_speed_text)
    TextView mCuttingSpeedText;

    @BindView(R.id.cutting_speed_edit_text)
    EditText mCuttingSpeedEditText;

    @BindView(R.id.cutting_depth)
    LinearLayout mCuttingDepth;

    @BindView(R.id.cutting_depth_text)
    TextView mCuttingDepthText;

    @BindView(R.id.cutting_depth_edit_text)
    EditText mCuttingDepthEditText;

    @BindView(R.id.feed_per_revolution)
    LinearLayout mFeedPerRevolution;

    @BindView(R.id.feed_per_revolution_text)
    TextView mFeedPerRevolutionText;

    @BindView(R.id.feed_per_revolution_edit_text)
    EditText mFeedPerRevolutionEditText;

    @BindView(R.id.specific_cutting_force)
    LinearLayout mSpecificCuttingForce;

    @BindView(R.id.specific_cutting_force_text)
    TextView mSpecificCuttingForceText;

    @BindView(R.id.specific_cutting_force_edit_text)
    EditText mSpecificCuttingForceEditText;

    @BindView(R.id.machined_length)
    LinearLayout mMachinedLength;

    @BindView(R.id.machined_length_text)
    TextView mMachinedLengthText;

    @BindView(R.id.machined_length_edit_text)
    EditText mMachinedLengthEditText;

    private int mItemPos;
    private int mIndex;

    public static Fragment initFragment(int itemPos, int index){
        Fragment fragment = new CalculatorFormulasFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_FRAGMENT_ITEM_POS, itemPos);
        bundle.putInt(ARGS_FRAGMENT_INDEX, index);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItemPos = getArguments().getInt(ARGS_FRAGMENT_ITEM_POS);
        mIndex = getArguments().getInt(ARGS_FRAGMENT_INDEX);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator_formulas, container, false);

        ButterKnife.bind(this, view);

        initView(mIndex, mItemPos);

        return view;
    }

    private void initView(int index, int itemPos){
        String[] parametersNames = getResources().getStringArray(R.array.turning_formulas);
        mMachinedDiameterText.setText(parametersNames[0]);
        mSpindleSpeedText.setText(parametersNames[1]);
        mCuttingSpeedText.setText(parametersNames[2]);
        mCuttingDepthText.setText(parametersNames[3]);
        mFeedPerRevolutionText.setText(parametersNames[4]);
        mSpecificCuttingForceText.setText(parametersNames[5]);
        mMachinedLengthText.setText(parametersNames[6]);

        mMachinedDiameter.setVisibility(View.GONE);
        mSpindleSpeed.setVisibility(View.GONE);
        mCuttingSpeed.setVisibility(View.GONE);
        mCuttingDepth.setVisibility(View.GONE);
        mFeedPerRevolution.setVisibility(View.GONE);
        mSpecificCuttingForce.setVisibility(View.GONE);
        mMachinedLength.setVisibility(View.GONE);

        switch (index){
            case 0:
                switch (itemPos){
                    case 0:
                        mMachinedDiameter.setVisibility(View.VISIBLE);
                        mSpindleSpeed.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        mMachinedDiameter.setVisibility(View.VISIBLE);
                        mCuttingSpeed.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        mCuttingDepth.setVisibility(View.VISIBLE);
                        mCuttingSpeed.setVisibility(View.VISIBLE);
                        mFeedPerRevolution.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        mCuttingDepth.setVisibility(View.VISIBLE);
                        mCuttingSpeed.setVisibility(View.VISIBLE);
                        mFeedPerRevolution.setVisibility(View.VISIBLE);
                        mSpecificCuttingForce.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        mMachinedLength.setVisibility(View.VISIBLE);
                        mSpindleSpeed.setVisibility(View.VISIBLE);
                        mFeedPerRevolution.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }
}
