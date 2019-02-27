package com.test.algorithm;

import java.util.Stack;

public class Reverse_Linked_List_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = head;
        while (dummy != null) {
            stack.push(dummy);
            dummy = dummy.next;
        }
        head = stack.pop();
        dummy = head;
        while (!stack.isEmpty()) {
            dummy.next = stack.pop();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head;
    }

    /**
     * best choice
     * @param head
     * @return
     */
    public ListNode reverseListOther(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode curTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = curTemp;
        }
        return pre;
    }
}
