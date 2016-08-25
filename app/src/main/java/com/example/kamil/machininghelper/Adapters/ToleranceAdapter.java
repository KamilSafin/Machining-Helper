package com.example.kamil.machininghelper.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.kamil.machininghelper.Model.Tolerance;
import com.example.kamil.machininghelper.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil Safin on 8/25/2016.
 */
public class ToleranceAdapter extends RecyclerView.Adapter<ToleranceAdapter.ToleranceHolder> {

    private Context mContext;
    private List<Tolerance> mTolerances;
    private List<ToleranceHolder> mToleranceHolders = new ArrayList<>();
    private Integer checkedItem = null;

    public ToleranceAdapter(Context context, List<Tolerance> tolerances) {
        mContext = context;
        mTolerances = tolerances;
    }

    @Override
    public ToleranceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_tolerance, parent, false);

        ToleranceHolder toleranceHolder = new ToleranceHolder(view);
        mToleranceHolders.add(toleranceHolder);
        return toleranceHolder;
    }

    @Override
    public void onBindViewHolder(ToleranceHolder holder, int position) {
        holder.bindView(mTolerances.get(position));

        if (checkedItem != null && checkedItem == position)
            holder.setChecked();
        else
            holder.setUnchecked();
    }

    @Override
    public int getItemCount() {
        return mTolerances.size();
    }

    class ToleranceHolder extends RecyclerView.ViewHolder{

        private Tolerance mTolerance;
        private TextView mToleranceText;

        public ToleranceHolder(View itemView) {
            super(itemView);

            mToleranceText = (TextView) itemView.findViewById(R.id.tolerance_text);

            itemView.setOnClickListener(l -> {
                for (ToleranceHolder toleranceHolder : mToleranceHolders){
                    toleranceHolder.setUnchecked();
                }
                this.setChecked();
                checkedItem = getLayoutPosition();
            });
        }

        public void bindView(Tolerance tolerance){
            mTolerance = tolerance;
            mToleranceText.setText(mTolerance.getDimension());
        }

        public void setChecked(){
            itemView.setBackgroundColor(Color.GRAY);
        }

        public void setUnchecked(){
            itemView.setBackgroundColor(Color.WHITE);
        }
    }
}
