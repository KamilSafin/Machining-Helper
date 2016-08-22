package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.kamil.machininghelper.Fragments.DimensionsAndToleranceFragment;

public class DimensionsAndToleranceActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, DimensionsAndToleranceActivity.class);

        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return DimensionsAndToleranceFragment.initFragment();
    }
}
