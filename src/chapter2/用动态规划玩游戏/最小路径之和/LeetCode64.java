package chapter2.用动态规划玩游戏.最小路径之和;

import java.util.Arrays;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode64 {

    int[][] memo;

//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        memo = new int[m][n];
//        for (int[] row : memo) {
//            Arrays.fill(row, -1);
//        }
//        return dp(grid, m - 1, n - 1);
//    }

    private int dp(int[][] grid, int i, int j) {
        //base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        // 如果索引出界，返回一个很大的值，
        // 保证在取 min 的时候不会被取到
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        //避免重复计算
        // 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        //比较向下走或者向右走那个比较小
        memo[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
        return memo[i][j];
    }


    //通过dp做法解决
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        //base case
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }


}
