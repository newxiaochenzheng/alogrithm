package com.test.algorithm;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            first.next = second.next;
            second.next = first;
            curr.next = second;
            curr = curr.next.next;
        }
        return dummy.next;
}

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = head;
        int count = 0;
        while (head != null && count > k) {
            if (head.next != null) {
                ListNode first = head;
                ListNode second = head.next;
                head = head.next.next;
                int tmp = first.val;
                first.val = second.val;
                second.val = tmp;
                count++;
            } else {
                break;
            }
        }
        return dummy;
    }

}
