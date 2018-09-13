package com.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ms
 * @Description: class description
 * @Package com.base.utils
 * @date: Created in 2018/9/10  13:45
 */
public class DateUtils {

    public static String time2Date(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = sdf.parse(sdf.format(time));
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
