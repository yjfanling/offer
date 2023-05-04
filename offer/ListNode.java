package offer;

import java.util.HashMap;

public class ListNode {
	public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        HashMap<Integer,ListNode> map=new HashMap<Integer,ListNode>();
        while(pHead!=null)
        {
        	if(!map.containsKey(pHead.next.val)||!map.containsValue(pHead.next.next))
        	{
        		map.put(pHead.val ,	pHead.next);
        		pHead=pHead.next;
        	}
        	else
        	{
        		return pHead.next;
        	}
      
        }
    	return null;
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
    	if (pHead == null || pHead.next == null) { 
            return pHead;
        }
    	if(pHead.val==pHead.next.val)
    	{
    		ListNode current=pHead.next;
    		while(current!=null&&current.val==pHead.val)
    		{
    			current=current.next;
    		}
    		return deleteDuplication(current);
    	}
    	else
    	{
    		pHead.next=deleteDuplication(pHead.next);
    		return pHead;
    	}
    }
}
