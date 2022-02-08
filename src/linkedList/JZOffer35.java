package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2022/2/8 21:08
 * @Version 1.0
 */
public class JZOffer35 {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);

        JZOffer35 jzOffer35 = new JZOffer35();
        jzOffer35.copyRandomList(node);
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Node oldHead = head;
        Node oldPtr = head;

        Node newHead = new Node(head.val);
        Node newPtr = newHead;

        map.put(oldPtr, newPtr);

        oldPtr = oldPtr.next;

        while (oldPtr != null) {
            newPtr.next = new Node(oldPtr.val);

            newPtr = newPtr.next;
            map.put(oldPtr, newPtr);

            oldPtr = oldPtr.next;


        }

        oldPtr = oldHead;
        newPtr = newHead;

        while (newPtr != null) {
            newPtr.random = map.get(oldPtr.random);

            oldPtr = oldPtr.next;
            newPtr = newPtr.next;
        }

        return newHead;
    }
}
