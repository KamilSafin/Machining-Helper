package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.kamil.machininghelper.Fragments.DimensionsAndToleranceFragment;
import com.example.kamil.machininghelper.R;

public class DimensionsAndToleranceActivity extends SingleFragmentActivity implements DimensionsAndToleranceFragment.DimensionAndToleranceCallback{

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, DimensionsAndToleranceActivity.class);

        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return DimensionsAndToleranceFragment.initFragment();
    }

    @Override
    public void startFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment);
        transaction.addToBackStack("fragment");
        transaction.commit();
    }
}
