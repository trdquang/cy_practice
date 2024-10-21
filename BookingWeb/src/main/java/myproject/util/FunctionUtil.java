package myproject.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FunctionUtil {
    public static int defaultStrToInt(String str) {
        return (str == null || str.isEmpty()) ? 0 : Integer.parseInt(str);
    }

    public static double defaultStrToDouble(String str) {
        return (str == null || str.isEmpty()) ? 0 : Double.parseDouble(str);
    }

    public static String deafultStr(String str){
        return str == null ? "" : str;
    }

    public static String nowDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        return simpleDateFormat.format(new Date());
    }

    public static Date parseStringToDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            if (dateString == null || dateString.isEmpty())
                return simpleDateFormat.parse("1/1/1999 00:00:01");
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String parseDateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static Date parseSearchDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (dateString == null || dateString.isEmpty())
                return simpleDateFormat.parse("1/1/1999 00:00:01");
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parseDetailStringToDate(String dateStr){
        try {
            // Chuỗi ngày cần parse
//            String dateStr = "Tue Oct 22 00:00:00 ICT 2024";

            // Định dạng ngày cần sử dụng
            String dateFormat = "EEE MMM dd HH:mm:ss z yyyy";

            // Khởi tạo SimpleDateFormat với định dạng đúng
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

            // Parse chuỗi ngày thành đối tượng Date
            Date parsedDate = sdf.parse(dateStr);
            return parsedDate;

            // In kết quả
//            System.out.println("Parsed Date: " + parsedDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
