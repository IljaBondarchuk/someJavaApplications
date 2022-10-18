package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class twoSum {
    public static int[] twoSums(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length- 1; i++){
            for (int j = 1; j < nums.length; j++){
                if (nums[i]+nums[j]==target &&i!=j){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
return null;
    }

    public static int[] twoSumsV2(int[] nums, int target) {
        int[] result= new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
 int[] example = {2,3,4};
        System.out.println(twoSums(example,6)[0] + " " + twoSums(example,6)[1]);
    }
}
