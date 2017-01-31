package com.example.kamil.machininghelper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.Activities.CalculatorFormulasActivity;
import com.example.kamil.machininghelper.Model.CalculatorCachedValuesLab;
import com.example.kamil.machininghelper.R;
import com.example.kamil.machininghelper.Utils.Utils;

import java.util.List;

/**
 * Created by Kamil Safin on 8/31/2016.
 */
public class CalculatorParametersAdapter extends RecyclerView.Adapter<CalculatorParametersAdapter.CalculatorParametersViewHolder> {

    private Context mContext;
    private List<String> mCalculatorParameters;
    private int mIndex;

    public CalculatorParametersAdapter(Context context, List<String> calculatorParameters, int index) {
        mContext = context;
        mCalculatorParameters = calculatorParameters;
        mIndex = index;
    }

    @Override
    public CalculatorParametersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_calculator_parameter, parent, false);

        return new CalculatorParametersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CalculatorParametersViewHolder holder, int position) {
        holder.bind(mCalculatorParameters.get(position));
    }

    @Override
    public int getItemCount() {
        return mCalculatorParameters.size();
    }

    class CalculatorParametersViewHolder extends RecyclerView.ViewHolder{

        private TextView mCalculatorParameter;
        private TextView mCalculatorResultText;

        public CalculatorParametersViewHolder(View itemView) {
            super(itemView);

            mCalculatorParameter = (TextView) itemView.findViewById(R.id.row_calculator_parameter_text);
            mCalculatorResultText = (TextView) itemView.findViewById(R.id.row_calculator_result_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = CalculatorFormulasActivity.newIntent(mContext, getLayoutPosition(), mIndex);
                    mContext.startActivity(intent);
                }
            });
        }

        public void bind(String parameter){
            mCalculatorParameter.setText(parameter);
            switch (mIndex){
                case 0:
                    switch (getLayoutPosition()){
                        case 0:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateTurningValues(0);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getTurningCuttingSpeed() != null){
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getTurningCuttingSpeed()) + " " + mContext.getResources().getString(R.string.m_min));
                            }
                            break;
                        case 1:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateTurningValues(1);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getTurningSpindleSpeed() != null){
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getTurningSpindleSpeed()) + " " + mContext.getResources().getString(R.string.rpm));
                            }
                            break;
                        case 2:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateTurningValues(2);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getTurningMetalRemovalRate() != null){
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getTurningMetalRemovalRate()) + " " + mContext.getResources().getString(R.string.cm3_min));
                            }
                            break;
                        case 3:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateTurningValues(3);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getTurningNetPowerRequirement() != null){
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getTurningNetPowerRequirement()) + " " + mContext.getResources().getString(R.string.kW));
                            }
                            break;
                        case 4:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateTurningValues(4);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getTurningMachiningTime() != null){
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getTurningMachiningTime()) + " " + mContext.getResources().getString(R.string.min));
                            }
                            break;
                    }
                    break;
                case 1:
                    switch (getLayoutPosition()) {
                        case 0:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateMillingValues(0);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingCuttingSpeed() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingCuttingSpeed()) + " " + mContext.getResources().getString(R.string.m_min));
                            }
                            break;
                        case 1:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateMillingValues(1);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingSpindleSpeed() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingSpindleSpeed()) + " " + mContext.getResources().getString(R.string.rpm));
                            }
                            break;
                        case 2:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateMillingValues(2);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingFeedTooth() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingFeedTooth()) + " " + mContext.getResources().getString(R.string.mm));
                            }
                            break;
                        case 3:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateMillingValues(3);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingTableFeed() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingTableFeed()) + " " + mContext.getResources().getString(R.string.mm_min));
                            }
                            break;
                        case 4:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateMillingValues(4);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingMetalRemovalRate() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingMetalRemovalRate()) + " " + mContext.getResources().getString(R.string.cm3_min));
                            }
                            break;
                        case 5:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateMillingValues(5);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingNetPowerRequirement() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingNetPowerRequirement()) + " " + mContext.getResources().getString(R.string.kW));
                            }
                            break;
                        case 6:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateMillingValues(6);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingTorque() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getMillingTorque()) + " " + mContext.getResources().getString(R.string.Nm));
                            }
                            break;
                    }
                    break;
                case 2:
                    switch (getLayoutPosition()) {
                        case 0:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateDrillingValues(0);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingCuttingSpeed() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingCuttingSpeed()) + " " + mContext.getResources().getString(R.string.m_min));
                            }
                            break;
                        case 1:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateDrillingValues(1);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingSpindleSpeed() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingSpindleSpeed()) + " " + mContext.getResources().getString(R.string.rpm));
                            }
                            break;
                        case 2:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateDrillingValues(2);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingFeedPerRevolution() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingFeedPerRevolution()) + " " + mContext.getResources().getString(R.string.rpm));
                            }
                            break;
                        case 3:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateDrillingValues(3);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingPenetrationRate() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingPenetrationRate()) + " " + mContext.getResources().getString(R.string.mm_min));
                            }
                            break;
                        case 4:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateDrillingValues(4);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingMetalRemovalRate() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingMetalRemovalRate()) + " " + mContext.getResources().getString(R.string.cm3_min));
                            }
                            break;
                        case 5:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateDrillingValues(5);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingMachiningTime() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingMachiningTime()) + " " + mContext.getResources().getString(R.string.min));
                            }
                            break;
                        case 6:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateDrillingValues(6);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingNetPowerRequirement() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingNetPowerRequirement()) + " " + mContext.getResources().getString(R.string.kW));
                            }
                            break;
                        case 7:
                            CalculatorCachedValuesLab.getCachedValuesLab(mContext).updateDrillingValues(7);
                            if (CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingTorque() != null) {
                                mCalculatorResultText.setVisibility(View.VISIBLE);
                                mCalculatorResultText.setText(Utils.fmt3(CalculatorCachedValuesLab.getCachedValuesLab(mContext).getDrillingTorque()) + " " + mContext.getResources().getString(R.string.Nm));
                            }
                            break;
                    }
                    break;
            }
        }
    }
}
