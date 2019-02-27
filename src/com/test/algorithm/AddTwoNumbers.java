package com.test.algorithm;

import java.math.BigDecimal;

public class AddTwoNumbers {
    public static void main(String[] args) {
//        int value = (int) (-Math.pow(2, 31));
//        System.out.println(new BigDecimal((value)).toString());
//        int result = new AddTwoNumbers().reverseInteger(value);
//        System.out.println(new BigDecimal(result).toString());
        int total = Integer.MAX_VALUE;
        System.out.println("total:"+total);
        int tail = 9;
        int reuslt = total * 10 +tail;
        System.out.println(reuslt);
        System.out.println("result:"+(reuslt - tail) / 10);
        System.out.println((((reuslt - tail) / 10 )!= total));
    }

    /**
     * 有可能两个链表长度不一样长！
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int x = 0;
            int y = 0;
            if (p != null) {
                x = p.val;
                p = p.next;
            }
            if (q != null) {
                y = q.val;
                q = q.next;
            }
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }

    public int reverseInteger(int x) {
        int result = 0;
        while (x != 0) {
            int newResult = result * 10 + x % 10;
            if ((newResult - x % 10) / 10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }

        return result;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
