package com.test.algorithm;

import java.util.List;

public class MergeKSortedLists_23 {
    public static void main(String[] args) {
        ListNode[] list = new ListNode[3];
        ListNode p1 = new ListNode(2);
        p1.next = new ListNode(4);
        p1.next.next = new ListNode(5);
        list[0] = p1;
        p1 = new ListNode(3);
        p1.next = new ListNode(8);
        p1.next.next = new ListNode(9);
        list[1] = p1;
        p1 = new ListNode(2);
        p1.next = new ListNode(6);
        list[2] = p1;
        ListNode node = new MergeKSortedLists_23().mergeKLists(list);
        System.out.println("print result--->");
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null|| lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        int len = 0;
        for(ListNode listNode:lists){
          if(listNode != null){
              len++;
          }
        }
        if(len == 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        Node[] nodes = new Node[len];
        int i = 0;
        for (ListNode listNode : lists) {
            if(listNode == null){
                continue;
            }
            Node node = new Node();
            node.element = listNode;
            node.val = listNode.val;
            nodes[i++] = node;
        }

        MinimumHeap heap = new MinimumHeap(nodes);
        Node root = heap.getMinListNode();
        while (root.element != null) {
            head.next = root.element;
            ListNode nextElement = root.element.next;
            if (nextElement == null) {
                root.val = Integer.MAX_VALUE;
                root.element = null;
            } else {
                root.element = nextElement;
                root.val = nextElement.val;
            }
            heap.replaceMin(root);
            head = head.next;
            root = heap.getMinListNode();

        }
        return dummy.next;
    }

}

class Node {
    ListNode element;
    int val;
}

class MinimumHeap {
    private final Node[] nodes;

    MinimumHeap(Node[] nodes) {
        this.nodes = nodes;
        buildMinHeap();
    }

    private void buildMinHeap() {
        for (int i = nodes.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nodes, i, nodes.length);
        }
    }

    private void adjustHeap(Node[] nodes, int i, int len) {
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < len && nodes[root].val > nodes[left].val) {
            root = left;
        }
        if (right < len && nodes[root].val > nodes[right].val) {
            root = right;
        }
        if (root != i) {
            swapNodes(root, i);
            adjustHeap(nodes, root, len);
        }
    }

    private void swapNodes(int root, int i) {
        Node node = nodes[root];
        nodes[root] = nodes[i];
        nodes[i] = node;
    }

    void replaceMin(Node node) {
        nodes[0] = node;
        adjustHeap(nodes, 0, nodes.length);
    }

    Node getMinListNode() {
        return nodes[0];
    }


}
