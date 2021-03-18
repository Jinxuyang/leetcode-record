package linkedList;

/**
 * @Author Verge
 * @Date 2021/3/18 18:20
 * @Version 1.0
 */
public class Leetcode2 {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     *
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了67.53%的用户
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        int cnt = 0,n1,n2;
        while (l1 != null || l2 != null){
            n1 = l1 == null ? 0 : l1.val;// 若这个链表后面没了，就把后面的都看作0
            n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + cnt;
            if (sum >= 10){
                temp.next = new ListNode((sum) - 10);
                cnt = 0;
                cnt++;
            } else {
                temp.next = new ListNode(sum);
                cnt = 0;
            }
            temp = temp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (cnt != 0) temp.next = new ListNode(cnt);

        return head.next;
    }
}
