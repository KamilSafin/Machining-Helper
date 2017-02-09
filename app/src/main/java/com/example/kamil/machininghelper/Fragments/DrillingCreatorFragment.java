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

public class DrillingCreatorFragment extends Fragment implements ChooseMaterialDialog.DialogMaterialCallback {

    private static final String CHOOSE_MATERIAL_DIALOG = DrillingCreatorFragment.class.getName() + "_choose_material_dialog";

    @BindView(R.id.drill_hss_bg)
    View mDrillHSSBg;

    @BindView(R.id.drill_carboned_bg)
    View mDrillCarbonedBg;

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

    @BindView(R.id.feed_per_revolution)
    LinearLayout mFeedPerRevolution;

    @BindView(R.id.feed_per_revolution_text)
    TextView mFeedPerRevolutionText;

    @BindView(R.id.feed_per_revolution_recommended)
    TextView mFeedPerRevolutionRecommended;

    @BindView(R.id.feed_per_revolution_edit_text)
    EditText mFeedPerRevolutionEditText;

    @BindView(R.id.feed_per_revolution_warning_image)
    ImageView mFeedPerRevolutionWarningImage;

    @BindView(R.id.feed_per_revolution_warning_text)
    TextView mFeedPerRevolutionWarningText;

    @BindView(R.id.spindle_speed)
    LinearLayout mSpindleSpeed;

    @BindView(R.id.spindle_speed_text)
    TextView mSpindleSpeedText;

    @BindView(R.id.spindle_speed_result)
    TextView mSpindleSpeedEditText;

    @BindView(R.id.drill_diameter)
    LinearLayout mDrillDiameter;

    @BindView(R.id.drill_diameter_text)
    TextView mDrillDiameterText;

    @BindView(R.id.drill_diameter_edit_text)
    EditText mDrillDiameterEditText;

    @BindView(R.id.metal_removal_rate)
    LinearLayout mMetalRemovalRate;

    @BindView(R.id.metal_removal_rate_text)
    TextView mMetalRemovalRateText;

    @BindView(R.id.metal_removal_rate_result)
    TextView mMetalRemovalRateEditText;

    @BindView(R.id.table_feed)
    LinearLayout mTableFeed;

    @BindView(R.id.table_feed_text)
    TextView mTableFeedText;

    @BindView(R.id.table_feed_result)
    TextView mTableFeedEditText;

    @BindView(R.id.machined_length)
    LinearLayout mMachinedLength;

    @BindView(R.id.machined_length_text)
    TextView mMachinedLengthText;

    @BindView(R.id.machined_length_edit_text)
    EditText mMachinedLengthEditText;

    @BindView(R.id.machining_drilling_length)
    LinearLayout mMachiningDrillingLength;

    @BindView(R.id.machining_drilling_length_text)
    TextView mMachiningDrillingLengthText;

    @BindView(R.id.machining_drilling_length_result)
    TextView mMachiningDrillingLengthResult;

    private CreatorCachedValuesLab mCreatorCachedValuesLab;
    private Boolean mIsHSSDrill = null;
    private CreatorLab mCreatorLab;
    private Integer mIndex = null;
    private Material mMaterial;

