package chapter2.子序列问题.编辑距离;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode72 {

    //递归算法
//    int[][] memo;
//
//    public int minDistance(String word1, String word2) {
//        int m = word1.length();
//        int n = word2.length();
//        memo = new int[m][n];
//        for (int[] row : memo) {
//            Arrays.fill(row, -1);
//        }
//        //将索引指向字符的最后一位
//        return dp(word1, m - 1, word2, n - 1);
//    }
//
//    private int dp(String word1, int i, String word2, int j) {
//        //base case
//        if (i == -1) {
//            return j + 1;
//        }
//        if (j == -1) {
//            return i + 1;
//        }
//
//        if (memo[i][j] != -1) {
//            return memo[i][j];
//        }
//        //如果相同啥也不做skip
//        if (word1.charAt(i) == word2.charAt(j)) {
//            memo[i][j] = dp(word1, i - 1, word2, j - 1);
//        } else {
//            memo[i][j] = min(dp(word1, i - 1, word2, j) + 1,
//                    dp(word1, i - 1, word2, j - 1) + 1,
//                    dp(word1, i - 1, word2, j - 1) + 1);
//        }
//
//        return memo[i][j];
//    }
//
//    public int min(int a, int b, int c) {
//        return Math.min(a, Math.min(b, c));
//    }


    //dp算法
    int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        //m+1和n+1是因为空白字符的时候也算一个格子
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        // 自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1,
                            dp[i - 1][j - 1] + 1
                    );
                }
            }
        }
        return dp[m][n];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}




