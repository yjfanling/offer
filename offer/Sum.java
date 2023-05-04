package offer;

import org.junit.Test;

import java.util.*;

public class Sum {
public int Sum_Solution(int n) {
        int sum=n;
        boolean flag=(n>0)&&((sum+=Sum_Solution(--n))>0);
        return sum;
    }
@Test
public void test(){
    System.out.println(Sum_Solution(3));
}
    public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length == 0) {
        return new ArrayList<>();
    }
    int size = nums.length;
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
        for (int i = 0; i < size-2; i++) {
            if (i>0&& nums[i] == nums[i-1]) {
                continue;
            }
            int right = size-1;
            for (int j = i+1; j < size; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                while(right > j && nums[i] + nums[j] + nums[right]>0) {
                    right--;
                }
                if (right == j) {
                    break;
                }
                if (nums[i] + nums[j] + nums[right]==0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[right]);
                    result.add(list);
                }
            }
        }
    return result;
    }

}
