package Chapter0.动态规划解题套路框架;

import java.util.Arrays;

/*
 * @author icyrain11~
 * @version 16
 */
public class LeetCode322 {
    //  int[] memo;
//
//    public int coinChange(int[] coins, int amount) {
//        memo = new int[amount + 1];
//        //dp数组初始化为特殊值
//        Arrays.fill(memo, -6);
//        return dp(coins, amount);
//    }

    //递归 凑出金额n,至少需要dp(coins,n)个硬币
//    public int dp(int[] coins, int amount) {
//        //base case
//        if (amount == 0) {
//            return 0;
//        }
//        if (amount < 0) {
//            return -1;
//        }
//        //以及计算过了则不需要重复计算
//        if (memo[amount] != -6) {
//            return memo[amount];
//        }
//        int res = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            //计算子问题
//            int subProblem = dp(coins, amount - coin);
//            //如果子问题无解则跳过
//            if (subProblem == -1) {
//                continue;
//            }
//            res = Math.min(res, subProblem + 1);
//        }
//        memo[amount] = (res == Integer.MAX_VALUE ? -1 : res);
//        return memo[amount];
//    }

    //动态规划dp解法
    public int coinChange(int[] coins, int amount) {
        //所有面值的可能性
        int[] dp = new int[amount + 1];
        //数组大小为amount+1,初始值因为amount+1
        Arrays.fill(dp, amount + 1);
        //base case；
        dp[0] = 0;
        //外层遍历出所有的状态 金额为i时候的子问题
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                //若子问题无解则跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
