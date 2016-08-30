package com.example.kamil.machininghelper.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.kamil.machininghelper.Fragments.CalculatorFragment;
import com.example.kamil.machininghelper.Fragments.CalculatorItemFragment;
import com.example.kamil.machininghelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalculatorActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout mTabLayout;

    @BindView(R.id.calculator_view_pager)
    ViewPager mViewPager;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, CalculatorActivity.class);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        ButterKnife.bind(this);

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
//
//        if (fragment == null){
//            fragment = CalculatorFragment.initFragment();
//            FragmentTransaction transaction = fragmentManager.beginTransaction().add(R.id.fragment_container, fragment);
//            transaction.commit();
//        }

        TabLayout.Tab turning = mTabLayout.newTab();
        TabLayout.Tab milling = mTabLayout.newTab();
        TabLayout.Tab drilling = mTabLayout.newTab();

        mTabLayout.addTab(turning);
        mTabLayout.addTab(milling);
        mTabLayout.addTab(drilling);

        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return CalculatorItemFragment.initFragment(position);
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }
}
