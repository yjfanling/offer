package leetcode100;

import java.util.HashMap;
import java.util.Map;

public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0l,1l);
        return pathSum(root,targetSum,0, map);
    }

    private int pathSum(TreeNode root, int targetSum, long curr, Map<Long,Long> map) {
        if (root == null) {
            return 0;
        }
        Long ret = 0l;
        curr += root.val;
        ret = map.getOrDefault(curr - targetSum,0l);
        map.put(curr, map.getOrDefault(curr,0l)+1);
        ret += pathSum(root.left,targetSum,curr,map);
        ret += pathSum(root.right,targetSum,curr,map);
        map.put(curr, map.getOrDefault(curr,0l)-1);
        return Math.toIntExact(ret);
    }
    /**
     * 深度遍历，前缀和，map计录同样的值有多少个
     * 退出当前时还原map里的记录
     */
}
