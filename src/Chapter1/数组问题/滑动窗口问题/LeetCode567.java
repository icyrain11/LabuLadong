package Chapter1.数组问题.滑动窗口问题;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode567 {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;


        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }
            //窗口缩小
            while ((right - left) >= s1.length()) {
                //如果找到合法的字串那么则返回
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d) == window.get(d)) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }
        }
        return false;
    }
}
