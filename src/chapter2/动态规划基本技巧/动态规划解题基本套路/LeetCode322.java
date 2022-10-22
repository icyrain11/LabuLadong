package chapter2.动态规划基本技巧.动态规划解题基本套路;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author icyrain11
 * @version 1.8
 */
@SuppressWarnings("All")
public class LeetCode322 {
//
//    int[] memo;
//
//    public int coinChange(int[] coins, int amount) {
//        memo = new int[amount + 1];
//        Arrays.fill(memo, -666);
//
//        return dp(coins, amount);
//    }
//
//    public int dp(int[] coins, int amount) {
//        //base case
//        if (amount == 0) {
//            return 0;
//        }
//        if (amount < 0) {
//            return -1;
//        }
//
//        // 查备忘录，防止重复计算
//        if (memo[amount] != -666) {
//            return memo[amount];
//        }
//
//        int res = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            //子问题
//            int subProblem = dp(coins, amount - coin);
//            //如果子问题无解则跳过
//            if (subProblem == -1) {
//                continue;
//            }
//            res = Math.min(res, subProblem + 1);
//        }
//
//
//        memo[amount] = (res == Integer.MAX_VALUE ? -1 : res);
//        return memo[amount];
//    }


    //动态规划dp
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        //base case
        dp[0] = 0;
        //外层套for遍历所有状态的取值
        for (int i = 0; i < dp.length; i++) {
            //内层for选择所有最小值
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1 ? -1 : dp[amount]);
    }

    @Test
    public void Test() {
        int[] coins = {1, 2, 5};
        int amout = 11;
    }


}
