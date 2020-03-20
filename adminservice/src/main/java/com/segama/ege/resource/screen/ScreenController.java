package com.segama.ege.resource.screen;

import com.segama.ege.dto.BaseResult;
import com.segama.ege.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * hello-world sample
 * https://spring.io/guides
 */
@RestController
@RequestMapping("/ege/api/screen")
public class ScreenController {

    private static boolean open = false;

    public static class Limitation {
        private int visit;
        private int user;
        private int gmv;
        private int deal;

        public Limitation(int visit, int user, int gmv, int deal) {
            this.visit = visit;
            this.user = user;
            this.gmv = gmv;
            this.deal = deal;
        }

        public int getVisit() {
            return visit;
        }

        public void setVisit(int visit) {
            this.visit = visit;
        }

        public int getUser() {
            return user;
        }

        public void setUser(int user) {
            this.user = user;
        }

        public int getGmv() {
            return gmv;
        }

        public void setGmv(int gmv) {
            this.gmv = gmv;
        }

        public int getDeal() {
            return deal;
        }

        public void setDeal(int deal) {
            this.deal = deal;
        }

        public int increaseRandom() {
            Random random = new Random();
            this.visit += random.nextInt(6);
            int randomDeal = random.nextInt(3);
            this.deal += randomDeal;
            this.user += randomDeal;
            if (randomDeal >= 1) {
                this.gmv += random.nextInt(100);
            }
            return randomDeal;
        }
    }

    public static class GeoCode {
        private String province;
        private String lat;
        private String lng;

        public GeoCode(String lng, String lat, String province) {
            this.lat = lat;
            this.lng = lng;
            this.province = province;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }
    }

    public static final Map<Integer, Limitation> limitMap = new HashMap<>();
    public static final Map<Integer, Limitation> provinceRecord = new HashMap<>();
    public static final Map<Integer, GeoCode> geoCodeMap = new HashMap<>();
    public static final Map<String, Integer> byMinute = new HashMap<>();

    static {
        totalReset();

        geoCodeMap.put(1, new GeoCode("120.21201", "30.2084", "浙江省"));
        geoCodeMap.put(2, new GeoCode("113.27324", "23.15792", "广东省"));
        geoCodeMap.put(3, new GeoCode("118.8921", "31.32751", "江苏省"));
        geoCodeMap.put(4, new GeoCode("116.75199", "36.55358", "山东省"));
        geoCodeMap.put(5, new GeoCode("113.6401", "34.72468", "河南省"));
        geoCodeMap.put(6, new GeoCode("104.10194", "30.65984", "四川省"));
        geoCodeMap.put(7, new GeoCode("114.02919", "30.58203", "湖北省"));
        geoCodeMap.put(8, new GeoCode("121.48941", "31.02751", "上海"));
        geoCodeMap.put(9, new GeoCode("112.98626", "28.25591", "湖南省"));
        geoCodeMap.put(10, new GeoCode("114.53952", "38.03647", "河北省"));
    }

    public static void totalReset() {
        resetInitConfig();
        Random random = new Random();
        provinceRecord.put(1, new Limitation(random.nextInt(100), random.nextInt(10), random.nextInt(800), random.nextInt(10)));
        provinceRecord.put(2, new Limitation(random.nextInt(100), random.nextInt(10), random.nextInt(800), random.nextInt(10)));
        provinceRecord.put(3, new Limitation(random.nextInt(100), random.nextInt(10), random.nextInt(800), random.nextInt(10)));
        provinceRecord.put(4, new Limitation(random.nextInt(100), random.nextInt(10), random.nextInt(800), random.nextInt(10)));
        provinceRecord.put(5, new Limitation(random.nextInt(100), random.nextInt(10), random.nextInt(800), random.nextInt(10)));
        provinceRecord.put(6, new Limitation(random.nextInt(100), random.nextInt(10), random.nextInt(800), random.nextInt(10)));
        provinceRecord.put(7, new Limitation(random.nextInt(100), random.nextInt(10), random.nextInt(800), random.nextInt(10)));
        provinceRecord.put(8, new Limitation(random.nextInt(100), random.nextInt(10), random.nextInt(800), random.nextInt(10)));
        provinceRecord.put(9, new Limitation(random.nextInt(100), random.nextInt(10), random.nextInt(800), random.nextInt(10)));
        provinceRecord.put(10, new Limitation(random.nextInt(100), random.nextInt(10), random.nextInt(800), random.nextInt(10)));
    }

