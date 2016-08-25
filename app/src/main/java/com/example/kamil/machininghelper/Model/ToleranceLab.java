package com.example.kamil.machininghelper.Model;

import android.content.Context;

import com.example.kamil.machininghelper.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil Safin on 8/25/2016.
 */
public class ToleranceLab {

    private static ToleranceLab sToleranceLab;
    private Context mContext;
    private List<Tolerance> mTolerances;

    public ToleranceLab(Context context){
        mContext = context;
        mTolerances = new ArrayList<>();
        String m = mContext.getResources().getString(R.string.micrometer);

        mTolerances.add(new Tolerance("<=3","4 " + m,"6 " + m,"10 " + m,"14 " + m,"25 " + m,"40 " + m,"60 " + m,"0.1 mm","0.14 mm","0.25 mm","0.4 mm","0.6 mm","1 mm","1.4 mm"));
        mTolerances.add(new Tolerance(">3-6","5 " + m,"8 " + m,"12 " + m,"18 " + m,"30 " + m,"48 " + m,"75 " + m,"0.12 mm","0.18 mm","0.3 mm","0.48 mm","0.75 mm","1.2 mm","1.8 mm"));
        mTolerances.add(new Tolerance(">6-10","6 " + m,"9 " + m,"15 " + m,"22 " + m,"36 " + m,"58 " + m,"90 " + m,"0.15 mm","0.22 mm","0.36 mm","0.58 mm","0.9 mm","1.5 mm","2.2 mm"));
        mTolerances.add(new Tolerance(">10-18","8 " + m,"11 " + m,"18 " + m,"27 " + m,"43 " + m,"70 " + m,"110 " + m,"0.18 mm","0.27 mm","0.43 mm","0.7 mm","1.1 mm","1.8 mm","2.7 mm"));
        mTolerances.add(new Tolerance(">18-30","9 " + m,"13 " + m,"21 " + m,"33 " + m,"52 " + m,"84 " + m,"130 " + m,"0.21 mm","0.33 mm","0.52 mm","0.84 mm","1.3 mm","2.1 mm","3.3 mm"));
        mTolerances.add(new Tolerance(">30-50","11 " + m,"16 " + m,"25 " + m,"39 " + m,"62 " + m,"100 " + m,"160 " + m,"0.25 mm","0.39 mm","0.62 mm","1 mm","1.6 mm","2.5 mm","3.9 mm"));
        mTolerances.add(new Tolerance(">50-80","13 " + m,"19 " + m,"30 " + m,"46 " + m,"74 " + m,"120 " + m,"190 " + m,"0.3 mm","0.46 mm","0.74 mm","1.2 mm","1.9 mm","3 mm","4.6 mm"));
        mTolerances.add(new Tolerance(">80-120","15 " + m,"22 " + m,"35 " + m,"54 " + m,"87 " + m,"140 " + m,"220 " + m,"0.35 mm","0.54 mm","0.87 mm","1.4 mm","2.2 mm","3.5 mm","5.4 mm"));
        mTolerances.add(new Tolerance(">120-180","18 " + m,"25 " + m,"40 " + m,"63 " + m,"100 " + m,"160 " + m,"250 " + m,"0.4 mm","0.63 mm","1 mm","1.6 mm","2.5 mm","4 mm","6.3 mm"));
        mTolerances.add(new Tolerance(">180-250","20 " + m,"29 " + m,"46 " + m,"72 " + m,"115 " + m,"185 " + m,"290 " + m,"0.46 mm","0.72 mm","1.15 mm","1.85 mm","2.9 mm","4.6 mm","7.2 mm"));
        mTolerances.add(new Tolerance(">250-315","23 " + m,"32 " + m,"52 " + m,"81 " + m,"130 " + m,"210 " + m,"320 " + m,"0.52 mm","0.81 mm","1.3 mm","2.1 mm","3.2 mm","5.2 mm","8.1 mm"));
        mTolerances.add(new Tolerance(">315-400","25 " + m,"36 " + m,"57 " + m,"89 " + m,"140 " + m,"230 " + m,"360 " + m,"0.57 mm","0.89 mm","1.4 mm","2.3 mm","3.6 mm","5.7 mm","8.9 mm"));
        mTolerances.add(new Tolerance(">400-500","27 " + m,"40 " + m,"63 " + m,"97 " + m,"155 " + m,"250 " + m,"400 " + m,"0.63 mm","0.97 mm","1.55 mm","2.5 mm","4 mm","6.3 mm","9.7 mm"));
        mTolerances.add(new Tolerance(">500-630","32 " + m,"44 " + m,"70 " + m,"110 " + m,"175 " + m,"280 " + m,"440 " + m,"0.7 mm","1.1 mm","1.75 mm","2.8 mm","4.4 mm","7 mm","11 mm"));
        mTolerances.add(new Tolerance(">630-800","36 " + m,"50 " + m,"80 " + m,"125 " + m,"200 " + m,"320 " + m,"500 " + m,"0.8 mm","1.25 mm","2 mm","3.2 mm","5 mm","8 mm","12.5 mm"));
        mTolerances.add(new Tolerance(">800-1000","40 " + m,"56 " + m,"90 " + m,"140 " + m,"230 " + m,"360 " + m,"560 " + m,"0.9 mm","1.4 mm","2.3 mm","3.6 mm","5.6 mm","9 mm","14 mm"));
        mTolerances.add(new Tolerance(">1000-1250","47 " + m,"66 " + m,"105 " + m,"165 " + m,"260 " + m,"420 " + m,"660 " + m,"1.05 mm","1.65 mm","2.6 mm","4.2 mm","6.6 mm","10.5 mm","16.5 mm"));
        mTolerances.add(new Tolerance(">1250-1600","55 " + m,"78 " + m,"125 " + m,"195 " + m,"310 " + m,"500 " + m,"780 " + m,"1.25 mm","1.95 mm","3.1 mm","5 mm","7.8 mm","12.5 mm","19.5 mm"));
        mTolerances.add(new Tolerance(">1600-2000","65 " + m,"92 " + m,"150 " + m,"230 " + m,"370 " + m,"600 " + m,"920 " + m,"1.5 mm","2.3 mm","3.7 mm","6 mm","9.2 mm","15 mm","23 mm"));
        mTolerances.add(new Tolerance(">2000-2500","78 " + m,"110 " + m,"175 " + m,"280 " + m,"440 " + m,"700 " + m,"1100 " + m,"1.75 mm","2.8 mm","4.4 mm","7 mm","11 mm","17.5 mm","28 mm"));
        mTolerances.add(new Tolerance(">2500-3150","96 " + m,"135 " + m,"210 " + m,"330 " + m,"540 " + m,"860 " + m,"1350 " + m,"2.1 mm","3.3 mm","5.4 mm","8.6 mm","13.5 mm","21 mm","33 mm"));
    }

    public static ToleranceLab getToleranceLab(Context context) {
        if (sToleranceLab == null)
            sToleranceLab = new ToleranceLab(context.getApplicationContext());

        return sToleranceLab;
    }

    public List<Tolerance> getTolerances() {
        return mTolerances;
    }
}
