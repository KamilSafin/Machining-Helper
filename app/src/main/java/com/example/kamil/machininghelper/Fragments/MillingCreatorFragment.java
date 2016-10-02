package com.example.kamil.machininghelper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kamil.machininghelper.Model.CreatorLab;
import com.example.kamil.machininghelper.Model.Material;
import com.example.kamil.machininghelper.R;
import com.example.kamil.machininghelper.Utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kamil Safin on 9/18/2016.
 */
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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_milling_creator, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.mill_hss)
    public void setMillHSS() {
        mMillHSSBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
        mMillCarbonedBg.setBackground(null);
        mIsHSSDrill = true;
        if (mIndex != null) {
            mMaterial = mCreatorLab.getSteelMillingMaterials().get(mIndex);
            updateView();
        }
    }

    @OnClick(R.id.mill_carboned)
    public void setMillCarboned() {
        mMillHSSBg.setBackground(null);
        mMillCarbonedBg.setBackground(getResources().getDrawable(R.drawable.circle_active));
        mIsHSSDrill = false;
        if (mIndex != null) {
            mMaterial = mCreatorLab.getCarbideMillingMaterials().get(mIndex);
            updateView();
        }
    }

    @OnClick(R.id.choose_material)
    public void setChooseMaterial() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ChooseMaterialDialog dialog = ChooseMaterialDialog.newInstance();
        if (mIsHSSDrill != null) {
            dialog.show(fragmentManager, CHOOSE_MATERIAL_DIALOG, this, mIsHSSDrill);
        }
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
        updateView();
    }
}
