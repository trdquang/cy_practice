package myproject.util;

public class FunctionUtil {
    public static int defaultStrToInt(String str){
        return (str == null || str.isEmpty())?0:Integer.parseInt(str);
    }
}
