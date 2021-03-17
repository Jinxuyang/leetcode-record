import java.util.HashMap;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2021/3/17 16:50
 * @Version 1.0
 */
public class Leetcode19 {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        ListNode head = new ListNode(input[0]);
        ListNode temp = head;
        for (int i = 1; i < input.length; i++) {
            temp.next = new ListNode(input[i]);
            temp = temp.next;
        }

        ListNode res = removeNthFromEnd1(head,2);

        while (res != null){
            System.out.print(res.val);
            res = res.next;
        }
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 思路：
     * 1. 遍历链表，并存入hashmap
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了18.44%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了5.11%的用户
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode temp = head;
        int i = 0;
        while (temp != null){
            i++;
            map.put(i,temp);
            temp = temp.next;
        }

        if (i == 1) return null;
        if (i == n) return head.next;
        temp = map.get(i - n);
        temp.next = temp.next.next;

        return head;
    }

    /**
     * 思路：
     * 1.快慢指针
     * 2.先让快指针走n步，再让快慢指针一块走，直到快指针走到链表末尾，这是慢指针指向的就是倒数第n+1个
     * 3.在快指针先走的过程中，要是直接走出了链表则说明，要删除第一个节点则直接返回head.next即可
     *
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了80.89%的用户
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode slow = head,fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
