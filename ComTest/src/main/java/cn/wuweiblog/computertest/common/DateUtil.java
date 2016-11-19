package cn.wuweiblog.computertest.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jervain on 2016-11-17.
 */
public class DateUtil {

    public static String parseDate(Date date) {
        if (date == null)   date = new Date();
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date parseString(String str) {
        if (str == null)    return new Date();
        String format = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

}
