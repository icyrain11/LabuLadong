package Chapter0.一个方法团灭股票买卖问题;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
// k = +infinity
public class LeetCode122 {

//    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
//    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
//            = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
//
//    我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
//    dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
//    dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])

    public int maxProfit_inf(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                //base case
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
