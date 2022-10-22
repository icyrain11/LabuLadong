package chapter2.子序列问题.最长公共子序列;

import java.util.Arrays;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //如果两个删除变得一样那么就是寻找最长子序列
        int lcs = longestCommonSubsequence(word1, word2);
        return m - lcs + n - lcs;
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        // 计算 s1[0..] 和 s2[0..] 的 lcs 长度

        return dp(s1, 0, s2, 0);
    }

    //自顶向下的递归写法
    int memo[][];

    public int dp(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        //如果已经遍历过
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        //情况1
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            //剩下的就是求出最大的
            memo[i][j] = max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1), dp(s1, i + 1, s2, j + 1));
        }
        return memo[i][j];
    }


    public int max(int dp, int dp1, int dp2) {
        return Math.max(dp, Math.max(dp1, dp2));
    }

}
