package Chapter1.数组问题.数组去重;

import java.util.Stack;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode316 {

    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        boolean[] instack = new boolean[256];
        int[] count = new int[256];

        //统计剩余字母的个数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }


        for (char c : s.toCharArray()) {
            count[c]--;
            if (instack[c]) {
                continue;
            }
            //单调栈弹出
            while (!stack.isEmpty() && stack.peek() > c) {
                //如果字符串中没有该字符那么不应该弹出
                if (count[stack.peek()] == 0) {
                    break;
                }
                //同弹出
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
