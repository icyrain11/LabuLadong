import java.util.*;

/**
 * @author icyrain11
 * @version 1.8
 */
public class Demo {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int res = 0;


        Map<Character, Integer> window = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            //更新串口
            window.put(c, window.getOrDefault(c, 0) + 1);

            //判断左侧串口是否需要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                //对串口移除
                window.put(d, window.getOrDefault(d, 0) - 1);
            }

            res = Math.max(res, right - left);
        }
        return res;
    }
}
