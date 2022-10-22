package Chapter0.一个方法团灭股票买卖问题;

/*
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")
//k = +infinity with cooldown
public class LeetCode309 {
//    dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
//    dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
//    解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                //base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if (i - 2 == -1) {
                //base case2
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);

        }
        return dp[n - 1][0];
    }

}
