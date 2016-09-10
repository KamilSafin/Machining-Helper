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

    @BindView(R.id.cutting_diameter_at_depth)
    LinearLayout mCuttingDiameterAtDepth;

    @BindView(R.id.cutting_diameter_at_depth_text)
    TextView mCuttingDiameterAtDepthText;

    @BindView(R.id.cutting_diameter_at_depth_edit_text)
    EditText mCuttingDiameterAtDepthEditText;

    @BindView(R.id.table_feed)
    LinearLayout mTableFeed;

    @BindView(R.id.table_feed_text)
    TextView mTableFeedText;

    @BindView(R.id.table_feed_edit_text)
    EditText mTableFeedEditText;

    @BindView(R.id.number_of_effective_teeth)
    LinearLayout mNumberOfEffectiveTeeth;

    @BindView(R.id.number_of_effective_teeth_text)
    TextView mNumberOfEffectiveTeethText;

    @BindView(R.id.number_of_effective_teeth_edit_text)
    EditText mNumberOfEffectiveTeethEditText;

    @BindView(R.id.feed_tooth)
    LinearLayout mFeedTooth;

    @BindView(R.id.feed_tooth_text)
    TextView mFeedToothText;

    @BindView(R.id.feed_tooth_edit_text)
    EditText mFeedToothEditText;

    @BindView(R.id.depth_of_cut)
    LinearLayout mDepthOfCut;

    @BindView(R.id.depth_of_cut_text)
    TextView mDepthOfCutText;

    @BindView(R.id.depth_of_cut_edit_text)
    EditText mDepthOfCutEditText;

    @BindView(R.id.working_engagement)
    LinearLayout mWorkingEngagement;

    @BindView(R.id.working_engagement_text)
    TextView mWorkingEngagementText;

    @BindView(R.id.working_engagement_edit_text)
    EditText mWorkingEngagementEditText;

    @BindView(R.id.net_power_requirement)
    LinearLayout mNetPowerRequirement;

    @BindView(R.id.net_power_requirement_text)
    TextView mNetPowerRequirementText;

    @BindView(R.id.net_power_requirement_edit_text)
    EditText mNetPowerRequirementEditText;

    @BindView(R.id.drill_diameter)
    LinearLayout mDrillDiameter;

    @BindView(R.id.drill_diameter_text)
    TextView mDrillDiameterText;

    @BindView(R.id.drill_diameter_edit_text)
    EditText mDrillDiameterEditText;

    @BindView(R.id.machining_drilling_length)
    LinearLayout mMachiningDrillingLength;

    @BindView(R.id.machining_drilling_length_text)
    TextView mMachiningDrillingLengthText;

    @BindView(R.id.machining_drilling_length_edit_text)
    EditText mMachiningDrillingLengthEditText;

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
        String[] parametersNames = getResources().getStringArray(R.array.machining_formulas);
        mMachinedDiameterText.setText(parametersNames[0]);
        mSpindleSpeedText.setText(parametersNames[1]);
        mCuttingSpeedText.setText(parametersNames[2]);
        mCuttingDepthText.setText(parametersNames[3]);
        mFeedPerRevolutionText.setText(parametersNames[4]);
        mSpecificCuttingForceText.setText(parametersNames[5]);
        mMachinedLengthText.setText(parametersNames[6]);
        mCuttingDiameterAtDepthText.setText(parametersNames[7]);
        mTableFeedText.setText(parametersNames[8]);
        mNumberOfEffectiveTeethText.setText(parametersNames[9]);
        mFeedToothText.setText(parametersNames[10]);
        mDepthOfCutText.setText(parametersNames[11]);
        mWorkingEngagementText.setText(parametersNames[12]);
        mNetPowerRequirementText.setText(parametersNames[13]);
        mDrillDiameterText.setText(parametersNames[14]);
        mMachiningDrillingLengthText.setText(parametersNames[15]);

        mMachinedDiameter.setVisibility(View.GONE);
        mSpindleSpeed.setVisibility(View.GONE);
        mCuttingSpeed.setVisibility(View.GONE);
        mCuttingDepth.setVisibility(View.GONE);
        mFeedPerRevolution.setVisibility(View.GONE);
        mSpecificCuttingForce.setVisibility(View.GONE);
        mMachinedLength.setVisibility(View.GONE);
        mCuttingDiameterAtDepth.setVisibility(View.GONE);
        mTableFeed.setVisibility(View.GONE);
        mNumberOfEffectiveTeeth.setVisibility(View.GONE);
        mFeedTooth.setVisibility(View.GONE);
        mDepthOfCut.setVisibility(View.GONE);
        mWorkingEngagement.setVisibility(View.GONE);
        mNetPowerRequirement.setVisibility(View.GONE);
        mDrillDiameter.setVisibility(View.GONE);
        mMachiningDrillingLength.setVisibility(View.GONE);

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
                switch (itemPos){
                    case 0:
                        mCuttingDiameterAtDepth.setVisibility(View.VISIBLE);
                        mSpindleSpeed.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        mCuttingDiameterAtDepth.setVisibility(View.VISIBLE);
                        mCuttingSpeed.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        mTableFeed.setVisibility(View.VISIBLE);
                        mSpindleSpeed.setVisibility(View.VISIBLE);
                        mNumberOfEffectiveTeeth.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        mFeedTooth.setVisibility(View.VISIBLE);
                        mSpindleSpeed.setVisibility(View.VISIBLE);
                        mNumberOfEffectiveTeeth.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        mDepthOfCut.setVisibility(View.VISIBLE);
                        mWorkingEngagement.setVisibility(View.VISIBLE);
                        mTableFeed.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        mDepthOfCut.setVisibility(View.VISIBLE);
                        mWorkingEngagement.setVisibility(View.VISIBLE);
                        mTableFeed.setVisibility(View.VISIBLE);
                        mSpecificCuttingForce.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        mNetPowerRequirement.setVisibility(View.VISIBLE);
                        mSpindleSpeed.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case 2:
                switch (itemPos){
                    case 0:
                        mDrillDiameter.setVisibility(View.VISIBLE);
                        mSpindleSpeed.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        mDrillDiameter.setVisibility(View.VISIBLE);
                        mCuttingSpeed.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        mTableFeed.setVisibility(View.VISIBLE);
                        mSpindleSpeed.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        mFeedPerRevolution.setVisibility(View.VISIBLE);
                        mSpindleSpeed.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        mDrillDiameter.setVisibility(View.VISIBLE);
                        mFeedPerRevolution.setVisibility(View.VISIBLE);
                        mCuttingSpeed.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        mMachiningDrillingLength.setVisibility(View.VISIBLE);
                        mTableFeed.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        mDrillDiameter.setVisibility(View.VISIBLE);
                        mFeedPerRevolution.setVisibility(View.VISIBLE);
                        mSpecificCuttingForce.setVisibility(View.VISIBLE);
                        mCuttingSpeed.setVisibility(View.VISIBLE);
                        break;
                    case 7:
                        mNetPowerRequirement.setVisibility(View.VISIBLE);
                        mSpindleSpeed.setVisibility(View.VISIBLE);
                        break;
                }
                break;
        }
    }
}
