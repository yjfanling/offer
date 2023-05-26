package leetcode100;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> occurences = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            occurences.put(nums[i], occurences.getOrDefault(nums[i],0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurences.entrySet()) {
            Integer num = entry.getKey();
            Integer value = entry.getValue();
            if (queue.size() == k) {
                if (value >queue.peek()[1]) {
                    queue.poll();
                    queue.offer(new int[] {num, value});
                }
            } else  {
                queue.offer(new int[] {num, value});
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
    @Test
    public void test() {
        int[] nums = new int[]{1,1,1,2,2,3};
        topKFrequent(nums, 2);
        System.out.println("yes");
    }
}
