package leetcode.medium;

import java.util.Stack;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
    }

    public static int reverseOld(int x){
        if (x == 0) {return x;}
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        if (stringBuilder.charAt(0) == '-'){
            stringBuilder.replace(0,1,"");
            stringBuilder.reverse();
            while (stringBuilder.charAt(0) == '0'){
                stringBuilder.replace(0,1,"");
            }
           stringBuilder.insert(0,"-");
        } else {
            stringBuilder.reverse();
            while (stringBuilder.charAt(0) == '0'){
                stringBuilder.replace(0,1,"");
            }
        }

        if (( Integer.parseInt(String.valueOf(stringBuilder)) < -2147483647) || ( Integer.parseInt(String.valueOf(stringBuilder)) > 2147483646)){return 0;}
        return Integer.parseInt(String.valueOf(stringBuilder));
    }

    public static int reverse(int x) {
        int minus = 1;
        Stack<Integer> integerStack = new Stack<>();
        if (x < 0) {
            x = -1 * x;
            minus = -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        for (int i = 0; i < stringBuilder.length(); i++){
            integerStack.push(Character.getNumericValue(stringBuilder.charAt(i)));
        }
        if (integerStack.size() == 10) {
            if (integerStack.get(9) > 2) {
                return 0;
            } else if (integerStack.get(9) == 2)  {
                Stack<Integer> copiedStack = (Stack<Integer>)integerStack.clone();
                StringBuilder checkBigInt = new StringBuilder();
                copiedStack.pop();
                while (!copiedStack.isEmpty()){
                    checkBigInt.append(copiedStack.pop());
                }
                if (Integer.parseInt(String.valueOf(checkBigInt)) > 147483646) {
                    return 0;
                }
            }
        } else if (integerStack.size() > 10) {
            return 0;
        }
        StringBuilder result = new StringBuilder();
        while (!integerStack.isEmpty()){
            result.append(integerStack.pop());
        }
    return Integer.parseInt(String.valueOf(result)) * minus;
    }
}
