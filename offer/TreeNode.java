package offer;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class TreeNode {
	int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
    public int TreeDepth(TreeNode root) {
     
		if(root==null)
			return 0;
		int left=TreeDepth(root.left);
		int right=TreeDepth(root.right);
	     return left>right?(left+1):(right+1);
    }
	public int TreeDepth1(TreeNode root){
		if(root==null)
			return 0;
		int cur,width,depth=0;
		TreeNode current;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
			cur=0;
			width=queue.size();
			while(cur<width){
				current=queue.poll();
				if(current.left!=null)
					queue.add(current.left);
				if(current.right!=null)
					queue.add(current.right);
				cur++;
			}
			depth++;
		}
		return depth;
	}
	public boolean IsBalanced_Solution(TreeNode root){
		if(root==null)
			return true;
		int left=TreeDepth(root.left);
		int right=TreeDepth(root.right);
		int diff=left-right;
		if(diff>1||diff<-1)
		{
			return false;
		}
		return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
	}
	public boolean IsBalanced_Solution1(TreeNode root)
	{
		return IsBalanced(root)!=-1;
	}
	public int IsBalanced(TreeNode root)
	{
		if(root==null)
			return 0;
		int left=IsBalanced(root.left);
		if(left==-1)
			return -1;
		int right=IsBalanced(root.right);
		if(right==-1)
			return -1;
		return Math.abs(left-right)>1?-1:1+Math.max(left, right);																																																													
	}
	@Test
	public void test(){
		TreeNode root=new TreeNode(1);
		root.left.val=2;
		root.right.val=3;
		root.left.left.val=4;
		root.left.right.val=5;
		root.left.right.left.val=6;
		if(IsBalanced_Solution1(root))
			System.out.println("yes");
		else
			System.out.println("no");
		
	}
}
