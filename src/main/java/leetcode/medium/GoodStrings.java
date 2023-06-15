package leetcode.medium;
/*
Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:

Append the character '0' zero times.
Append the character '1' one times.
This can be performed any number of times.

A good string is a string constructed by the above process having a length between low and high (inclusive).

Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.*/


public class GoodStrings {
    public static void main(String[] args) {

    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        StringBuilder stringZero = new StringBuilder();
        StringBuilder stringOne = new StringBuilder();
        int i = 0;
        while (i < zero){
            stringZero.append("0");
            i++;
        }
        i=0;
        while (i < one){
            stringOne.append("1");
            i++;
        }


        return 0;
    }
}
