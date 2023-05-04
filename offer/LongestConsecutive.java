package offer;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length ==0 ) {
            return 0;
        }
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int n : nums) {
            if (set.remove(n)) {
                int curr = n;
                int maxlen = 0;
                while (set.remove(curr-1)) {
                    curr--;
                }
                maxlen = n-curr+1;
                curr = n;
                while (set.remove(curr+1)) {
                    curr++;
                }
                maxlen+=curr - n;
                result = Math.max(maxlen, result);
            }
        }
        return result;
    }
}
/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 * 2n也是O(n)
 *
 * 利用哈希表可以将查找速度降到O(1)
 * 边找边remove可以避免重复查找
 */
