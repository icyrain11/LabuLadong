package chapter2.用动态规划玩游戏.正则表达式;

import java.util.HashMap;
import java.util.Map;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode10 {
    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    //备忘录消除子序列问题
    Map<String, Boolean> memo = new HashMap<String, Boolean>();

    public boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();
        //base case
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            // 如果能匹配空串，一定是字符和 * 成对儿出现
            if ((n - j) % 2 == 1) {
                return false;
            }
            // 检查是否为 x*y*z* 这种形式
            for (; j + 1 < p.length(); j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        Boolean res = false;
        //.匹配
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            //如果有*通配符
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 1.1 通配符匹配 0 次或多次
                res = dp(s, i, p, j + 2)
                        || dp(s, i + 1, p, j);
            } else {
                //匹配一次
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            //不匹配
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 2.1 通配符匹配 0 次
                res = dp(s, i, p, j + 2);
            } else {
                // 2.2 无法继续匹配
                res = false;
            }
        }
        memo.put(key, res);
        return res;
    }
}
