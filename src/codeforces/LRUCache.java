package codeforces;

import java.util.*;

public class LRUCache {

    private int capacity;

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) { this.key = key; this.value = value; }
    }

    private Map<Integer, Node> cache = new HashMap<>();
    private Node head;
    private Node tail;

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 6);

        cache.put(10, 5);
        cache.put(9, 10);
        cache.put(2, 19);
        cache.put(5, 5);
        cache.put(1, 30);
        cache.put(9, 12);

        cache.put(9, 13);


        System.out.println(cache.head.value + " --- ");
        System.out.println("prev: " + cache.head.prev);
        System.out.println("next: " + cache.head.next.value);

        System.out.println(cache.head.next.value + " --- ");
        System.out.println("prev: " + cache.head.next.prev.value);
        System.out.println("next: " + cache.head.next.next.value);

        System.out.println(cache.head.next.next.value + " --- ");
        System.out.println("prev: " + cache.head.next.next.prev.value);
        System.out.println("next: " + cache.head.next.next.next.value);

        System.out.println(cache.head.next.next.next.value + " --- ");
        System.out.println("prev: " + cache.head.next.next.next.prev.value);
        System.out.println("next: " + cache.head.next.next.next.next.value);

        System.out.println(cache.head.next.next.next.next.value + " --- ");
        System.out.println("prev: " + cache.head.next.next.next.next.prev.value);
        System.out.println("next: " + cache.head.next.next.next.next.next);

//        System.out.println(cache.head.next.next.next.next.next.value + " --- ");
//        System.out.println("prev: " + cache.head.next.next.next.next.next.prev.value);
//        System.out.println("next: " + cache.head.next.next.next.next.next.next);


//        System.out.println(cache.get(3));
//        System.out.println(cache.get(2));
//        cache.put(5, 5);
//        System.out.println(cache.get(3));
    }

    public LRUCache(int capacity) {

        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);

            if (node.equals(head)) {
                return head.value;
            }

            if (node.prev != null) {
                node.prev.next = node.next;
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
            }
            if (node.next == null) {
                tail = node.prev;
            }
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;

            return head.value;
        }
        return -1;
    }

    public void put(int key, int value) {

        if (cache.isEmpty()) {
            Node node = new Node(key, value);
            head = tail = node;
            cache.put(key, node);
        } else if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;

            if (node.prev != null) {
                node.prev.next = node.next;
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
            }
            if (node.next == null && node.prev != null) {
                tail = node.prev;
            }

            if (node.prev != null) {
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            }
        } else if (cache.size() == capacity) {

            Node node = cache.get(tail.key);
            cache.remove(tail.key);

            if (node.prev != null) {
                tail = node.prev;
                tail.next = null;
            }

            node = new Node(key, value);
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;

            cache.put(key, node);
        } else {
            Node node = new Node(key, value);
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;

            cache.put(key, node);
        }
    }

}
