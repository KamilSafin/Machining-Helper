package com.example.kamil.machininghelper.Activities;

import android.support.v4.app.Fragment;

import com.example.kamil.machininghelper.Fragments.MainFragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return MainFragment.initFragment();
    }
}
