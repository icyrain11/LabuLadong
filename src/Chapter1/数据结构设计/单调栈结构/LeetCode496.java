package Chapter1.数据结构设计.单调栈结构;

/*
 * @author icyrain11~
 * @version 16
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@SuppressWarnings("All")
public class LeetCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            //遇到挨个
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }

}
