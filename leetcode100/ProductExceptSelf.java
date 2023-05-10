package leetcode100;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int pre = 1,suf = 1;
        Arrays.fill(result,1);
        /**
         * 遍历一次， 用pre记录i左边的乘积，用suf记录i右边的乘积
         * 遍历时result[i]乘左边的乘积，result[len-i-1]乘右边的乘积，
         * 一次遍历计算两次
         * 时间复杂度O(N)
         */
        for (int i = 0; i < len; i++) {
            result[i] *=pre;
            result[len - i -1] *= suf;
            pre *= nums[i];
            suf *= nums[len - i -1];
        }
        return result;
    }
}
