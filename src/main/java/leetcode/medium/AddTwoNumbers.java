package leetcode.medium;

import java.math.BigInteger;
import java.util.List;

public class AddTwoNumbers {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int [] result =addingTwoArrays( formingIntFromListNode(l1), formingIntFromListNode(l2));
        ListNode l3 = new ListNode();
        ListNode head = null;
        for (int i = 0; i < result.length; i++) {
            l3.val = result[i];
            l3.next = new ListNode();
            if (i == 0){
                head = l3;
            }
            if (i == result.length -1 ) {
                l3.next = null;
            }
            l3 = l3.next;
        }
        return head;
    }

    public static int[] formingIntFromListNode (ListNode l1){
        ListNode tailL1 = l1;
        ListNode currL1 = l1;
        int countL1 = 0;
        while (tailL1 != null){
            countL1++;
            tailL1 = tailL1.next;
        }
        int[] intL1 = new int[countL1];
        for (int i = 0; i < countL1; i++ ){
            intL1[i] = currL1.val;
            currL1 = currL1.next;
        }

        return intL1;
    }

    public static int[] addingTwoArrays(int[] l1, int[] l2){
        int h = 0;
        int[] l3;if (l1.length > l2.length) {
            l3 = new int[l1.length+1];
        } else {
            l3 = new int[l2.length+1];
        }
        for (int i = 0; i < l3.length - 1; i++){
            if (i < l1.length && i < l2.length){
                if (l1[i] + l2[i] + h <10){
                    l3[i] = l1[i] + l2[i] + h;
                    h = 0;
                } else {
                    l3[i] = (l1[i] + l2[i] + h)%10;
                    h = 1;
                }
            } else if (i >= l1.length && i < l2.length) {
                if (l2[i] + h <10){
                    l3[i] = l2[i] + h;
                    h = 0;
                } else {
                    l3[i] =  (l2[i] + h)%10;
                    h = 1;
                }
            } else if (i < l1.length && i >= l2.length){
                if (l1[i] + h <10){
                    l3[i] = l1[i] + h;
                    h = 0;
                } else {
                    l3[i] =  (l1[i] + h)%10;
                    h = 1;
                }
            }
        }
        int[] l4;
        if (h == 1) {
            l3[l3.length-1] = h;
            l4 = l3;
        } else {
            l4 = new int[l3.length-1];
            System.arraycopy(l3, 0, l4, 0, l3.length - 1);
        }
        return l4;
    }



    public static void main(String[] args) {

   //    ListNode lst1 = new ListNode(9);
     //   ListNode lst2 = new ListNode(1,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))))))));
       ListNode lst1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode lst2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        System.out.println(10%10);
        ListNode l3 = addTwoNumbers(lst1,lst2);
        System.out.println(l3);
    }
}

