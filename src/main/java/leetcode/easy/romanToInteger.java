package leetcode.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */

public class romanToInteger {
    /**
     * this is wrong way :(
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int number = 0;
        int cntM = 0;
        int cntCM = 0;
        int cntD = 0;
        int cntCD = 0;
        int cntC = 0;
        int cntCX = 0;
        int cntL = 0;
        int cntLX = 0;
        int cntX = 0;
        int cntIX = 0;
        int cntV = 0;
        int cntIV = 0;
        int cntI = 0;
        int counter = 0;
       char[] romanChars = s.toCharArray();
           if (romanChars[counter] == 'M'|| romanChars[counter] == 'C') {
               for (int i = counter; i < romanChars.length; i++) {
                   if (romanChars[i] == 'M') {
                       cntM++;
                       counter++;
                   } else if (romanChars[i] == 'C' && i + 1 < romanChars.length  && romanChars[i + 1] == 'M') {
                       cntCM++;
                       i++;
                       counter++;
                       counter++;
                   } else {
                       break;
                   }
               }
           }
           if (romanChars[counter] == 'D'|| romanChars[counter] == 'C') {
               for (int i = counter; i < romanChars.length; i++) {
                   if (romanChars[i] == 'D') {
                       cntD++;
                       counter++;
                   } else if (romanChars[i] == 'C'  && i + 1 < romanChars.length && romanChars[i + 1] == 'D') {
                       cntCD++;
                       i++;
                       counter++;
                       counter++;
                   } else {
                       break;
                   }
               }
           }
           if (romanChars[counter] == 'C' || romanChars[counter] == 'X') {
               for (int i = counter; i < romanChars.length; i++) {
                   if (romanChars[i] == 'C') {
                       cntC++;
                       counter++;
                   } else if (romanChars[i] == 'X'  && i + 1 < romanChars.length && romanChars[i + 1] == 'C') {
                       cntCX++;
                       i++;
                       counter++;
                       counter++;
                   } else {
                       break;
                   }
               }
           }
           if (romanChars[counter] == 'L' || romanChars[counter] == 'X') {
               for (int i = counter; i < romanChars.length; i++) {
                   if (romanChars[i] == 'L') {
                       cntL++;
                       counter++;
                   } else if (romanChars[i] == 'X'  && i + 1 < romanChars.length  && romanChars[i + 1] == 'L') {
                       cntLX++;
                       i++;
                       counter++;
                       counter++;
                   } else {
                       break;
                   }
               }
           }
           if (romanChars[counter] == 'X' || romanChars[counter] == 'I') {
               for (int i = counter; i < romanChars.length; i++) {
                   if (romanChars[i] == 'X') {
                       cntX++;
                       counter++;
                   } else if (romanChars[i] == 'I' && i + 1 < romanChars.length && romanChars[i + 1] == 'X') {
                       cntIX++;
                       i++;
                       counter++;
                   } else {
                       break;
                   }
               }
           }
           if (romanChars[counter] == 'V' || romanChars[counter] == 'I') {
               for (int i = counter; i < romanChars.length; i++) {
                   if (romanChars[i] == 'V') {
                       cntV++;
                       counter++;
                   } else if (romanChars[i] == 'I' && i + 1 < romanChars.length && romanChars[i + 1] == 'V' ) {
                       cntIV++;
                       i++;
                       counter++;
                   } else {
                       break;
                   }
               }
           }
           if (romanChars[counter] == 'I') {
               for (int i = counter; i < romanChars.length; i++) {
                   if (romanChars[i] == 'I') {
                       cntI++;
                       counter++;
                   }
               }
           }
        return cntM*1000 + cntCM*900+cntD*500+cntCD*400+cntC*100+cntCX*90+cntL*50+cntLX*40+cntX*10+cntIX*9+cntV*5+cntIV*4+cntI;
    }

    public static int romanToIntV2(String s) {
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
        Map<String, Integer> mapCostRoman = new LinkedHashMap<>();
        mapCostRoman.put("M", 1000);
        mapCostRoman.put("CM", 900);
        mapCostRoman.put("D", 500);
        mapCostRoman.put("CD", 400);
        mapCostRoman.put("C", 100);
        mapCostRoman.put("XC", 90);
        mapCostRoman.put("L", 50);
        mapCostRoman.put("XL", 40);
        mapCostRoman.put("X", 10);
        mapCostRoman.put("IX", 9);
        mapCostRoman.put("V", 5);
        mapCostRoman.put("IV", 4);
        mapCostRoman.put("I", 1);
        AtomicInteger counter = new AtomicInteger();
        AtomicInteger answer = new AtomicInteger();
        for (Map.Entry<String, Integer> pair : mapCostRoman.entrySet()) {
                mapCntRoman.forEach((k,v)->{
                    if (Objects.equals(k, pair.getKey())){
                        int result = getNum(pair.getKey(), s, counter.get());
                        if (pair.getKey().length() == 2) {
                            answer.set(answer.get() + pair.getValue()*result/2);
                        } else {
                            answer.set(answer.get() + pair.getValue()*result);
                        }
                        counter.set(counter.get() + result);
                    }
                });
            }
        return answer.get();
    }


    public static   int getNum(String roman, String s, int counter){
        int counterStart = counter;
        char[] sChar = s.toCharArray();
        char[] symbol = roman.toCharArray();
        if (symbol.length == 1) {
            for (int i = counter; i < sChar.length; i++ ) {
                if (sChar[i] == symbol[0]) {
                    counter++;
                } else {
                   break;
                }
            }
        } else if ((sChar.length > counter + 1)){
            for (int i = counter; i < sChar.length; i++) {
                if(sChar[i] == symbol[0]&&sChar[i+1] ==symbol[1]){
                    counter++;
                    counter++;
                } else {
                    break;
                }
            }
        }
        return counter - counterStart;
    }


    public static void main(String[] args) {
        String s = "MMCDXXV";
        System.out.println(romanToIntV2(s));
        System.out.println(romanToInt(s));
    }
}
