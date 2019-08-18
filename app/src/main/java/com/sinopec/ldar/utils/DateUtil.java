package com.sinopec.ldar.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String timeStamp2Date(long time, String format) {
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(time));
    }
}
