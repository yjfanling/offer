package leetcode100;

import offer.ListNode;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(true) {
            if (fast==null || fast.next==null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast=fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
