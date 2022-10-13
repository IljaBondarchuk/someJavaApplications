package leetcode.easy;

/**
 * boolean
 * int [] 1 is in int [] 2 ?
 */

public class arrayInArray {

    public static boolean isInArray(int[] arraySub, int[] arrayMain){
        for (int i = 0; i < arrayMain.length; i++){
            if (i == arraySub[0]){
                int startI = i;
                for (int j = 0; j < arraySub.length; j++){
                    if (arraySub[j]!=i){
                        i = startI;
                        break;
                    } else if (j == arraySub.length -1){
                        return true;
                    } else {
                        i++;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    int [] arraySub ={2,3};
    int [] arrayMain ={1,2,4,2,3};
        System.out.println(isInArray(arraySub,arrayMain));
    }
}
