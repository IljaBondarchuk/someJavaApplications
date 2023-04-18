package leetcode.easy;

import java.util.Arrays;

public class mergeAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd","pq"));
    }

    public static String mergeAlternately(String word1, String word2){
        char[] wordChar1 = word1.toCharArray();
        char[] wordChar2 = word2.toCharArray();
        StringBuilder result = new StringBuilder();
        int maxLength = wordChar1.length >= wordChar2.length ? wordChar1.length : wordChar2.length;
        for (int i = 0; i < maxLength; i++){
            if (i < wordChar1.length){
                result.append(wordChar1[i]);
            }
            if (i < wordChar2.length){
                result.append(wordChar2[i]);
            }
        }
        return result.toString();
    }
}
