package leetcode.easy;

import java.util.LinkedList;
import java.util.List;
//check later
public class PalindromeLinkedList {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static boolean isPalindrome(ListNode head){
          ListNode next = null;
          ListNode curr = head;
          ListNode prev = null;
          ListNode tail = head;
          int n = 0;
          while (tail!=null){
              n++;
              tail = tail.next;
          }
          int mid=n/2;
          while(mid!=0){
              next = curr.next;
              curr.next = prev;
              prev = curr;
              curr = next;
              mid--;
          }
          if(n%2!=0) curr = curr.next;
          while(curr!=null){
              if(prev.val!= curr.val) return false;
          curr = curr.next;
          prev = prev.next;
          }
          return true;
    }

    public static void main(String[] args) {
        LinkedList<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(2);
        integerList.add(1);
      }
}
