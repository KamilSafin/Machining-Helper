package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.example.kamil.machininghelper.Fragments.MachiningProblemsSolutionFragment;
import com.example.kamil.machininghelper.R;

public class MachiningProblemsSolutionActivity extends SingleFragmentActivity {

    private static final String EXTRA_SOLUTION_FRAGMENT_INDEX = MachiningProblemsSolutionActivity.class.getName() + "_extra_solution_fragment_index";
    private static final String EXTRA_SOLUTION_FRAGMENT_ITEM_POS = MachiningProblemsSolutionActivity.class.getName() + "_extra_solution_fragment_item_pos";

    private Toolbar mToolbar;

    private int mIndex;
    private int mItemPos;

    public static Intent newIntent(Context context, int index, int item){
        Intent intent = new Intent(context, MachiningProblemsSolutionActivity.class);
        intent.putExtra(EXTRA_SOLUTION_FRAGMENT_INDEX, index);
        intent.putExtra(EXTRA_SOLUTION_FRAGMENT_ITEM_POS, item);

        return intent;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        switch (mIndex){
            case 0:
                getSupportActionBar().setTitle(getResources().getString(R.string.turning_problems_solution));
                break;
            case 1:
                getSupportActionBar().setTitle(getResources().getString(R.string.milling_problems_solution));
                break;
            case 2:
                getSupportActionBar().setTitle(getResources().getString(R.string.drilling_problems_solution));
                break;
        }
    }

    @Override
    protected Fragment createFragment() {
        mIndex = getIntent().getIntExtra(EXTRA_SOLUTION_FRAGMENT_INDEX, 0);
        mItemPos = getIntent().getIntExtra(EXTRA_SOLUTION_FRAGMENT_ITEM_POS, 0);
        return MachiningProblemsSolutionFragment.initFragment(mIndex, mItemPos);
    }
}
