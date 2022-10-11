package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> soldiers = new HashMap();

        for(int i = 0; i < mat.length; i++){
            int numSoldiers = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1) numSoldiers++;
                else break;
            }
            soldiers.put(i, numSoldiers);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> soldiers.get(b) - (soldiers.get(a))); // wrong sorted???


        for(int i = 0; i < mat.length; i++){
            maxHeap.add(i);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        int[] ans = new int[k];
        int pos = 0;
        for(int row: maxHeap){
            ans[--k] = row;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,1,1,0,0,0,0},
                //{1,1,1,1,1,1,0},
                {0,0,0,0,0,0,0},
                {1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1}
        };
        System.out.println(kWeakestRows(mat,4));
    }
}
