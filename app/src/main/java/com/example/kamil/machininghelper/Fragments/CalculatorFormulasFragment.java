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
import java.text.DecimalFormat;

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

    private DecimalFormat mPrecision = new DecimalFormat("0.000");

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

        mMachinedDiameterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setTurningMachinedDiameter(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setTurningMachinedDiameter(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mSpindleSpeedEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setTurningSpindleSpeed(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setTurningSpindleSpeed(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mCuttingSpeedEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setTurningCuttingSpeed(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setTurningCuttingSpeed(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mCuttingDepthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setTurningCuttingDepth(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setTurningCuttingDepth(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mFeedPerRevolutionEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setTurningFeedPerRevolution(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setTurningFeedPerRevolution(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mSpecificCuttingForceEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setTurningSpecificCuttingForce(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setTurningSpecificCuttingForce(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mMachinedLengthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setTurningMachinedLength(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setTurningMachinedLength(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mCuttingDiameterAtDepthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setMillingCuttingDiameterAtDepth(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setMillingCuttingDiameterAtDepth(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mTableFeedEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setMillingTableFeed(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setMillingTableFeed(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mNumberOfEffectiveTeethEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setMillingNumberOfEffectiveTeeth(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setMillingNumberOfEffectiveTeeth(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mFeedToothEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setMillingFeedTooth(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setMillingFeedTooth(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mDepthOfCutEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setMillingDepthOfCut(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setMillingDepthOfCut(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mWorkingEngagementEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setMillingWorkingEngagement(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setMillingWorkingEngagement(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mNetPowerRequirementEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setMillingNetPowerRequirement(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setMillingNetPowerRequirement(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mDrillDiameterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setDrillingDrillDiameter(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setDrillingDrillDiameter(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mMachiningDrillingLengthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    mCachedValuesLab.setDrillingMachiningDrillingLength(Double.parseDouble(charSequence.toString()));
                    initResult();
                } catch (NumberFormatException ex){
                    mCachedValuesLab.setDrillingMachiningDrillingLength(null);
                    initResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        initView(mIndex, mItemPos);

        initResult();

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

        mMachinedDiameterEditText.setText(mCachedValuesLab.getTurningMachinedDiameter() == null ? null : mPrecision.format(mCachedValuesLab.getTurningMachinedDiameter()).replace(",", "."));
        mSpindleSpeedEditText.setText(mCachedValuesLab.getTurningSpindleSpeed() == null ? null : mPrecision.format(mCachedValuesLab.getTurningSpindleSpeed()).replace(",", "."));
        mCuttingSpeedEditText.setText(mCachedValuesLab.getTurningCuttingSpeed() == null ? null : mPrecision.format(mCachedValuesLab.getTurningCuttingSpeed()).replace(",", "."));
        mCuttingDepthEditText.setText(mCachedValuesLab.getTurningCuttingDepth() == null ? null : mPrecision.format(mCachedValuesLab.getTurningCuttingDepth()).replace(",", "."));
        mFeedPerRevolutionEditText.setText(mCachedValuesLab.getTurningFeedPerRevolution() == null ? null : mPrecision.format(mCachedValuesLab.getTurningFeedPerRevolution()).replace(",", "."));
        mSpecificCuttingForceEditText.setText(mCachedValuesLab.getTurningSpecificCuttingForce() == null ? null : mPrecision.format(mCachedValuesLab.getTurningSpecificCuttingForce()).replace(",", "."));
        mMachinedLengthEditText.setText(mCachedValuesLab.getTurningMachinedLength() == null ? null : mPrecision.format(mCachedValuesLab.getTurningMachinedLength()).replace(",", "."));
        mCuttingDiameterAtDepthEditText.setText(mCachedValuesLab.getMillingCuttingDiameterAtDepth() == null ? null : mPrecision.format(mCachedValuesLab.getMillingCuttingDiameterAtDepth()).replace(",", "."));
        mTableFeedEditText.setText(mCachedValuesLab.getMillingTableFeed() == null ? null : mPrecision.format(mCachedValuesLab.getMillingTableFeed()).replace(",", "."));
        mNumberOfEffectiveTeethEditText.setText(mCachedValuesLab.getMillingNumberOfEffectiveTeeth() == null ? null : mPrecision.format(mCachedValuesLab.getMillingNumberOfEffectiveTeeth()).replace(",", "."));
        mFeedToothEditText.setText(mCachedValuesLab.getMillingFeedTooth() == null ? null : mPrecision.format(mCachedValuesLab.getMillingFeedTooth()).replace(",", "."));
        mDepthOfCutEditText.setText(mCachedValuesLab.getMillingDepthOfCut() == null ? null : mPrecision.format(mCachedValuesLab.getMillingDepthOfCut()).replace(",", "."));
        mWorkingEngagementEditText.setText(mCachedValuesLab.getMillingWorkingEngagement() == null ? null : mPrecision.format(mCachedValuesLab.getMillingWorkingEngagement()).replace(",", "."));
        mNetPowerRequirementEditText.setText(mCachedValuesLab.getMillingNetPowerRequirement() == null ? null : mPrecision.format(mCachedValuesLab.getMillingNetPowerRequirement()).replace(",", "."));
        mDrillDiameterEditText.setText(mCachedValuesLab.getDrillingDrillDiameter() == null ? null : mPrecision.format(mCachedValuesLab.getDrillingDrillDiameter()).replace(",", "."));
        mMachiningDrillingLengthEditText.setText(mCachedValuesLab.getDrillingMachiningDrillingLength() == null ? null : mPrecision.format(mCachedValuesLab.getDrillingMachiningDrillingLength()).replace(",", "."));

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

    private void initResult(){

        switch (mIndex){
            case 0:
                switch (mItemPos){
                    case 0:
                        if (mCachedValuesLab.getTurningCuttingSpeed() != null){
                            mResult.setText(mPrecision.format(mCachedValuesLab.getTurningCuttingSpeed()).replace(",", "."));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 1:
                        if (mCachedValuesLab.getTurningSpindleSpeed() != null){
                            mResult.setText(mPrecision.format(mCachedValuesLab.getTurningSpindleSpeed()).replace(",", "."));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 2:
                        if (mCachedValuesLab.getTurningMetalRemovalRate() != null){
                            mResult.setText(mPrecision.format(mCachedValuesLab.getTurningMetalRemovalRate()).replace(",", "."));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 3:
                        if (mCachedValuesLab.getTurningNetPower() != null){
                            mResult.setText(mPrecision.format(mCachedValuesLab.getTurningNetPower()).replace(",", "."));
                        } else {
                            mResult.setText(null);
                        }
                        break;
                    case 4:
                        if (mCachedValuesLab.getTurningMachiningTime() != null){
                            mResult.setText(mPrecision.format(mCachedValuesLab.getTurningMachiningTime()).replace(",", "."));
                        } else {
                            mResult.setText(null);
                        }
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
}
