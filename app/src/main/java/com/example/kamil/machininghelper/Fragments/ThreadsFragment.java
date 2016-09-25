package com.example.kamil.machininghelper.Fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamil.machininghelper.Activities.DimensionsAndToleranceActivity;
import com.example.kamil.machininghelper.Adapters.ThreadsAdapter;
import com.example.kamil.machininghelper.Model.ThreadLab;
import com.example.kamil.machininghelper.Model.Threads;
import com.example.kamil.machininghelper.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kamil Safin on 8/24/2016.
 */
public class ThreadsFragment extends Fragment {

    private static final String ARGS_HOLE_DIAMETER = ThreadsFragment.class.getName() + "_args_hole_diameter";
    private static final String ARGS_THEAD_TYPE = ThreadsFragment.class.getName() + "_args_thread_type";
    private static final String ARGS_IS_METRIC = ThreadsFragment.class.getName() + "_args_is_metric";

    @BindView(R.id.thread_recyler_view)
    RecyclerView mThreadRecyclerView;

    @BindView(R.id.thread_type)
    TextView mThreadType;

    private static TextView sThreadHoleText;

    private ThreadsAdapter mThreadsAdapter;
    private ThreadLab mThreadLab;
    private List<Threads> mThreads;
    private boolean mIsMetric = true;

    public static Fragment initFragment(){
        Fragment fragment = new ThreadsFragment();

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
        mThreadLab = ThreadLab.getThreadLab(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_treads, container, false);

        ButterKnife.bind(this, view);

        sThreadHoleText = (TextView) view.findViewById(R.id.thread_hole_text);

        if (savedInstanceState != null){
            sThreadHoleText.setText(savedInstanceState.getString(ARGS_HOLE_DIAMETER));
            mThreadType.setText(savedInstanceState.getString(ARGS_THEAD_TYPE));
            mIsMetric = savedInstanceState.getBoolean(ARGS_IS_METRIC);
        } else {
            sThreadHoleText.setText(R.string.thread_size);
            mThreadType.setText(R.string.metric_threads);
        }

        initAdapter(mIsMetric);

        return view;
    }

    private void initAdapter(boolean isMetric){
        if (isMetric)
            mThreads = mThreadLab.getMetricThreads();
        else
            mThreads = mThreadLab.getFineThreads();

        mThreadsAdapter = new ThreadsAdapter(getContext(), mThreads);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            mThreadRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        else
            mThreadRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));

        mThreadRecyclerView.setAdapter(mThreadsAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.change, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.change_type:
                mIsMetric = !mIsMetric;
                sThreadHoleText.setText(R.string.thread_size);
                break;
        }
        if (mIsMetric)
            mThreadType.setText(R.string.metric_threads);
        else
            mThreadType.setText(R.string.fine_threads);

        initAdapter(mIsMetric);

        return super.onOptionsItemSelected(item);
    }

    public static void setHoleDiameter(Threads thread){
        sThreadHoleText.setText(Double.toString(thread.getThreadDiameter()) + " mm");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((DimensionsAndToleranceActivity) getActivity()).resetToolbarTitle();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ARGS_HOLE_DIAMETER, sThreadHoleText.getText().toString());
        outState.putString(ARGS_THEAD_TYPE, mThreadType.getText().toString());
        outState.putBoolean(ARGS_IS_METRIC, mIsMetric);
    }
}
