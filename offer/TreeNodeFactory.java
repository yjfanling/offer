package offer;

import org.junit.Test;

public class TreeNodeFactory {
	int index=1;
	public static TreeNode buildTreeByArray(int[] a,int n){
		TreeNode[] p=new TreeNode[n+1];
		p[0]=null;
		for(int i=1;i<=n;i++)
		{
			if(a[i]==-1){
				p[i]=null;
			}
			else
			{
				p[i]=new TreeNode(a[i]);
			}
		}
		for(int i=1;i<=n/2;i++){
			if(a[i]!=-1){
				if((2*i<=n)&&a[2*i]!=-1)
				{
					p[i].setLeft(p[2*i]);
				}
				if((2*i+1<=n)&&(a[2*i+1]!=-1)){
					p[i].setRight(p[2*i+1]);
				}
			}
		}
		return p[1];
	}
	public TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null)
        	return null;
        return KthNodeCore(pRoot,k);
    }
	private TreeNode KthNodeCore(TreeNode pRoot, int k) {
		// TODO Auto-generated method stub
		TreeNode temp=null;
		if(pRoot.left!=null)
			temp=KthNodeCore(pRoot.left, k);
		if(temp==null)
		{
			if(index==k)
				temp=pRoot;
			index++;
		}
		if(temp==null&&pRoot.right!=null)
		{
			temp=KthNodeCore(pRoot.right, k);
		}
		return temp;
	}
	@Test
	public void test(){
		int[] a={0,8,6,10,5,7,9,11};
		int i=0;
		TreeNode node=buildTreeByArray(a,7);
		TreeNode result=KthNode(node, 2);
		System.out.println(result.val);
	}
}
