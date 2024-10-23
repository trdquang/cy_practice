package util;

public class FunctionUtil {
    public static int convertStrToInt(String str){
        return (str == null || str.isEmpty()) ?0: Integer.parseInt(str);
    }
}
