package codewars;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.JUnit4;

public class CryptanalysisWordPatterns {
    public static void main(String[] args) {
        System.out.println(wordPattern("Hippopotomonstrosesquippedaliophobia"));
    }
    public static String wordPattern(String str){
            char[] chars = str.toLowerCase().toCharArray();
            int pointer = 1;
            HashMap<Character,Integer> decryptor = new HashMap<>();
            StringBuilder stringBuilder = new StringBuilder();
            decryptor.put(chars[0],0);
            stringBuilder.append(0);
            for (int i = 1; i < chars.length; i++) {
                if (!decryptor.containsKey(chars[i])) {
                    decryptor.put(chars[i], pointer++);
                }
                stringBuilder.append(".").append(decryptor.get(chars[i]));
            }
            return stringBuilder.toString();
    }
}

