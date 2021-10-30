package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class JZOffer06 {
    /**
     * 思路：遍历链表，将连边所有元素入栈，再出栈
     */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int size = stack.size();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = stack.pop().val;
        }
        return a;
    }

}
