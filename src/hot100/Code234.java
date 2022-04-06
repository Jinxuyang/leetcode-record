package hot100;

/**
 * @Author Verge
 * @Date 2022/4/6 20:01
 * @Version 1.0
 */
public class Code234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = reserve(slow);

        while(head != null && tail != null) {
            if(head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }

        return true;

    }

    public ListNode reserve(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode prev = head, cur = head.next;
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
