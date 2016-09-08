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
 * Created by Kamil Safin on 9/7/2016.
 */
public class MachiningProblemSolutionAdapter extends RecyclerView.Adapter<MachiningProblemSolutionAdapter.MachningProblemsViewHolder> {

    private List<String> mMachiningProblemsSolution;
    private Context mContext;

    public MachiningProblemSolutionAdapter(Context context, List<String> machiningProblems) {
        mMachiningProblemsSolution = machiningProblems;
        mContext = context;
    }

    @Override
    public MachningProblemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_machning_problem_solution, parent, false);

        return new MachningProblemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MachningProblemsViewHolder holder, int position) {
        holder.bind(mMachiningProblemsSolution.get(position));
    }

    @Override
    public int getItemCount() {
        return mMachiningProblemsSolution.size();
    }

    class MachningProblemsViewHolder extends RecyclerView.ViewHolder{

        private String mMachiningProblemSolution;
        private TextView mProblemNameTextView;
        public MachningProblemsViewHolder(View itemView) {
            super(itemView);

            mProblemNameTextView = (TextView) itemView.findViewById(R.id.row_machining_problem_solution_name_text);
        }

        public void bind(String machiningProblemSolution){
            mMachiningProblemSolution = machiningProblemSolution;
            mProblemNameTextView.setText(mMachiningProblemSolution);
        }
    }
}