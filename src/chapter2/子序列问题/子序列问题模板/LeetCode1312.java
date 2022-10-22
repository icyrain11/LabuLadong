package chapter2.子序列问题.子序列问题模板;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode1312 {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        //dp[i][j]代表的就是插入的个数和516恰好不同
        //也是反着遍历
        for (int i = n - 1; i >= 0; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    //如果左右两边相等则无需插入
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    //若不相等差最小的那个
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
