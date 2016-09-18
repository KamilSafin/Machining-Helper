package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.kamil.machininghelper.Fragments.DrillingCreatorFragment;
import com.example.kamil.machininghelper.Fragments.MillingCreatorFragment;
import com.example.kamil.machininghelper.Fragments.TurningCreatorFragment;

public class DetailCreatorActivity extends SingleFragmentActivity {

    private static final String EXTRA_INDEX = DetailCreatorActivity.class.getName() + "_extra_index";

    public static Intent newIntent(Context context, int index){
        Intent intent = new Intent(context, DetailCreatorActivity.class);
        intent.putExtra(EXTRA_INDEX, index);

        return intent;
    }

    @Override
    protected Fragment createFragment() {
        int index = getIntent().getIntExtra(EXTRA_INDEX, 0);

        switch (index){
            case 0:
                return TurningCreatorFragment.initFragment();
            case 1:
                return MillingCreatorFragment.initFragment();
            case 2:
                return DrillingCreatorFragment.initFragment();
            default:
                return null;
        }
    }
}
