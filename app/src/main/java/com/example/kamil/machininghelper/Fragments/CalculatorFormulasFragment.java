package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.kamil.machininghelper.Model.CalculatorCachedValuesLab;
import com.example.kamil.machininghelper.R;
import com.example.kamil.machininghelper.Utils.Utils;
import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 9/8/2016.
 */
public class CalculatorFormulasFragment extends Fragment {

    private static final String ARGS_FRAGMENT_ITEM_POS = CalculatorFormulasFragment.class.getName() + "_args_fragment_item_pos";
    private static final String ARGS_FRAGMENT_INDEX = CalculatorFormulasFragment.class.getName() + "_args_fragment_index";

    @BindView(R.id.result)
    TextView mResult;

    @BindView(R.id.machined_diameter)
    LinearLayout mMachinedDiameter;

    @BindView(R.id.machined_diameter_text)
    TextView mMachinedDiameterText;

    @BindView(R.id.machined_diameter_edit_text)
    EditText mMachinedDiameterEditText;

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

    @BindView(R.id.result_name)
    TextView mResultName;

    private CalculatorCachedValuesLab mCalculatorCachedValuesLab;
    private int mItemPos;
    private MachiningType mMachiningType;
    private String[] titles;

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

        mCalculatorCachedValuesLab = CalculatorCachedValuesLab.getCachedValuesLab(getContext());
        mItemPos = getArguments().getInt(ARGS_FRAGMENT_ITEM_POS);
        int machiningType = getArguments().getInt(ARGS_FRAGMENT_INDEX);
        switch (machiningType) {
            case 0:
                mMachiningType = MachiningType.TURNING;
                break;
            case 1:
                mMachiningType = MachiningType.MILLING;
                break;
            case 2:
                mMachiningType = MachiningType.DRILLING;
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator_formulas, container, false);

        ButterKnife.bind(this, view);

        switch (mMachiningType){
            case TURNING:
                titles = getResources().getStringArray(R.array.turning_calculator_parameters);
                mResultName.setText(titles[mItemPos]);
                break;
            case MILLING:
                titles = getResources().getStringArray(R.array.milling_calculator_parameters);
                mResultName.setText(titles[mItemPos]);
                break;
            case DRILLING:
                titles = getResources().getStringArray(R.array.drilling_calculator_parameters);
                mResultName.setText(titles[mItemPos]);
                break;
        }

        initView();

        addListeners();

        initResult();

