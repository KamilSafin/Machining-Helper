package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class DetailCreatorActivity extends SingleFragmentActivity {

    private static final String EXTRA_INDEX = DetailCreatorActivity.class.getName() + "_extra_index";

    public static Intent newIntent(Context context, int index){
        Intent intent = new Intent(context, DetailCreatorActivity.class);
        intent.putExtra(EXTRA_INDEX, index);

        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return null;
    }
}
