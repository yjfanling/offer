package leetcode100;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    ListNode head;

    ListNode last;
    int capacity;

    int count = 0;

    Map<Integer, ListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(0, 0);
        last = new ListNode(0, 0);
        head.next = last;
        last.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return  -1;
        }
        ListNode res = map.get(key);
        remove(res);
        putToLast(res);
        return res.val;
    }

    private void putToLast(ListNode res) {
        res.pre = last.pre;
        last.pre.next = res;
        res.next = last;
        last.pre = res;
    }

    private void remove(ListNode res) {
        ListNode pre = res.pre;
        pre.next = res.next;
        res.next.pre = pre;
        res.next = null;
        res.pre = null;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            ListNode res = map.get(key);
            res.val = value;
            remove(res);
            putToLast(res);
        } else {
            if (count == capacity) {
                map.remove(head.next.key);
                remove(head.next);
            } else  {
                count ++;
            }
            ListNode res = new ListNode(value, key);
            map.put(key, res);
            putToLast(res);
        }
    }
}
class ListNode{
    ListNode pre;
    ListNode next;
    int val;

    int key;
    public ListNode(int val, int key) {
        this.val = val;
        this.key = key;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

