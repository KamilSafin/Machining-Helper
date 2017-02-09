package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kamil.machininghelper.Model.CreatorCachedValuesLab;
import com.example.kamil.machininghelper.Model.CreatorLab;
import com.example.kamil.machininghelper.Model.Material;
import com.example.kamil.machininghelper.R;

import java.math.BigDecimal;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MillingCreatorFragment extends Fragment implements ChooseMaterialDialog.DialogMaterialCallback {

    private static final String CHOOSE_MATERIAL_DIALOG = MillingCreatorFragment.class.getName() + "_choose_material_dialog";

    @BindView(R.id.mill_hss_bg)
    View mMillHSSBg;

    @BindView(R.id.mill_carboned_bg)
    View mMillCarbonedBg;

    @BindView(R.id.choose_material_text)
    TextView mChooseMaterialText;

    @BindView(R.id.cutting_speed)
    LinearLayout mCuttingSpeed;

    @BindView(R.id.cutting_speed_text)
    TextView mCuttingSpeedText;

    @BindView(R.id.cutting_speed_recommended)
    TextView mCuttingSpeedRecommended;

    @BindView(R.id.cutting_speed_edit_text)
    EditText mCuttingSpeedEditText;

    @BindView(R.id.cutting_speed_warning_image)
    ImageView mCuttingSpeedWarningImage;

    @BindView(R.id.cutting_speed_warning_text)
    TextView mCuttingSpeedWarningText;

    @BindView(R.id.cutting_diameter_at_depth)
    LinearLayout mCuttingDiameterAtDepth;

    @BindView(R.id.cutting_diameter_at_depth_text)
    TextView mCuttingDiameterAtDepthText;

    @BindView(R.id.cutting_diameter_at_depth_edit_text)
    EditText mCuttingDiameterAtDepthEditText;

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

    @BindView(R.id.feed_tooth_recommended)
    TextView mFeedToothRecommended;

    @BindView(R.id.feed_tooth_edit_text)
    EditText mFeedToothEditText;

    @BindView(R.id.feed_tooth_warning_image)
    ImageView mFeedToothWarningImage;

    @BindView(R.id.feed_tooth_warning_text)
    TextView mFeedToothWarningText;

    @BindView(R.id.spindle_speed)
    LinearLayout mSpindleSpeed;

    @BindView(R.id.spindle_speed_text)
    TextView mSpindleSpeedText;

    @BindView(R.id.spindle_speed_result)
    TextView mSpindleSpeedEditText;

    @BindView(R.id.table_feed)
    LinearLayout mTableFeed;

    @BindView(R.id.table_feed_text)
    TextView mTableFeedText;

    @BindView(R.id.table_feed_result)
    TextView mTableFeedEditText;

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

    @BindView(R.id.metal_removal_rate)
    LinearLayout mMetalRemovalRate;

    @BindView(R.id.metal_removal_rate_text)
    TextView mMetalRemovalRateText;

    @BindView(R.id.metal_removal_rate_result)
    TextView mMetalRemovalRateEditText;

    private CreatorCachedValuesLab mCreatorCachedValuesLab;
    private Boolean mIsHSSDrill = null;
    private CreatorLab mCreatorLab;
    private Integer mIndex = null;
    private Material mMaterial;

    public static Fragment initFragment() {
        Fragment fragment = new MillingCreatorFragment();

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCreatorLab = CreatorLab.getCreatorLab(getContext());
        mCreatorCachedValuesLab = CreatorCachedValuesLab.getCachedValuesLab(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_milling_creator, container, false);

        ButterKnife.bind(this, view);

        if (mCreatorCachedValuesLab.getMillingMaterial() != null) {
            mMaterial = mCreatorCachedValuesLab.getMillingMaterial();
            mIsHSSDrill = mCreatorCachedValuesLab.isMillingHssDrill();
            if (mIsHSSDrill) {
                mMillHSSBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
                List<Material> materials = mCreatorLab.getSteelMillingMaterials();
                for (int i = 0; i < materials.size(); i++) {
                    if (materials.get(i).getName().equals(mMaterial.getName())) {
                        mIndex = i;
                        break;
                    }
                }
            } else {
                mMillCarbonedBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
                List<Material> materials = mCreatorLab.getCarbideMillingMaterials();
                for (int i = 0; i < materials.size(); i++) {
                    if (materials.get(i).getName().equals(mMaterial.getName())) {
                        mIndex = i;
                        break;
                    }
                }
            }
            mChooseMaterialText.setText(mMaterial.getName());

            if (mCreatorCachedValuesLab.getMillingCuttingDiameterAtDepth() != null) {
                mCuttingDiameterAtDepthEditText.setText("" + Math.round(mCreatorCachedValuesLab.getMillingCuttingDiameterAtDepth().doubleValue() * 100f) / 100f);
            }
            if (mCreatorCachedValuesLab.getMillingNumberOfEffectiveTeeth() != null) {
                mNumberOfEffectiveTeethEditText.setText("" + Math.round(mCreatorCachedValuesLab.getMillingNumberOfEffectiveTeeth().doubleValue()));
            }
            if (mCreatorCachedValuesLab.getMillingCuttingSpeed() != null) {
                mCuttingSpeedEditText.setText("" + Math.round(mCreatorCachedValuesLab.getMillingCuttingSpeed().doubleValue() * 100f) / 100f);

                if (mCreatorCachedValuesLab.getMillingCuttingSpeed().doubleValue() >= mMaterial.getMinCuttingSpeed() &&
                        mCreatorCachedValuesLab.getMillingCuttingSpeed().doubleValue() <= mMaterial.getMaxCuttingSpeed()) {
                    mCuttingSpeedWarningImage.setVisibility(View.GONE);
                    mCuttingSpeedWarningText.setVisibility(View.GONE);
                } else {
                    mCuttingSpeedWarningImage.setVisibility(View.VISIBLE);
                    mCuttingSpeedWarningText.setVisibility(View.VISIBLE);
                }
            }
            if (mCreatorCachedValuesLab.getMillingFeedTooth() != null) {
                mFeedToothEditText.setText("" + Math.round(mCreatorCachedValuesLab.getMillingFeedTooth().doubleValue() * 100f) / 100f);

                if (mCreatorCachedValuesLab.getMillingFeedTooth().doubleValue() >= mMaterial.getMinFeedPerTooth() &&
                        mCreatorCachedValuesLab.getMillingFeedTooth().doubleValue() <= mMaterial.getMaxFeedPerTooth()) {
                    mFeedToothWarningImage.setVisibility(View.GONE);
                    mFeedToothWarningText.setVisibility(View.GONE);
                } else {
                    mFeedToothWarningImage.setVisibility(View.VISIBLE);
                    mFeedToothWarningText.setVisibility(View.VISIBLE);
                }
            }
            if (mCreatorCachedValuesLab.getMillingDepthOfCut() != null) {
                mDepthOfCutEditText.setText("" + Math.round(mCreatorCachedValuesLab.getMillingDepthOfCut().doubleValue() * 100f) / 100f);
            }
            if (mCreatorCachedValuesLab.getMillingWorkingEngagement() != null) {
                mWorkingEngagementEditText.setText("" + Math.round(mCreatorCachedValuesLab.getMillingWorkingEngagement().doubleValue() * 100f) / 100f);
            }

            updateView();
        }

        addListeners();

        return view;
    }

    private void addListeners() {
        mCuttingSpeedEditText.addTextChangedListener(mCuttingSpeedEditTextWatcher);
        mFeedToothEditText.addTextChangedListener(mFeedToothEditTextWatcher);
        mCuttingDiameterAtDepthEditText.addTextChangedListener(mCuttingDiameterAtDepthEditTextWatcher);
        mNumberOfEffectiveTeethEditText.addTextChangedListener(mNumberOfEffectiveTeethEditTextWatcher);
        mDepthOfCutEditText.addTextChangedListener(mDepthOfCutEditTextWatcher);
        mWorkingEngagementEditText.addTextChangedListener(mWorkingEngagementEditTextWatcher);
    }

    @OnClick(R.id.mill_hss)
    public void setMillHSS() {
        mMillHSSBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
        mMillCarbonedBg.setBackground(null);
        mCreatorCachedValuesLab.setMillingHssDrill(true);
        mIsHSSDrill = true;
        if (mIndex != null) {
            mMaterial = mCreatorLab.getSteelMillingMaterials().get(mIndex);
            updateView();
        }
        updateRecommended();
    }

    @OnClick(R.id.mill_carboned)
    public void setMillCarboned() {
        mMillHSSBg.setBackground(null);
        mMillCarbonedBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
        mCreatorCachedValuesLab.setMillingHssDrill(false);
        mIsHSSDrill = false;
        if (mIndex != null) {
            mMaterial = mCreatorLab.getCarbideMillingMaterials().get(mIndex);
            updateView();
        }
        updateRecommended();
    }

    @OnClick(R.id.choose_material)
    public void setChooseMaterial() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ChooseMaterialDialog dialog = ChooseMaterialDialog.newInstance();
        if (mIsHSSDrill != null) {
            dialog.show(fragmentManager, CHOOSE_MATERIAL_DIALOG, this, mIsHSSDrill);
        }
    }

    public void resetView() {
        mMaterial = null;
        mIndex = null;
        mCreatorCachedValuesLab.removeMillingValues();
        mMillCarbonedBg.setBackground(null);
        mMillHSSBg.setBackground(null);
        mSpindleSpeedEditText.setText("");
        mTableFeedEditText.setText("");
        mSpindleSpeed.setVisibility(View.GONE);
        mTableFeed.setVisibility(View.GONE);
        mDepthOfCut.setVisibility(View.GONE);
        mWorkingEngagement.setVisibility(View.GONE);
        mChooseMaterialText.setText(getString(R.string.choose_material));
        mCuttingDiameterAtDepthEditText.setText(null);
        mNumberOfEffectiveTeethEditText.setText(null);
        mCuttingSpeedEditText.setText(null);
        mFeedToothEditText.setText(null);
        mMetalRemovalRateEditText.setText(null);
        mMetalRemovalRate.setVisibility(View.GONE);
        mDepthOfCutEditText.setText(null);
        mWorkingEngagementEditText.setText(null);

        updateView();
    }

    private void updateView() {
        String[] parametersNames = getResources().getStringArray(R.array.machining_formulas);
        if (mMaterial != null) {
            mCuttingDiameterAtDepth.setVisibility(View.VISIBLE);
            mCuttingDiameterAtDepthText.setText(parametersNames[7]);

            mNumberOfEffectiveTeeth.setVisibility(View.VISIBLE);
            mNumberOfEffectiveTeethText.setText(parametersNames[9]);

            mCuttingSpeed.setVisibility(View.VISIBLE);
            mCuttingSpeedText.setText(parametersNames[2]);
            mCuttingSpeedRecommended.setText(recommendedValues(mMaterial.getMinCuttingSpeed(), mMaterial.getMaxCuttingSpeed()));

            mFeedTooth.setVisibility(View.VISIBLE);
            mFeedToothText.setText(parametersNames[10]);
            mFeedToothRecommended.setText(recommendedValues(mMaterial.getMinFeedPerTooth(), mMaterial.getMaxFeedPerTooth()));

            if (mCreatorCachedValuesLab.getMillingSpindleSpeed() != null) {
                mSpindleSpeed.setVisibility(View.VISIBLE);
                mSpindleSpeedText.setText(parametersNames[1]);
                mSpindleSpeedEditText.setText("" + (int) Math.round(mCreatorCachedValuesLab.getMillingSpindleSpeed().doubleValue()) + " " + getString(R.string.rpm));
            } else {
                mSpindleSpeed.setVisibility(View.GONE);
            }

            if (mCreatorCachedValuesLab.getMillingTableFeed() != null) {
                mTableFeed.setVisibility(View.VISIBLE);
                mTableFeedText.setText(parametersNames[8]);
                mTableFeedEditText.setText("" + (int) Math.round(mCreatorCachedValuesLab.getMillingTableFeed().doubleValue()) + " " + getString(R.string.mm_min));

                mDepthOfCut.setVisibility(View.VISIBLE);
                mDepthOfCutText.setText(parametersNames[11]);

                mWorkingEngagement.setVisibility(View.VISIBLE);
                mWorkingEngagementText.setText(parametersNames[12]);
            } else {
                mTableFeed.setVisibility(View.GONE);
                mTableFeedEditText.setText("");
                mDepthOfCut.setVisibility(View.GONE);
                mWorkingEngagement.setVisibility(View.GONE);
                mMetalRemovalRate.setVisibility(View.GONE);
            }

            if (mCreatorCachedValuesLab.getMillingMetalRemovalRate() != null && mCreatorCachedValuesLab.getMillingTableFeed() != null) {
                mMetalRemovalRate.setVisibility(View.VISIBLE);
                mMetalRemovalRateText.setText(parametersNames[16]);
                mCreatorCachedValuesLab.updateMillingValues(4);
                mMetalRemovalRateEditText.setText("" + Math.round(mCreatorCachedValuesLab.getMillingMetalRemovalRate().doubleValue() * 100f) / 100f + " " + getString(R.string.cm3_min));
            } else {
                mMetalRemovalRate.setVisibility(View.GONE);
                mMetalRemovalRateEditText.setText("");
            }
        } else {
            mCuttingDiameterAtDepth.setVisibility(View.GONE);
            mNumberOfEffectiveTeeth.setVisibility(View.GONE);
            mCuttingSpeed.setVisibility(View.GONE);
            mFeedTooth.setVisibility(View.GONE);
        }
    }

    private String recommendedValues(double minValue, double maxValue) {
        return getString(R.string.recommended_values) + ": (" + formatValue(minValue) + " - " + formatValue(maxValue) + ")";
    }

    private String formatValue(double value) {
        int testValue = (int) value;
        if (testValue == value) {
            return "" + testValue;
        } else {
            return String.format("%.3f", value).replace(",", ".");
        }
    }

    private void updateRecommended() {
        String cuttingSpeedText = mCuttingSpeedEditText.getText().toString();
        mCuttingSpeedEditText.setText(cuttingSpeedText);
        String feedToothText = mFeedToothEditText.getText().toString();
        mFeedToothEditText.setText(feedToothText);
    }

    @Override
    public void onMaterialSelected(int index) {
        if (mIsHSSDrill) {
            List<Material> materials = mCreatorLab.getSteelMillingMaterials();
            mIndex = index;
            mMaterial = materials.get(mIndex);
        } else {
            List<Material> materials = mCreatorLab.getCarbideMillingMaterials();
            mIndex = index;
            mMaterial = materials.get(mIndex);
        }
        mChooseMaterialText.setText(mMaterial.getName());
        mCreatorCachedValuesLab.setMillingMaterial(mMaterial);
        updateView();
        updateRecommended();
    }

    private TextWatcher mCuttingSpeedEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                BigDecimal millingCuttingSpeed = new BigDecimal(Double.parseDouble(charSequence.toString()));
                if (millingCuttingSpeed.doubleValue() >= mMaterial.getMinCuttingSpeed() &&
                        millingCuttingSpeed.doubleValue() <= mMaterial.getMaxCuttingSpeed()) {
                    mCuttingSpeedWarningImage.setVisibility(View.GONE);
                    mCuttingSpeedWarningText.setVisibility(View.GONE);
                } else {
                    mCuttingSpeedWarningImage.setVisibility(View.VISIBLE);
                    mCuttingSpeedWarningText.setVisibility(View.VISIBLE);
                }
                mCreatorCachedValuesLab.setMillingCuttingSpeed(millingCuttingSpeed);
            } catch (NumberFormatException ex) {
                mCreatorCachedValuesLab.setMillingCuttingSpeed(null);
                mCuttingSpeedWarningImage.setVisibility(View.GONE);
                mCuttingSpeedWarningText.setVisibility(View.GONE);
            } finally {
                mCreatorCachedValuesLab.updateMillingValues(1);
                mCreatorCachedValuesLab.updateMillingValues(3);
                updateView();
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
                BigDecimal millingFeedTooth = new BigDecimal(Double.parseDouble(charSequence.toString()));
                if (millingFeedTooth.doubleValue() >= mMaterial.getMinFeedPerTooth() &&
                        millingFeedTooth.doubleValue() <= mMaterial.getMaxFeedPerTooth()) {
                    mFeedToothWarningImage.setVisibility(View.GONE);
                    mFeedToothWarningText.setVisibility(View.GONE);
                } else {
                    mFeedToothWarningImage.setVisibility(View.VISIBLE);
                    mFeedToothWarningText.setVisibility(View.VISIBLE);
                }
                mCreatorCachedValuesLab.setMillingFeedTooth(millingFeedTooth);
            } catch (NumberFormatException ex){
                mCreatorCachedValuesLab.setMillingFeedTooth(null);
                mCuttingSpeedWarningImage.setVisibility(View.GONE);
                mCuttingSpeedWarningText.setVisibility(View.GONE);
            } finally {
                mCreatorCachedValuesLab.updateMillingValues(1);
                mCreatorCachedValuesLab.updateMillingValues(3);
                updateView();
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
                mCreatorCachedValuesLab.setMillingCuttingDiameterAtDepth(new BigDecimal(Double.parseDouble(charSequence.toString())));
            } catch (NumberFormatException ex){
                mCreatorCachedValuesLab.setMillingCuttingDiameterAtDepth(null);
            } finally {
                mCreatorCachedValuesLab.updateMillingValues(1);
                mCreatorCachedValuesLab.updateMillingValues(3);
                updateView();
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
                mCreatorCachedValuesLab.setMillingNumberOfEffectiveTeeth(new BigDecimal(Double.parseDouble(charSequence.toString())));
            } catch (NumberFormatException ex){
                mCreatorCachedValuesLab.setMillingNumberOfEffectiveTeeth(null);
            } finally {
                mCreatorCachedValuesLab.updateMillingValues(1);
                mCreatorCachedValuesLab.updateMillingValues(3);
                updateView();
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
                mCreatorCachedValuesLab.setMillingDepthOfCut(new BigDecimal(Double.parseDouble(charSequence.toString())));
            } catch (NumberFormatException ex){
                mCreatorCachedValuesLab.setMillingDepthOfCut(null);
            } finally {
                mCreatorCachedValuesLab.updateMillingValues(4);
                updateView();
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
                mCreatorCachedValuesLab.setMillingWorkingEngagement(new BigDecimal(Double.parseDouble(charSequence.toString())));
            } catch (NumberFormatException ex){
                mCreatorCachedValuesLab.setMillingWorkingEngagement(null);
            } finally {
                mCreatorCachedValuesLab.updateMillingValues(4);
                updateView();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