        return view;
    }

    private void addListeners(){
        mCuttingSpeedEditText.addTextChangedListener(mCuttingSpeedEditTextWatcher);
        mCuttingDepthEditText.addTextChangedListener(mCuttingDepthEditTextWatcher);
        mMachinedDiameterEditText.addTextChangedListener(mMachinedDiameterEditTextWatcher);
        mSpindleSpeedEditText.addTextChangedListener(mSpindleSpeedEditTextWatcher);
        mFeedPerRevolutionEditText.addTextChangedListener(mFeedPerRevolutionEditTextWatcher);
        mSpecificCuttingForceEditText.addTextChangedListener(mSpecificCuttingForceEditTextWatcher);
        mMachinedLengthEditText.addTextChangedListener(mMachinedLengthEditTextWatcher);
        mCuttingDiameterAtDepthEditText.addTextChangedListener(mCuttingDiameterAtDepthEditTextWatcher);
        mTableFeedEditText.addTextChangedListener(mTableFeedEditTextWatcher);
        mNumberOfEffectiveTeethEditText.addTextChangedListener(mNumberOfEffectiveTeethEditTextWatcher);
        mFeedToothEditText.addTextChangedListener(mFeedToothEditTextWatcher);
        mDepthOfCutEditText.addTextChangedListener(mDepthOfCutEditTextWatcher);
        mWorkingEngagementEditText.addTextChangedListener(mWorkingEngagementEditTextWatcher);
        mNetPowerRequirementEditText.addTextChangedListener(mNetPowerRequirementEditTextWatcher);
        mDrillDiameterEditText.addTextChangedListener(mDrillDiameterEditTextWatcher);
        mMachiningDrillingLengthEditText.addTextChangedListener(mMachiningDrillingLengthEditTextWatcher);
    }

    private void initEditTexts(){
        switch (mMachiningType){
            case TURNING:
                mMachinedDiameterEditText.setText(mCalculatorCachedValuesLab.getTurningMachinedDiameter() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getTurningMachinedDiameter()));
                mSpindleSpeedEditText.setText(mCalculatorCachedValuesLab.getTurningSpindleSpeed() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getTurningSpindleSpeed()));
                mCuttingSpeedEditText.setText(mCalculatorCachedValuesLab.getTurningCuttingSpeed() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getTurningCuttingSpeed()));
                mCuttingDepthEditText.setText(mCalculatorCachedValuesLab.getTurningCuttingDepth() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getTurningCuttingDepth()));
                mFeedPerRevolutionEditText.setText(mCalculatorCachedValuesLab.getTurningFeedPerRevolution() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getTurningFeedPerRevolution()));
                mSpecificCuttingForceEditText.setText(mCalculatorCachedValuesLab.getTurningSpecificCuttingForce() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getTurningSpecificCuttingForce()));
                mMachinedLengthEditText.setText(mCalculatorCachedValuesLab.getTurningMachinedLength() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getTurningMachinedLength()));
                break;
            case MILLING:
                mCuttingDiameterAtDepthEditText.setText(mCalculatorCachedValuesLab.getMillingCuttingDiameterAtDepth() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getMillingCuttingDiameterAtDepth()));
                mSpindleSpeedEditText.setText(mCalculatorCachedValuesLab.getMillingSpindleSpeed() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getMillingSpindleSpeed()));
                mCuttingSpeedEditText.setText(mCalculatorCachedValuesLab.getMillingCuttingSpeed() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getMillingCuttingSpeed()));
                mTableFeedEditText.setText(mCalculatorCachedValuesLab.getMillingTableFeed() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getMillingTableFeed()));
                mNumberOfEffectiveTeethEditText.setText(mCalculatorCachedValuesLab.getMillingNumberOfEffectiveTeeth() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getMillingNumberOfEffectiveTeeth()));
                mFeedToothEditText.setText(mCalculatorCachedValuesLab.getMillingFeedTooth() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getMillingFeedTooth()));
                mDepthOfCutEditText.setText(mCalculatorCachedValuesLab.getMillingDepthOfCut() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getMillingDepthOfCut()));
                mWorkingEngagementEditText.setText(mCalculatorCachedValuesLab.getMillingWorkingEngagement() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getMillingWorkingEngagement()));
                mSpecificCuttingForceEditText.setText(mCalculatorCachedValuesLab.getMillingSpecificCuttingForce() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getMillingSpecificCuttingForce()));
                mNetPowerRequirementEditText.setText(mCalculatorCachedValuesLab.getMillingNetPowerRequirement() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getMillingNetPowerRequirement()));
                break;
            case DRILLING:
                mDrillDiameterEditText.setText(mCalculatorCachedValuesLab.getDrillingDrillDiameter() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getDrillingDrillDiameter()));
                mSpindleSpeedEditText.setText(mCalculatorCachedValuesLab.getDrillingSpindleSpeed() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getDrillingSpindleSpeed()));
                mCuttingSpeedEditText.setText(mCalculatorCachedValuesLab.getDrillingCuttingSpeed() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getDrillingCuttingSpeed()));
                mTableFeedEditText.setText(mCalculatorCachedValuesLab.getDrillingPenetrationRate() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getDrillingPenetrationRate()));
                mFeedPerRevolutionEditText.setText(mCalculatorCachedValuesLab.getDrillingFeedPerRevolution() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getDrillingFeedPerRevolution()));
                mMachiningDrillingLengthEditText.setText(mCalculatorCachedValuesLab.getDrillingMachiningDrillingLength() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getDrillingMachiningDrillingLength()));
                mSpecificCuttingForceEditText.setText(mCalculatorCachedValuesLab.getDrillingSpecificCuttingForce() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getDrillingSpecificCuttingForce()));
                mNetPowerRequirementEditText.setText(mCalculatorCachedValuesLab.getDrillingNetPowerRequirement() == null ? null : Utils.fmt4(mCalculatorCachedValuesLab.getDrillingNetPowerRequirement()));
                break;
        }
    }

    public void initView(){
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

        initEditTexts();

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

        switch (mMachiningType){
            case TURNING:
                switch (mItemPos){
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
            case MILLING:
                switch (mItemPos){
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
            case DRILLING:
                switch (mItemPos){
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

    private void initResult(){

        switch (mMachiningType){
            case TURNING:
                switch (mItemPos){
                    case 0:
                        mCalculatorCachedValuesLab.updateTurningValues(0);
                        if (mCalculatorCachedValuesLab.getTurningCuttingSpeed() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getTurningCuttingSpeed()) + " " + getResources().getString(R.string.m_min));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 1:
                        mCalculatorCachedValuesLab.updateTurningValues(1);
                        if (mCalculatorCachedValuesLab.getTurningSpindleSpeed() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getTurningSpindleSpeed()) + " " + getResources().getString(R.string.rpm));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 2:
                        mCalculatorCachedValuesLab.updateTurningValues(2);
                        if (mCalculatorCachedValuesLab.getTurningMetalRemovalRate() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getTurningMetalRemovalRate()) + " " + getResources().getString(R.string.cm3_min));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 3:
                        mCalculatorCachedValuesLab.updateTurningValues(3);
                        if (mCalculatorCachedValuesLab.getTurningNetPowerRequirement() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getTurningNetPowerRequirement()) + " " + getResources().getString(R.string.kW));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 4:
                        mCalculatorCachedValuesLab.updateTurningValues(4);
                        if (mCalculatorCachedValuesLab.getTurningMachiningTime() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getTurningMachiningTime()) + " " + getResources().getString(R.string.min));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                }
                break;
            case MILLING:
                switch (mItemPos){
                    case 0:
                        mCalculatorCachedValuesLab.updateMillingValues(0);
                        if (mCalculatorCachedValuesLab.getMillingCuttingSpeed() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getMillingCuttingSpeed()) + " " + getResources().getString(R.string.m_min));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 1:
                        mCalculatorCachedValuesLab.updateMillingValues(1);
                        if (mCalculatorCachedValuesLab.getMillingSpindleSpeed() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getMillingSpindleSpeed()) + " " + getResources().getString(R.string.rpm));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 2:
                        mCalculatorCachedValuesLab.updateMillingValues(2);
                        if (mCalculatorCachedValuesLab.getMillingFeedTooth() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getMillingFeedTooth()) + " " + getResources().getString(R.string.mm));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 3:
                        mCalculatorCachedValuesLab.updateMillingValues(3);
                        if (mCalculatorCachedValuesLab.getMillingTableFeed() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getMillingTableFeed()) + " " + getResources().getString(R.string.mm_min));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 4:
                        mCalculatorCachedValuesLab.updateMillingValues(4);
                        if (mCalculatorCachedValuesLab.getMillingMetalRemovalRate() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getMillingMetalRemovalRate()) + " " + getResources().getString(R.string.cm3_min));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 5:
                        mCalculatorCachedValuesLab.updateMillingValues(5);
                        if (mCalculatorCachedValuesLab.getMillingNetPowerRequirement() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getMillingNetPowerRequirement()) + " " + getResources().getString(R.string.kW));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 6:
                        mCalculatorCachedValuesLab.updateMillingValues(6);
                        if (mCalculatorCachedValuesLab.getMillingTorque() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getMillingTorque()) + " " + getResources().getString(R.string.Nm));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                }
                break;
            case DRILLING:
                switch (mItemPos){
                    case 0:
                        mCalculatorCachedValuesLab.updateDrillingValues(0);
                        if (mCalculatorCachedValuesLab.getDrillingCuttingSpeed() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getDrillingCuttingSpeed()) + " " + getResources().getString(R.string.m_min));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 1:
                        mCalculatorCachedValuesLab.updateDrillingValues(1);
                        if (mCalculatorCachedValuesLab.getDrillingSpindleSpeed() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getDrillingSpindleSpeed()) + " " + getResources().getString(R.string.rpm));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 2:
                        mCalculatorCachedValuesLab.updateDrillingValues(2);
                        if (mCalculatorCachedValuesLab.getDrillingFeedPerRevolution() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getDrillingFeedPerRevolution()) + " " + getResources().getString(R.string.mm_r));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 3:
                        mCalculatorCachedValuesLab.updateDrillingValues(3);
                        if (mCalculatorCachedValuesLab.getDrillingPenetrationRate() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getDrillingPenetrationRate()) + " " + getResources().getString(R.string.mm_min));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 4:
                        mCalculatorCachedValuesLab.updateDrillingValues(4);
                        if (mCalculatorCachedValuesLab.getDrillingMetalRemovalRate() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getDrillingMetalRemovalRate()) + " " + getResources().getString(R.string.cm3_min));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 5:
                        mCalculatorCachedValuesLab.updateDrillingValues(5);
                        if (mCalculatorCachedValuesLab.getDrillingMachiningTime() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getDrillingMachiningTime()) + " " + getResources().getString(R.string.min));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 6:
                        mCalculatorCachedValuesLab.updateDrillingValues(6);
                        if (mCalculatorCachedValuesLab.getDrillingNetPowerRequirement() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getDrillingNetPowerRequirement()) + " " + getResources().getString(R.string.kW));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 7:
                        mCalculatorCachedValuesLab.updateDrillingValues(7);
                        if (mCalculatorCachedValuesLab.getDrillingTorque() != null){
                            mResult.setText(Utils.fmt4(mCalculatorCachedValuesLab.getDrillingTorque()) + " " + getResources().getString(R.string.Nm));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                }
                break;
        }
    }

    private TextWatcher mMachinedDiameterEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCalculatorCachedValuesLab.setTurningMachinedDiameter(new BigDecimal(Double.parseDouble(charSequence.toString())));
            } catch (NumberFormatException ex){
                mCalculatorCachedValuesLab.setTurningMachinedDiameter(null);
            } finally {
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mSpindleSpeedEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                switch (mMachiningType){
                    case TURNING:
                        mCalculatorCachedValuesLab.setTurningSpindleSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case MILLING:
                        mCalculatorCachedValuesLab.setMillingSpindleSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingSpindleSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
            } catch (NumberFormatException ex){
                switch (mMachiningType){
                    case TURNING:
                        mCalculatorCachedValuesLab.setTurningSpindleSpeed(null);
                        break;
                    case MILLING:
                        mCalculatorCachedValuesLab.setMillingSpindleSpeed(null);
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingSpindleSpeed(null);
                        break;
                }
            } finally {
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mCuttingSpeedEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                switch (mMachiningType){
                    case TURNING:
                        mCalculatorCachedValuesLab.setTurningCuttingSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case MILLING:
                        mCalculatorCachedValuesLab.setMillingCuttingSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingCuttingSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
                initResult();
            } catch (NumberFormatException ex){
                switch (mMachiningType){
                    case TURNING:
                        mCalculatorCachedValuesLab.setTurningCuttingSpeed(null);
                        break;
                    case MILLING:
                        mCalculatorCachedValuesLab.setMillingCuttingSpeed(null);
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingCuttingSpeed(null);
                        break;
                }
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mCuttingDepthEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCalculatorCachedValuesLab.setTurningCuttingDepth(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCalculatorCachedValuesLab.setTurningCuttingDepth(null);
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mFeedPerRevolutionEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                switch (mMachiningType){
                    case TURNING:
                        mCalculatorCachedValuesLab.setTurningFeedPerRevolution(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingFeedPerRevolution(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
                initResult();
            } catch (NumberFormatException ex){
                switch (mMachiningType){
                    case TURNING:
                        mCalculatorCachedValuesLab.setTurningFeedPerRevolution(null);
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingFeedPerRevolution(null);
                        break;
                }
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mSpecificCuttingForceEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                switch (mMachiningType){
                    case TURNING:
                        mCalculatorCachedValuesLab.setTurningSpecificCuttingForce(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case MILLING:
                        mCalculatorCachedValuesLab.setMillingSpecificCuttingForce(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingSpecificCuttingForce(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
                initResult();
            } catch (NumberFormatException ex){
                switch (mMachiningType){
                    case TURNING:
                        mCalculatorCachedValuesLab.setTurningSpecificCuttingForce(null);
                        break;
                    case MILLING:
                        mCalculatorCachedValuesLab.setMillingSpecificCuttingForce(null);
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingSpecificCuttingForce(null);
                        break;
                }
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mMachinedLengthEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCalculatorCachedValuesLab.setTurningMachinedLength(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCalculatorCachedValuesLab.setTurningMachinedLength(null);
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mCuttingDiameterAtDepthEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCalculatorCachedValuesLab.setMillingCuttingDiameterAtDepth(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCalculatorCachedValuesLab.setMillingCuttingDiameterAtDepth(null);
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mTableFeedEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                switch (mMachiningType){
                    case MILLING:
                        mCalculatorCachedValuesLab.setMillingTableFeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingPenetrationRate(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
                initResult();
            } catch (NumberFormatException ex){
                switch (mMachiningType){
                    case MILLING:
                        mCalculatorCachedValuesLab.setMillingTableFeed(null);
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingPenetrationRate(null);
                        break;
                }
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mNumberOfEffectiveTeethEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCalculatorCachedValuesLab.setMillingNumberOfEffectiveTeeth(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCalculatorCachedValuesLab.setMillingNumberOfEffectiveTeeth(null);
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mFeedToothEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCalculatorCachedValuesLab.setMillingFeedTooth(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCalculatorCachedValuesLab.setMillingFeedTooth(null);
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mDepthOfCutEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCalculatorCachedValuesLab.setMillingDepthOfCut(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCalculatorCachedValuesLab.setMillingDepthOfCut(null);
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mWorkingEngagementEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCalculatorCachedValuesLab.setMillingWorkingEngagement(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCalculatorCachedValuesLab.setMillingWorkingEngagement(null);
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mNetPowerRequirementEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                switch (mMachiningType){
                    case MILLING:
                        mCalculatorCachedValuesLab.setMillingNetPowerRequirement(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingNetPowerRequirement(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
                initResult();
            } catch (NumberFormatException ex){
                switch (mMachiningType){
                    case MILLING:
                        mCalculatorCachedValuesLab.setMillingNetPowerRequirement(null);
                        break;
                    case DRILLING:
                        mCalculatorCachedValuesLab.setDrillingNetPowerRequirement(null);
                        break;
                }
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mDrillDiameterEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCalculatorCachedValuesLab.setDrillingDrillDiameter(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCalculatorCachedValuesLab.setDrillingDrillDiameter(null);
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mMachiningDrillingLengthEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCalculatorCachedValuesLab.setDrillingMachiningDrillingLength(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCalculatorCachedValuesLab.setDrillingMachiningDrillingLength(null);
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private enum MachiningType {
        TURNING,
        MILLING,
        DRILLING
    }
}
