package com.segama.ege.admin.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static String HH_MM = "HH:mm";
    public static String YYYY_MM_DD = "yyyy-MM-dd";
    public static String ZERO_TIME_STR = " 00:00:00";

    public static String parse(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return format.format(date);
    }

    public static Date getDate(String dateStr, String pattern) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            Date date = format.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String parseToYYYYMMDD(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD);
        return format.format(date);
    }

    public static Date getDateByStr(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            Date date = format.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getNowDateStr() {
        return parse(new Date());
    }

    public static String getYYYYMMDDStrOfToday() {
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD);
        return format.format(new Date());
    }

    //当前时间加minutes分钟
    public static Date plusMinutes(Date date, int minutes) {
        java.util.Date afterDate = new java.util.Date(date.getTime() + minutes * 60 * 1000);
        return afterDate;
    }

    /**
     *       * 指定日期加上天数后的日期
     *       * @param num 为增加的天数
     *       * @param newDate 创建时间
     *       * @return
     *       * @throws ParseException
     */
    public static String plusDay(long num, String newDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
            Date currentDate = format.parse(newDate);
            Long aSeconds = currentDate.getTime();
            Long seconds = num * 24 * 60 * 60 * 1000;
            aSeconds = aSeconds + seconds;
            Date bb = new Date(aSeconds); //将毫秒数转换成日期
            String endDateStr = parse(bb);
            return endDateStr;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
    /**
     *       * 指定日期加上天数后的日期
     *       * @param num 为增加的天数
     *       * @param newDate 创建时间
     *       * @return
     *       * @throws ParseException
     */
    public static String minusDay(long num, String newDate) {
        long new_num = -1 * num;
        if(new_num > 0){
            new_num = -1 * new_num;
        }
        return plusDay(new_num, newDate);
    }

    public static void main(String[] args) {
        //Date now = new Date();
        //System.out.println(DateUtil.parse(now));
        //System.out.println(DateUtil.parse(plusMinutes(now, 5)));

        String currDateStr = DateUtil.getYYYYMMDDStrOfToday() + DateUtil.ZERO_TIME_STR;
        int days = 30;
        System.out.println(currDateStr);
        String effectiveDateStr = DateUtil.plusDay(days, currDateStr);
        String expireDateStr = DateUtil.plusDay(1, effectiveDateStr);
        System.out.println("effectiveDateStr=" + effectiveDateStr);
        System.out.println("expireDateStr=" + expireDateStr);

        String effectiveDateStr2 = DateUtil.minusDay(days, currDateStr);
        System.out.println("effectiveDateStr2=" + effectiveDateStr2);

        List<Long> order_ids = new ArrayList<Long>();
        order_ids.add(1L);
        //order_ids.add(8L);
        //order_ids.add(3L);
        if(order_ids.size() > 0){
            String order_id = String.valueOf(order_ids.get(0));
            int m = 1;
            for (; m < order_ids.size(); ++m){
                order_id = order_id + "|" + order_ids.get(m);
            }
            System.out.println(order_id);
        }
    }
}
