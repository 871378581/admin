package com.segama.ege.util;
import org.slf4j.Logger;

import java.math.BigDecimal;

import static org.slf4j.LoggerFactory.getLogger;

public class DistanceComputeUtil {

    private static final Logger log = getLogger(DistanceComputeUtil.class);
    private static double EARTH_RADIUS = 6371.0;//6378.137
    /// <summary>
    /// 给定的纬度1，经度1；纬度2，经度2. 计算2个经纬度之间的距离。
    /// </summary>
    /// <param name="lat1">纬度1</param>
    /// <param name="lon1">经度1</param>
    /// <param name="lat2">纬度2</param>
    /// <param name="lon2">经度2</param>
    /// <returns>距离（公里、千米）</returns>
    public static double getDistance(double latitude1, double longitude1,
                                     double latitude2, double longitude2 ){
        double La1 = rad(latitude1);
        double La2 = rad(latitude2);
        double La3 = La1 - La2;
        double Lb3 = rad(longitude1) - rad(longitude2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(La3 / 2), 2) + Math.cos(La1) * Math.cos(La2) * Math.pow(Math.sin(Lb3 / 2), 2)));

        s = s * EARTH_RADIUS;//地球半径
        s = Math.round(s * 10000d) / 10d;//单位：米
        /*log.info("纬度1=" + latitude1 + ", 经度1=" + longitude1
                + "；纬度2=" + latitude2 + ", 经度2=" + longitude2 +"; 距离=" + s + "米");*/
        return s;
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static void main(String[] args) {
        double distance = getDistance(30.3454, 120.093224,
                30.29724, 120.343759);
        double tempD = 4.7133;
        BigDecimal b = new BigDecimal(tempD);
        double scoreD = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(String.valueOf(scoreD));
    }
}
