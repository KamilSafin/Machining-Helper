package com.example.kamil.machininghelper.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.Model.CreatorLab;
import com.example.kamil.machininghelper.Model.Material;
import com.example.kamil.machininghelper.R;

import java.util.List;

/**
 * Created by Kamil Safin on 10/2/2016.
 */

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.MaterialHolder> {

    private Context mContext;
    private List<Material> mMaterials;
    private MaterialAdapterCallback mMaterialAdapterCallback;

    public MaterialAdapter(Context context, MaterialAdapterCallback materialAdapterCallback, boolean isHSSDrill) {
        mContext = context;
        mMaterialAdapterCallback = materialAdapterCallback;
        if (isHSSDrill) {
            mMaterials = CreatorLab.getCreatorLab(context).getSteelMillingMaterials();
        } else {
            mMaterials = CreatorLab.getCreatorLab(context).getCarbideMillingMaterials();
        }
    }

    public interface MaterialAdapterCallback {
        void onItemClicked(int index);
    }

    @Override
    public MaterialHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_material, parent, false);

        return new MaterialHolder(view);
    }

    @Override
    public void onBindViewHolder(MaterialHolder holder, int position) {
        holder.bindView(mMaterials.get(position));
    }

    @Override
    public int getItemCount() {
        return mMaterials.size();
    }

    class MaterialHolder extends RecyclerView.ViewHolder {

        private TextView mMaterialText;

        public MaterialHolder(View itemView) {
            super(itemView);

            mMaterialText = (TextView) itemView.findViewById(R.id.material_name_text);

            itemView.setOnClickListener(l -> {
                mMaterialAdapterCallback.onItemClicked(getLayoutPosition());
            });
        }

        public void bindView(Material material) {
            mMaterialText.setText(material.getName());
        }
    }
}
