package com.example.kamil.machininghelper.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil Safin on 8/24/2016.
 */
public class ThreadLab {

    private static ThreadLab sThreadLab;
    private Context mContext;
    private List<Threads> mMetricThreads;
    private List<Threads> mFineThreads;

    public ThreadLab(Context context) {
        mContext = context;

        mMetricThreads = new ArrayList<>();
        mFineThreads = new ArrayList<>();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                mMetricThreads.add(new MetricThread("M1", 0.75));
                mMetricThreads.add(new MetricThread("M1.2", 0.95));
                mMetricThreads.add(new MetricThread("M1.4", 1.1));
                mMetricThreads.add(new MetricThread("M1.6", 1.25));
                mMetricThreads.add(new MetricThread("M1.8", 1.45));
                mMetricThreads.add(new MetricThread("M2", 1.6));
                mMetricThreads.add(new MetricThread("M2.2", 1.75));
                mMetricThreads.add(new MetricThread("M2.5", 2.05));
                mMetricThreads.add(new MetricThread("M3", 2.5));
                mMetricThreads.add(new MetricThread("M3.5", 2.9));
                mMetricThreads.add(new MetricThread("M4", 3.3));
                mMetricThreads.add(new MetricThread("M5", 4.2));
                mMetricThreads.add(new MetricThread("M6", 5));
                mMetricThreads.add(new MetricThread("M7", 6));
                mMetricThreads.add(new MetricThread("M8", 6.8));
                mMetricThreads.add(new MetricThread("M9", 7.8));
                mMetricThreads.add(new MetricThread("M10", 8.5));
                mMetricThreads.add(new MetricThread("M11", 9.5));
                mMetricThreads.add(new MetricThread("M12", 10.2));
                mMetricThreads.add(new MetricThread("M14", 12));
                mMetricThreads.add(new MetricThread("M16", 14));
                mMetricThreads.add(new MetricThread("M18", 15.5));
                mMetricThreads.add(new MetricThread("M20", 17.5));
                mMetricThreads.add(new MetricThread("M22", 19.5));
                mMetricThreads.add(new MetricThread("M24", 21));
                mMetricThreads.add(new MetricThread("M27", 24));
                mMetricThreads.add(new MetricThread("M30", 26.5));
                mMetricThreads.add(new MetricThread("M33", 29.5));
                mMetricThreads.add(new MetricThread("M36", 32));
                mMetricThreads.add(new MetricThread("M39", 35));
                mMetricThreads.add(new MetricThread("M42", 37.5));
                mMetricThreads.add(new MetricThread("M45", 40.5));
                mMetricThreads.add(new MetricThread("M48", 43));
                mMetricThreads.add(new MetricThread("M52", 47));
                mMetricThreads.add(new MetricThread("M56", 50.5));
                mMetricThreads.add(new MetricThread("M60", 54.5));
                mMetricThreads.add(new MetricThread("M64", 58));
                mMetricThreads.add(new MetricThread("M68", 62));

                mFineThreads.add(new FineThread("M3x0.35", 2.65));
                mFineThreads.add(new FineThread("M4x0.5", 3.5));
                mFineThreads.add(new FineThread("M5x0.5", 4.5));
                mFineThreads.add(new FineThread("M6x0.75", 5.2));
                mFineThreads.add(new FineThread("M7x0.75", 6.2));
                mFineThreads.add(new FineThread("M8x0.75", 7.2));
                mFineThreads.add(new FineThread("M8x1", 7));
                mFineThreads.add(new FineThread("M9x1", 8));
                mFineThreads.add(new FineThread("M10x0.75", 9.2));
                mFineThreads.add(new FineThread("M10x1", 9));
                mFineThreads.add(new FineThread("M10x1.25", 8.8));
                mFineThreads.add(new FineThread("M12x1", 11));
                mFineThreads.add(new FineThread("M12x1.25", 10.8));
                mFineThreads.add(new FineThread("M12x1.5", 10.5));
                mFineThreads.add(new FineThread("M14x1.5", 12.5));
                mFineThreads.add(new FineThread("M15x1.5", 13.5));
                mFineThreads.add(new FineThread("M16x1", 15));
                mFineThreads.add(new FineThread("M16x1.5", 14.5));
                mFineThreads.add(new FineThread("M18x2", 16));
                mFineThreads.add(new FineThread("M20x1.5", 18.5));
                mFineThreads.add(new FineThread("M20x2", 18));
                mFineThreads.add(new FineThread("M22x1.5", 20.5));
                mFineThreads.add(new FineThread("M22x2", 20));
                mFineThreads.add(new FineThread("M24x1", 23));
                mFineThreads.add(new FineThread("M24x1.5", 22.5));
                mFineThreads.add(new FineThread("M24x2", 22));
                mFineThreads.add(new FineThread("M26x1.5", 24.5));
                mFineThreads.add(new FineThread("M27x1.5", 25.5));
                mFineThreads.add(new FineThread("M27x2", 25));
                mFineThreads.add(new FineThread("M28x1.5", 26.5));
                mFineThreads.add(new FineThread("M30x2", 28));
                mFineThreads.add(new FineThread("M33x2", 31));
                mFineThreads.add(new FineThread("M36x1.5", 34.5));
                mFineThreads.add(new FineThread("M36x2", 34));
                mFineThreads.add(new FineThread("M39x3", 36));
                mFineThreads.add(new FineThread("M42x1.5", 40.5));
                mFineThreads.add(new FineThread("M45x1.5", 43.5));
            }
        });

        thread.start();
    }

    public static ThreadLab getThreadLab(Context context) {
        if (sThreadLab == null)
            sThreadLab = new ThreadLab(context.getApplicationContext());

        return sThreadLab;
    }

    public List<Threads> getMetricThreads(){
        return mMetricThreads;
    }

    public List<Threads> getFineThreads(){
        return mFineThreads;
    }
}
