package com.suripro.lib;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtilities {

    public static final String DEFAULT_YMD_FORMAT = "yyyy-MM-dd";
    public static final String SHORT = "EEE";
    public static final String FULL = "EEEE";
    //for date differ
    public static final int DIFFER_SECOND = 0;
    public static final int DIFFER_MINUTES = 1;
    public static final int DIFFER_HOURS = 2;
    public static final int DIFFER_DAYS = 3;
    public static final int DIFFER_MILLIS = 4;
    private static final String TAG = "DateUtilities";
    private static DateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_YMD_FORMAT, Locale.US);
    public static final String TODAY = simpleDateFormat.format(new Date());

    //default method to initialize date format
    private static void setSimpleDateFormat(String format) {
        DateUtilities.simpleDateFormat = new SimpleDateFormat(format, Locale.US);
    }
    //----------------------------------------

    public static String getCurrentDate() {
        return simpleDateFormat.format(new Date());
    }

    public static String getCurrentDateTime(String returnFormat) {
        setSimpleDateFormat(returnFormat);
        return simpleDateFormat.format(new Date());
    }

    public static String getTodayName(String nameFormat) {
        setSimpleDateFormat(nameFormat);
        return simpleDateFormat.format(new Date());
    }

    public static String ChangeDateFormat(String date, String dateFormat, String returnFormat) {

        try {
            setSimpleDateFormat(dateFormat);
            Date date1 = simpleDateFormat.parse(date);
            setSimpleDateFormat(returnFormat);
            return simpleDateFormat.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String dateToString(Date date, String returnFormat) {
        setSimpleDateFormat(returnFormat);
        return simpleDateFormat.format(date);
    }

    public static Date stringToDate(String date, String dateFormat) {
        try {
            setSimpleDateFormat(dateFormat);
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    //it return user specific date format
    public static String getDateWithDifference(String dateFrom, int diffDays, String dateFormat, String returnFormat) {

        try {
            setSimpleDateFormat(dateFormat);
            Date date = simpleDateFormat.parse(dateFrom);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, diffDays);

            setSimpleDateFormat(returnFormat);
            return simpleDateFormat.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }


    //it return same date format
    public static String getDateWithDifference(String dateFrom, int diffDays, String dateFormat) {

        try {
            setSimpleDateFormat(dateFormat);
            Date date = simpleDateFormat.parse(dateFrom);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, diffDays);

            return simpleDateFormat.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static long dateDiff(String fromDate, String fromDateFormat, String toDate, String toDateFormat, int returnType) {

        try {
            setSimpleDateFormat(fromDateFormat);
            Date fdate = simpleDateFormat.parse(fromDate);
            setSimpleDateFormat(toDateFormat);
            Date tdate = simpleDateFormat.parse(toDate);

            long diffInMillis = Math.abs(tdate.getTime() - fdate.getTime());

            return getLong(diffInMillis, returnType);

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public static long dateDiff(String fromDate, String toDate, String dateFormat, int returnType) {

        try {
            setSimpleDateFormat(dateFormat);
            Date fdate = simpleDateFormat.parse(fromDate);
            Date tdate = simpleDateFormat.parse(toDate);

            long diffInMillis = Math.abs(tdate.getTime() - fdate.getTime());

            return getLong(diffInMillis, returnType);


        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static long getLong(long diffInMillis, int type) {
        switch (type) {
            case DIFFER_SECOND:
                return Math.abs(TimeUnit.SECONDS.convert(diffInMillis, TimeUnit.MILLISECONDS));

            case DIFFER_MINUTES:
                return Math.abs(TimeUnit.MINUTES.convert(diffInMillis, TimeUnit.MILLISECONDS));

            case DIFFER_HOURS:
                return Math.abs(TimeUnit.HOURS.convert(diffInMillis, TimeUnit.MILLISECONDS));

            case DIFFER_DAYS:
                return Math.abs(TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS));

            default:
                return diffInMillis;
        }
    }

    public static long getMillis(String date, String dateFormat) {
        try {
            setSimpleDateFormat(dateFormat);
            return simpleDateFormat.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Date millisToDate(long millis) {
        Date date = new Date();
        date.setTime(millis);
        return date;
    }

    public static String millisToString(long millis, String returnFormat) {
        Date date = millisToDate(millis);
        setSimpleDateFormat(returnFormat);
        return simpleDateFormat.format(date);
    }


}
