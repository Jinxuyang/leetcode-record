package linkedList;

/**
 * @Author Verge
 * @Date 2021/3/18 13:00
 * @Version 1.0
 */
public class Leetcode141 {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    /**
     * 思路：
     * 1. 使用两个指针，一个每次向前走1一个每次走2
     * 2. 让快的先走，假若没有环的话快的走着走着必定碰到null
     * 3. 要是有环的话必定配不到null，切快的每次比慢的多走1，总有一个时刻快的能比慢的多跑一圈从而追上慢的，快慢相遇说明有环
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了37.76%的用户
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next,slow = head;
        while (fast != null && slow != null){
            if (fast == slow) return true;
            if (fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
