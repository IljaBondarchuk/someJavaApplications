package leetcode.easy;

import java.util.*;

/**
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 *
 * A row i is weaker than a row j if one of the following is true:
 *
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 *
 *
 */
public class weakestRow {

    public static int[] findWeak(int[][] row, int count){
        HashMap<Integer,Integer> sortedMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < row.length; i++){
            sortedMap.put(i,Arrays.stream(row[i]).sum());
        }
        int max = Collections.max(sortedMap.values());
        int min = Collections.min(sortedMap.values());
        if (min != max) {
            do {
                int fin = min;
                min++;
                sortedMap.forEach((k, v) -> {
                    if (v == fin) {
                        result.add(k);
                    }
                });
            } while (sortedMap.size() != result.size());
        } else {
            sortedMap.forEach((k,v) -> result.add(k));
        }
        while (result.size() > count){
            result.remove(result.size() - 1);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,1,1,0,0,0,0},
                {1,1,1,1,1,1,0},
                {0,0,0,0,0,0,0},
                {1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1}
        };
        System.out.println(findWeak(mat, 2));

    }
}
