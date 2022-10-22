package Chapter1.数据结构设计.单调栈结构;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.Stack;

public class LeetCode739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temp) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return res;
    }
}
