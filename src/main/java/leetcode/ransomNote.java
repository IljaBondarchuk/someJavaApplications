package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 */

public class ransomNote {

    public static boolean canConstruct  (String ransomNote, String magazine){
        StringBuilder stringBuilder = new StringBuilder();
        char[] charsMagazine = magazine.toCharArray();
        char[] charsRansomNote = ransomNote.toCharArray();
        for (char ransChar : charsRansomNote){
            for (int i = 0; i < charsMagazine.length; i++){
                if (ransChar == charsMagazine[i]) {
                    stringBuilder.append(ransChar);
                    charsMagazine[i] = '9';
                    break;
                }
            }
        }
        return stringBuilder.toString().equals(ransomNote);
    }


    public static void main(String[] args) {
        System.out.println(canConstruct("aa","ab"));
    }
}
