package org.example.cafeweb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FunctionUtil {
    public static String defaultIfNull(String str) {
        return str != null ? str : "";
    }

    public static Integer defaultIfNull(Integer num) {
        return num != null ? num : 0;
    }

    public static Double defaultIfNull(Double num) {
        return num != null ? num : 0.0;
    }

    public static String nowDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        return simpleDateFormat.format(new Date());
    }
}
