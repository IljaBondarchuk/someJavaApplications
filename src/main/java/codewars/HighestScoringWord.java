package codewars;

import java.util.*;

public class HighestScoringWord {
    public static void main(String[] args) {
        char ch = 'b';
        int val = ch;

        System.out.println(high("what time are we climbing up to the volcano"));
    }
   public static String bestPractice(String s){
       return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> i - 96).sum()
                )).get();
}
    public static String high(String s) {
        String[] strings = s.split(" ");
        int max = 0;
        Map<String, Integer> mapString = new LinkedHashMap<>();
        for (String str :
                strings) {
            mapString.put(str, 0);
        }
        for (Map.Entry<String, Integer> entry : mapString.entrySet()) {
            int sum = 0;
            for (char ch :
                    entry.getKey().toCharArray()) {
                sum = (sum + ch) - 96;
            }
            mapString.put(entry.getKey(), sum);
            if (max < sum) {
                max = sum;
            }
        }
        for (Map.Entry<String, Integer> entry : mapString.entrySet()) {
            if (max == entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
    }
}

