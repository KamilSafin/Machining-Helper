package com.example.kamil.machininghelper.Activities;

import android.support.v4.app.Fragment;
import com.example.kamil.machininghelper.Fragments.MainFragment;
import com.example.kamil.machininghelper.R;

public class MainActivity extends SingleFragmentActivity {

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected Fragment createFragment() {
        return MainFragment.initFragment();
    }
}
