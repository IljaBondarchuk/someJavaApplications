package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
      char[] charS = s.toCharArray();
        int del = 0;
        Map<String, Integer> lengthOfUniqueStrings = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charS.length; i++){

            if (stringBuilder.indexOf(String.valueOf(charS[i])) > -1) {
                lengthOfUniqueStrings.put(stringBuilder.toString(), stringBuilder.length());
                i = i - stringBuilder.length() + stringBuilder.indexOf(String.valueOf(charS[i]));
                stringBuilder.delete(0, stringBuilder.length());

            } else {
                stringBuilder.append(charS[i]);
            }
        }
        lengthOfUniqueStrings.put(stringBuilder.toString(), stringBuilder.length());
        int max = 0;
        for (Map.Entry<String, Integer> map : lengthOfUniqueStrings.entrySet()){
            if (max < map.getValue()){
                max = map.getValue();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
