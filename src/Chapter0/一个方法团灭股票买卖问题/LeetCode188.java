package Chapter0.一个方法团灭股票买卖问题;

/*
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")
public class LeetCode188 {
    //k = anyinteger
    public int maxProfit(int max_k, int[] prices) {
        int n = prices.length;
        if (max_k <= 0) {
            return 0;
        }
        // 交易次数 k 没有限制的情况
        if (max_k > n / 2) {
            return maxProfit_inf(prices);
        }

        // base case：
        // dp[-1][...][0] = dp[...][0][0] = 0
        // dp[-1][...][1] = dp[...][0][1] = -infinity
        int[][][] dp = new int[n][max_k + 1][2];
        // k = 1的base case
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MAX_VALUE;
            dp[i][0][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);

            }
        }
        return dp[n - 1][max_k][0];

    }

    public int maxProfit_inf(int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
