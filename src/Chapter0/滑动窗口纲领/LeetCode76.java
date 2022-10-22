package Chapter0.滑动窗口纲领;

/*
 * @author icyrain11~
 * @version 16
 */

import java.util.HashMap;

@SuppressWarnings("All")
public class LeetCode76 {
    public String minWindow(String s, String t) {

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : t.toCharArray()) {
            if (c >= 'a' && c >= 'A') {
                need[c - 'a']++;
            } else {
                need[c - 'A']++;
            }
        }

        int left = 0, right = 0;
        int valid = 0;
        //记录最小字串的起始位置和长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            //c是移入窗口的字符
            char c = s.charAt(right);
            //右移
            right++;
            //对窗口进行数据更新
            if (need[c] != 0) {
                if (c >= 'a' && c >= 'A') {
                    window[c - 'a']++;
                    if (window[c - 'a'] == need[c - 'a']) {

                    }
                } else {
                    window[c - 'A']++;
                    if (window[c - 'A'] == need[c - 'A']) {
                        valid++;
                    }
                }
            }

            //对左侧进行收缩
            while (valid == need.length) {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
