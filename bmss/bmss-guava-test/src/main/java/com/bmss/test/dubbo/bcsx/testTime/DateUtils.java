package com.bmss.test.dubbo.bcsx.testTime;

import com.google.common.base.Strings;
import org.joda.time.format.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
    public static final long oneDay = 24 * 60 * 60 * 1000;
    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMddHHmmss = "yyyy/MM/dd HH:mm:ss";

    // date 与 string之间的互相转化
    public static String timeMillisToStr(long timeMillis) {
        String result = null;
        Date date = new Date(timeMillis);
        SimpleDateFormat formatter = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
        try {
            result = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static long strTotimeMills(String date) {
        Date objDate = null;
        long dateMillis = 0;
        SimpleDateFormat formatter = new SimpleDateFormat(yyyy_MM_dd);
        try {
            objDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateMillis = objDate.getTime();
        return dateMillis;
    }


    public static long strTotimeMillsByformatStyle(String date, String formatStyle) {
        Date objDate = null;
        long dateMillis = 0;
        SimpleDateFormat formatter = new SimpleDateFormat(formatStyle);
        try {
            objDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateMillis = objDate.getTime();
        return dateMillis;
    }

    /**
     * @return 当前时间
     */
    public static Date getNowDate() {

        int offsetDays = 0;
        int offsetMinutes = 0;
        if (offsetDays == 0 && offsetMinutes == 0) {
            return new Date();
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + offsetDays);
            calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + offsetMinutes);
            return calendar.getTime();
        }


    }

    /**
     * @return 年月日
     */
    public static Date getNowDay() {
        Calendar calo = Calendar.getInstance();
        calo.setTime(DateUtils.getNowDate());
        calo.set(Calendar.HOUR_OF_DAY, 0);
        calo.set(Calendar.MINUTE, 0);
        calo.set(Calendar.SECOND, 0);
        calo.set(Calendar.MILLISECOND, 0);
        return calo.getTime();
    }

    public static long getNowDayTime() {
        return getNowDay().getTime();
    }


    public static long sevenDaysBefore(long time) {
        long sevenDaysBefore = time - 7 * oneDay;
        return sevenDaysBefore;
    }


    public static long getTimeMillis(int timeChoice) {
        Long timeMillis = 0L;
        Date date;
        Calendar calendar = Calendar.getInstance();
        switch (timeChoice) {
            case 0:
                /**全部数据是从2014后开始的**/
                calendar.set(Calendar.YEAR, 2014);
                break;
            case 1:
                /**最近一周**/
                calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) - 1);
                break;
            case 2:
                /**最近一个月**/
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
                break;
            case 3:
                /**最近三个月**/
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 3);
                break;
            case 4:
                /**最近六个月**/
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 6);
                break;
            case 5:
                /**最近一年**/
                calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
                break;
            default:
                calendar.set(Calendar.YEAR, 2014);
                break;
        }
        timeMillis = calendar.getTime().getTime();
        return timeMillis;
    }

    public static long getweekagoTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) - 1);
        return calendar.getTime().getTime();
    }

    public static long dateStingToLong(String time) {
        long timemills = 0;
        if (!Strings.isNullOrEmpty(time)) {
            timemills = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime(time).getMillis();
        }
        return timemills;
    }

    public static long dateShortStingToLong(String time) {
        long timemills = 0;
        if (!Strings.isNullOrEmpty(time)) {
            timemills = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(time).getMillis();
        }
        return timemills;
    }


    public static void main(String[] args) {
        long time = dateStingToLong("2016-09-10 12:00:00");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date(time)));
        System.out.println(time);
    }

}
