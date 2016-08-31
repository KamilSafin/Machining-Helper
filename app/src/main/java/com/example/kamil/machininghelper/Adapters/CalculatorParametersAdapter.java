package com.example.kamil.machininghelper.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.R;

import java.util.List;

/**
 * Created by Kamil Safin on 8/31/2016.
 */
public class CalculatorParametersAdapter extends RecyclerView.Adapter<CalculatorParametersAdapter.CalculatorParametersViewHolder> {

    private Context mContext;
    private List<String> mCalculatorParameters;

    public CalculatorParametersAdapter(Context context, List<String> calculatorParameters) {
        mContext = context;
        mCalculatorParameters = calculatorParameters;
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
        }

        public void bind(String parameter){
            mCalculatorParameter.setText(parameter);
        }
    }
}
