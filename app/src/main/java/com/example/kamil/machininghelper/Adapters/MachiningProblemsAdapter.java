package com.example.kamil.machininghelper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.Activities.MachiningProblemsSolutionActivity;
import com.example.kamil.machininghelper.Model.MachiningProblem;
import com.example.kamil.machininghelper.R;

import java.util.List;

/**
 * Created by Kamil Safin on 8/31/2016.
 */
public class MachiningProblemsAdapter extends RecyclerView.Adapter<MachiningProblemsAdapter.MachningProblemsViewHolder> {

    private List<MachiningProblem> mMachiningProblems;
    private Context mContext;
    private int mIndex;

    public MachiningProblemsAdapter(Context context, List<MachiningProblem> machiningProblems, int index) {
        mMachiningProblems = machiningProblems;
        mContext = context;
        mIndex = index;
    }

    @Override
    public MachningProblemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_machining_problem, parent, false);

        return new MachningProblemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MachningProblemsViewHolder holder, int position) {
        holder.bind(mMachiningProblems.get(position));
    }

    @Override
    public int getItemCount() {
        return mMachiningProblems.size();
    }

    class MachningProblemsViewHolder extends RecyclerView.ViewHolder{

        private MachiningProblem mMachiningProblem;
        private TextView mProblemNameTextView;

        public MachningProblemsViewHolder(View itemView) {
            super(itemView);

            mProblemNameTextView = (TextView) itemView.findViewById(R.id.row_machining_problem_name_text);

            itemView.setOnClickListener(l -> {
                Intent intent = MachiningProblemsSolutionActivity.newIntent(mContext, mIndex, getLayoutPosition());
                mContext.startActivity(intent);
            });
        }

        public void bind(MachiningProblem machiningProblem){
            mMachiningProblem = machiningProblem;
            mProblemNameTextView.setText(mMachiningProblem.getName());
        }
    }
}
