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
import com.example.kamil.machininghelper.Model.CachedValuesLab;
import com.example.kamil.machininghelper.R;
import com.example.kamil.machininghelper.Utils.Utils;

import java.math.BigDecimal;
import java.util.Locale;

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

    private CachedValuesLab mCachedValuesLab;
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

        mCachedValuesLab = CachedValuesLab.getCachedValuesLab(getContext());
        mItemPos = getArguments().getInt(ARGS_FRAGMENT_ITEM_POS);
        mIndex = getArguments().getInt(ARGS_FRAGMENT_INDEX);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator_formulas, container, false);

        ButterKnife.bind(this, view);

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
        switch (mIndex){
            case 0:
                mMachinedDiameterEditText.setText(mCachedValuesLab.getTurningMachinedDiameter() == null ? null : Utils.fmt4(mCachedValuesLab.getTurningMachinedDiameter()));
                mSpindleSpeedEditText.setText(mCachedValuesLab.getTurningSpindleSpeed() == null ? null : Utils.fmt4(mCachedValuesLab.getTurningSpindleSpeed()));
                mCuttingSpeedEditText.setText(mCachedValuesLab.getTurningCuttingSpeed() == null ? null : Utils.fmt4(mCachedValuesLab.getTurningCuttingSpeed()));
                mCuttingDepthEditText.setText(mCachedValuesLab.getTurningCuttingDepth() == null ? null : Utils.fmt4(mCachedValuesLab.getTurningCuttingDepth()));
                mFeedPerRevolutionEditText.setText(mCachedValuesLab.getTurningFeedPerRevolution() == null ? null : Utils.fmt4(mCachedValuesLab.getTurningFeedPerRevolution()));
                mSpecificCuttingForceEditText.setText(mCachedValuesLab.getTurningSpecificCuttingForce() == null ? null : Utils.fmt4(mCachedValuesLab.getTurningSpecificCuttingForce()));
                mMachinedLengthEditText.setText(mCachedValuesLab.getTurningMachinedLength() == null ? null : Utils.fmt4(mCachedValuesLab.getTurningMachinedLength()));


                break;
            case 1:
                mCuttingDiameterAtDepthEditText.setText(mCachedValuesLab.getMillingCuttingDiameterAtDepth() == null ? null : Utils.fmt4(mCachedValuesLab.getMillingCuttingDiameterAtDepth()));
                mSpindleSpeedEditText.setText(mCachedValuesLab.getMillingSpindleSpeed() == null ? null : Utils.fmt4(mCachedValuesLab.getMillingSpindleSpeed()));
                mCuttingSpeedEditText.setText(mCachedValuesLab.getMillingCuttingSpeed() == null ? null : Utils.fmt4(mCachedValuesLab.getMillingCuttingSpeed()));
                mTableFeedEditText.setText(mCachedValuesLab.getMillingTableFeed() == null ? null : Utils.fmt4(mCachedValuesLab.getMillingTableFeed()));
                mNumberOfEffectiveTeethEditText.setText(mCachedValuesLab.getMillingNumberOfEffectiveTeeth() == null ? null : Utils.fmt4(mCachedValuesLab.getMillingNumberOfEffectiveTeeth()));
                mFeedToothEditText.setText(mCachedValuesLab.getMillingFeedTooth() == null ? null : Utils.fmt4(mCachedValuesLab.getMillingFeedTooth()));
                mDepthOfCutEditText.setText(mCachedValuesLab.getMillingDepthOfCut() == null ? null : Utils.fmt4(mCachedValuesLab.getMillingDepthOfCut()));
                mWorkingEngagementEditText.setText(mCachedValuesLab.getMillingWorkingEngagement() == null ? null : Utils.fmt4(mCachedValuesLab.getMillingWorkingEngagement()));
                mSpecificCuttingForceEditText.setText(mCachedValuesLab.getMillingSpecificCuttingForce() == null ? null : Utils.fmt4(mCachedValuesLab.getMillingSpecificCuttingForce()));
                mNetPowerRequirementEditText.setText(mCachedValuesLab.getMillingNetPowerRequirement() == null ? null : Utils.fmt4(mCachedValuesLab.getMillingNetPowerRequirement()));
                break;
            case 2:
                mDrillDiameterEditText.setText(mCachedValuesLab.getDrillingDrillDiameter() == null ? null : Utils.fmt4(mCachedValuesLab.getDrillingDrillDiameter()));
                mSpindleSpeedEditText.setText(mCachedValuesLab.getDrillingSpindleSpeed() == null ? null : Utils.fmt4(mCachedValuesLab.getDrillingSpindleSpeed()));
                mCuttingSpeedEditText.setText(mCachedValuesLab.getDrillingCuttingSpeed() == null ? null : Utils.fmt4(mCachedValuesLab.getDrillingCuttingSpeed()));
                mTableFeedEditText.setText(mCachedValuesLab.getDrillingTableFeed() == null ? null : Utils.fmt4(mCachedValuesLab.getDrillingTableFeed()));
                mFeedPerRevolutionEditText.setText(mCachedValuesLab.getDrillingFeedPerRevolution() == null ? null : Utils.fmt4(mCachedValuesLab.getDrillingFeedPerRevolution()));
                mMachiningDrillingLengthEditText.setText(mCachedValuesLab.getDrillingMachiningDrillingLength() == null ? null : Utils.fmt4(mCachedValuesLab.getDrillingMachiningDrillingLength()));
                mSpecificCuttingForceEditText.setText(mCachedValuesLab.getDrillingSpecificCuttingForce() == null ? null : Utils.fmt4(mCachedValuesLab.getDrillingSpecificCuttingForce()));
                mNetPowerRequirementEditText.setText(mCachedValuesLab.getDrillingNetPowerRequirement() == null ? null : Utils.fmt4(mCachedValuesLab.getDrillingNetPowerRequirement()));
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

        switch (mIndex){
            case 0:
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
            case 1:
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
            case 2:
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

        switch (mIndex){
            case 0:
                switch (mItemPos){
                    case 0:
                        mCachedValuesLab.updateTurningValues(0);
                        if (mCachedValuesLab.getTurningCuttingSpeed() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getTurningCuttingSpeed()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 1:
                        mCachedValuesLab.updateTurningValues(1);
                        if (mCachedValuesLab.getTurningSpindleSpeed() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getTurningSpindleSpeed()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 2:
                        mCachedValuesLab.updateTurningValues(2);
                        if (mCachedValuesLab.getTurningMetalRemovalRate() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getTurningMetalRemovalRate()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 3:
                        mCachedValuesLab.updateTurningValues(3);
                        if (mCachedValuesLab.getTurningNetPowerRequirement() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getTurningNetPowerRequirement()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 4:
                        mCachedValuesLab.updateTurningValues(4);
                        if (mCachedValuesLab.getTurningMachiningTime() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getTurningMachiningTime()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                }
                break;
            case 1:
                switch (mItemPos){
                    case 0:
                        mCachedValuesLab.updateMillingValues(0);
                        if (mCachedValuesLab.getMillingCuttingSpeed() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getMillingCuttingSpeed()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 1:
                        mCachedValuesLab.updateMillingValues(1);
                        if (mCachedValuesLab.getMillingSpindleSpeed() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getMillingSpindleSpeed()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 2:
                        mCachedValuesLab.updateMillingValues(2);
                        if (mCachedValuesLab.getMillingFeedTooth() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getMillingFeedTooth()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 3:
                        mCachedValuesLab.updateMillingValues(3);
                        if (mCachedValuesLab.getMillingTableFeed() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getMillingTableFeed()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 4:
                        mCachedValuesLab.updateMillingValues(4);
                        if (mCachedValuesLab.getMillingMetalRemovalRate() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getMillingMetalRemovalRate()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 5:
                        mCachedValuesLab.updateMillingValues(5);
                        if (mCachedValuesLab.getMillingNetPowerRequirement() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getMillingNetPowerRequirement()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 6:
                        mCachedValuesLab.updateMillingValues(6);
                        if (mCachedValuesLab.getMillingTorque() != null){
                            mResult.setText(Utils.fmt4(mCachedValuesLab.getMillingTorque()));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                }
                break;
            case 2:
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

    private TextWatcher mMachinedDiameterEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCachedValuesLab.setTurningMachinedDiameter(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCachedValuesLab.setTurningMachinedDiameter(null);
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
                switch (mIndex){
                    case 0:
                        mCachedValuesLab.setTurningSpindleSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case 1:
                        mCachedValuesLab.setMillingSpindleSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingSpindleSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
                initResult();
            } catch (NumberFormatException ex){
                switch (mIndex){
                    case 0:
                        mCachedValuesLab.setTurningSpindleSpeed(null);
                        break;
                    case 1:
                        mCachedValuesLab.setMillingSpindleSpeed(null);
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingSpindleSpeed(null);
                        break;
                }
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
                switch (mIndex){
                    case 0:
                        mCachedValuesLab.setTurningCuttingSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case 1:
                        mCachedValuesLab.setMillingCuttingSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingCuttingSpeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
                initResult();
            } catch (NumberFormatException ex){
                switch (mIndex){
                    case 0:
                        mCachedValuesLab.setTurningCuttingSpeed(null);
                        break;
                    case 1:
                        mCachedValuesLab.setMillingCuttingSpeed(null);
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingCuttingSpeed(null);
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
                mCachedValuesLab.setTurningCuttingDepth(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCachedValuesLab.setTurningCuttingDepth(null);
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
                switch (mIndex){
                    case 0:
                        mCachedValuesLab.setTurningFeedPerRevolution(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingFeedPerRevolution(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
                initResult();
            } catch (NumberFormatException ex){
                switch (mIndex){
                    case 0:
                        mCachedValuesLab.setTurningFeedPerRevolution(null);
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingFeedPerRevolution(null);
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
                switch (mIndex){
                    case 0:
                        mCachedValuesLab.setTurningSpecificCuttingForce(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case 1:
                        mCachedValuesLab.setMillingSpecificCuttingForce(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingSpecificCuttingForce(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
                initResult();
            } catch (NumberFormatException ex){
                switch (mIndex){
                    case 0:
                        mCachedValuesLab.setTurningSpecificCuttingForce(null);
                        break;
                    case 1:
                        mCachedValuesLab.setMillingSpecificCuttingForce(null);
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingSpecificCuttingForce(null);
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
                mCachedValuesLab.setTurningMachinedLength(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCachedValuesLab.setTurningMachinedLength(null);
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
                mCachedValuesLab.setMillingCuttingDiameterAtDepth(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCachedValuesLab.setMillingCuttingDiameterAtDepth(null);
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
                switch (mIndex){
                    case 1:
                        mCachedValuesLab.setMillingTableFeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingTableFeed(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
                initResult();
            } catch (NumberFormatException ex){
                switch (mIndex){
                    case 1:
                        mCachedValuesLab.setMillingTableFeed(null);
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingTableFeed(null);
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
                mCachedValuesLab.setMillingNumberOfEffectiveTeeth(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCachedValuesLab.setMillingNumberOfEffectiveTeeth(null);
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
                mCachedValuesLab.setMillingFeedTooth(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCachedValuesLab.setMillingFeedTooth(null);
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
                mCachedValuesLab.setMillingDepthOfCut(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCachedValuesLab.setMillingDepthOfCut(null);
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
                mCachedValuesLab.setMillingWorkingEngagement(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCachedValuesLab.setMillingWorkingEngagement(null);
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
                switch (mIndex){
                    case 1:
                        mCachedValuesLab.setMillingNetPowerRequirement(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingNetPowerRequirement(new BigDecimal(Double.parseDouble(charSequence.toString())));
                        break;
                }
                initResult();
            } catch (NumberFormatException ex){
                switch (mIndex){
                    case 1:
                        mCachedValuesLab.setMillingNetPowerRequirement(null);
                        break;
                    case 2:
                        mCachedValuesLab.setDrillingNetPowerRequirement(null);
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
                mCachedValuesLab.setDrillingDrillDiameter(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCachedValuesLab.setDrillingDrillDiameter(null);
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
                mCachedValuesLab.setDrillingMachiningDrillingLength(new BigDecimal(Double.parseDouble(charSequence.toString())));
                initResult();
            } catch (NumberFormatException ex){
                mCachedValuesLab.setDrillingMachiningDrillingLength(null);
                initResult();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

}
