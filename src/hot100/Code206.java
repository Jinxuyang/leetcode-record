package hot100;

/**
 * @Author Verge
 * @Date 2022/4/6 17:21
 * @Version 1.0
 */
public class Code206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head.next, prev = head;
        prev.next = null;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }
}
