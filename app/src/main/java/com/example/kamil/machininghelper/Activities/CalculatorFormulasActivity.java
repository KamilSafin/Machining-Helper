package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.example.kamil.machininghelper.Fragments.CalculatorFormulasFragment;

public class CalculatorFormulasActivity extends SingleFragmentActivity {

    private static final String EXTRA_FRAGMENT_ITEM_POS = CalculatorFormulasActivity.class.getName() + "_extra_fragment_item_pos";
    private static final String EXTRA_FRAGMENT_INDEX = CalculatorFormulasActivity.class.getName() + "_extra_fragment_index";

    private int mItemPos;
    private int mIndex;

    public static Intent newIntent(Context context, int itemPos, int index){
        Intent intent = new Intent(context, CalculatorFormulasActivity.class);
        intent.putExtra(EXTRA_FRAGMENT_ITEM_POS, itemPos);
        intent.putExtra(EXTRA_FRAGMENT_INDEX, index);

        return intent;
    }

    @Override
    protected Fragment createFragment() {
        mItemPos = getIntent().getIntExtra(EXTRA_FRAGMENT_ITEM_POS, 0);
        mIndex = getIntent().getIntExtra(EXTRA_FRAGMENT_INDEX, 0);

        return CalculatorFormulasFragment.initFragment(mItemPos, mIndex);
    }
}
