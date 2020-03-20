package com.segama.ege.util;

import org.apache.commons.lang3.StringUtils;

public class PlateConvertUtil {

    public static String convertToCapital(String plate){
        StringBuffer sb = new StringBuffer();
        if (StringUtils.isNotEmpty(plate)) {
            for (int i = 0; i < plate.length(); i++) {
                char c = plate.charAt(i);
                if(Character.isLowerCase(c)) {
                    sb.append(Character.toUpperCase(c));
                }else{
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToCapital("答复f789ffF9F22jkj好好"));
        System.out.println(convertToCapital(""));
    }
}
