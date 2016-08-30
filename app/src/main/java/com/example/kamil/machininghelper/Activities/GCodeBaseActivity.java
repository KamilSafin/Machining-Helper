package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.example.kamil.machininghelper.Fragments.GCodeBaseFragment;
import com.example.kamil.machininghelper.R;

public class GCodeBaseActivity extends SingleFragmentActivity {

    private Toolbar mToolbar;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, GCodeBaseActivity.class);

        return intent;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.g_code_base));
    }

    @Override
    protected Fragment createFragment() {
        return GCodeBaseFragment.initFragment();
    }
}
