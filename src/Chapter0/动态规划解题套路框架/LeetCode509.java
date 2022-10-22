package Chapter0.动态规划解题套路框架;

/*
 * @author icyrain11~
 * @version 16
 */
public class LeetCode509 {
    //这种做法就是再递归的基础上添加了一个备忘录，使得减少了冗余的计算！
//    public int fib(int n) {
//        int[] memo = new int[n + 1];
//        return helper(memo, n);
//    }
//
//    public int helper(int[] memo, int n) {
//        //base case
//        if (n == 0 || n == 1) {
//            return n;
//        }
//        //若以及计算过则不需要再次计算
//        if (memo[n] != 0) {
//            return memo[n];
//        }
//        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
//        return memo[n];
//    }

    //动态规划
    public int fib(int n) {
//        if (n == 0) {
//            return 0;
//        }

//        //dp数组 base case
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        //状态转移
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];

        //其实可以再优化只需记录前面一个数值和前前个数值即可
        if (n < 1) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        int prev = 1, cur = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + cur;
            prev = cur;
            cur = sum;
        }
        return cur;
    }
}