    public static Fragment initFragment(){
        Fragment fragment = new DrillingCreatorFragment();

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
        View view = inflater.inflate(R.layout.fragment_drilling_creator, container, false);

        ButterKnife.bind(this, view);

        if (mCreatorCachedValuesLab.getDrillingMaterial() != null) {
            mMaterial = mCreatorCachedValuesLab.getDrillingMaterial();
            mIsHSSDrill = mCreatorCachedValuesLab.isDrillingHssDrill();
            if (mIsHSSDrill) {
                mDrillHSSBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
                List<Material> materials = mCreatorLab.getSteelMillingMaterials();
                for (int i = 0; i < materials.size(); i++) {
                    if (materials.get(i).getName().equals(mMaterial.getName())) {
                        mIndex = i;
                        break;
                    }
                }
            } else {
                mDrillCarbonedBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
                List<Material> materials = mCreatorLab.getCarbideMillingMaterials();
                for (int i = 0; i < materials.size(); i++) {
                    if (materials.get(i).getName().equals(mMaterial.getName())) {
                        mIndex = i;
                        break;
                    }
                }
            }
            mChooseMaterialText.setText(mMaterial.getName());

            if (mCreatorCachedValuesLab.getDrillingDrillDiameter() != null) {
                mDrillDiameterEditText.setText("" + Math.round(mCreatorCachedValuesLab.getDrillingDrillDiameter().doubleValue() * 100f) / 100f);
            }
            if (mCreatorCachedValuesLab.getDrillingCuttingSpeed() != null) {
                mCuttingSpeedEditText.setText("" + Math.round(mCreatorCachedValuesLab.getDrillingCuttingSpeed().doubleValue() * 100f) / 100f);

                if (mCreatorCachedValuesLab.getDrillingCuttingSpeed().doubleValue() >= mMaterial.getMinCuttingSpeed() &&
                        mCreatorCachedValuesLab.getDrillingCuttingSpeed().doubleValue() <= mMaterial.getMaxCuttingSpeed()) {
                    mCuttingSpeedWarningImage.setVisibility(View.GONE);
                    mCuttingSpeedWarningText.setVisibility(View.GONE);
                } else {
                    mCuttingSpeedWarningImage.setVisibility(View.VISIBLE);
                    mCuttingSpeedWarningText.setVisibility(View.VISIBLE);
                }
            }
            if (mCreatorCachedValuesLab.getDrillingFeedPerRevolution() != null) {
                mFeedPerRevolutionEditText.setText("" + Math.round(mCreatorCachedValuesLab.getDrillingFeedPerRevolution().doubleValue() * 1000f) / 1000f);

                if (mCreatorCachedValuesLab.getDrillingDrillDiameter() != null &&
                        mCreatorCachedValuesLab.getDrillingFeedPerRevolution().doubleValue() >= mMaterial.getMinFeedPerRevolution(mCreatorCachedValuesLab.getDrillingDrillDiameter().doubleValue()) &&
                        mCreatorCachedValuesLab.getDrillingFeedPerRevolution().doubleValue() <= mMaterial.getMaxFeedPerRevolution(mCreatorCachedValuesLab.getDrillingDrillDiameter().doubleValue())) {
                    mFeedPerRevolutionWarningImage.setVisibility(View.GONE);
                    mFeedPerRevolutionWarningText.setVisibility(View.GONE);
                } else {
                    mFeedPerRevolutionWarningImage.setVisibility(View.VISIBLE);
                    mFeedPerRevolutionWarningText.setVisibility(View.VISIBLE);
                }
            }
            if (mCreatorCachedValuesLab.getDrillingMachiningDrillingLength() != null) {
                mMachinedLengthEditText.setText("" + Math.round(mCreatorCachedValuesLab.getDrillingMachiningDrillingLength().doubleValue() * 100f) / 100f);
            }

            updateView();
        }

        addListeners();

        return view;
    }

    private void addListeners() {
        mCuttingSpeedEditText.addTextChangedListener(mCuttingSpeedEditTextWatcher);
        mFeedPerRevolutionEditText.addTextChangedListener(mFeedPerRevolutionEditTextWatcher);
        mDrillDiameterEditText.addTextChangedListener(mDrillDiameterEditTextWatcher);
        mMachinedLengthEditText.addTextChangedListener(mMachinedLengthEditTextWatcher);
    }

    @OnClick(R.id.drill_hss)
    public void setDrillHSS() {
        mDrillHSSBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
        mDrillCarbonedBg.setBackground(null);
        mCreatorCachedValuesLab.setDrillingHssDrill(true);
        mIsHSSDrill = true;
        if (mIndex != null) {
            mMaterial = mCreatorLab.getSteelMillingMaterials().get(mIndex);
            updateView();
        }
        updateRecommended();
    }

