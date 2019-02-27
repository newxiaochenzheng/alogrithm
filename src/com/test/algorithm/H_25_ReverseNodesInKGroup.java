package com.test.algorithm;

public class H_25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 1;
        ListNode newHead = null;
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            if (count == k) {
                while (head != p) {
                    ListNode tmp = head.next;
                    head.next = pre;
                    pre = head;
                    head = tmp;
                }
                if (newHead == null) {
                    newHead = pre;
                }
                count = 1;

            } else {
                p = p.next;
                count++;
            }
        }
        return newHead;
    }

    private int getMedian(int[] array1, int start1, int end1, int[] array2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return getMedian(array2, start2, end2, array1, start1, end1, k);
        }
        if (len1 == 0) {
            return array2[start2 + k - 1];
        }
        if(k == 1){
            return Math.min(array1[start1],array2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (array1[i] < array2[j]) {
            return getMedian(array1, i + 1, end1, array2, start2, end2, k - (i + 1 - start1));
        } else {
            return getMedian(array1, start1, end1, array2, j + 1, end2, k - (j + 1 - start2));
        }

    }
}
