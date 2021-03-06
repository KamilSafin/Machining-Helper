package com.example.kamil.machininghelper.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.kamil.machininghelper.R;

/**
 * Created by Kamil Safin on 8/20/2016.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    public int initLayout(){
        return R.layout.activity_single_fragment;
    }
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            fragment = createFragment();
            FragmentTransaction transaction = fragmentManager.beginTransaction().add(R.id.fragment_container, fragment);
            transaction.commit();
        }
    }
}
