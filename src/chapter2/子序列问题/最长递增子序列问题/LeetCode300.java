package chapter2.子序列问题.最长递增子序列问题;

import java.util.Arrays;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {

        //dp数组
        int[] dp = new int[nums.length];
        //全部初始化为1
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