    @OnClick(R.id.drill_carboned)
    public void setDrillCarboned() {
        mDrillHSSBg.setBackground(null);
        mDrillCarbonedBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
        mCreatorCachedValuesLab.setDrillingHssDrill(false);
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
        mCreatorCachedValuesLab.removeDrillingValues();
        mDrillCarbonedBg.setBackground(null);
        mDrillHSSBg.setBackground(null);
        mSpindleSpeedEditText.setText("");
        mTableFeedEditText.setText("");
        mSpindleSpeed.setVisibility(View.GONE);
        mTableFeed.setVisibility(View.GONE);
        mDrillDiameter.setVisibility(View.GONE);
        mMachinedLength.setVisibility(View.GONE);
        mFeedPerRevolution.setVisibility(View.GONE);
        mCuttingSpeed.setVisibility(View.GONE);
        mMachiningDrillingLength.setVisibility(View.GONE);
        mChooseMaterialText.setText(getString(R.string.choose_material));
        mDrillDiameterEditText.setText(null);
        mMachinedLengthEditText.setText(null);
        mCuttingSpeedEditText.setText(null);
        mMetalRemovalRateEditText.setText(null);
        mMetalRemovalRate.setVisibility(View.GONE);

        updateView();
    }

    private void updateView() {
        String[] parametersNames = getResources().getStringArray(R.array.machining_formulas);
        if (mMaterial != null) {
            mDrillDiameter.setVisibility(View.VISIBLE);
            mDrillDiameterText.setText(parametersNames[14]);

            mCuttingSpeed.setVisibility(View.VISIBLE);
            mCuttingSpeedText.setText(parametersNames[2]);
            mCuttingSpeedRecommended.setText(recommendedValues(mMaterial.getMinCuttingSpeed(), mMaterial.getMaxCuttingSpeed()));

            if (mCreatorCachedValuesLab.getDrillingDrillDiameter() != null) {
                mFeedPerRevolution.setVisibility(View.VISIBLE);
                mFeedPerRevolutionText.setText(parametersNames[4]);
                mFeedPerRevolutionRecommended.setText(recommendedValues(
                        mMaterial.getMinFeedPerRevolution(mCreatorCachedValuesLab.getDrillingDrillDiameter().doubleValue()),
                        mMaterial.getMaxFeedPerRevolution(mCreatorCachedValuesLab.getDrillingDrillDiameter().doubleValue())));
            }

            if (mCreatorCachedValuesLab.getDrillingSpindleSpeed() != null) {
                mSpindleSpeed.setVisibility(View.VISIBLE);
                mSpindleSpeedText.setText(parametersNames[1]);
                mSpindleSpeedEditText.setText("" + (int) Math.round(mCreatorCachedValuesLab.getDrillingSpindleSpeed().doubleValue()) + " " + getString(R.string.rpm));
            } else {
                mSpindleSpeed.setVisibility(View.GONE);
            }

            if (mCreatorCachedValuesLab.getDrillingPenetrationRate() != null) {
                mTableFeed.setVisibility(View.VISIBLE);
                mTableFeedText.setText(parametersNames[17]);
                mTableFeedEditText.setText("" + Math.round(mCreatorCachedValuesLab.getDrillingPenetrationRate().doubleValue() * 100f) / 100f + " " + getString(R.string.mm_min));

            } else {
                mTableFeed.setVisibility(View.GONE);
                mTableFeedEditText.setText("");
                mMetalRemovalRate.setVisibility(View.GONE);
            }

            if (mCreatorCachedValuesLab.getDrillingMetalRemovalRate() != null) {
                mMetalRemovalRate.setVisibility(View.VISIBLE);
                mMetalRemovalRateText.setText(parametersNames[16]);
                mCreatorCachedValuesLab.updateDrillingValues(4);
                mMetalRemovalRateEditText.setText("" + Math.round(mCreatorCachedValuesLab.getDrillingMetalRemovalRate().doubleValue() * 100f) / 100f + " " + getString(R.string.cm3_min));

                mMachinedLength.setVisibility(View.VISIBLE);
                mMachinedLengthText.setText(parametersNames[15]);
            } else {
                mMetalRemovalRate.setVisibility(View.GONE);
                mMetalRemovalRateEditText.setText("");
                mMachinedLength.setVisibility(View.GONE);
            }

            if (mCreatorCachedValuesLab.getDrillingMachiningTime() != null) {
                mMachiningDrillingLength.setVisibility(View.VISIBLE);
                mMachiningDrillingLengthText.setText(parametersNames[18]);
                mMachiningDrillingLengthResult.setText("" + Math.round(mCreatorCachedValuesLab.getDrillingMachiningTime().doubleValue() * 100f) / 100f + " " + getString(R.string.min));

            } else {
                mMachiningDrillingLength.setVisibility(View.GONE);
                mMachiningDrillingLengthResult.setText("");
            }
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
        String feedToothText = mFeedPerRevolutionEditText.getText().toString();
        mFeedPerRevolutionEditText.setText(feedToothText);
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
        mCreatorCachedValuesLab.setDrillingMaterial(mMaterial);
        updateView();
        updateRecommended();
    }

    private TextWatcher mCuttingSpeedEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                BigDecimal drillingCuttingSpeed = new BigDecimal(Double.parseDouble(charSequence.toString()));
                if (drillingCuttingSpeed.doubleValue() >= mMaterial.getMinCuttingSpeed() &&
                        drillingCuttingSpeed.doubleValue() <= mMaterial.getMaxCuttingSpeed()) {
                    mCuttingSpeedWarningImage.setVisibility(View.GONE);
                    mCuttingSpeedWarningText.setVisibility(View.GONE);
                } else {
                    mCuttingSpeedWarningImage.setVisibility(View.VISIBLE);
                    mCuttingSpeedWarningText.setVisibility(View.VISIBLE);
                }
                mCreatorCachedValuesLab.setDrillingCuttingSpeed(drillingCuttingSpeed);
            } catch (NumberFormatException ex) {
                mCreatorCachedValuesLab.setDrillingCuttingSpeed(null);
                mCuttingSpeedWarningImage.setVisibility(View.GONE);
                mCuttingSpeedWarningText.setVisibility(View.GONE);
            } finally {
                mCreatorCachedValuesLab.updateDrillingValues(1);
                mCreatorCachedValuesLab.updateDrillingValues(3);
                mCreatorCachedValuesLab.updateDrillingValues(4);
                mCreatorCachedValuesLab.updateDrillingValues(5);
                updateView();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {}
    };

