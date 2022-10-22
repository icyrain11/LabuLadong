package chapter2.子序列问题.最长公共子序列;

import java.util.Arrays;


/**
 * @author icyrain11
 * @version 1.8
 */
@SuppressWarnings("All")
public class LeetCode1143 {


    //备忘录
    int[][] memo;

//    public int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length();
//        int n = text2.length();
//        memo = new int[m][n];
//        for (int[] row : memo)
//            Arrays.fill(row, -1);
//        // 计算 s1[0..] 和 s2[0..] 的 lcs 长度
//
//        return dp(text1, 0, text2, 0);
//    }

    //dp遍历
    public int dp(String text1, int i, String text2, int j) {
        //base case 如果i j 都走到末尾那么就是都为空串
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        // 如果之前计算过，则直接返回备忘录中的答案
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        //如果只看text1[i]和text2[j] 如果text1[i]==text2[j]那么则一定在lcs中
        if (text1.charAt(i) == text2.charAt(j)) {
            // s1[i] 和 s2[j] 必然在 lcs 中，
            // 加上 s1[i+1..] 和 s2[j+1..] 中的 lcs 长度，就是答案
            memo[i][j] = 1 + dp(text1, i + 1, text2, j + 1);
        } else {
            //text1[i]和text2[j] 不相等的时候有三种情况

            memo[i][j] = max(//情况1 s[1]不在lcs中
                    dp(text1, i + 1, text2, j),
                    //情况2 s2[1]不在lcs中
                    dp(text1, i, text2, j + 1),
                    //情况3 s1[1]和s[2]都不在lcs中
                    dp(text1, i + 1, text2, j + 1));
        }

        return memo[i][j];
    }

    public int max(int dp, int dp1, int dp2) {
        return Math.max(dp, Math.max(dp1, dp2));
    }


    //自底向下的动态规划写法
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 定义：s1[0..i-1] 和 s2[0..j-1] 的 lcs 长度为 dp[i][j]
        // 目标：s1[0..m-1] 和 s2[0..n-1] 的 lcs 长度，即 dp[m][n]
        // base case: dp[0][..] = dp[..][0] = 0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 现在 i 和 j 从 1 开始，所以要减一
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // s1[i-1] 和 s2[j-1] 必然在 lcs 中
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }


}
