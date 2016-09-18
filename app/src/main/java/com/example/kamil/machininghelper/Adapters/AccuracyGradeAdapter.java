package com.example.kamil.machininghelper.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.Fragments.ToleranceFragment;
import com.example.kamil.machininghelper.Model.AccuracyGrades;
import com.example.kamil.machininghelper.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil Safin on 8/25/2016.
 */
public class AccuracyGradeAdapter extends RecyclerView.Adapter<AccuracyGradeAdapter.AccuracyGradeHolder> {

    private Context mContext;
    private List<String> mAccuracyGrades;
    private List<AccuracyGradeHolder> mToleranceHolders = new ArrayList<>();
    private static Integer sCheckedItem = null;

    public AccuracyGradeAdapter(Context context, AccuracyGrades accuracyGrades, Integer checkedItem) {
        mContext = context;
        mAccuracyGrades = accuracyGrades.getAccuracyGrades();
        sCheckedItem = checkedItem;
    }

    @Override
    public AccuracyGradeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_tolerance, parent, false);

        AccuracyGradeHolder accuracyGradeHolder = new AccuracyGradeHolder(view);
        mToleranceHolders.add(accuracyGradeHolder);

        return new AccuracyGradeHolder(view);
    }

    @Override
    public void onBindViewHolder(AccuracyGradeHolder holder, int position) {
        holder.bindView(mAccuracyGrades.get(position));

        if (sCheckedItem != null && sCheckedItem == position)
            holder.setChecked();
        else
            holder.setUnchecked();
    }

    @Override
    public int getItemCount() {
        return mAccuracyGrades.size();
    }

    class AccuracyGradeHolder extends RecyclerView.ViewHolder{

        private String mAccuracyGrade;
        private TextView mAccuracyText;

        public AccuracyGradeHolder(View itemView) {
            super(itemView);

            mAccuracyText = (TextView) itemView.findViewById(R.id.row_tolerance_text);
            itemView.setOnClickListener(l -> {
                for (AccuracyGradeHolder toleranceHolder : mToleranceHolders){
                    toleranceHolder.setUnchecked();
                }
                this.setChecked();
                sCheckedItem = getLayoutPosition();
                ToleranceFragment.setAccuracy(sCheckedItem);
            });
        }

        public void bindView(String accuracyGrade){
            mAccuracyGrade = accuracyGrade;
            mAccuracyText.setText(mAccuracyGrade);
        }

        public void setChecked(){
            itemView.setBackgroundColor(mContext.getResources().getColor(R.color.yellow));
        }

        public void setUnchecked(){
            itemView.setBackgroundColor(Color.WHITE);
        }
    }
}
