package codewars;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

public class ROT13 {
    public static void main(String[] args) {
        System.out.println(rot13("123@#!!#@  33"));
    }
    public static String rot13(String str){
        String keys = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String values = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm";
        // Create a HashMap to store the key-value pairs
        Map<Character, Character> hashMap = new HashMap<>();

        // Populate the HashMap with the keys and values
        for (int i = 0; i < keys.length(); i++) {
            hashMap.put(keys.charAt(i), values.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();
        for (Character ch :
        chars){
            result.append(hashMap.getOrDefault(ch, ch));
        }
        return result.toString();
    }
}

