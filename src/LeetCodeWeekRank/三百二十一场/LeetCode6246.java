package LeetCodeWeekRank.三百二十一场;

import org.junit.Test;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode6246 {
    public int appendCharacters(String s, String t) {
        int n = s.length();
        int m = t.length();
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        return m - j;
    }

}
