package com.example.kamil.machininghelper.Model;

import android.content.Context;

import com.example.kamil.machininghelper.R;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil Safin on 8/22/2016.
 */
public class GCodeLab {

    private static GCodeLab sGCode;
    private Context mContext;
    private List<GCode> mGCodes;

    private GCodeLab(Context context) {
        mContext = context;
        String[] functions = mContext.getResources().getStringArray(R.array.g_codes);

        Thread thread = new Thread(() -> {
            mGCodes = new ArrayList<>();
            mGCodes.add(new GCode("G0", functions[0], "X,Y,Z", "G1"));
            mGCodes.add(new GCode("G1", functions[1], "X,Y,Z,R,C", "G0"));
            mGCodes.add(new GCode("G2", functions[2], "X,Y,Z,F,R,I,J,K", "G3"));
            mGCodes.add(new GCode("G3", functions[3], "X,Y,Z,F,R,I,J,K", "G2"));
            mGCodes.add(new GCode("G12", functions[4], "I,K,Q,F,Z,L,D", "G13"));
            mGCodes.add(new GCode("G13", functions[5], "I,K,Q,F,Z,L,D", "G12"));
            mGCodes.add(new GCode("G17..19", functions[6], "brak", "brak"));
            mGCodes.add(new GCode("G20", functions[7], "brak", "G21"));
            mGCodes.add(new GCode("G21", functions[8], "brak", "G20"));
            mGCodes.add(new GCode("G40", functions[9], "brak", "G41,G42"));
            mGCodes.add(new GCode("G41", functions[10], "brak", "G40,G42"));
            mGCodes.add(new GCode("G42", functions[11], "brak", "G40,G41"));
            mGCodes.add(new GCode("G43", functions[12], "H", "brak"));
            mGCodes.add(new GCode("G54..59", functions[13], "brak", "brak"));
            mGCodes.add(new GCode("G70", functions[14], "I,J,L", "G71,G72"));
            mGCodes.add(new GCode("G71", functions[15], "I,J,K,L", "G70,G72"));
            mGCodes.add(new GCode("G72", functions[16], "I,J,L", "G70,G71"));
            mGCodes.add(new GCode("G81", functions[17], "X,Y,Z,F,L,R", "G82,G83"));
            mGCodes.add(new GCode("G82", functions[18], "X,Y,ZF,L,R,P", "G81,G83"));
            mGCodes.add(new GCode("G83", functions[19], "X,Y,Z,F,L,R,P,Q,I,J,K", "G81,G82"));
            mGCodes.add(new GCode("G84", functions[20], "X,Y,Z,F,L,R,J", "G81,G83"));
            mGCodes.add(new GCode("G90", functions[21], "brak", "G91"));
            mGCodes.add(new GCode("G91", functions[22], "brak", "G90"));
            mGCodes.add(new GCode("G98", functions[23], "brak", "G99"));
            mGCodes.add(new GCode("G99", functions[24], "brak", "G98"));
            mGCodes.add(new GCode("G150", functions[25], "X,Y,Z,F,R,I,J,K,D,P,Q", "G12,G13"));
            mGCodes.add(new GCode("M0", functions[26], "brak", "brak"));
            mGCodes.add(new GCode("M3", functions[27], "brak", "M4,M5"));
            mGCodes.add(new GCode("M4", functions[28], "brak", "M3,M5"));
            mGCodes.add(new GCode("M5", functions[29], "brak", "M3,M4"));
            mGCodes.add(new GCode("M6", functions[30], "T", "brak"));
            mGCodes.add(new GCode("M8", functions[31], "brak", "M9,M88,M89"));
            mGCodes.add(new GCode("M9", functions[32], "brak", "M8,M88,M89"));
            mGCodes.add(new GCode("M88", functions[33], "brak", "M8,M9,M89"));
            mGCodes.add(new GCode("M89", functions[34], "brak", "M8,M9,M88"));
            mGCodes.add(new GCode("M30", functions[35], "brak", "M0"));
            mGCodes.add(new GCode("M31", functions[36], "brak", "M33"));
            mGCodes.add(new GCode("M33", functions[37], "brak", "M31"));
            mGCodes.add(new GCode("M97", functions[38], "brak", "M98,M99"));
            mGCodes.add(new GCode("M98", functions[39], "brak", "M97,M99"));
            mGCodes.add(new GCode("M99", functions[40], "brak", "M97,M98"));
        });

        thread.run();
    }

    public static GCodeLab getGCodeLab(Context context) {
        if (sGCode == null)
            sGCode = new GCodeLab(context.getApplicationContext());

        return sGCode;
    }

    public List<GCode> getGCodes() {
        return mGCodes;
    }
}
