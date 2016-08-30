package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.example.kamil.machininghelper.Fragments.DimensionsAndToleranceFragment;
import com.example.kamil.machininghelper.R;

public class DimensionsAndToleranceActivity extends SingleFragmentActivity implements DimensionsAndToleranceFragment.DimensionAndToleranceCallback{

    private Toolbar mToolbar;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, DimensionsAndToleranceActivity.class);

        return intent;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.dimensions_and_tolerance));
    }

    public void resetToolbarTitle(){
        getSupportActionBar().setTitle(getResources().getString(R.string.dimensions_and_tolerance));
    }

    @Override
    protected Fragment createFragment() {
        return DimensionsAndToleranceFragment.initFragment();
    }

    @Override
    public void startFragment(Fragment fragment, String title) {
        getSupportActionBar().setTitle(title);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment);
        transaction.addToBackStack("fragment");
        transaction.commit();
    }
}
