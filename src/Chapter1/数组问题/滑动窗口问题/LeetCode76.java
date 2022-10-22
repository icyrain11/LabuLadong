package Chapter1.数组问题.滑动窗口问题;

import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

/**
 * 最小覆盖子串
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode76 {

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;


        //获取需要的字符
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }


        while (right < s.length()) {
            //c是移入窗口的字符
            char c = s.charAt(right);
            //右移窗口增大
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }
            //判断左侧是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


    @Test
    public void TestDemo() {
        String s = "ADOBECODEBANC", t = "ABC";

        String s1 = minWindow(s, t);
        System.out.println("s1 = " + s1);

    }

}
