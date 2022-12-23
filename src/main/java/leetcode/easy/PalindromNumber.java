package leetcode.easy;

public class PalindromNumber {
    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(-101));
    }
    public static boolean isPalindromeNumber(int num){
        char[] nums = String.valueOf(num).toCharArray();
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] == nums[nums.length - i] || (i - 1) == (nums.length - i)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
