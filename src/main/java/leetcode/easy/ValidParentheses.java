package leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
   String s = "{{[[{}]]}}()({})";
        System.out.println(isValid(s));
    }
  /*  public static boolean isValid (String s) {
        return isValid1(s) || isValid2(s);
    }
    public static boolean isValid2 (String s) {
        if (s.length()%2 != 0) return false;
        int mid = s.length()/2 - 1;
        char [] charS = s.toCharArray();
        for (int i = 0; i > mid; i++) {
            if ((charS[mid - i] == '{' && charS[mid + i + 1] == '}') ||
                (charS[mid - i] == '[' && charS[mid + i + 1] == ']') ||
                (charS[mid - i] == '(' && charS[mid + i + 1] == ')')) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid1 (String s) {
        if (s.length() % 2 != 0) return false;
        char [] charS = s.toCharArray();
        if (s.length() == 2) {
            return closedBrackets(charS, 0);
        }
            for (int i = 0; i < s.length() - 2; i++) {
               if (!closedBrackets(charS, i)) {
                   return false;
               } else {
                   i++;
               }
            }
            return true;
        }

    public static boolean closedBrackets (char[] charS, int step){
        return (charS[step] == '{' && charS[step + 1] == '}') ||
                (charS[step] == '[' && charS[step + 1] == ']') ||
                (charS[step] == '(' && charS[step + 1] == ')');
    }*/
  public static boolean isValid (String s) {
      Stack<Character> stack = new Stack<>();
      char [] charS = s.toCharArray();
      for (char c : charS){
          if (c == '{') {
              stack.push('}');
          } else if (c == '[') {
              stack.push(']');
          } else if (c == '(') {
              stack.push(')');
          } else if (stack.isEmpty() || stack.pop() != c )
              return false;
      }
      return stack.isEmpty();
  }
}
