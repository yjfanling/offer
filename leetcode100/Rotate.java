package leetcode100;

public class Rotate {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k% length;
        reverse(nums,0,length-1);
        reverse(nums, 0 , k);
        reverse(nums, k+1, length-1);
    }

    private void reverse(int[] nums, int l, int r) {
        while(l<r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }
}
