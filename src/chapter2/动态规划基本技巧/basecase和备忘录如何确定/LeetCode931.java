package chapter2.动态规划基本技巧.basecase和备忘录如何确定;

import java.util.Arrays;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode931 {

    //备忘录
    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        memo = new int[n][n];
        //初始化memo
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }

        //答案可能落在某一列中
        for (int j = 0; j < n; j++) {
            res = Math.min(dp(matrix, n - 1, j), res);
        }
        return res;
    }


    public int dp(int[][] matrix, int i, int j) {
        //检测索引
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 99999;
        }

        //base case
        if (i == 0) {
            return matrix[0][j];
        }
        // 3、查找备忘录，防止重复计算
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }

        memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j), dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j + 1));
        return memo[i][j];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
