package com.example.kamil.machininghelper.Model;

import android.content.Context;

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

        mTolerances.add(new Tolerance("<=3","4 μm","6 μm","10 μm","14 μm","25 μm","40 μm","60 μm","0.1 mm","0.14 mm","0.25 mm","0.4 mm","0.6 mm","1 mm","1.4 mm"));
        mTolerances.add(new Tolerance(">3-6","5 μm","8 μm","12 μm","18 μm","30 μm","48 μm","75 μm","0.12 mm","0.18 mm","0.3 mm","0.48 mm","0.75 mm","1.2 mm","1.8 mm"));
        mTolerances.add(new Tolerance(">6-10","6 μm","9 μm","15 μm","22 μm","36 μm","58 μm","90 μm","0.15 mm","0.22 mm","0.36 mm","0.58 mm","0.9 mm","1.5 mm","2.2 mm"));
        mTolerances.add(new Tolerance(">10-18","8 μm","11 μm","18 μm","27 μm","43 μm","70 μm","110 μm","0.18 mm","0.27 mm","0.43 mm","0.7 mm","1.1 mm","1.8 mm","2.7 mm"));
        mTolerances.add(new Tolerance(">18-30","9 μm","13 μm","21 μm","33 μm","52 μm","84 μm","130 μm","0.21 mm","0.33 mm","0.52 mm","0.84 mm","1.3 mm","2.1 mm","3.3 mm"));
        mTolerances.add(new Tolerance(">30-50","11 μm","16 μm","25 μm","39 μm","62 μm","100 μm","160 μm","0.25 mm","0.39 mm","0.62 mm","1 mm","1.6 mm","2.5 mm","3.9 mm"));
        mTolerances.add(new Tolerance(">50-80","13 μm","19 μm","30 μm","46 μm","74 μm","120 μm","190 μm","0.3 mm","0.46 mm","0.74 mm","1.2 mm","1.9 mm","3 mm","4.6 mm"));
        mTolerances.add(new Tolerance(">80-120","15 μm","22 μm","35 μm","54 μm","87 μm","140 μm","220 μm","0.35 mm","0.54 mm","0.87 mm","1.4 mm","2.2 mm","3.5 mm","5.4 mm"));
        mTolerances.add(new Tolerance(">120-180","18 μm","25 μm","40 μm","63 μm","100 μm","160 μm","250 μm","0.4 mm","0.63 mm","1 mm","1.6 mm","2.5 mm","4 mm","6.3 mm"));
        mTolerances.add(new Tolerance(">180-250","20 μm","29 μm","46 μm","72 μm","115 μm","185 μm","290 μm","0.46 mm","0.72 mm","1.15 mm","1.85 mm","2.9 mm","4.6 mm","7.2 mm"));
        mTolerances.add(new Tolerance(">250-315","23 μm","32 μm","52 μm","81 μm","130 μm","210 μm","320 μm","0.52 mm","0.81 mm","1.3 mm","2.1 mm","3.2 mm","5.2 mm","8.1 mm"));
        mTolerances.add(new Tolerance(">315-400","25 μm","36 μm","57 μm","89 μm","140 μm","230 μm","360 μm","0.57 mm","0.89 mm","1.4 mm","2.3 mm","3.6 mm","5.7 mm","8.9 mm"));
        mTolerances.add(new Tolerance(">400-500","27 μm","40 μm","63 μm","97 μm","155 μm","250 μm","400 μm","0.63 mm","0.97 mm","1.55 mm","2.5 mm","4 mm","6.3 mm","9.7 mm"));
        mTolerances.add(new Tolerance(">500-630","32 μm","44 μm","70 μm","110 μm","175 μm","280 μm","440 μm","0.7 mm","1.1 mm","1.75 mm","2.8 mm","4.4 mm","7 mm","11 mm"));
        mTolerances.add(new Tolerance(">630-800","36 μm","50 μm","80 μm","125 μm","200 μm","320 μm","500 μm","0.8 mm","1.25 mm","2 mm","3.2 mm","5 mm","8 mm","12.5 mm"));
        mTolerances.add(new Tolerance(">800-1000","40 μm","56 μm","90 μm","140 μm","230 μm","360 μm","560 μm","0.9 mm","1.4 mm","2.3 mm","3.6 mm","5.6 mm","9 mm","14 mm"));
        mTolerances.add(new Tolerance(">1000-1250","47 μm","66 μm","105 μm","165 μm","260 μm","420 μm","660 μm","1.05 mm","1.65 mm","2.6 mm","4.2 mm","6.6 mm","10.5 mm","16.5 mm"));
        mTolerances.add(new Tolerance(">1250-1600","55 μm","78 μm","125 μm","195 μm","310 μm","500 μm","780 μm","1.25 mm","1.95 mm","3.1 mm","5 mm","7.8 mm","12.5 mm","19.5 mm"));
        mTolerances.add(new Tolerance(">1600-2000","65 μm","92 μm","150 μm","230 μm","370 μm","600 μm","920 μm","1.5 mm","2.3 mm","3.7 mm","6 mm","9.2 mm","15 mm","23 mm"));
        mTolerances.add(new Tolerance(">2000-2500","78 μm","110 μm","175 μm","280 μm","440 μm","700 μm","1100 μm","1.75 mm","2.8 mm","4.4 mm","7 mm","11 mm","17.5 mm","28 mm"));
        mTolerances.add(new Tolerance(">2500-3150","96 μm","135 μm","210 μm","330 μm","540 μm","860 μm","1350 μm","2.1 mm","3.3 mm","5.4 mm","8.6 mm","13.5 mm","21 mm","33 mm"));
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
