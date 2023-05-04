package offer.tianchi;

import offer.ListNode;
import org.junit.Test;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int tmp = head.val-1;
        while(head != null) {
            while (head!=null && head.next !=null && (head.val == tmp||head.val ==head.next.val)) {
                tmp = head.val;
                head = head.next;

            }
            if (head!=null&&head.val !=tmp) {
                cur.next = new ListNode(head.val);
                cur = cur.next;
                tmp = head.val;
                head = head.next;
            }else{
                head = head.next;
            }
        }
        return pre.next;
    }
    @Test
    public void test()
    {
        ListNode node = new ListNode(1);
        ListNode cur = node;
        cur.next = new ListNode(2);
        cur=cur.next;
        cur.next=new ListNode(3);
        cur=cur.next;
        cur.next=new ListNode(3);
        ListNode n= deleteDuplicates(node);
    }
}
