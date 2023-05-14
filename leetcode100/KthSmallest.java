package leetcode100;

import java.util.HashMap;
import java.util.Map;

//  Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        MyTree myTree = new MyTree(root);
        return myTree.getKthSmallest(k);
    }
}
class MyTree{
      TreeNode root;
      Map<TreeNode, Integer> map = new HashMap<>();

      public MyTree(TreeNode t) {
          root = t;
          countNodeNum(t);
      }

    private int countNodeNum(TreeNode t) {
          if (t == null){
              return 0;
          }
          map.put(t,1+countNodeNum(t.left)+countNodeNum(t.right));
          return getNum(t);
    }

    private int getNum(TreeNode t) {
          return map.getOrDefault(t,0);
    }

    public int getKthSmallest(int k) {
          TreeNode node = root;
          while(true) {
              int left = getNum(node.left);
              if (left == k-1) {
                  break;
              } else if (left>k-1) {
                  node = node.left;
              } else {
                  node = node.right;
                  k -=left+1;
              }
          }
          return node.val;
    }
}