package com.example.kamil.machininghelper.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.kamil.machininghelper.Adapters.MaterialAdapter;
import com.example.kamil.machininghelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 10/2/2016.
 */

public class ChooseMaterialDialog extends DialogFragment implements MaterialAdapter.MaterialAdapterCallback {

    @BindView(R.id.material_recycler_view)
    RecyclerView mMaterialRecyclerView;

    private Boolean mIsHSSDrill = null;
    private DialogMaterialCallback mDialogMaterialCallback;

    public static ChooseMaterialDialog newInstance() {

        Bundle args = new Bundle();

        ChooseMaterialDialog fragment = new ChooseMaterialDialog();
        fragment.setArguments(args);
        return fragment;
    }


    public interface DialogMaterialCallback {
        void onMaterialSelected(int index);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.dialog_choose_material, null);

        ButterKnife.bind(this, view);

        mMaterialRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mMaterialRecyclerView.setAdapter(new MaterialAdapter(getContext(), this, mIsHSSDrill));

        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(STYLE_NO_TITLE);
        dialog.setContentView(view);

        return dialog;
    }

    public void show(FragmentManager manager, String tag, DialogMaterialCallback dialogMaterialCallback, Boolean isHSSDrill) {
        super.show(manager, tag);
        mDialogMaterialCallback = dialogMaterialCallback;
        mIsHSSDrill = isHSSDrill;
    }

    @Override
    public void onItemClicked(int index) {
        mDialogMaterialCallback.onMaterialSelected(index);
        dismiss();
    }
}
