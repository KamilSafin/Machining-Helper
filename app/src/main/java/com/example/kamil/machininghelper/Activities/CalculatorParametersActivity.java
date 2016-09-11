package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kamil.machininghelper.Fragments.CalculatorFragment;
import com.example.kamil.machininghelper.Model.CachedValuesLab;
import com.example.kamil.machininghelper.R;

public class CalculatorParametersActivity extends SingleFragmentActivity {

    private static final String EXTRA_FRAGMENT_INDEX = CalculatorParametersActivity.class.getName() + "_extra_fragment_index";
    private static final String ARGS_FRAGMENT_INDEX = CalculatorParametersActivity.class.getName() + "_args_fragment_index";

    private Toolbar mToolbar;
    private int mIndex;

    public static Intent newIntent(Context context, int index){
        Intent intent = new Intent(context, CalculatorParametersActivity.class);
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
                getSupportActionBar().setTitle(getResources().getString(R.string.turning_parameters));
                break;
            case 1:
                getSupportActionBar().setTitle(getResources().getString(R.string.milling_parameters));
                break;
            case 2:
                getSupportActionBar().setTitle(getResources().getString(R.string.drilling_parameters));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.trash:
                switch (mIndex){
                    case 0:
                        CachedValuesLab.getCachedValuesLab(this).removeTurningValues();
                        break;
                    case 1:
                        CachedValuesLab.getCachedValuesLab(this).removeMillingValues();
                        break;
                    case 2:
                        CachedValuesLab.getCachedValuesLab(this).removeDrillingValues();
                        break;
                }
                ((CalculatorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container)).initView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected Fragment createFragment() {
        mIndex = getIntent().getIntExtra(EXTRA_FRAGMENT_INDEX, 0);

        return CalculatorFragment.initFragment(mIndex);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mIndex = savedInstanceState.getInt(ARGS_FRAGMENT_INDEX);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARGS_FRAGMENT_INDEX, mIndex);
    }
}
