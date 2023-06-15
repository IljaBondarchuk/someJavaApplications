package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsCandies {
    public static void main(String[] args) {
        Candy candy = new Candy();
      int [] candies = new int[]{4,2,1,1,2};
      int extraCandies = 1;
      KidsCandies kidsCandies = new KidsCandies();
       System.out.println(kidsCandies.kidsWithCandies(candies,extraCandies).toString());

    }

    public  List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies){
            if (maxCandies < candy){
                maxCandies = candy;
            }
        }
        List<Boolean> addedExtra = new ArrayList<>();
        for (int candy : candies) {
            if ((candy + extraCandies) >= maxCandies){
                addedExtra.add(true);
            } else {
                addedExtra.add(false);
            }
        }
        return addedExtra;
    }

    public static String getRandomColor(){

        return Colors.values()[0].name();
    }

}
