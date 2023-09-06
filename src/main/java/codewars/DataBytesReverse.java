package codewars;

import java.util.Arrays;

public class DataBytesReverse {
    public static void main(String[] args) {
        int[] data1= {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0};
        int[] data2= {1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};

        System.out.println(Arrays.toString(reverse(data1)));
    }

    public static int[] reverse(int[] arr) {
        int cntBytes = arr.length/8;
        int pointer = 0;
        int[][] subArr = new int[cntBytes][8];
        for (int i = 0; i < cntBytes; i++){
            for (int j = 0; j < 8; j++){
                subArr[i][j] = arr[pointer];
                pointer++;
            }
        }
        pointer = 0;
        int[] resultArray = new int[arr.length];
        for (int i = cntBytes-1; i >= 0; i--){
            for (int j = 0; j < 8; j++){
                resultArray[pointer] = subArr[i][j];
                pointer++;
            }
        }
        return resultArray;
    }

    public static int[] bestPractice(int[] data){
        int[] reversed = new int[data.length];
        for (int i = 0; i < data.length; i += 8) {
            System.arraycopy(data, i, reversed, data.length - 8 - i, 8);
        }
        return reversed;
    }
}
