package com.example.kamil.machininghelper.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kamil.machininghelper.Fragments.ToleranceFragment;
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
    private static Integer sCheckedItem = null;

    public ToleranceAdapter(Context context, List<Tolerance> tolerances, Integer checkedItem) {
        mContext = context;
        mTolerances = tolerances;
        sCheckedItem = checkedItem;
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

        if (sCheckedItem != null && sCheckedItem == position)
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
        private RelativeLayout mBackground;

        public ToleranceHolder(View itemView) {
            super(itemView);

            mToleranceText = (TextView) itemView.findViewById(R.id.row_tolerance_text);
            mBackground = (RelativeLayout) itemView.findViewById(R.id.tolerance_bg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (ToleranceHolder toleranceHolder : mToleranceHolders){
                        toleranceHolder.setUnchecked();
                    }
                    ToleranceHolder.this.setChecked();
                    sCheckedItem = getLayoutPosition();
                    ToleranceFragment.setDimension(sCheckedItem);
                }
            });
        }

        public void bindView(Tolerance tolerance){
            mTolerance = tolerance;
            mToleranceText.setText(mTolerance.getDimension());
        }

        public void setChecked(){
            mBackground.setBackground(mContext.getResources().getDrawable(R.drawable.tolerance_rect_active));
        }

        public void setUnchecked(){
            mBackground.setBackground(mContext.getResources().getDrawable(R.drawable.tolerance_rect_normal));
        }
    }
}
