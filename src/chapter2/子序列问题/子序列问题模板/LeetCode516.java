package chapter2.子序列问题.子序列问题模板;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //dp数组初始化为0 i>j的地方不存在子序列因此都初始化为0
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        //反着遍历保证正确的状态转移,因为遍历的顺序是从dp[0][0]到dp[0][n-1]也就是00长度到0~n的长度的字符串的所有情况
        //为了遍历到dp[0][n]的位置因此需要从dp[n-1][i]的位置遍历因此i<j的时候是没有意义的
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        //返回最长子序列长度
        return dp[0][n - 1];
    }
}
