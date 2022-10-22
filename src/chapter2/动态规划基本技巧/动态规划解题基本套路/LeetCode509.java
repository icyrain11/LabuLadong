package chapter2.动态规划基本技巧.动态规划解题基本套路;

import org.junit.Test;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode509 {


//    public int fib(int n) {
//        //带备忘录的动态规划
//        int[] memo = new int[n + 1];
//        return helper(memo, n);
//    }

    public int helper(int[] memo, int n) {
        //base case
        if (n == 0 || n == 1) {
            return n;
        }
        //如果已经计算过了那么无需计算
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }


//    //dp数组递推
//    int fib(int N) {
//        if (N == 0) return 0;
//        int[] dp = new int[N + 1];
//        // base case
//        dp[0] = 0;
//        dp[1] = 1;
//        // 状态转移
//        for (int i = 2; i <= N; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//
//        return dp[N];
//    }


    //dp数组递推优化
    int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int dp_i_1 = 1;
        int dp_i_2 = 0;
        for (int i = 2; i <= N; i++) {
            int dp_i = dp_i_2 + dp_i_1;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }


}
