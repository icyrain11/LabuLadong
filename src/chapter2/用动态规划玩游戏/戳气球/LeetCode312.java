package chapter2.用动态规划玩游戏.戳气球;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode312 {

    public int maxCoins(int[] nums) {
        int n = nums.length;

        //将两端加入虚拟气球
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }


        //当 0 和 n+1之间的所有气球被戳光了 那么就没有气球了
        int[][] dp = new int[n + 2][n + 2];
        // 开始状态转移
        // i 应该从下往上
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]);
                }
            }
        }

        return dp[0][n + 1];
    }
}
