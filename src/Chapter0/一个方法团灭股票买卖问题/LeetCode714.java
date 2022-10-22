package Chapter0.一个方法团灭股票买卖问题;

/*
 * @author icyrain11~
 * @version 16
 */

@SuppressWarnings("All")
public class LeetCode714 {
    //k = +infinity with fee
    //每次交易要支付手续费，只要把手续费从利润中减去即可。改写方程
    //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][i]+prices[i])
    //dp[i][1] = Math.max(dp[i-1][0],dp[i-1][i]-prices[i]-fee)
   /* public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                //base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i]-fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }*/


    //空间复杂度优化
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }
        return dp_i_0;
    }
}
