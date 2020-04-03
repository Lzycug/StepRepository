
package com.lzycug.personnel.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-04-03
 */
public class Util {
    private Util() {
    }

    public static Date parse(String date, String type) {
        DateFormat dateFormat = new SimpleDateFormat(type);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
