package com.example.kamil.machininghelper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.Activities.CalculatorFormulasActivity;
import com.example.kamil.machininghelper.R;

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

        public CalculatorParametersViewHolder(View itemView) {
            super(itemView);

            mCalculatorParameter = (TextView) itemView.findViewById(R.id.row_calculator_parameter_text);

            itemView.setOnClickListener(l -> {
                Intent intent = CalculatorFormulasActivity.newIntent(mContext, getLayoutPosition(), mIndex);
                mContext.startActivity(intent);
            });
        }

        public void bind(String parameter){
            mCalculatorParameter.setText(parameter);
        }
    }
}
