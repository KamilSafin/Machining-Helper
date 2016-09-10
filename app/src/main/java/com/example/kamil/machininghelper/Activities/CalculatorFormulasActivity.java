package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.example.kamil.machininghelper.Fragments.CalculatorFormulasFragment;
import com.example.kamil.machininghelper.R;

public class CalculatorFormulasActivity extends SingleFragmentActivity {

    private static final String EXTRA_FRAGMENT_ITEM_POS = CalculatorFormulasActivity.class.getName() + "_extra_fragment_item_pos";
    private static final String EXTRA_FRAGMENT_INDEX = CalculatorFormulasActivity.class.getName() + "_extra_fragment_index";

    private Toolbar mToolbar;
    private int mItemPos;
    private int mIndex;
    private String[] titles;

    public static Intent newIntent(Context context, int itemPos, int index){
        Intent intent = new Intent(context, CalculatorFormulasActivity.class);
        intent.putExtra(EXTRA_FRAGMENT_ITEM_POS, itemPos);
        intent.putExtra(EXTRA_FRAGMENT_INDEX, index);

        return intent;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        switch (mIndex){
            case 0:
                titles = getResources().getStringArray(R.array.turning_calculator_parameters);
                getSupportActionBar().setTitle(titles[mItemPos]);
                break;
            case 1:
                titles = getResources().getStringArray(R.array.milling_calculator_parameters);
                getSupportActionBar().setTitle(titles[mItemPos]);
                break;
            case 2:
                titles = getResources().getStringArray(R.array.drilling_calculator_parameters);
                getSupportActionBar().setTitle(titles[mItemPos]);
                break;
        }
    }

    @Override
    protected Fragment createFragment() {
        mItemPos = getIntent().getIntExtra(EXTRA_FRAGMENT_ITEM_POS, 0);
        mIndex = getIntent().getIntExtra(EXTRA_FRAGMENT_INDEX, 0);

        return CalculatorFormulasFragment.initFragment(mItemPos, mIndex);
    }
}