    public static void resetInitConfig() {
        limitMap.put(1, new Limitation(378, 58, 39904, 58));
        limitMap.put(2, new Limitation(1880, 328, 225664, 328));
        limitMap.put(3, new Limitation(5888, 984, 676992, 984));
        limitMap.put(4, new Limitation(16888, 2866, 1971808, 2866));
        limitMap.put(5, new Limitation(53485, 6239, 4292432, 6239));
        limitMap.put(6, new Limitation(102354, 9452, 6502976, 9452));
        limitMap.put(7, new Limitation(129876, 11298, 7773024, 11298));
        limitMap.put(8, new Limitation(153948, 13876, 9546688, 13876));
        limitMap.put(9, new Limitation(198765, 15475, 10646800, 15475));
    }

    public static long startSecond = 0;

    @RequestMapping("/start")
    public BaseResult start() {
        resetInitConfig();
        open = true;
        startSecond = System.currentTimeMillis() / 1000;
        return BaseResult.success(open);
    }

    @RequestMapping("/close")
    public BaseResult close() {
        open = false;
        return BaseResult.success(open);
    }

    @RequestMapping("/reset")
    public BaseResult reset() {
        open = false;
        totalReset();
        return BaseResult.success(open);
    }

    public static int randomAbs(int target) {
        Random random = new Random();
        return Math.abs(random.nextInt(target));
    }

    @RequestMapping("/run")
    public BaseResult run() {
        if (open) {

            Integer minutePassed = Math.toIntExact((System.currentTimeMillis() / 1000 - startSecond) / 60);
            if (minutePassed >= 0 && minutePassed <= 10) {
                if (minutePassed == 0) {
                    minutePassed = 1;
                }
                Random random = new Random();
                Limitation limitation = limitMap.get(minutePassed);
                int delta_d = random.nextInt(limitation.getDeal());
                int delta_g = random.nextInt(limitation.getGmv());
                int delta_u = random.nextInt(limitation.getUser());
                int delta_v = random.nextInt(limitation.getVisit());

                if (delta_d > 0) {
                    limitation.setDeal(limitation.getDeal() - delta_d);
                    limitation.setGmv(limitation.getGmv() - delta_g);
                    limitation.setUser(limitation.getUser() - delta_u);
                    limitation.setVisit(limitation.getVisit() - delta_v);

                    CommonUtil.info("ScreenController", "run", new Object[]{"minute=" + minutePassed, "delta_d=" + delta_d,
                            "delta_g=" + delta_g, "delta_u=" + delta_u, "delta_v=" + delta_v}, limitation);

                    int[] randomeDivide_d = randomDivide(delta_d, 10);
                    int[] randomeDivide_g = randomDivide(delta_g, 10);
                    int[] randomeDivide_u = randomDivide(delta_u, 10);
                    int[] randomeDivide_v = randomDivide(delta_v, 10);
                    for (int i = 1; i <= 10; i++) {
                        Limitation limitation1 = provinceRecord.get(i);
                        int actualDeltaDeal = randomeDivide_d[i - 1];
                        limitation1.setDeal(limitation1.getDeal() + actualDeltaDeal);
                        if (actualDeltaDeal > 0) {
                            limitation1.setGmv(limitation1.getGmv() + randomeDivide_g[i - 1]);
                        }
                        limitation1.setUser(limitation1.getUser() + randomeDivide_u[i - 1]);
                        limitation1.setVisit(limitation1.getVisit() + randomeDivide_v[i - 1]);
                    }

                    String currentMinuteKey = currentMinuteKey();
                    if (!byMinute.containsKey(currentMinuteKey)) {
                        byMinute.put(currentMinuteKey, 0);
                        removeLastKeyIfOverSize(byMinute);
                    }


                    delta_d = byMinute.get(currentMinuteKey) + delta_d;
                    byMinute.put(currentMinuteKey, delta_d);

                    return BaseResult.success("minute=" + minutePassed);
                }
            }
        }

        int total = 0;
        for (int i = 1; i <= 10; i++) {
            Limitation limitation = provinceRecord.get(i);
            total += limitation.increaseRandom();
        }

        String currentMinuteKey = currentMinuteKey();
        if (!byMinute.containsKey(currentMinuteKey)) {
            byMinute.put(currentMinuteKey, 0);
            removeLastKeyIfOverSize(byMinute);
        }

        total = byMinute.get(currentMinuteKey) + total;
        byMinute.put(currentMinuteKey, total);


        return BaseResult.success(open);
    }

