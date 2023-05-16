package leetcode100;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class LowestCommonAncestor {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        haveNode(root,p,q);
        return ans;
    }

    private boolean haveNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return false;
        }
        boolean lson = haveNode(root.left,p,q);
        boolean rson = haveNode(root.right,p,q);
        if ((lson&&rson)||((lson||rson)&&(p.val == root.val||q.val == root.val))){
            ans = root;
        }
        return lson||rson||p.val == root.val||q.val == root.val;
    }
    /**
     * 公共父节点需要满足的条件为
     * 1.左子树中包含p或者q，右子树中也包含p或者q
     * 2.当前节点为p或者q，右子树或左子树中包含p或者q
     *
     */
}
