package leetcode100;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int curr = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < len; i++) {
            curr += nums[i];
            if (map.containsKey(curr-k)) {
                result+=map.get(curr-k);
            }
            map.put(curr, map.getOrDefault(curr, 0) +1);
        }
        return result;
    }
}
