package offer;

public class TreeLinkNode {
	int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)
        	return null;
        TreeLinkNode pnext=null;
        if(pNode.right!=null){
        	pnext=pNode.right;
        	while(pnext.left!=null)
        	{
        		pnext=pnext.left;
        	}
        }
        else if(pNode.next!=null)
        {
        	pnext=pNode.next;
        	if(pnext.left==pNode);
        	else
        	{
        		while(pnext!=null&&pNode==pnext.right)
        		{
        			pNode=pnext;
        			pnext=pnext.next;
        		}
        	}
        }
        return pnext;
    }
}
