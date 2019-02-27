package com.test.algorithm.frequency;

import java.util.HashMap;

public class H_146_LRUCache {
    public static void main(String[] args) {

    }
}

class LRUCache {
    private HashMap<Integer, Node> map;

    private int count;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {

        map = new HashMap<>(capacity);
        count = 0;
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            deleteNode(node);

        } else {
            node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
            }
        }
        addToHead(node);
    }


    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            }else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

    private void addToHead(Node node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
}

class Node {
    public Node pre;
    public Node next;
    public int key;
    public int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}