package offer.tianchi;

import offer.ListNode;

public class GetIntersectionNode {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A = headA;
        ListNode B = headB;
        boolean isEndA = false;
        boolean isEndB = false;
        while(A!=null || B !=null) {
            if (A == null && !isEndA) {
                A = headB;
                isEndA=true;
            }
            if (B == null && !isEndB) {
                B = headA;
                isEndB = true;
            }
            if (A == null || B == null) {
                return null;
            }
            if (A==B) {
                return A;
            } else {
                A = A.next;
                B=B.next;
            }
        }
        return null;
    }
}
