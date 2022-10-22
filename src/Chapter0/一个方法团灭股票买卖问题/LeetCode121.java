package Chapter0.一个方法团灭股票买卖问题;

/*
 * @author icyrain11~
 * @version 16
 */
@SuppressWarnings("All")
// k = 1的情况
public class LeetCode121 {

  /*  public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                //base case
                // 根据状态转移方程可得：
                //   dp[i][0]
                // = max(dp[-1][0], dp[-1][1] + prices[i])
                // = max(0, -infinity + prices[i]) = 0
                dp[i][0] = 0;

                // 根据状态转移方程可得：
                //   dp[i][1]
                // = max(dp[-1][1], dp[-1][0] - prices[i])
                // = max(-infinity, 0 - prices[i])
                // = -prices[i]
                dp[i][1] = -prices[i];
                continue;
            }
            //卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //购入  dp[0][0] k = 0的base case 且i = 0则无法购入则为0
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
        }
        return dp[n - 1][0];
    }

   */

    //空间复杂度优化 因为新状态只和一个相邻的一个状态有关系则存储临时变量就可以
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp[-1][0] = 0;
        int dp_i_0 = 0;
        //dp[-1][1] = -infinity
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.min(dp_i_1, -prices[i]);
        }

        return dp_i_0;
    }


}
