package leetcode;

/**
 * Given an integer num, return the number of steps to reduce it to zero.
 *
 * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */

public class reduceNumToZero {

    public static int reduceNum(int num){
        int step = 0;
        do {
            if (num%2 != 0) {
          num--;
          step++;
            }
            num = num/2;
            step++;
        } while (num != 0);
        return step-1;
    }

    public static void main(String[] args) {
        System.out.println(reduceNum(123));
    }
}
