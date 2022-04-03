package hot100;


import java.util.Objects;

/**
 * @Author Verge
 * @Date 2022/4/3 19:41
 * @Version 1.0
 */
public class Code142 {
    public ListNode detectCycle(ListNode head) {
        if (head.next == null) return null;
        ListNode fast = head.next.next,slow = head.next;

        while (slow != null && fast.next != null && !Objects.equals(fast, slow)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == null || fast.next == null) return null;

        slow = head;
        while (!Objects.equals(fast, slow)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
