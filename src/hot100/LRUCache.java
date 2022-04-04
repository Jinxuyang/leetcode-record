package hot100;

import java.util.*;

/**
 * @Author Verge
 * @Date 2022/4/3 20:18
 * @Version 1.0
 */

public class LRUCache {
    class LinkedListNode {
        int key;
        int val;
        LinkedListNode next;
        LinkedListNode prev;

        public LinkedListNode() {
        }

        public LinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer, LinkedListNode> map;
    LinkedListNode head;
    LinkedListNode tail;
    Integer capacity;
    public LRUCache(int capacity) {
        head = new LinkedListNode();
        tail = new LinkedListNode();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        LinkedListNode linkedListNode = map.get(key);
        if (linkedListNode == null) return -1;
        moveToHead(linkedListNode);
        return linkedListNode.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkedListNode linkedListNode = map.get(key);
            linkedListNode.val = value;
            moveToHead(linkedListNode);
            map.put(key, linkedListNode);
        } else {
            if (map.size() >= capacity) {
                int targetKey = removeFromTail();
                map.remove(targetKey);
            }
            LinkedListNode linkedListNode = new LinkedListNode(key, value);
            addToHead(linkedListNode);
            map.put(key, linkedListNode);
        }
    }

    public void addToHead(LinkedListNode linkedListNode) {
        LinkedListNode next = head.next;
        head.next = linkedListNode;
        linkedListNode.next = next;
        linkedListNode.prev = head;
        next.prev = linkedListNode;
    }

    public int removeFromTail() {
        LinkedListNode target = tail.prev;
        target.prev.next = tail;
        tail.prev = target.prev;
        return target.key;
    }

    public void moveToHead(LinkedListNode linkedListNode) {
        linkedListNode.prev.next = linkedListNode.next;
        linkedListNode.next.prev = linkedListNode.prev;
        addToHead(linkedListNode);
    }
}


