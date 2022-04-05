package hot100;

import java.util.HashSet;

/**
 * @Author Verge
 * @Date 2022/4/5 14:04
 * @Version 1.0
 */
public class Code160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null && headB != null) {
            if (!set.contains(headA)) {
                set.add(headA);
                headA = headA.next;
            } else {
                return headA;
            }
            if (!set.contains(headB)) {
                set.add(headB);
                headB = headB.next;
            } else {
                return headB;
            }
        }
        if (headA != null) {
            while (headA != null) {
                if (!set.contains(headA)) {
                    set.add(headA);
                    headA = headA.next;
                } else {
                    return headA;
                }
            }
        }
        if (headB != null) {
            while (headB != null) {
                if (!set.contains(headB)) {
                    set.add(headB);
                    headB = headB.next;
                } else {
                    return headB;
                }
            }
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int A = 0, B = 0;
        ListNode curA = headA, curB  = headB;
        while (curA.next != null) {
            curA = curA.next;
            A++;
        }

        while (curB.next != null) {
            curB = curB.next;
            B++;
        }

        if (curA != curB) return null;

        if (A == B) {
            curA = headA;
            curB = headB;
        }
        else if (A > B) {
            curA = headA;
            for (int i = 0; i < A - B; i++) {
                curA = curA.next;
            }
            curB = headB;
        } else {
            curB = headB;
            for (int i = 0; i < B - A; i++) {
                curB = curB.next;
            }
            curA = headA;
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
    }
}
