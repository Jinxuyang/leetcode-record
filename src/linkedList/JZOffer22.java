package linkedList;

import java.util.List;
import java.util.Stack;

/**
 * @Author Verge
 * @Date 2021/12/22 20:16
 * @Version 1.0
 */
public class JZOffer22 {
    /**
     * 利用栈
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode node = null;
        for (int i = 0; !stack.isEmpty() && i < k; i++) {
            node = stack.pop();
        }

        return node;
    }

    /**
     * 两个指针，先让一个指针走k步，然后两个指针同步走，等先走的指针走到头，那么后面的指针就指向倒数第k个
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode front = head, end = head;
        for (int i = 0; front != null && i < k; i++) {
            front = front.next;
        }

        while (front != null) {
            front = front.next;
            end = end.next;
        }

        return end;
    }

}
