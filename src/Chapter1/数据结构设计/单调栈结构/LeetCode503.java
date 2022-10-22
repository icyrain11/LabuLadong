package Chapter1.数据结构设计.单调栈结构;

/*
 * @author icyrain11~
 * @version 16
 */

import org.junit.Test;

import java.util.Stack;

@SuppressWarnings("All")
public class LeetCode503 {

    //环形数组问题
    public int[] nextGreaterElements(int[] nums) {
        //TheNextGreaterNumber 问题就是单调栈
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            //矮个子让位
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }


}
