package leetcode100;

public class MoveZero {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length ==0 ) {
            return;
        }
        int len = nums.length;
        int j = 0;
        for (int i = 0; i <= len; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
