package com.test.algorithm;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd_19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pre = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        head = head.next;
        head.next = null;
        ListNode node = new RemoveNthFromEnd_19().removeNthFromEnd(pre, 5);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode fast = start;
        ListNode slow = start;
        start.next = head;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}


