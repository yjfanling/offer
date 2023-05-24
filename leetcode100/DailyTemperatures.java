package leetcode100;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }
        return result;
    }
}
