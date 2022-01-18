package com.andy.camunda.utils;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 日期时间处理工具，转换工具
 * 1. 涉及到时区时，本工具默认使用东八区或者系统缺省值
 */
public class DateTimeUtils {

    public static Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) return null;

        ZoneId zoneId = ZoneId.systemDefault();
        Date date = Date.from(localDateTime.atZone(zoneId).toInstant());
        return date;
    }

    public static Date toDate(LocalDate localDate) {
        if (localDate == null) return null;

        ZoneId zoneId = ZoneId.systemDefault();
        return Date.from(localDate.atStartOfDay().atZone(zoneId).toInstant());
    }

    public static LocalDate toLocalDate(String str) {
        return toLocalDate(toLocalDateTime(str));
    }

    /**
     * 返回字符串格式的日期 : yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String toStringDate(LocalDate date) {
        if (date == null) return "";

        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    /**
     * 返回字符串格式的日期时间 yyyy-MM-dd HH:mm:ss
     *
     * @param datetime
     * @return
     */
    public static String toStringDateTime(LocalDateTime datetime) {
        if (datetime == null) return "";

        return datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 使用模式 pattern 输出字符串格式的日期
     *
     * @param datetime
     * @param pattern
     * @return
     */
    public static String toString(LocalDateTime datetime, String pattern) {
        if (datetime == null) return "";

        return datetime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 返回当前时间的某个字符串形式
     *
     * @param pattern
     * @return
     */
    public static String now(String pattern) {
        LocalDateTime datetime = LocalDateTime.now();
        return datetime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 返回字符串格式的日期时间 yyyy-MM-dd
     *
     * @param datetime
     * @return
     */
    public static String toStringDate(LocalDateTime datetime) {
        if (datetime == null) return "";

        return datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static LocalDate toLocalDate(LocalDateTime dt) {
        if (dt == null) return null;
        return LocalDate.of(dt.getYear(), dt.getMonth(), dt.getDayOfMonth());
    }

    public static long toSeconds(LocalDateTime dt) {
        return toMilliseconds(dt) / 1000;
    }

    public static long toSeconds(LocalDate dt) {
        return toMilliseconds(dt) / 1000;
    }

    public static long toMilliseconds(LocalDateTime dt) {
        if (dt == null) return 0l;
        long milli = dt.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return milli;
    }

    public static long toMilliseconds(LocalDate dt) {
        if (dt == null) return 0l;
        long milli = dt.atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return milli;
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) return null;

        ZoneId zoneId = ZoneId.systemDefault();
        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }

    public static LocalDate toLocalDate(Date date) {
        if (date == null) return null;


        ZoneId zoneId = ZoneId.systemDefault();
        return date.toInstant().atZone(zoneId).toLocalDate();
    }


    public static LocalDateTime toLocalDateTime(String str) {
        try {
            LocalDateTime dt = LocalDateTime.parse(str);
            return dt;
        } catch (Exception e) {
        }

        String[] patterns = new String[]{"yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss.SSS", "yyyy-MM-dd HH:mm:ss.SS", "yyyy-MM-dd HH:mm:ss.S", "yyyy-MM-dd"};

        for (int i = 0; i < patterns.length; i++) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern(patterns[i]);
            try {
                LocalDateTime dt = LocalDateTime.parse(str, fmt);
                if (dt != null) return dt;
            } catch (Exception e) {
                ;// 继续尝试下一个
            }
        }

        return null;
    }

    /**
     * 转换为格式为 Wed, 23 Jan 2013 06:43:08 GMT 的日期字符串
     *
     * @param date
     * @return
     */
    public static String getGMTDateString(Date date) {
        if (date == null) return "";

        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    /**
     * 将秒转换成 LocalDateTime, 东八区
     *
     * @param seconds
     * @return
     */
    public static LocalDateTime ofEpochSecond(long seconds) {
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.of("+8"));
        return dateTime;
    }

    /**
     * 转换为格式为 Wed, 23 Jan 2013 06:43:08 GMT 的日期字符串
     *
     * @param localDateTime
     * @return
     */
    public static String getGMTDateString(LocalDateTime localDateTime) {
        return getGMTDateString(toDate(localDateTime));
    }
}
