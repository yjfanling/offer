package leetcode100;

import offer.ListNode;

import java.util.List;

public class SortList {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next ==null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast !=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while(left!=null&&right!=null) {
            if (left.val<right.val) {
                h.next = left;
                left= left.next;
            } else {
                h.next= right;
                right=right.next;
            }
            h=h.next;
        }
        if (left!=null) {
            h.next = left;
        }
        if (right!=null){
            h.next=right;
        }
        return res.next;
    }
    public static void main(String[] args) {
        ListNode pre = new ListNode(4);
        ListNode head = pre;
        head.next = new ListNode(2);
        head=head.next;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(3);
        sortList(pre);
    }
}


