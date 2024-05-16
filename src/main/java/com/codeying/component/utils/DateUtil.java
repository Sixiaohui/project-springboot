package com.codeying.component.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 字符串转日期
     */
    public static Date strToDate(String str) {
        if (str == null) {
            return null;
        }
        str = str.replace("T"," ");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = format.parse(str);
            return date;
        } catch (Exception e) {
        }
        format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        try {
            date = format.parse(str);
            return date;
        } catch (Exception e) {
        }
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            date = format.parse(str);
            return date;
        } catch (Exception e) {
        }

        format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(str);
            return date;
        } catch (Exception e) {
        }

        return null;
    }


    /**
     * 字符串转日期
     */
    public static String dateToStr(Date date) {
        return dateToStr(date,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 字符串转日期
     */
    public static String dateToStr(Date date,String formatStr) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }

    public static String day0Str(){
        return dateToStr(new Date(),"yyyy-MM-dd");
    }
    public static String month0Str(){
        return dateToStr(new Date(),"yyyy-MM");
    }
    public static String year0Str(){
        return dateToStr(new Date(),"yyyy");
    }

    public static Date day0(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        return calendar.getTime();
    }
    public static Date month0(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day0());
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return calendar.getTime();
    }
    public static Date year0(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(month0());
        calendar.set(Calendar.MONTH,0);
        return calendar.getTime();
    }

}