    private TextWatcher mFeedPerRevolutionEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                BigDecimal drillingFeedTooth = new BigDecimal(Double.parseDouble(charSequence.toString()));
                if (drillingFeedTooth.doubleValue() >= mMaterial.getMinFeedPerRevolution(Double.parseDouble(mDrillDiameterEditText.getText().toString())) &&
                        drillingFeedTooth.doubleValue() <= mMaterial.getMaxFeedPerRevolution(Double.parseDouble(mDrillDiameterEditText.getText().toString()))) {
                    mFeedPerRevolutionWarningImage.setVisibility(View.GONE);
                    mFeedPerRevolutionWarningText.setVisibility(View.GONE);
                } else {
                    mFeedPerRevolutionWarningImage.setVisibility(View.VISIBLE);
                    mFeedPerRevolutionWarningText.setVisibility(View.VISIBLE);
                }
                mCreatorCachedValuesLab.setDrillingFeedPerRevolution(drillingFeedTooth);
            } catch (NumberFormatException ex){
                mCreatorCachedValuesLab.setDrillingFeedPerRevolution(null);
                mCuttingSpeedWarningImage.setVisibility(View.GONE);
                mCuttingSpeedWarningText.setVisibility(View.GONE);
            } finally {
                mCreatorCachedValuesLab.updateDrillingValues(1);
                mCreatorCachedValuesLab.updateDrillingValues(3);
                mCreatorCachedValuesLab.updateDrillingValues(4);
                mCreatorCachedValuesLab.updateDrillingValues(5);
                updateView();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {}
    };

    private TextWatcher mDrillDiameterEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCreatorCachedValuesLab.setDrillingDrillDiameter(new BigDecimal(Double.parseDouble(charSequence.toString())));
            } catch (NumberFormatException ex){
                mCreatorCachedValuesLab.setDrillingDrillDiameter(null);
            } finally {
                mCreatorCachedValuesLab.updateDrillingValues(1);
                mCreatorCachedValuesLab.updateDrillingValues(3);
                mCreatorCachedValuesLab.updateDrillingValues(4);
                mCreatorCachedValuesLab.updateDrillingValues(5);
                updateView();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {}
    };

    private TextWatcher mMachinedLengthEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCreatorCachedValuesLab.setDrillingMachiningDrillingLength(new BigDecimal(Double.parseDouble(charSequence.toString())));
            } catch (NumberFormatException ex){
                mCreatorCachedValuesLab.setDrillingMachiningDrillingLength(null);
            } finally {
                mCreatorCachedValuesLab.updateDrillingValues(5);
                updateView();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {}
    };
}
