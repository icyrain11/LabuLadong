package chapter2.用动态规划玩游戏.高楼丢鸡蛋;

import java.util.Arrays;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode887 {


    //dp 线性扫描超时 时间复杂度为 子问题个数 X 函数本身复杂度  时间复杂度为O（K*N^ 2 ）  空间复杂度为 O（KN）


//    int[][] memo;
//
//    public int superEggDrop(int k, int n) {
//        memo = new int[k + 1][n + 1];
//        for (int[] row : memo) {
//            Arrays.fill(row, -999);
//        }
//
//        return dp(k, n);
//    }
//
//
//    //k个鸡蛋n层楼返回最优解
//    public int dp(int k, int n) {
//
//        //base case
//        if (k == 1) {
//            return n;
//        }
//
//        if (n == 0) {
//            return 0;
//        }
//
//
//        //备忘录
//        if (memo[k][n] != -999) {
//            return memo[k][n];
//        }
//
//        int res = Integer.MAX_VALUE;
//        for (int i = 1; i <= n; i++) {
//            res = Math.min(res, Math.max(dp(k - 1, i - 1),
//                    dp(k, n - i)) + 1);
//        }
//
//        memo[k][n] = res;
//        return res;
//    }


    //二分优化

    int[][] memo;
//
//    public int superEggDrop(int k, int n) {
//        memo = new int[k + 1][n + 1];
//        for (int[] row : memo) {
//            Arrays.fill(row, -999);
//        }
//
//        return dp(k, n);
//    }


    public int dp(int k, int n) {
        //base case
        if (k == 1) {
            return n;
        }

        if (n == 0) {
            return 0;
        }

        //消除子序列问题
        if (memo[k][n] != -999) {
            return memo[k][n];
        }

        int res = Integer.MAX_VALUE;
        int lo = 1, hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //broken
            int broken = dp(k - 1, mid - 1);
            //not broken
            int not_broken = dp(k, n - mid);

            if (broken > not_broken) {
                res = Math.min(res, broken + 1);
                hi = mid - 1;
            } else {
                res = Math.min(res, not_broken + 1);
                lo = mid + 1;
            }

        }

        memo[k][n] = res;

        return res;
    }


    //dp优化
    int superEggDrop(int k, int n) {
        int m = 0;
        int[][] dp = new int[k + 1][n + 1];
        while (dp[k][m] < n) {
            m++;
            for (int j = 1; j <= k; j++) {
                dp[j][m] = dp[j][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }

        return m;
    }

}
