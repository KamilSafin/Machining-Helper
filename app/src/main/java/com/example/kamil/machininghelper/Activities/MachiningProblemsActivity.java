package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.example.kamil.machininghelper.Fragments.MachiningProblemsFragment;
import com.example.kamil.machininghelper.R;

public class MachiningProblemsActivity extends SingleFragmentActivity {

    private static final String EXTRA_FRAGMENT_INDEX = MachiningProblemsActivity.class.getName() + "_extra_fragment_index";

    private Toolbar mToolbar;

    private int mIndex;

    public static Intent newIntent(Context context, int index){
        Intent intent = new Intent(context, MachiningProblemsActivity.class);
        intent.putExtra(EXTRA_FRAGMENT_INDEX, index);

        return intent;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mIndex = getIntent().getIntExtra(EXTRA_FRAGMENT_INDEX, 0);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        switch (mIndex){
            case 0:
                getSupportActionBar().setTitle(getResources().getString(R.string.turning_problems));
                break;
            case 1:
                getSupportActionBar().setTitle(getResources().getString(R.string.milling_problems));
                break;
            case 2:
                getSupportActionBar().setTitle(getResources().getString(R.string.drilling_problems));
                break;
        }
    }

    @Override
    protected Fragment createFragment() {
        return MachiningProblemsFragment.initFragment(mIndex);
    }
}
