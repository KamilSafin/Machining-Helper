package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.example.kamil.machininghelper.Fragments.GCodeDetailFragment;
import com.example.kamil.machininghelper.R;

public class GCodeDetailActivity extends SingleFragmentActivity{

    private static final String EXTRA_G_CODE_INDEX = GCodeDetailActivity.class.getName() + "g_code_index";

    private Toolbar mToolbar;

    public static Intent newIntent(Context context, int gCodeIndex){
        Intent intent = new Intent(context, GCodeDetailActivity.class);
        intent.putExtra(EXTRA_G_CODE_INDEX, gCodeIndex);

        return intent;
    }

    @Override
    protected Fragment createFragment() {
        int index = getIntent().getIntExtra(EXTRA_G_CODE_INDEX, 0);
        return GCodeDetailFragment.initFragment(index);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.g_code_base));
    }
}
