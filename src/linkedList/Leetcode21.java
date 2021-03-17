package linkedList;

/**
 * @Author Verge
 * @Date 2021/3/17 19:18
 * @Version 1.0
 */
public class Leetcode21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    private static void main(String[] args) {
        int[] input1 = {};
        int[] input2 = {};

        ListNode list1 = new ListNode(input1[0]);
        ListNode list2 = new ListNode(input2[0]);
        ListNode temp = list1;
        for (int i = 1; i < input1.length; i++) {
            temp.next = new ListNode(input1[i]);
            temp = temp.next;
        }
        temp = list2;
        for (int i = 1; i < input2.length; i++) {
            temp.next = new ListNode(input2[i]);
            temp = temp.next;
        }

        ListNode res = mergeTwoLists(list1,list2);

        while (res != null){
            System.out.print(res.val);
            res = res.next;
        }
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了25.10%的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了65.73%的用户
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1,node2 = l2,res = new ListNode(),temp = res;
        while (node1 != null && node2 != null){
            temp.next = new ListNode();
            temp = temp.next;
            if (node1.val >= node2.val) {
                temp.val = node2.val;
                node2 = node2.next;
            } else {
                temp.val = node1.val;
                node1 = node1.next;
            }
        }

        if (node1 == null) temp.next = node2;
        else temp.next = node1;

        return res.next;

    }
}
