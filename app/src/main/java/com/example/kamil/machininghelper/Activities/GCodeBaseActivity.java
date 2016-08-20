package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.kamil.machininghelper.Fragments.GCodeBaseFragment;

public class GCodeBaseActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, GCodeBaseActivity.class);

        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return GCodeBaseFragment.initFragment();
    }
}
