package Chapter1.数组问题.滑动窗口问题;

import java.util.HashMap;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int max_len = Integer.MIN_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);

            //窗口缩小
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            max_len = Math.max(max_len, right - left);
        }

        return max_len;
    }
}