    private void removeLastKeyIfOverSize(Map<String, Integer> byMinute) {
        if (byMinute.size() < 25) {
            return;
        }
        String min = null;
        for (String key : byMinute.keySet()) {
            if (min == null) {
                min = key;
            } else if (min.compareTo(key) > 0) {
                min = key;
            }
        }
        if (StringUtils.isBlank(min)) {
            byMinute.remove(min);
        }
    }

    public static String currentMinuteKey() {
        return String.format("%02d:%02d", new Date().getHours(), new Date().getMinutes());
    }

    private static int[] randomDivide(int delta_d, int cnt) {
        int[] ints = new int[cnt];
        Random random = new Random();
        while (delta_d > 0) {
            int index = Math.abs(random.nextInt(delta_d));
            ints[index % cnt]++;
            delta_d--;
        }
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(currentMinuteKey());
//        int[] ints = randomDivide(100, 10);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
    }

    @RequestMapping("/gmv")
    public List<Map<String, Object>> gmv() {
        ArrayList<Map<String, Object>> toReturn = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        long totalGmv = 0;
        for (Limitation limitation : provinceRecord.values()) {
            totalGmv += limitation.getGmv();
        }
        map.put("value", totalGmv);
        toReturn.add(map);
        return toReturn;
    }

    @RequestMapping("/visit")
    public List<Map<String, Object>> visit() {
        ArrayList<Map<String, Object>> toReturn = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        long total = 0;
        for (Limitation limitation : provinceRecord.values()) {
            total += limitation.getVisit();
        }
        map.put("value", total);
        map.put("suffix", "次");
        toReturn.add(map);
        return toReturn;
    }

    @RequestMapping("/deal")
    public List<Map<String, Object>> deal() {
        ArrayList<Map<String, Object>> toReturn = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        long total = 0;
        for (Limitation limitation : provinceRecord.values()) {
            total += limitation.getDeal();
        }
        map.put("value", total);
        map.put("suffix", "单");
        toReturn.add(map);
        return toReturn;
    }

    @RequestMapping("/user")
    public List<Map<String, Object>> user() {
        ArrayList<Map<String, Object>> toReturn = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        long total = 0;
        for (Limitation limitation : provinceRecord.values()) {
            total += limitation.getUser();
        }
        map.put("value", total);
        map.put("suffix", "人");
        toReturn.add(map);
        return toReturn;
    }

    @RequestMapping("/turnoverRate")
    public List<Map<String, Object>> turnoverRate() {
        ArrayList<Map<String, Object>> toReturn = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        long total = 0;
        long totalDeal = 0;
        for (Limitation limitation : provinceRecord.values()) {
            total += limitation.getVisit();
            totalDeal += limitation.getDeal();
        }
        map.put("value", (double) totalDeal / total);
        toReturn.add(map);
        return toReturn;
    }

    @RequestMapping("/top10")
    public List<Map<String, Object>> top10() {
        ArrayList<Map<String, Object>> toReturn = new ArrayList<>();
        for (Map.Entry<Integer, Limitation> provinceLimit : provinceRecord.entrySet()) {
            Integer pId = provinceLimit.getKey();
            GeoCode geoCode = geoCodeMap.get(pId);
            Map<String, Object> map = new HashMap<>();
            map.put("value", provinceLimit.getValue().getGmv());
            map.put("content", geoCode.getProvince());
            toReturn.add(map);
        }
        return toReturn;
    }

    @RequestMapping("/bymin")
    public List<Map<String, Object>> bymin() {
        ArrayList<Map<String, Object>> toReturn = new ArrayList<>();


        for (Map.Entry<String, Integer> entry : byMinute.entrySet()) {
            Map<String, Object> map = new HashMap<>();
            map.put("x", entry.getKey());
            map.put("y", entry.getValue());
            map.put("s", "1");
            toReturn.add(map);
        }
        return toReturn;
    }

    @RequestMapping("/map")
    public List<Map<String, Object>> map() {
        ArrayList<Map<String, Object>> toReturn = new ArrayList<>();
        for (Map.Entry<Integer, Limitation> provinceLimit : provinceRecord.entrySet()) {
            Integer pId = provinceLimit.getKey();
            GeoCode geoCode = geoCodeMap.get(pId);
            Map<String, Object> map = new HashMap<>();
            map.put("lat", geoCode.getLat());
            map.put("lng", geoCode.getLng());
            map.put("value", provinceLimit.getValue().getDeal());
            toReturn.add(map);
        }
        return toReturn;
    }

}
