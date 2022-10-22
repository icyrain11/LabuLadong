package Chapter1.数组问题.数组去重;

import java.util.Stack;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode1081 {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] instack = new boolean[256];
        int[] count = new int[256];

        //记录字符出现次数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (char c : s.toCharArray()) {
            count[c]--;
            if (instack[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                instack[stack.pop()] = false;
            }
            stack.push(c);
            instack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }


        return sb.reverse().toString();
    }
}
