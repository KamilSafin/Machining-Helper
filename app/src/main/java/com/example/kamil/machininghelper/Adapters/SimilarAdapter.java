package com.example.kamil.machininghelper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.Activities.GCodeDetailActivity;
import com.example.kamil.machininghelper.Model.GCode;
import com.example.kamil.machininghelper.Model.GCodeLab;
import com.example.kamil.machininghelper.R;

import java.util.List;

/**
 * Created by Kamil Safin on 9/25/2016.
 */
public class SimilarAdapter extends RecyclerView.Adapter<SimilarAdapter.SimilarHolder> {

    private Context mContext;
    private String[] mNames;
    private List<GCode> mGCodes;
    private int mIndex;

    public SimilarAdapter(Context context, int index) {
        mContext = context;
        mIndex = index;
        mGCodes = GCodeLab.getGCodeLab(mContext).getGCodes();
        mNames = mGCodes.get(mIndex).getSimilar();
    }

    @Override
    public SimilarHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_g_code_similar, parent, false);
        SimilarHolder similarHolder = new SimilarHolder(view);

        return similarHolder;
    }

    @Override
    public void onBindViewHolder(SimilarHolder holder, int position) {
        holder.bindView(mNames[position]);
    }

    @Override
    public int getItemCount() {
        return mNames.length;
    }

    class SimilarHolder extends RecyclerView.ViewHolder{

        private TextView mName;

        public SimilarHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.g_code_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = 0;
                    for (int j = 0; j < mGCodes.size(); j++) {
                        if (mGCodes.get(j).getG().equals(mGCodes.get(mIndex).getSimilar()[getLayoutPosition()])) {
                            index = j;
                        }
                    }
                    Intent intent = GCodeDetailActivity.newIntent(mContext, index);
                    mContext.startActivity(intent);
                }
            });
        }

        public void bindView(String name){
            mName.setText(name);
        }
    }
}
