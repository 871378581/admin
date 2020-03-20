package com.segama.ege.admin.utils;
import java.util.Random;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2019-10-25 02:44
 */

/**
 * 生成6位随机密码,包含3位字母,3位数字
 * */
public class Password {
    private static Random getR = new Random();
    public static void main(String[] args) {
        String print = getRandomS();
        System.out.println(print);
    }

    public static String getRandomS() {
        Password p = new Password();
        String s = "";
        int n = 0;
        int m = 0;
        for (int i = 0; i < 6; i++) {
            if (n == 3) {
                s += p.getSz();
                m++;
            } else if (m == 3) {
                s += p.getZm();
                n++;
            } else {
                int ri = getR.nextInt(2);
                int temp = ri == 0 ? m++ : n++;
                s += ri == 0 ? p.getSz() : p.getZm();
            }
        }
        return s;
    }

    // 随机数字的字母，区分大小写
    private String getZm() {
        char sSS = (char) (getR.nextInt(26) + 97);// 小写字母97--122=a---z
        char sBs = (char) (getR.nextInt(26) + 65);// 大写65--90=A----Z
        char[] stemp = { sSS, sBs };
        int i = getR.nextInt(2);
        String sS = String.valueOf(stemp[i]);
        return sS;
    }

    // 随机数字的字符串
    private String getSz() {
        int getI = getR.nextInt(10) + 48;// 数字48--57=0---9
        String sI = String.valueOf((char) getI);
        return sI;
    }
}
