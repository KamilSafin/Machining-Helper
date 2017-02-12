package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kamil.machininghelper.Fragments.DrillingCreatorFragment;
import com.example.kamil.machininghelper.Fragments.MillingCreatorFragment;
import com.example.kamil.machininghelper.Fragments.TurningCreatorFragment;
import com.example.kamil.machininghelper.Model.CreatorCachedValuesLab;
import com.example.kamil.machininghelper.R;

public class DetailCreatorActivity extends SingleFragmentActivity {

    private static final String EXTRA_INDEX = DetailCreatorActivity.class.getName() + "_extra_index";

    private Toolbar mToolbar;

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

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.trash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int index = getIntent().getIntExtra(EXTRA_INDEX, 0);
        switch (item.getItemId()){
            case R.id.trash:
                switch (index){
                    case 0:
                        CreatorCachedValuesLab.getCachedValuesLab(this).removeTurningValues();
                        ((TurningCreatorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container)).resetView();
                        break;
                    case 1:
                        CreatorCachedValuesLab.getCachedValuesLab(this).removeMillingValues();
                        ((MillingCreatorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container)).resetView();
                        break;
                    case 2:
                        CreatorCachedValuesLab.getCachedValuesLab(this).removeDrillingValues();
                        ((DrillingCreatorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container)).resetView();
                        break;
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
