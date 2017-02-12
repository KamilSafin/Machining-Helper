package com.example.kamil.machininghelper.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.Model.CreatorLab;
import com.example.kamil.machininghelper.Model.TurningMaterial;
import com.example.kamil.machininghelper.R;

import java.util.List;

public class TurningMaterialAdapter extends RecyclerView.Adapter<TurningMaterialAdapter.MaterialHolder> {

    private Context mContext;
    private List<TurningMaterial> mMaterials;
    private TurningMaterialAdapterCallback mMaterialAdapterCallback;

    public TurningMaterialAdapter(Context context, TurningMaterialAdapterCallback materialAdapterCallback) {
        mContext = context;
        mMaterialAdapterCallback = materialAdapterCallback;
        mMaterials = CreatorLab.getCreatorLab(context).getTurningMaterials();
    }

    public interface TurningMaterialAdapterCallback {
        void onItemClicked(int index);
    }

    @Override
    public MaterialHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_material, parent, false);

        return new MaterialHolder(view);
    }

    @Override
    public void onBindViewHolder(TurningMaterialAdapter.MaterialHolder holder, int position) {
        holder.bindView(mMaterials.get(position));
    }

    @Override
    public int getItemCount() {
        return mMaterials.size();
    }

    class MaterialHolder extends RecyclerView.ViewHolder {

        private TextView mMaterialText;
        private TextView mMaterialCuttingTypeText;

        public MaterialHolder(View itemView) {
            super(itemView);

            mMaterialText = (TextView) itemView.findViewById(R.id.material_name_text);
            mMaterialCuttingTypeText = (TextView) itemView.findViewById(R.id.material_cutting_type_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mMaterialAdapterCallback.onItemClicked(getLayoutPosition());
                }
            });
        }

        public void bindView(TurningMaterial material) {
            if (material.getGroupId() != null) {
                mMaterialText.setText(material.getName());
                mMaterialCuttingTypeText.setText(" (" + material.getCuttingType() + ")");
            } else {
                mMaterialText.setText(material.getName());
                mMaterialCuttingTypeText.setText(null);
            }
        }
    }
}
