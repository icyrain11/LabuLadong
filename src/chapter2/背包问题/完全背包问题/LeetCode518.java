package chapter2.背包问题.完全背包问题;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode518 {

    int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++)
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j]
                            + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
        }
        return dp[n][amount];
    }

//
//    int change(int amount, int[] coins) {
//        int n = coins.length;
//        int[] dp = new int[amount + 1];
//        dp[0] = 1; // base case
//        for (int i = 0; i < n; i++)
//            for (int j = 1; j <= amount; j++)
//                if (j - coins[i] >= 0)
//                    dp[j] = dp[j] + dp[j-coins[i]];
//
//        return dp[amount];
//    }

}
