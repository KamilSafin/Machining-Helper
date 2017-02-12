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

import com.example.kamil.machininghelper.Adapters.TurningMaterialAdapter;
import com.example.kamil.machininghelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseTurningMaterialDialog extends DialogFragment implements TurningMaterialAdapter.TurningMaterialAdapterCallback {

    @BindView(R.id.material_recycler_view)
    RecyclerView mMaterialRecyclerView;

    private ChooseTurningMaterialDialog.DialogTurningMaterialCallback mDialogMaterialCallback;

    public static ChooseTurningMaterialDialog newInstance() {

        Bundle args = new Bundle();

        ChooseTurningMaterialDialog fragment = new ChooseTurningMaterialDialog();
        fragment.setArguments(args);
        return fragment;
    }


    public interface DialogTurningMaterialCallback {
        void onTurningMaterialSelected(int index);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.dialog_choose_material, null);

        ButterKnife.bind(this, view);

        mMaterialRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mMaterialRecyclerView.setAdapter(new TurningMaterialAdapter(getContext(), this));

        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(STYLE_NO_TITLE);
        dialog.setContentView(view);

        return dialog;
    }

    public void show(FragmentManager manager, String tag, ChooseTurningMaterialDialog.DialogTurningMaterialCallback dialogMaterialCallback) {
        super.show(manager, tag);
        mDialogMaterialCallback = dialogMaterialCallback;
    }


    @Override
    public void onItemClicked(int index) {
        mDialogMaterialCallback.onTurningMaterialSelected(index);
        dismiss();
    }
}
