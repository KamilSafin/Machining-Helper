package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.kamil.machininghelper.Fragments.GCodeDetailFragment;
import com.example.kamil.machininghelper.R;

public class GCodeDetailActivity extends SingleFragmentActivity implements GCodeDetailFragment.GCodeFragmentCallback{

    private static final String EXTRA_G_CODE_INDEX = GCodeDetailActivity.class.getName() + "g_code_index";

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
    public void onSimilarCodeClicked(int index) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction().replace(R.id.fragment_container, GCodeDetailFragment.initFragment(index));
        transaction.addToBackStack("fragment");
        transaction.commit();
    }
}
