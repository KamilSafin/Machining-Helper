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
import com.example.kamil.machininghelper.Model.TurningMaterial;
import com.example.kamil.machininghelper.R;

import java.math.BigDecimal;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TurningCreatorFragment extends Fragment implements ChooseTurningMaterialDialog.DialogTurningMaterialCallback {

    private static final String CHOOSE_MATERIAL_DIALOG = TurningCreatorFragment.class.getName() + "_choose_material_dialog";

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

    @BindView(R.id.cutting_diameter_at_depth)
    LinearLayout mTurningMachinedDiameter;

    @BindView(R.id.cutting_diameter_at_depth_text)
    TextView mTurningMachinedDiameterText;

    @BindView(R.id.cutting_diameter_at_depth_edit_text)
    EditText mTurningMachinedDiameterEditText;

    @BindView(R.id.spindle_speed)
    LinearLayout mSpindleSpeed;

    @BindView(R.id.spindle_speed_text)
    TextView mSpindleSpeedText;

    @BindView(R.id.spindle_speed_result)
    TextView mSpindleSpeedEditText;

    @BindView(R.id.depth_of_cut)
    LinearLayout mCuttingDepth;

    @BindView(R.id.depth_of_cut_text)
    TextView mCuttingDepthText;

    @BindView(R.id.depth_of_cut_recommended)
    TextView mCuttingDepthRecommended;

    @BindView(R.id.depth_of_cut_edit_text)
    EditText mCuttingDepthEditText;

    @BindView(R.id.depth_of_cut_warning_image)
    ImageView mCuttingDepthWarningImage;

    @BindView(R.id.depth_of_cut_warning_text)
    TextView mCuttingDepthWarningText;

    @BindView(R.id.metal_removal_rate)
    LinearLayout mMetalRemovalRate;

    @BindView(R.id.metal_removal_rate_text)
    TextView mMetalRemovalRateText;

    @BindView(R.id.metal_removal_rate_result)
    TextView mMetalRemovalRateResult;

    @BindView(R.id.machined_length)
    LinearLayout mMachinedLength;

    @BindView(R.id.machined_length_text)
    TextView mMachinedLengthText;

    @BindView(R.id.machined_length_edit_text)
    EditText mMachinedLengthEditText;

    @BindView(R.id.machining_time)
    LinearLayout mMachiningTime;

    @BindView(R.id.machining_time_text)
    TextView mMachiningTimeText;

    @BindView(R.id.machining_time_result)
    TextView mMachiningTimeResult;

    @BindView(R.id.specific_cutting_force)
    LinearLayout mSpecificCuttingForce;

    @BindView(R.id.specific_cutting_force_text)
    TextView mSpecificCuttingForceText;

    @BindView(R.id.specific_cutting_force_edit_text)
    TextView mSpecificCuttingForceEditText;

    @BindView(R.id.net_power_requirement)
    LinearLayout mNetPowerRequirement;

    @BindView(R.id.net_power_requirement_text)
    TextView mNetPowerRequirementText;

    @BindView(R.id.net_power_requirement_result)
    TextView mNetPowerRequirementResult;

    private CreatorCachedValuesLab mCreatorCachedValuesLab;
    private CreatorLab mCreatorLab;
    private Integer mIndex = null;
    private TurningMaterial mMaterial;

    public static Fragment initFragment() {
        Fragment fragment = new TurningCreatorFragment();

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
        View view = inflater.inflate(R.layout.fragment_turning_creator, container, false);

        ButterKnife.bind(this, view);

        if (mCreatorCachedValuesLab.getTurningMaterial() != null) {
            mMaterial = mCreatorCachedValuesLab.getTurningMaterial();

            List<TurningMaterial> materials = mCreatorLab.getTurningMaterials();
            for (int i = 0; i < materials.size(); i++) {
                if (materials.get(i).getName().equals(mMaterial.getName())) {
                    mIndex = i;
                    break;
                }
            }

            setMaterial();

            if (mCreatorCachedValuesLab.getTurningMachinedDiameter() != null) {
                mTurningMachinedDiameterEditText.setText("" + Math.round(mCreatorCachedValuesLab.getTurningMachinedDiameter().doubleValue() * 100f) / 100f);
            }
            if (mCreatorCachedValuesLab.getTurningCuttingSpeed() != null) {
                mCuttingSpeedEditText.setText("" + Math.round(mCreatorCachedValuesLab.getTurningCuttingSpeed().doubleValue() * 100f) / 100f);

                if (mCreatorCachedValuesLab.getTurningCuttingSpeed().doubleValue() >= mMaterial.getMinCuttingSpeed() &&
                        mCreatorCachedValuesLab.getTurningCuttingSpeed().doubleValue() <= mMaterial.getMaxCuttingSpeed()) {
                    mCuttingSpeedWarningImage.setVisibility(View.GONE);
                    mCuttingSpeedWarningText.setVisibility(View.GONE);
                } else {
                    mCuttingSpeedWarningImage.setVisibility(View.VISIBLE);
                    mCuttingSpeedWarningText.setVisibility(View.VISIBLE);
                }
            }
            if (mCreatorCachedValuesLab.getTurningSpindleSpeed() != null) {
                mSpindleSpeedEditText.setText("" + Math.round(mCreatorCachedValuesLab.getTurningSpindleSpeed().doubleValue() * 100f) / 100f);
            }
            if (mCreatorCachedValuesLab.getTurningFeedPerRevolution() != null) {
                mFeedPerRevolutionEditText.setText("" + Math.round(mCreatorCachedValuesLab.getTurningFeedPerRevolution().doubleValue() * 100f) / 100f);

                if (mCreatorCachedValuesLab.getTurningFeedPerRevolution().doubleValue() >= mMaterial.getMinFeedPerRevolution() &&
                        mCreatorCachedValuesLab.getTurningFeedPerRevolution().doubleValue() <= mMaterial.getMaxFeedPerRevolution()) {
                    mFeedPerRevolutionWarningImage.setVisibility(View.GONE);
                    mFeedPerRevolutionWarningText.setVisibility(View.GONE);
                } else {
                    mFeedPerRevolutionWarningImage.setVisibility(View.VISIBLE);
                    mFeedPerRevolutionWarningText.setVisibility(View.VISIBLE);
                }
            }
            if (mCreatorCachedValuesLab.getTurningCuttingDepth() != null) {
                mCuttingDepthEditText.setText("" + Math.round(mCreatorCachedValuesLab.getTurningCuttingDepth().doubleValue() * 100f) / 100f);

                if (mCreatorCachedValuesLab.getTurningCuttingDepth().doubleValue() >= mMaterial.getMinCuttingSpeed() &&
                        mCreatorCachedValuesLab.getTurningCuttingDepth().doubleValue() <= mMaterial.getMaxCuttingSpeed()) {
                    mCuttingDepthWarningImage.setVisibility(View.GONE);
                    mCuttingDepthWarningText.setVisibility(View.GONE);
                } else {
                    mCuttingDepthWarningImage.setVisibility(View.VISIBLE);
                    mCuttingDepthWarningText.setVisibility(View.VISIBLE);
                }
            }
            if (mCreatorCachedValuesLab.getTurningMachinedLength() != null) {
                mMachinedLengthEditText.setText("" + Math.round(mCreatorCachedValuesLab.getTurningMachinedLength().doubleValue() * 100f) / 100f);
            }
            if (mCreatorCachedValuesLab.getTurningSpecificCuttingForce() != null) {
                mSpecificCuttingForceEditText.setText("" + Math.round(mCreatorCachedValuesLab.getTurningSpecificCuttingForce().doubleValue() * 100f) / 100f);
            }
            if (mCreatorCachedValuesLab.getTurningMetalRemovalRate() != null) {
                mMetalRemovalRateResult.setText("" + Math.round(mCreatorCachedValuesLab.getTurningMetalRemovalRate().doubleValue() * 100f) / 100f);
            }
            if (mCreatorCachedValuesLab.getTurningMachiningTime() != null) {
                mMachiningTimeResult.setText("" + Math.round(mCreatorCachedValuesLab.getTurningMachiningTime().doubleValue() * 100f) / 100f);
            }
            if (mCreatorCachedValuesLab.getTurningNetPowerRequirement() != null) {
                mNetPowerRequirementResult.setText("" + Math.round(mCreatorCachedValuesLab.getTurningNetPowerRequirement().doubleValue() * 100f) / 100f);
            }

            updateView();
        }

        addListeners();

        return view;
    }

    private void addListeners() {
        mCuttingSpeedEditText.addTextChangedListener(mCuttingSpeedEditTextWatcher);
        mTurningMachinedDiameterEditText.addTextChangedListener(mTurningMachinedDiameterEditTextWatcher);
        mFeedPerRevolutionEditText.addTextChangedListener(mFeedPerRevolutionEditTextWatcher);
        mCuttingDepthEditText.addTextChangedListener(mCuttingDepthEditTextWatcher);
        mMachinedLengthEditText.addTextChangedListener(mMachinedLengthEditTextWatcher);
        mSpecificCuttingForceEditText.addTextChangedListener(mSpecificCuttingForceEditTextWatcher);
    }

    @OnClick(R.id.choose_material)
    public void setChooseMaterial() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ChooseTurningMaterialDialog dialog = ChooseTurningMaterialDialog.newInstance();
        dialog.show(fragmentManager, CHOOSE_MATERIAL_DIALOG, this);
    }

    public void resetView() {
        mMaterial = null;
        mIndex = null;
        mChooseMaterialText.setText(getString(R.string.choose_material));
        mCreatorCachedValuesLab.removeMillingValues();
        mTurningMachinedDiameter.setVisibility(View.GONE);
        mTurningMachinedDiameterEditText.setText(null);
        mCuttingSpeed.setVisibility(View.GONE);
        mCuttingSpeedEditText.setText(null);
        mSpindleSpeed.setVisibility(View.GONE);
        mSpindleSpeedEditText.setText("");
        mFeedPerRevolution.setVisibility(View.GONE);
        mFeedPerRevolutionEditText.setText(null);
        mCuttingDepth.setVisibility(View.GONE);
        mCuttingDepthEditText.setText(null);
        mMachinedLength.setVisibility(View.GONE);
        mMachinedLengthEditText.setText(null);
        mSpecificCuttingForce.setVisibility(View.GONE);
        mSpecificCuttingForceEditText.setText(null);
        mMetalRemovalRate.setVisibility(View.GONE);
        mMetalRemovalRateResult.setText(null);
        mMachiningTime.setVisibility(View.GONE);
        mMachiningTimeResult.setText(null);
        mNetPowerRequirement.setVisibility(View.GONE);
        mNetPowerRequirementResult.setText(null);

        updateView();
    }

    private void updateView() {
        String[] parametersNames = getResources().getStringArray(R.array.machining_formulas);
        if (mMaterial != null) {
            mTurningMachinedDiameter.setVisibility(View.VISIBLE);
            mTurningMachinedDiameterText.setText(parametersNames[0]);

            mCuttingSpeed.setVisibility(View.VISIBLE);
            mCuttingSpeedText.setText(parametersNames[2]);
            mCuttingSpeedRecommended.setText(recommendedValues(mMaterial.getMinCuttingSpeed(), mMaterial.getRecommendedCuttingSpeed(), mMaterial.getMaxCuttingSpeed()));

            if (mCreatorCachedValuesLab.getTurningSpindleSpeed() != null) {
                mSpindleSpeed.setVisibility(View.VISIBLE);
                mSpindleSpeedText.setText(parametersNames[1]);
                mSpindleSpeedEditText.setText("" + (int) Math.round(mCreatorCachedValuesLab.getTurningSpindleSpeed().doubleValue()) + " " + getString(R.string.rpm));

                mFeedPerRevolution.setVisibility(View.VISIBLE);
                mFeedPerRevolutionText.setText(parametersNames[4]);
                mFeedPerRevolutionRecommended.setText(recommendedValues(mMaterial.getMinFeedPerRevolution(), mMaterial.getRecommendedFeedPerRevolution(), mMaterial.getMaxFeedPerRevolution()));

                mCuttingDepth.setVisibility(View.VISIBLE);
                mCuttingDepthText.setText(parametersNames[3]);
                mCuttingDepthRecommended.setText(recommendedValues(mMaterial.getMinDepthOfCut(), null, mMaterial.getMaxDepthOfCut()));

                mMachinedLength.setVisibility(View.VISIBLE);
                mMachinedLengthText.setText(parametersNames[6]);

                mSpecificCuttingForce.setVisibility(View.VISIBLE);
                mSpecificCuttingForceText.setText(parametersNames[5]);
            } else {
                mSpindleSpeed.setVisibility(View.GONE);
                mFeedPerRevolution.setVisibility(View.GONE);
                mCuttingDepth.setVisibility(View.GONE);
                mMetalRemovalRate.setVisibility(View.GONE);
                mMachinedLength.setVisibility(View.GONE);
                mSpecificCuttingForce.setVisibility(View.GONE);
            }

            if (mCreatorCachedValuesLab.getTurningMetalRemovalRate() != null) {
                mMetalRemovalRate.setVisibility(View.VISIBLE);
                mMetalRemovalRateText.setText(parametersNames[16]);
                mMetalRemovalRateResult.setText("" + Math.round(mCreatorCachedValuesLab.getTurningMetalRemovalRate().doubleValue() * 100f) / 100f + " " + getString(R.string.cm3_min));
            } else {
                mMetalRemovalRate.setVisibility(View.GONE);
                mMetalRemovalRateResult.setText("");
            }

            if (mCreatorCachedValuesLab.getTurningMachiningTime() != null) {
                mMachiningTime.setVisibility(View.VISIBLE);
                mMachiningTimeText.setText(parametersNames[19]);
                mMachiningTimeResult.setText("" + Math.round(mCreatorCachedValuesLab.getTurningMachiningTime().doubleValue() * 100f) / 100f + " " + getString(R.string.min));
            } else {
                mMachiningTime.setVisibility(View.GONE);
                mMachiningTimeResult.setText("");
            }

            if (mCreatorCachedValuesLab.getTurningNetPowerRequirement() != null) {
                mNetPowerRequirement.setVisibility(View.VISIBLE);
                mNetPowerRequirementText.setText(parametersNames[13]);
                mNetPowerRequirementResult.setText("" + Math.round(mCreatorCachedValuesLab.getTurningNetPowerRequirement().doubleValue() * 100f) / 100f + " " + getString(R.string.kW));
            } else {
                mNetPowerRequirement.setVisibility(View.GONE);
                mNetPowerRequirementResult.setText("");
            }
        }
    }

    @Override
    public void onTurningMaterialSelected(int index) {
        List<TurningMaterial> materials = mCreatorLab.getTurningMaterials();
        mIndex = index;
        mMaterial = materials.get(mIndex);
        setMaterial();
        mCreatorCachedValuesLab.setTurningMaterial(mMaterial);
        updateView();
        updateRecommended();
    }

    private void setMaterial() {
        if (mMaterial.getCuttingType() != null) {
            mChooseMaterialText.setText(mMaterial.getName() + "\n (" + mMaterial.getCuttingType() + ")");
        } else {
            mChooseMaterialText.setText(mMaterial.getName());
        }
    }

    private String recommendedValues(double minValue, Double recommendedValue, double maxValue) {
        if (recommendedValue == null) {
            return getString(R.string.recommended_values) + ": (" + formatValue(minValue) + " - " + formatValue(maxValue) + ")";
        } else {
            return getString(R.string.recommended_values) +
                    ": " + formatValue(minValue) + " - (" + formatValue(recommendedValue) + ") - " + formatValue(maxValue);
        }
    }

    private String formatValue(double value) {
        int testValue = (int) value;
        if (testValue == value) {
            return "" + testValue;
        } else {
            return String.format("%.2f", value).replace(",", ".");
        }
    }

    private void updateRecommended() {
        String cuttingSpeedText = mCuttingSpeedEditText.getText().toString();
        mCuttingSpeedEditText.setText(cuttingSpeedText);
        String feedToothText = mFeedPerRevolutionEditText.getText().toString();
        mFeedPerRevolutionEditText.setText(feedToothText);
        String depthOfCutText = mCuttingDepthEditText.getText().toString();
        mCuttingDepthEditText.setText(depthOfCutText);
    }

    private TextWatcher mCuttingSpeedEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                BigDecimal turningCuttingSpeed = new BigDecimal(Double.parseDouble(charSequence.toString()));
                if (turningCuttingSpeed.doubleValue() >= mMaterial.getMinCuttingSpeed() &&
                        turningCuttingSpeed.doubleValue() <= mMaterial.getMaxCuttingSpeed()) {
                    mCuttingSpeedWarningImage.setVisibility(View.GONE);
                    mCuttingSpeedWarningText.setVisibility(View.GONE);
                } else {
                    mCuttingSpeedWarningImage.setVisibility(View.VISIBLE);
                    mCuttingSpeedWarningText.setVisibility(View.VISIBLE);
                }
                mCreatorCachedValuesLab.setTurningCuttingSpeed(turningCuttingSpeed);
            } catch (NumberFormatException ex) {
                mCreatorCachedValuesLab.setTurningCuttingSpeed(null);
                mCuttingSpeedWarningImage.setVisibility(View.GONE);
                mCuttingSpeedWarningText.setVisibility(View.GONE);
            } finally {
                mCreatorCachedValuesLab.updateTurningValues(1);
                mCreatorCachedValuesLab.updateTurningValues(2);
                mCreatorCachedValuesLab.updateTurningValues(3);
                mCreatorCachedValuesLab.updateTurningValues(4);
                updateView();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher mTurningMachinedDiameterEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                mCreatorCachedValuesLab.setTurningMachinedDiameter(new BigDecimal(Double.parseDouble(charSequence.toString())));
            } catch (NumberFormatException ex) {
                mCreatorCachedValuesLab.setTurningMachinedDiameter(null);
            } finally {
                mCreatorCachedValuesLab.updateTurningValues(0);
                mCreatorCachedValuesLab.updateTurningValues(1);
                mCreatorCachedValuesLab.updateTurningValues(2);
                mCreatorCachedValuesLab.updateTurningValues(3);
                mCreatorCachedValuesLab.updateTurningValues(4);
                updateView();
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
                BigDecimal turningFeedPerRevolution = new BigDecimal(Double.parseDouble(charSequence.toString()));
                if (turningFeedPerRevolution.doubleValue() >= mMaterial.getMinFeedPerRevolution() &&
                        turningFeedPerRevolution.doubleValue() <= mMaterial.getMaxFeedPerRevolution()) {
                    mFeedPerRevolutionWarningImage.setVisibility(View.GONE);
                    mFeedPerRevolutionWarningText.setVisibility(View.GONE);
                } else {
                    mFeedPerRevolutionWarningImage.setVisibility(View.VISIBLE);
                    mFeedPerRevolutionWarningText.setVisibility(View.VISIBLE);
                }
                mCreatorCachedValuesLab.setTurningFeedPerRevolution(turningFeedPerRevolution);
            } catch (NumberFormatException ex){
                mCreatorCachedValuesLab.setTurningFeedPerRevolution(null);
                mCuttingSpeedWarningImage.setVisibility(View.GONE);
                mCuttingSpeedWarningText.setVisibility(View.GONE);
            } finally {
                mCreatorCachedValuesLab.updateTurningValues(2);
                mCreatorCachedValuesLab.updateTurningValues(3);
                mCreatorCachedValuesLab.updateTurningValues(4);
                updateView();
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
                BigDecimal turningCuttingDepth = new BigDecimal(Double.parseDouble(charSequence.toString()));
                if (turningCuttingDepth.doubleValue() >= mMaterial.getMinDepthOfCut() &&
                        turningCuttingDepth.doubleValue() <= mMaterial.getMaxDepthOfCut()) {
                    mCuttingDepthWarningImage.setVisibility(View.GONE);
                    mCuttingDepthWarningText.setVisibility(View.GONE);
                } else {
                    mCuttingDepthWarningImage.setVisibility(View.VISIBLE);
                    mCuttingDepthWarningText.setVisibility(View.VISIBLE);
                }
                mCreatorCachedValuesLab.setTurningCuttingDepth(turningCuttingDepth);
            } catch (NumberFormatException ex){
                mCreatorCachedValuesLab.setTurningCuttingDepth(null);
                mCuttingDepthWarningImage.setVisibility(View.GONE);
                mCuttingDepthWarningText.setVisibility(View.GONE);
            } finally {
                mCreatorCachedValuesLab.updateTurningValues(2);
                mCreatorCachedValuesLab.updateTurningValues(3);
                mCreatorCachedValuesLab.updateTurningValues(4);
                updateView();
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
                mCreatorCachedValuesLab.setTurningMachinedLength(new BigDecimal(Double.parseDouble(charSequence.toString())));
            } catch (NumberFormatException ex) {
                mCreatorCachedValuesLab.setTurningMachinedLength(null);
            } finally {
                mCreatorCachedValuesLab.updateTurningValues(3);
                mCreatorCachedValuesLab.updateTurningValues(4);
                updateView();
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
                mCreatorCachedValuesLab.setTurningSpecificCuttingForce(new BigDecimal(Double.parseDouble(charSequence.toString())));
            } catch (NumberFormatException ex) {
                mCreatorCachedValuesLab.setTurningSpecificCuttingForce(null);
            } finally {
                mCreatorCachedValuesLab.updateTurningValues(3);
                updateView();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
