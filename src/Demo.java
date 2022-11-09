import java.util.*;

/**
 * @author icyrain11
 * @version 1.8
 */
public class Demo {


    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] instack = new boolean[256];
        int[] count = new int[256];
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
