package lc146_LRUCache;

import java.util.HashMap;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity
 */
class LRUCache {
    static class Node {
        public Node prev = null;
        public Node next = null;
        public int val;
        public int key;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    static class DoublyLinkedList {
        public Node first;
        public Node last;
        public DoublyLinkedList() {}
        public void addLast(Node node) {
            if (this.last == null) {
                this.first = node;
                this.last = node;
            } else {
                this.last.next = node;
                node.prev = this.last;
                node.next = null;
                this.last = node;
            }
        }
        public void cut(Node node) {
            if (node.prev == null) {
                this.first = this.first.next;
                if (this.first != null) this.first.prev = null;
            } else if (node.next == null) {
                this.last = this.last.prev;
                this.last.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    }

    private final DoublyLinkedList linkedList;
    private final HashMap<Integer, Node> hashMap;
    private final int capacity;

    public LRUCache(int capacity) {
        this.linkedList = new DoublyLinkedList();
        this.hashMap = new HashMap<>();
        this.capacity = capacity;
    }

    private void updateLRU(int key) {
        Node node = this.hashMap.get(key);
        if (node.next != null) {
            this.linkedList.cut(node);
            this.linkedList.addLast(node);
        }
    }
    private void removeLRU() {
        Node node = this.linkedList.first;
        this.linkedList.cut(node);
        this.hashMap.remove(node.key);
    }

    public int get(int key) {
        if (!this.hashMap.containsKey(key)) {
            return -1;
        } else {
            this.updateLRU(key);
            return this.hashMap.get(key).val;
        }

    }

    public void put(int key, int value) {
        if (this.hashMap.containsKey(key)) {
            Node node = this.hashMap.get(key);
            node.val = value;
            this.updateLRU(key);
        } else {
            if (this.hashMap.size() == capacity) this.removeLRU();
            Node node = new Node(key, value);
            this.linkedList.addLast(node);
            this.hashMap.put(key, node);
        }
    }
}
