package leetcode.medium;
//https://leetcode.com/problems/container-with-most-water/submissions/971905903/?envType=featured-list&envId=top-interview-questions
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] newInt = new int[]{1,1};
        System.out.println(maxArea(newInt));
    }

    public static int maxArea(int[] height){
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left != right){
            if (result < (right - left) * (Math.min(height[left], height[right]))){
                result = (right - left) * (Math.min(height[left], height[right]));
            }
            if (height[right] < height[left]) {
                right = right - 1;
            } else {
                left = left +1;
            }
        }
        return result;
    }
}
