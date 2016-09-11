package com.example.kamil.machininghelper.Utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by Kamil Safin on 9/11/2016.
 */
public class Utils {

    public static String fmt3(BigDecimal decimal){
        return new DecimalFormat("#.###").format(decimal).replace(",",".");
    }

    public static String fmt4(BigDecimal decimal){
        return new DecimalFormat("#.####").format(decimal).replace(",",".");
    }
}
