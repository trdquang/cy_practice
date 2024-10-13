package org.example.cafeweb.util;

public class FunctionUtil {
    public static String defaultIfNull(String str){
        return str!=null?str:"";
    }

    public static Integer defaultIfNull(Integer num){
        return num!=null?num:0;
    }

    public static Double defaultIfNull(Double num){
        return num!=null?num:0.0;
    }
}
