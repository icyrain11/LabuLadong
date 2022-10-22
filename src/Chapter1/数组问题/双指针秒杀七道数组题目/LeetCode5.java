package Chapter1.数组问题.双指针秒杀七道数组题目;

/**
 * 最长回文串
 *
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode5 {

    //以s[l] 和 s[r]寻找最长的回文串
    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public String longestPalindrome(String s) {
        String res = "";
        // 以 s[i] 为中心的最长回文子串
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
}
