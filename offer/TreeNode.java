package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class TreeNode {
	int val = 0;
	int index=-1;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
    public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
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
	public boolean isSymmetrical(TreeNode pRoot)
    {
		return isSymmetrical(pRoot,pRoot);
    }
	private boolean isSymmetrical(TreeNode pRoot, TreeNode pRoot2) {
		// TODO Auto-generated method stub
		if(pRoot==null&&pRoot2==null)
			return true;
		if(pRoot==null||pRoot2==null)
			return false;
		if(pRoot.val!=pRoot2.val)
			return false;
		return isSymmetrical(pRoot.left, pRoot2.right)&&isSymmetrical(pRoot.right, pRoot2.left);
	}
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		int layer=1;
		ArrayList<ArrayList<Integer> > result=new ArrayList<ArrayList<Integer> >();
		Stack<TreeNode> s1=new Stack<TreeNode>();
		Stack<TreeNode> s2=new Stack<TreeNode>();
		s1.push(pRoot);
		while(!s1.empty()||!s2.empty())
		{
			if(layer%2==1)
			{
				ArrayList<Integer> row=new ArrayList<Integer>();
				while(!s1.empty())
				{
					TreeNode node=s1.pop();
					if(node!=null){
						row.add(node.val);
						s2.push(node.left);
						s2.push(node.right );
					}
				}
				if(!row.isEmpty())
				{
					result.add(row);
					layer++;
				}
			}
			else
			{
				ArrayList<Integer> row=new ArrayList<Integer>();
				while(!s2.empty())
				{
					TreeNode node=s2.pop();
					if(node!=null){
						row.add(node.val);
						s1.push(node.right);
						s1.push(node.left);
					}
				}
				if(!row.isEmpty())
				{
					result.add(row);
					layer++;
				}
			}
		}
		return result;
    }
	ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
		ArrayList<ArrayList<Integer> > result=new ArrayList<ArrayList<Integer> >();
		ArrayList<Integer> list=new ArrayList<Integer>();
		Queue<TreeNode> s=new LinkedList<TreeNode>();
		if(pRoot == null){
            return result;
        }
		s.add(pRoot);
		int start=0,end=1;
		while(!s.isEmpty())
		{
			TreeNode temp=s.remove();
			list.add(temp.val);
			start++;
			if(temp.left !=null)
			{
				s.add(temp.left);
			}
			if(temp.right!=null)
				s.add(temp.right);
			if(start==end)
			{
				start=0;
				end=s.size();
				result.add(list);
				list=new ArrayList<Integer>();
			}
		}
		
		return result;
    }
	public String Serialize(TreeNode root) {
		StringBuffer result=null;
        if(root==null)
        {
        	result.append("$,");
        	return result.toString();
        	
        }
        result.append(root.val+",");
        result.append(Serialize(root.left));
        result.append(Serialize(root.right));
        return result.toString();
	  }
	public TreeNode Deserialize(String str) {
		index++;
		TreeNode Node=null;
        String[] string=str.split(",");
        if(index>=str.length())
        	return null;
        if(!string[index].equals("$")){
        	Node=new TreeNode(Integer.valueOf(string[index]));
        	Node.left=Deserialize(str);
        	Node.right=Deserialize(str);
        }
        return Node;
	  }
}
