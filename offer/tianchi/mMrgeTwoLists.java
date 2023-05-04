package offer.tianchi;

import offer.ListNode;

public class mMrgeTwoLists {
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode pre = new ListNode(-1);
        ListNode cur = new ListNode(-1);
        pre.next = cur;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                cur.next = node2;
                break;
            }
            if (node2 == null) {
                cur.next = node1;
            }
            if (node1.val >= node2.val) {
                cur.next = new ListNode(node1.val);
                node1 = node1.next;
            }else{
                cur.next = new ListNode(node2.val);
                node2 = node2.next;
            }
            cur = cur.next;
        }
        return pre.next;
    }
}
