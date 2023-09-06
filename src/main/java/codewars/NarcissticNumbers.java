package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NarcissticNumbers {
    public static void main(String[] args) {
        System.out.println(isNarcissistic(112));
    }

    public static boolean isNarcissistic(int number){
        int digit = String.valueOf(number).length();
        String temp = Integer.toString(number);
        int[] numbers = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            numbers[i] = temp.charAt(i) - '0';
        }


        return Arrays.stream(numbers)
                .mapToDouble(a -> Math.pow(a,digit))
                .sum() ==  number;
    }
}
