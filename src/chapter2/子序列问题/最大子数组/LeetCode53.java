package chapter2.子序列问题.最大子数组;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];

        //base case
        dp[0] = nums[0];

        //状态转移
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
