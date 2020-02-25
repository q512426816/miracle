package com.crrcdt.pbd.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public final class DateUtils {
    private DateUtils() {
    }

    /**
     * 默认 日期格式化
     */
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 获取指定格式的日期字符
     * @param date
     * @param format
     * @return 指定格式的日期字符
     */
    public static String getDateStr(Date date, String format) {
        if (date == null || format == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取 日期yyyy-MM-dd HH:mm:ss的字符
     * @param date
     * @return yyyy-MM-dd HH:mm:ss的字符
     */
    public static String getDateStr(Date date) {
        return getDateStr(date, DEFAULT_FORMAT);
    }

    /**
     * 获取日期yyyy-MM-dd的字符
     * @param date
     * @return yyyy-MM-dd的字符
     */
    public static String getDateStrDate(Date date) {
        return getDateStr(date, DATE_FORMAT);
    }

    /**
     * 比较两个日期是否一样
     *
     * @param date0
     * @param date1
     * @return 是否相同
     */
    public static boolean isSameDate(Date date0, Date date1) {
        return Objects.equals(getDateStrDate(date0), getDateStrDate(date1));
    }

    /**
     * 比较两个日期及时间（精确到秒）是否一样
     *
     * @param date0
     * @param date1
     * @return 是否相同
     */
    public static boolean isSameDateTime(Date date0, Date date1) {
        return Objects.equals(getDateStr(date0), getDateStr(date1));
    }

}
