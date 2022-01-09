package linkedList;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author Verge
 * @Date 2022/1/8 12:28
 * @Version 1.0
 */
public class JZOffer24 {

    public static void main(String[] args) {
        int a = 1;
        int b = a;

        b = 2;
        System.out.println(a==b);
    }
    /**
     * 思路：利用栈
     */
    public ListNode reverseList(ListNode head) {







































        if (head == null) return null;
        new Stack<>();
        Stack<ListNode> stack = new Stack<>();

        // 第一个节点比较特殊，链表旋转后第一个节点变为最后一个节点，若不特殊处理的话，这个节点会指向倒数第二个节点，形成环，因此再第一个节点入栈时，
        // 将其的next指针指向null，避免出现环
        stack.push(head);
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        ListNode res  = stack.pop();
        ListNode temp = res;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }

        return res;
    }

    public ListNode reverseList1(ListNode head) {
        return recur(head, null);
    }

    public ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        cur.next = recur(pre.next, pre);
        return cur.next;
    }
}
