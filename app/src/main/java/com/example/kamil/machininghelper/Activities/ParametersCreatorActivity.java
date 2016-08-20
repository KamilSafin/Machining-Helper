package com.example.kamil.machininghelper.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kamil.machininghelper.Fragments.ParametersCreatorFragment;

public class ParametersCreatorActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return ParametersCreatorFragment.initFragment();
    }
}
