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
import com.example.kamil.machininghelper.R;

import java.util.List;

/**
 * Created by Kamil Safin on 8/22/2016.
 */
public class GCodeBaseAdapter extends RecyclerView.Adapter<GCodeBaseAdapter.GCodeBaseHolder>{

    private Context mContext;
    private List<GCode> mGCodes;

    public GCodeBaseAdapter(Context context, List<GCode> gCodes) {
        mContext = context;
        mGCodes = gCodes;
    }

    @Override
    public GCodeBaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_g_code, parent, false);
        GCodeBaseHolder gcodeBaseHolder = new GCodeBaseHolder(view);

        return gcodeBaseHolder;
    }

    @Override
    public void onBindViewHolder(GCodeBaseHolder holder, int position) {
        holder.bindView(mGCodes.get(position));
    }

    @Override
    public int getItemCount() {
        return mGCodes.size();
    }

    class GCodeBaseHolder extends RecyclerView.ViewHolder{

        private GCode mGCode;
        private TextView mGCodeText;

        public GCodeBaseHolder(View itemView) {
            super(itemView);

            mGCodeText = (TextView) itemView.findViewById(R.id.g_code_text);
            itemView.setOnClickListener(l -> {
                Intent intent = GCodeDetailActivity.newIntent(mContext, getLayoutPosition());
                mContext.startActivity(intent);
            });
        }

        public void bindView(GCode gcode){
            mGCode = gcode;
            mGCodeText.setText(mGCode.getG());
        }
    }
}
