package linkedList;

/**
 *  Definition for singly-linked list.
 *  public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) { val = x; }
 *   }
 * @Author Verge
 * @Date 2021/12/22 18:53
 * @Version 1.0
 */
public class JZOffer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode node = head;
        while(node != null) {
            if (node.next != null && node.next.val == val) {
                node.next = node.next.next;
                return head;
            }
            node = node.next;
        }
        return head;
    }
}
