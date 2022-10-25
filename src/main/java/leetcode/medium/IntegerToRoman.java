package leetcode.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {
    public static String intToRoman(int num){
        Map<String, Integer> mapCntRoman = new LinkedHashMap<>();
        mapCntRoman.put("M", 0);
        mapCntRoman.put("CM", 0);
        mapCntRoman.put("D", 0);
        mapCntRoman.put("CD", 0);
        mapCntRoman.put("C", 0);
        mapCntRoman.put("XC", 0);
        mapCntRoman.put("L", 0);
        mapCntRoman.put("XL", 0);
        mapCntRoman.put("X", 0);
        mapCntRoman.put("IX", 0);
        mapCntRoman.put("V", 0);
        mapCntRoman.put("IV", 0);
        mapCntRoman.put("I", 0);
        String s = String.valueOf(num);
        StringBuilder stringBuilder = new StringBuilder(s);
        s = stringBuilder.reverse().toString();
        char[] charS1 = s.toCharArray();
        int[] charS = new int[charS1.length];
        for (int i = 0; i < charS.length; i++){
            charS[i] = charS1[i] -48;
        }
        if (s.length() > 3) {
            mapCntRoman.put("M",  charS[3]);
        }
        if (s.length() > 2) {
            if ( charS[2] == 9) {
                mapCntRoman.put("CM", 1);
            } else if ( charS[2] == 4) {
                mapCntRoman.put("CD", 1);
            } else if ( charS[2] >= 5) {
                mapCntRoman.put("D", 1);
                mapCntRoman.put("C",  charS[2] - 5);
            } else if ( charS[2] > 0) {
                mapCntRoman.put("C",  charS[2]);
            }
        }
        if (s.length() > 1) {
            if ( charS[1] == 9) {
                mapCntRoman.put("XC", 1);
            } else if ( charS[1] == 4) {
                mapCntRoman.put("XL", 1);
            } else if ( charS[1] >= 5) {
                mapCntRoman.put("L", 1);
                mapCntRoman.put("X",  charS[1] - 5);
            } else if ( charS[1] > 0) {
                mapCntRoman.put("X",  charS[1]);
            }
        }
        if (s.length() > 0) {
            if ( charS[0] == 9) {
                mapCntRoman.put("IX", 1);
            } else if ( charS[0] == 4) {
                mapCntRoman.put("IV", 1);
            } else if ( charS[0] >= 5) {
                mapCntRoman.put("V", 1);
                mapCntRoman.put("I",  charS[0] - 5);
            } else if ( charS[0] > 0) {
                mapCntRoman.put("I",  charS[0]);
            }
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String,Integer> map : mapCntRoman.entrySet()){
            if (map.getValue() > 0) {
                for (int i = 0; i < map.getValue(); i++){
                    result.append(map.getKey());
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
}
