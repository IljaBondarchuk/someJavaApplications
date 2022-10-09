package leetcode;

import java.util.Arrays;

/**
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​
 * customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
 *
 * A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.
 */

public class richestCustomer {
    public static int maximumWealth(int[][] accounts) {
        int richManWealth = 0;
        int richManNum = 0;
        int networth = 0;
        for (int i = 0; i < accounts.length; i++){
            for (int j = 0; j < accounts[i].length; j++){
                 networth += accounts[i][j];
            }
            if (richManWealth < networth) {
                richManWealth = networth;
                richManNum = i;
            }
            networth = 0;
        }
        return richManNum;
    }

    public static void main(String[] args) {
        int [][] accounts = new int[2][3];
        accounts[0][0] = 5;
        accounts[0][1] = 2;
        accounts[0][2] = 3;
        accounts[1][0] = 1;
        accounts[1][1] = 2;
        accounts[1][2] = 4;
        System.out.println(maximumWealth(accounts));

    }
}
